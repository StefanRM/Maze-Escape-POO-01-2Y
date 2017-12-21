import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * This class represents the Game in which there are two Characters trying to
 * find each other in a maze, while walking simultaneously.
 * 
 * @author Maftei Stefan - Radu
 * @version 1.3
 */
public class Game {
	/**
	 * First Character located in the maze
	 */
	private Character character1;
	/**
	 * Second Character located in the maze
	 */
	private Character character2;
	/**
	 * Map which represents the maze like a matrix
	 */
	private CityMap map;
	/**
	 * Map of first Character's path length in each cell (Lee algorithm)
	 */
	private int[][] character1_map;
	/**
	 * Map of second Character's path length in each cell (Lee algorithm)
	 */
	private int[][] character2_map;
	/**
	 * Input file's name
	 */
	private String filename_in;

	/**
	 * Initializes a Game with given Characters' names and codes, and input
	 * file's name
	 * 
	 * @param name1
	 *            The name of the first Character
	 * @param code1
	 *            The code of the first Character in the map matrix of the maze
	 * @param name2
	 *            The name of the second Character
	 * @param code2
	 *            The code of the second Character in the map matrix of the maze
	 * @param filename_in
	 *            Input file's name
	 */
	public Game(String name1, int code1, String name2, int code2,
			String filename_in) {
		character1 = new Character(name1, code1);
		character2 = new Character(name2, code2);
		this.filename_in = filename_in;
		map = new CityMap(filename_in, code1, code2); // initialize the map
														// matrix of the maze

		// initialize characters' maps
		character1_map = new int[map.n][map.m];
		character2_map = new int[map.n][map.m];

		// copy map matrix to characters' maps, but instead of characters' codes
		// we put value 1
		for (int i = 0; i < map.n; i++) {
			for (int j = 0; j < map.m; j++) {
				if (map.map[i][j] > 1) {
					character1_map[i][j] = 1;
					character2_map[i][j] = 1;
				} else {
					character1_map[i][j] = map.map[i][j];
					character2_map[i][j] = map.map[i][j];
				}
			}
		}

		// setting characters' positions from the map matrix
		map.setCharacterPosition(character1);
		map.setCharacterPosition(character2);
	}

	/**
	 * Verifies if a set of coordinates is in the map matrix boundaries
	 * 
	 * @param x
	 *            X Coordinate
	 * @param y
	 *            Y coordinate
	 * @return True if the set of coordinates is in the map matrix boundaries,
	 *         otherwise false
	 */
	private boolean isInMapBoundaries(int x, int y) {
		return (x >= 0) && (x < map.n) && (y >= 0) && (y < map.m);
	}

	/**
	 * Traverse the map matrix to find the shortest distance between Characters
	 * 
	 * @param map_matrix
	 *            Map matrix of the maze (after this function it will be the map
	 *            matrix where every cell is numbered with the distance to
	 *            starting point)
	 * @param startPoint
	 *            Point from where the path starts (a Character's Point)
	 * @param finishPoint
	 *            Point to where the path finishes (other Character's Point)
	 * @return The shortest distance between the Characters' Points
	 */
	public int getMinDistance(int map_matrix[][], Point startPoint,
			Point finishPoint) {

		// create shortcuts to all 8 neighbors of a Point
		int xNeighbors[] = { -1, 0, 1, 1, 1, 0, -1, -1 };
		int yNeighbors[] = { 1, 1, 1, 0, -1, -1, -1, 0 };

		// create a visited array because we don't want to analyze more than
		// once a Point in the map matrix
		boolean[][] visited = new boolean[map.n][map.m];
		// initializing with false for safety
		for (int i = 0; i < map.n; i++) {
			for (int j = 0; j < map.m; j++) {
				visited[i][j] = false;
			}
		}

		// mark the starting Point as visited
		visited[startPoint.getX()][startPoint.getY()] = true;

		// create a Queue for storing the map matrix's Points
		Queue queue = new Queue(map.m * map.n);

		// distance of startPoint is 0
		Point firstPoint = new Point(startPoint.getX(), startPoint.getY());
		queue.enqueue(firstPoint); // enqueue startPoint

		// we will store neighbors of each Point in the Queue
		while (!queue.isEmpty()) {
			// get the head of the Queue
			Point currentPoint = queue.front();

			// maybe we reached the finishPoint
			if (currentPoint.getX() == finishPoint.getX()
					&& currentPoint.getY() == finishPoint.getY()) {
				return currentPoint.getDistance();
			}

			// if not, dequeue and enqueue currentPoint's neighbors
			queue.dequeue();

			for (int i = 0; i < 8; i++) {
				// getting neighbors' coordinates
				int x = currentPoint.getX() + xNeighbors[i];
				int y = currentPoint.getY() + yNeighbors[i];

				// if the neighbor has its coordinates in the map and it is not
				// visited we will enqueue it
				if (isInMapBoundaries(x, y) && map_matrix[x][y] != 0
						&& !visited[x][y]) {
					// mark neighbor as visited and enqueue it
					visited[x][y] = true;

					// update in map matrix the path length
					// initial distance is zero, and startPoint in map_matrix is
					// 1
					map_matrix[x][y] = currentPoint.getDistance() + 2;
					Point NeighborPoint = new Point(x, y); // create the
															// neighbor's Point

					// increase the distance to startPoint
					NeighborPoint.setDistance(currentPoint.getDistance() + 1);
					queue.enqueue(NeighborPoint); // enqueue the neighbor
				}
			}
		}

		// return -1 if finishPoint cannot be reached
		return -1;
	}

	/**
	 * Writes the solution to output file
	 * 
	 * @param distance
	 *            Shortest distance between the two Characters
	 */
	public void writeToFile(int distance) {
		// obtain output file's name
		String filename_out = filename_in.replace(".in", ".out");
		boolean met = false; // we want to know if the Characters met

		try {
			PrintWriter writer = new PrintWriter(filename_out, "UTF-8");
			if (distance != -1) { // there is a chance they met
				distance = (distance + 1) / 2 + 1; // both Characters starts
													// with distance 1 and they
													// walk simultaneously
				for (int i = 0; i < map.n; i++) {
					for (int j = 0; j < map.m; j++) {
						if (character1_map[i][j] == character2_map[i][j]
								&& character1_map[i][j] == distance) {
							writer.println(
									distance + " " + (i + 1) + " " + (j + 1));
							met = true; // they sure met
						}
					}
				}
			}

			// if they didn't meet
			if (!met) { // maybe the path was blocked, or since they walk
						// simultaneously, they didn't end up on the same
						// position with the shortest distance
				writer.println("INF");
			}

			writer.close();
		} catch (FileNotFoundException e) { // handling error if the file is not
											// found
			System.out.println("File Not Found!");
		} catch (UnsupportedEncodingException e) { // handling error if the
													// encoding is not supported
			System.out.println("Unsupported Encoding");
		}
	}

	/**
	 * Plays in order to determine the shortest distance and write the solution
	 * to output file
	 */
	public void play() {
		int distance = getMinDistance(character1_map, character1.getPosition(),
				character2.getPosition());
		distance = getMinDistance(character2_map, character2.getPosition(),
				character1.getPosition());

		writeToFile(distance);
	}

	/**
	 * Here the execution starts
	 * 
	 * @param args
	 *            We don't use them
	 */
	public static void main(String[] args) {
		// initialize the game
		Game game = new Game("Romeo", 2, "Juliet", 3, "maze.in");
		game.play(); // Play on!
	}

}

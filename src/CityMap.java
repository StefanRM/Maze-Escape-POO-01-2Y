import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class represents the city maze with a map matrix, and it has two certain
 * codes for two characters placed in the city maze
 * 
 * @author Maftei Stefan - Radu
 * @version 1.3
 */
public class CityMap {
	/**
	 * The map matrix of the maze
	 */
	public int map[][];
	/**
	 * The number of rows of the map matrix
	 */
	public int n;
	/**
	 * The number of columns of the map matrix
	 */
	public int m;

	/**
	 * Initializes the map matrix of the maze, using specified codes for the
	 * position of characters
	 * 
	 * @param filename
	 *            The file used for reading the city maze
	 * @param code1
	 *            The code for the first character
	 * @param code2
	 *            The code for the second character
	 */
	public CityMap(String filename, int code1, int code2) {
		try {
			Scanner s = new Scanner(new File(filename));
			this.n = s.nextInt();
			this.m = s.nextInt();
			this.map = new int[n][m];
			char line[] = new char[m];
			int i = 0;
			s.nextLine(); // garbage, because we used nextInt() and now we want
							// to read lines

			while (s.hasNextLine()) { // read city maze lines and convert them
										// to map matrix
				line = s.nextLine().toCharArray();
				for (int j = 0; j < m; j++) {
					switch (line[j]) {
					case 'R': // first character
						this.map[i][j] = code1;
						break;
					case 'J': // second character
						this.map[i][j] = code2;
						break;
					case 'X': // position in the city maze that cannot be
								// crossed
						this.map[i][j] = 0;
						break;
					default: // position in the city maze that can be crossed
						this.map[i][j] = 1;
						break;
					}
				}

				i++;
			}
			s.close();

		} catch (FileNotFoundException e) { // handling error if the file is not
											// found
			System.out.println("File Not Found!");
		}
	}

	/**
	 * Sets a character's position by finding the code in the map matrix
	 * 
	 * @param character
	 *            Character whose position is set
	 */
	public void setCharacterPosition(Character character) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (this.map[i][j] == character.getCode()) { // verify each
																// position in
																// map matrix
					character.setPosition(i, j);
					return;
				}
			}
		}
	}
}

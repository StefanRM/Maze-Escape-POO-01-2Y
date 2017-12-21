/**
 * This class represents a Point in map matrix
 * 
 * @author Maftei Stefan - Radu
 * @version 1.3
 */
public class Point {
	/**
	 * X coordinate of a position in map matrix
	 */
	private int x;
	/**
	 * Y coordinate of a position in map matrix
	 */
	private int y;
	/**
	 * The shortest distance of this Point to the start Point through maze
	 */
	private int distance;

	/**
	 * Initializes a Point at the first position in map, with distance zero
	 */
	public Point() {
		this(0, 0);
	}

	/**
	 * Initializes a Point at a certain position in map, with distance zero
	 * 
	 * @param x
	 *            X coordinate of a position in map matrix
	 * @param y
	 *            Y coordinate of a position in map matrix
	 */
	public Point(int x, int y) {
		this(x, y, 0);
	}

	/**
	 * Initializes a Point at a certain position in map, with a certain distance
	 * 
	 * @param x
	 *            X coordinate of a position in map matrix
	 * @param y
	 *            Y coordinate of a position in map matrix
	 * @param distance
	 *            The shortest distance of this Point to the start Point through
	 *            maze
	 */
	public Point(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}

	/**
	 * Sets a Point's x coordinate
	 * 
	 * @param x
	 *            X coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Sets a Point's y coordinate
	 * 
	 * @param y
	 *            Y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets Point's x coordinate
	 * 
	 * @return Point's x coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets Point's y coordinate
	 * 
	 * @return Point's y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Gets Point's distance
	 * 
	 * @return Point's distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * Sets a Point's distance
	 * 
	 * @param distance
	 *            The shortest distance of this Point to the start Point through
	 *            maze
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
}

/**
 * This class represents a Character located in a maze
 * 
 * @author Maftei Stefan - Radu
 * @version 1.3
 */
public class Character {
	/**
	 * The name of the Character
	 */
	private String name;
	/**
	 * The position in maze of the Character
	 */
	private Point position;
	/**
	 * The code of the Character in the map matrix of the maze
	 */
	private int code;

	/**
	 * Initializes a newly created character object so that it represents an
	 * "unknown" Character, at the first position in map
	 */
	public Character() {
		this("unknown", 0, 0, 0);
	}

	/**
	 * Initializes a newly created Character object at the first position in map
	 * 
	 * @param name
	 *            Name of the identified Character
	 * @param code
	 *            Code chosen for representation in the map matrix of the maze
	 */
	public Character(String name, int code) {
		this(name, code, 0, 0);
	}

	/**
	 * Initializes a newly created Character object at a certain position in map
	 * 
	 * @param name
	 *            Name of the identified Character
	 * @param code
	 *            Code chosen for representation in the map matrix of the maze
	 * @param positionX
	 *            X coordinate of the position in the map matrix of the maze
	 * @param positionY
	 *            Y coordinate of the position in the map matrix of the maze
	 */
	public Character(String name, int code, int positionX, int positionY) {
		this.name = name;
		this.code = code;
		this.position = new Point(positionX, positionY);
	}

	/**
	 * Sets a Character's position with the specified coordinates
	 * 
	 * @param positionX
	 *            X coordinate of the position in the map matrix of the maze
	 * @param positionY
	 *            Y coordinate of the position in the map matrix of the maze
	 */
	public void setPosition(int positionX, int positionY) {
		this.position.setX(positionX);
		this.position.setY(positionY);
	}

	/**
	 * Gets the Character's name
	 * 
	 * @return Character's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the Character's position
	 * 
	 * @return Character's position
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * Gets the Character's code
	 * 
	 * @return Character's code
	 */
	public int getCode() {
		return code;
	}
}

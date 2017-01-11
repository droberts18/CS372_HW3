/**
 * @author Drew Roberts
 * @version 1.0
 */

import java.util.ArrayList;

public class Building {
	private String name;
	private String address;
	private ArrayList<Person> currentOccupants = new ArrayList<Person>();
	
	/**
	 * Default constructor: Creates a building object with no name or address
	 */
	public Building(){
		name = "unavailable";
		address = "unavailable";
	}
	
	/**
	 * Creates a building
	 * @param name	Name of the building
	 * @param address	Address of the building
	 */
	public Building(String name, String address){
		this.name = name;
		this.address = address;
	}
	
	/**
	 * Adds an occupant to the building
	 * @param p	New occupant
	 */
	public void addOccupant(Person p){
		currentOccupants.add(p);
	}
	
	/**
	 * Gets the occupants in the building
	 * @return Occupants in building
	 */
	public ArrayList<Person> getCurrentOccupants(){
		return currentOccupants;
	}
	
	/**
	 * Gets the name of the building
	 * @return	Name of building
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Sets the name of the building
	 * @param name 	New name of building
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Sets the address of the building
	 * @param address	New address of the building
	 */
	public void setAddress(String address){
		this.address = address;
	}
}

/**
 * @author Drew Roberts
 * @version 1.0
 */
import java.util.ArrayList;

public class CityHall extends Building {
	ArrayList<Kid> kids = new ArrayList<Kid>();
	ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	
	/**
	 * Creates a new city hall
	 * @param name	 Name of the new city hall
	 * @param address 	Address of the new city hall
	 */
	public CityHall(String name, String address){
		setName(name);
		setAddress(address);
	}
}

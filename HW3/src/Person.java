/**
 * @author Drew Roberts
 * @version 1.0
 */

public class Person {
	private String name;
	private int age;
	private int phoneNumber;
	private static int lastPhoneNumber = 1111111;
	
	/**
	 * Default constructor: Creates a new person with no name or age
	 */
	public Person(){
		phoneNumber = lastPhoneNumber;
		lastPhoneNumber++;
		name = "not available";
		age = 0;
	}
	
	/**
	 * Creates a new person
	 * @param name	Name of the new person
	 * @param age	Age of the new person
	 * @param phoneNumber	Phone number of the new person
	 */
	public Person(String name, int age, int phoneNumber){
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.name = name;
	}
	
	/**
	 * Gets the name of the person
	 * @return Name of the person
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Gets the age of the person
	 * @return Age of the person
	 */
	public int getAge(){
		return age;
	}
	
	/**
	 * Gets the person's phone number
	 * @return Person's phone number
	 */
	public int getPhoneNumber(){
		return phoneNumber;
	}
	
	/**
	 * Sets the new name of the person
	 * @param name	New name
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Sets the new age of the person
	 * @param age New Age
	 */
	public void setAge(int age){
		this.age = age;
	}
	
	/**
	 * Sets the new phone number of the person
	 * @param phoneNumber	New phone number
	 */
	public void setPhoneNumber(int phoneNumber){
		this.phoneNumber = phoneNumber;
	}
}

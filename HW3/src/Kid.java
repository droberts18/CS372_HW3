/**
 * @author Drew Roberts
 * @version 1.0
 */

public class Kid extends Person {
	private String favoriteCandy;
	
	/**
	 * Creates a new kid
	 * @param name	Name of the new kid
	 * @param age	Age of the new kid
	 * @param phoneNumber	Phone number of the new kid
	 * @param favoriteCandy		Favorite candy of the new kid
	 */
	public Kid(String name, int age, int phoneNumber, String favoriteCandy){
		setName(name);
		setAge(age);
		setPhoneNumber(phoneNumber);
		this.favoriteCandy = favoriteCandy;
	}
	
	/**
	 * Gets kid's favorite candy
	 * @return Kid's favorite candy
	 */
	public String getFavoriteCandy(){
		return favoriteCandy;
	}
}

/**
 * @author Drew Roberts
 * @version 1.0
 */

public class Police extends Person implements Employee {
	private Role r;
	private int pay;
	private int EmployeeID;

	/**
	 * Creates a new police member
	 * @param name	Name of new member
	 * @param age	Age of the new member
	 * @param phoneNumber	Phone number of new member
	 * @param r		Role of new member within police
	 * @param pay	New member's pay
	 */
	public Police(String name, int age, int phoneNumber, Role r, int pay){
		setName(name);
		setAge(age);
		setPhoneNumber(phoneNumber);
		this.r = r;
		this.pay = pay;
		EmployeeID = lastEmployeeID;
	}
	
	/**
	 * Gets the employee's ID
	 */
	public int getEmployeeID(){
		return EmployeeID;
	}
	
	/**
	 * Gets the pay of police member
	 */
	public int getPay(){
		return pay;
	}
	
	/**
	 * Pays police member
	 */
	public void getPaid(){
		System.out.printf("%s was successfully paid $%d\n", getName(), pay);
	}
	
	/**
	 * Gets the police officer's role
	 * @return Police officer's role
	 */
	public Role getRole(){
		return r;
	}
}

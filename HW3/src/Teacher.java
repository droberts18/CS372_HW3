/**
 * @author Drew Roberts
 * @version 1.0
 */

public class Teacher extends Person implements Employee{
	private int EmployeeID;
	private int pay;
	private int gradeLevel;
	private String certification;
	
	/**
	 * Creates a new teacher
	 * @param name	Name of new teacher
	 * @param age	Age of new teacher
	 * @param phoneNumber	Phone number of new teacher
	 * @param pay	New teacher's pay
	 * @param gradeLevel	New teacher's grade level
	 * @param certification	New teacher's certification
	 */
	public Teacher(String name, int age, int phoneNumber, int pay, int gradeLevel,
			String certification){
		setName(name);
		setAge(age);
		setPhoneNumber(phoneNumber);
		this.pay = pay;
		this.gradeLevel = gradeLevel;
		this.certification = certification;
		EmployeeID = lastEmployeeID;
	}
	
	/**
	 * Gets the employee ID of the teacher
	 * @return	The teacher's employee ID
	 */
	public int getEmployeeID(){
		return EmployeeID;
	}
	
	/**
	 * Gets the teacher's pay
	 * @return	The teacher's pay
	 */
	public int getPay(){
		return pay;
	}
	
	/**
	 * Gets the teacher's grade level
	 * @return	Teacher's grade level
	 */
	public int getGradeLevel(){
		return gradeLevel;
	}
	
	/**
	 * Gets the teacher's certification
	 * @return Teacher's certification
	 */
	public String getCertification(){
		return certification;
	}
	
	/**
	 * Pays the teacher
	 */
	public void getPaid(){
		System.out.printf("%s was successfully paid $%d\n", getName(), pay);
	}
}

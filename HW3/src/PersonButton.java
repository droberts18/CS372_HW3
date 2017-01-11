/**
 * @author Drew Roberts
 * @version 1.0
 */

import javax.swing.JButton;

public class PersonButton {
	private Person p;
	public JButton btn;
	
	/**
	 * Creates a PersonButton based on the person
	 * @param p	Person to be associated with new button
	 */
	public PersonButton(Person p){
		this.p = p;
		btn = new JButton();
		btn.setFocusPainted(false);
	}
	
	/**
	 * Sets the text of the button
	 * @param s	The text to be displayed on the button
	 */
	public void setBtnText(String s){
		btn.setText(s);
	}
	
	/**
	 * Gets the person's button
	 * @return	Person's button
	 */
	public JButton getBtn(){
		return btn;
	}
	
	/**
	 * Gets the person related a button
	 * @return	Person related to button
	 */
	public Person getPerson(){
		return p;
	}

	/**
	 * Gets all the specific info on a certain person
	 * @return	Specific info on person
	 */
	public String getInfo() {
		String specificInfo = "";
		
		if(p instanceof Kid){
			Kid k = ((Kid)p);
			specificInfo += "<br>Favorite Candy: " + k.getFavoriteCandy() + "</html>";
		}
		else if(p instanceof Teacher){
			Teacher t = ((Teacher)p);
			specificInfo += "<br>Employee ID: " + t.getEmployeeID();
			specificInfo += "<br>Pay: $" + t.getPay();
			specificInfo += "<br>Grade Level: " + t.getGradeLevel();
			specificInfo += "<br>Certification: " + t.getCertification() + "</html>";
		}
		else{
			Police po = ((Police)p);
			specificInfo += "<br>Employee ID: " + po.getEmployeeID();
			specificInfo += "<br>Pay: $" + po.getPay();
			specificInfo += "<br>Role: " + po.getRole() + "</html>";
		}
		return retrieveBasicPersonInfo() + specificInfo;
	}
	
	/**
	 * Gets all basic information on a person
	 * @return	All basic information on the person
	 */
	private String retrieveBasicPersonInfo(){
		return "<html>Name: " + p.getName() +"<br>Age: " + p.getAge() + "<br>Phone Number: " + p.getPhoneNumber();
	}
}

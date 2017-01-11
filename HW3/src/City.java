/**
 * @author Drew Roberts
 * @version 1.0
 */


import java.util.ArrayList;

public class City {
		// Declaring buildings
		private ArrayList<Building> buildings = new ArrayList<Building>();
		private CityHall cityHall;
		private School school;
		private Building outAndAbout;
		
	public City() {
		// Initializing buildings
		cityHall = new CityHall("City Hall", "123 1st Street");
		school = new School("School", "456 2nd Street");
		outAndAbout = new Building ("Out and About", "City");
		
		// Adds buildings
		buildings.add(cityHall);
		buildings.add(school);
		buildings.add(outAndAbout);
		
		// Adds citizens
		school.addOccupant(new Kid("Larry", 7, 5551230, "Butterfinger"));
		school.addOccupant(new Kid("Sam", 12, 5559180, "Twix"));
		school.addOccupant(new Teacher("Kim", 27, 5554678, 55000, 4, "Art"));
		school.addOccupant(new Teacher("Dave", 36, 5553029, 60000, 7, "Geography"));
		school.addOccupant(new Teacher("Tanner", 24, 5553089, 45000, 1, "Special Education"));
		cityHall.addOccupant(new Police("Beth", 29, 5556374, Role.Captain, 80000));
		cityHall.addOccupant(new Police("Shane", 38, 5559023, Role.Chief, 90000));
		cityHall.addOccupant(new Police("Hannah", 23, 5553301, Role.Patrol, 60000));
		cityHall.addOccupant(new Police("Richard", 29, 5554678, Role.Sargent, 70000));
		
		// Outputs the name of all citizens
		System.out.printf("NAMES OF ALL CITIZENS\n");
		for(Person p : school.getCurrentOccupants())
			System.out.printf("%s\n", p.getName());
		
		for(Person p : cityHall.getCurrentOccupants())
			System.out.printf("%s\n", p.getName());
		System.out.println();
		
		// Outputs the names of all buildings
		System.out.printf("NAMES OF ALL BUILDINGS\n");
		for(Building b : buildings){
			System.out.printf("%s\n", b.getName());
		}
		System.out.println();
		
		// Outputs the name of all kids and teachers in the school
		System.out.printf("KIDS AND TEACHERS IN SCHOOL\n");
		for(Person p : school.getCurrentOccupants()){
			System.out.printf("%s\n", p.getName());
		}
		System.out.println();
		
		// Outputs the name of all police in City Hall
		System.out.printf("POLICE IN CITY HALL\n");
		for(Person p : cityHall.getCurrentOccupants()){
			System.out.printf("%s\n", p.getName());
		}
		System.out.println();
		
		// Pays all employees
		System.out.printf("PAYING EMPLOYEES\n");
		for(Person p : school.getCurrentOccupants()){
			if(p instanceof Employee)
				((Employee)p).getPaid();
		}
		
		for(Person p : cityHall.getCurrentOccupants())
			((Employee)p).getPaid();
	}
	
	/**
	 * Gets all the kids in the city
	 * @return	Kids in the city
	 */
	public ArrayList<Kid> getKids(){
		ArrayList<Kid> kids = new ArrayList<Kid>();
		
		for(Person p : school.getCurrentOccupants()){
			if(p instanceof Kid)
				kids.add((Kid)p);
		}
		
		return kids;
	}
	
	/**
	 * Gets all teachers in the city
	 * @return Teachers in the city
	 */
	public ArrayList<Teacher> getTeachers(){
		ArrayList<Teacher> teachers = new ArrayList<Teacher>();
		
		for(Person p : school.getCurrentOccupants()){
			if(p instanceof Teacher)
				teachers.add((Teacher)p);
		}
		
		return teachers;
	}
	
	/**
	 * Gets all police in the city
	 * @return	Police in the city
	 */
	public ArrayList<Police> getPolice(){
		ArrayList<Police> officers = new ArrayList<Police>();
		
		for(Person p : cityHall.getCurrentOccupants())
			officers.add((Police)p);
		
		return officers;
	}
	
	/**
	 * Gets those who are out and about (not at city hall or school)
	 * @return	People who are out and about
	 */
	public ArrayList<Person> getThoseOutAndAbout(){
		return outAndAbout.getCurrentOccupants();
	}
	
	/**
	 * Removes a person from their location
	 * @param p Person to be removed
	 */
	public void removeOccupant(Person p){
		if(school.getCurrentOccupants().contains(p))
			school.getCurrentOccupants().remove(p);
		else if(cityHall.getCurrentOccupants().contains(p))
			cityHall.getCurrentOccupants().remove(p);
		else
			outAndAbout.getCurrentOccupants().remove(p);
	}
}

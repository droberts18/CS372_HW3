/**
 * @author Drew Roberts
 * @version 1.0
 */

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Main extends JComponent{
	// Necessary global variables
	JFrame frame;
	JButton selectedBtn = null;
	PersonButton selectedPerson = null;
	City city = new City();
	ArrayList<PersonButton> thoseOutAndAbout = new ArrayList<PersonButton>();
	
	public Main(){
		initialize();
		frame.setVisible(true);
	}
	
	private void initialize(){
		String school = "resources/school.png";
		String cityHall = "resources/city hall.png";
		
		// Creates window
		frame = new JFrame();
		frame.setBounds(0, 0, 861, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Container c = frame.getContentPane();
		c.setBackground(new Color(0, 255, 127));
		
		// Creates the first street
		JPanel street1 = new JPanel();
		street1.setBounds(294, 0, 80, 605);
		frame.getContentPane().add(street1);
		street1.setBackground(new Color(128, 128, 128));
		
		// Creates the second street
		JPanel street2 = new JPanel();
		street2.setBounds(0, 395, 851, 80);
		frame.getContentPane().add(street2);
		street2.setBackground(new Color(128, 128, 128));
		
		// Creates the school panel that will show the image of the school
		JPanel schoolPanel = new JPanel();
		schoolPanel.setBounds(10, 75, 274, 309);
		frame.getContentPane().add(schoolPanel);
		schoolPanel.setBackground(new Color(0, 255, 127));
		schoolPanel.setLayout(null);
		
		// Creates the panel that holds people buttons when the mouse hovers over it
		JPanel hoverSchoolPanel = new JPanel();
		hoverSchoolPanel.setPreferredSize(hoverSchoolPanel.getPreferredSize());
		hoverSchoolPanel.setLayout(new FlowLayout());
		hoverSchoolPanel.setBounds(0, 0, schoolPanel.getWidth(), schoolPanel.getHeight());
		hoverSchoolPanel.setBackground(new Color(0, 0, 0, 200));
		schoolPanel.add(hoverSchoolPanel);
		hoverSchoolPanel.setVisible(false);
		
		// Creates the image of the school and adds in to the school panel
		try{
			Image schoolImg = Toolkit.getDefaultToolkit().getImage(school);
			schoolImg = schoolImg.getScaledInstance(schoolPanel.getWidth(),
				schoolPanel.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon schoolIcon = new ImageIcon(schoolImg);
			JLabel schoolLabel = new JLabel("", schoolIcon, JLabel.CENTER);
			schoolLabel.setLocation(0, 0);
			schoolLabel.setSize(274, 309);
			schoolLabel.setBackground(new Color(0, 255, 127));
			schoolPanel.add(schoolLabel);
		}
		catch (Exception ex){;}
		
		// Creates the city hall panel that will hold the image of city hall
		JPanel cityHallPanel = new JPanel();
		cityHallPanel.setBounds(390, 80, 435, 300);
		frame.getContentPane().add(cityHallPanel);
		cityHallPanel.setBackground(new Color(0, 255, 127));
		
		// Creates the panel that holds police officer's buttons when mouse hovers over
		JPanel hoverCityHallPanel = new JPanel();
		hoverCityHallPanel.setPreferredSize(hoverSchoolPanel.getPreferredSize());
		hoverCityHallPanel.setLayout(new FlowLayout());
		hoverCityHallPanel.setBounds(0, 0, cityHallPanel.getWidth(), cityHallPanel.getHeight());
		hoverCityHallPanel.setBackground(new Color(0, 0, 0, 200));
		cityHallPanel.add(hoverCityHallPanel);
		cityHallPanel.setLayout(null);
		hoverCityHallPanel.setVisible(false);

		// Creates image of city hall and puts it on the city hall panel
		try{
			Image cityHallImg = Toolkit.getDefaultToolkit().getImage(cityHall);
			cityHallImg = cityHallImg.getScaledInstance(cityHallPanel.getWidth(),
					cityHallPanel.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon cityHallIcon = new ImageIcon(cityHallImg);
			JLabel cityHallLabel = new JLabel("", cityHallIcon, JLabel.CENTER);
			cityHallLabel.setBounds(0, 0, cityHallPanel.getWidth(), cityHallPanel.getHeight());
			cityHallPanel.add(cityHallLabel);
		}
		catch (Exception ex){;}
		
		// Creates the info panel in the bottom right that displays all available info
		// on the selected person.  Does not appear until someone is selected.
		JPanel personInfoPanel = new JPanel();
		personInfoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)));
		personInfoPanel.setBounds(384, 480, 451, 120);
		frame.getContentPane().add(personInfoPanel);
		personInfoPanel.setLayout(null);
		personInfoPanel.setVisible(false);
		
		// Label that outputs all available info on selected person
		JLabel personInfo = new JLabel();
		personInfoPanel.add(personInfo);
		personInfo.setBounds(10, 0, personInfoPanel.getWidth(), personInfoPanel.getHeight());
		
		// Creates the deselect button and adds it to info panel
		JButton btnDeselect = new JButton("DESELECT");
		btnDeselect.setBounds(341, 74, 100, 23);
		personInfoPanel.add(btnDeselect);
		
		// Creates the panel for those who are out and about
		JPanel OutAndAboutPanel = new JPanel();
		OutAndAboutPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)));
		OutAndAboutPanel.setBackground(new Color(135, 206, 235));
		OutAndAboutPanel.setBounds(10, 486, 274, 108);
		frame.getContentPane().add(OutAndAboutPanel);
		OutAndAboutPanel.setLayout(null);
		
		// Label for the out and about panel
		JLabel lblOutAndAbout = new JLabel("OUT AND ABOUT");
		lblOutAndAbout.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutAndAbout.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblOutAndAbout.setBounds(10, 11, 254, 86);
		OutAndAboutPanel.add(lblOutAndAbout);
		
		// Creates a panel that when hovered over by mouse reveals all people's buttons in location
		JPanel hoverOutAndAboutPanel = new JPanel();
		hoverOutAndAboutPanel.setPreferredSize(hoverOutAndAboutPanel.getPreferredSize());
		hoverOutAndAboutPanel.setLayout(new FlowLayout());
		hoverOutAndAboutPanel.setBounds(0, 0, OutAndAboutPanel.getWidth(), OutAndAboutPanel.getHeight());
		hoverOutAndAboutPanel.setBackground(new Color(0, 0, 0, 200));
		OutAndAboutPanel.add(hoverOutAndAboutPanel);
		hoverOutAndAboutPanel.setVisible(false);
		
		// Creating city hall and the school
		createCityHall(hoverCityHallPanel, personInfoPanel, personInfo);
		createSchool(hoverSchoolPanel, personInfoPanel, personInfo);
		
		// Warning about deselecting
		JLabel lblnoteDeselectingPuts = new JLabel("<html>*Note: DESELECT puts the currently selected person into \"Out and About\".</html>");
		lblnoteDeselectingPuts.setVerticalAlignment(SwingConstants.TOP);
		lblnoteDeselectingPuts.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblnoteDeselectingPuts.setHorizontalAlignment(SwingConstants.LEFT);
		lblnoteDeselectingPuts.setBounds(309, 11, 132, 52);
		personInfoPanel.add(lblnoteDeselectingPuts);
		
		// When deselect is clicked, puts selected person in Out and About and
		// changes current selected person button to null

		btnDeselect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				personInfoPanel.setVisible(false);
				thoseOutAndAbout.add(selectedPerson);
				refreshOutAndAbout(hoverOutAndAboutPanel);
				selectedPerson.getBtn().setEnabled(true);
				resetSelected(null);
			}
		});
		
		// Allows the corresponding hover panel to show when mouse hovers over.
		// Also adds selected person if panel is clicked on
		OutAndAboutPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblOutAndAbout.setVisible(false);
				hoverOutAndAboutPanel.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(e.getX() <= 0 || e.getX() >= hoverOutAndAboutPanel.getWidth() || 
						e.getY() <= 0 || e.getY() >= hoverOutAndAboutPanel.getHeight()){
					lblOutAndAbout.setVisible(true);
					hoverOutAndAboutPanel.setVisible(false);
				}
			}
			@Override
			public void mouseClicked(MouseEvent e){
				if(selectedPerson != null){
					thoseOutAndAbout.add(selectedPerson);
					personInfoPanel.setVisible(false);
					refreshOutAndAbout(hoverOutAndAboutPanel);
					selectedPerson.getBtn().setEnabled(true);
					resetSelected(null);
				}
			}
		});

		// Allows the corresponding hover panel to show when mouse hovers over.
		// Also adds police officer to city hall provided that there is
		// a person selected and they are a police officer.
		cityHallPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hoverCityHallPanel.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(e.getX() <= 0 || e.getX() >= hoverCityHallPanel.getWidth() || 
						e.getY() <= 0 || e.getY() >= hoverCityHallPanel.getHeight()){
					hoverCityHallPanel.setVisible(false);
				}
			}
			@Override
			public void mouseClicked(MouseEvent e){
				if(selectedPerson != null && selectedPerson.getPerson() instanceof Police){
					city.getPolice().add((Police) selectedPerson.getPerson());
					personInfoPanel.setVisible(false);
					refreshCityHall(hoverCityHallPanel);
					selectedPerson.getBtn().setEnabled(true);
					resetSelected(null);
				}
			}
		});
			
		// Allows the corresponding hover panel to show.
		// Also adds a kid or teacher to the school provided that
		// there is a person selected and they are either a kid or teacher.
		schoolPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {

				hoverSchoolPanel.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(e.getX() <= 0 || e.getX() >= hoverSchoolPanel.getWidth() || 
						e.getY() <= 0 || e.getY() >= hoverSchoolPanel.getHeight()){
					hoverSchoolPanel.setVisible(false);
				}
			}
			@Override
			public void mouseClicked(MouseEvent e){
				if(selectedPerson != null && (selectedPerson.getPerson() instanceof Police) == false){
						
					if(selectedPerson.getPerson() instanceof Kid)
						city.getKids().add((Kid) selectedPerson.getPerson());
					else
						city.getTeachers().add((Teacher)selectedPerson.getPerson());
						
					personInfoPanel.setVisible(false);
					refreshSchool(hoverSchoolPanel);
					selectedPerson.getBtn().setEnabled(true);
					resetSelected(null);
				}
			}
		});
	}
	
	/**
	 * Creates a city hall and adds police officers to the city hall
	 * @param hoverCityHallPanel The panel that shows when mouse hovers over city hall
	 * @param personInfoPanel	The panel displaying all info on selected person
	 * @param personInfo	The label that outputs all info on selected person
	 */
	private void createCityHall(JPanel hoverCityHallPanel, JPanel personInfoPanel, JLabel personInfo){
		// Creates a personButton for each officer and adds their button to the city hall hover panel.
		for(int i = 0; i < city.getPolice().size(); i++){
			PersonButton pb = new PersonButton(city.getPolice().get(i));
			pb.setBtnText("Officer #" + Integer.toString(i+1)+ ": " + city.getPolice().get(i).getRole());
			pb.getBtn().setBackground(Color.BLUE);
			pb.getBtn().setForeground(Color.YELLOW);
			hoverCityHallPanel.add(pb.getBtn());
			
			// If the button is clicked, the person is selected and the button is removed
			// from its current parent.
			// Correct info on person is displayed.
			pb.getBtn().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(pb.getBtn() != selectedBtn){
						buttonClicked(pb);
						personInfoPanel.setVisible(true);
						city.removeOccupant(pb.getPerson());
						if(pb.getBtn().getParent() != hoverCityHallPanel){
							thoseOutAndAbout.remove(pb);
						}
						personInfo.setText(pb.getInfo());
					}
				}
			});
		}
	}
	
	/**
	 * Creates a school and adds kids and teachers to the school
	 * @param hoverSchoolPanel	The panel that appears when the mouse hovers over the school panel
	 * @param personInfoPanel	The panel that displays all info on selected person
	 * @param personInfo	The label that outputs all info on selected person
	 */
	private void createSchool(JPanel hoverSchoolPanel, JPanel personInfoPanel, JLabel personInfo){
		// Creates a personButton for each kid and adds their button to the school hover panel.
		for(int i = 0; i < city.getKids().size(); i++){
			PersonButton pb = new PersonButton(city.getKids().get(i));
			pb.setBtnText("Kid #" + Integer.toString(i+1));
			pb.getBtn().setBackground(Color.CYAN);
			hoverSchoolPanel.add(pb.getBtn());
			
			// If the button is clicked, the person is selected and the button is removed from 
			// its current parent.
			// Correct info on person is displayed.
			pb.getBtn().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(pb.getBtn() != selectedBtn){
						buttonClicked(pb);
						personInfoPanel.setVisible(true);
						city.removeOccupant(pb.getPerson());
						if(pb.getBtn().getParent() != hoverSchoolPanel){
							thoseOutAndAbout.remove(pb);
						}
						personInfo.setText(pb.getInfo());
					}
				}
			});
		}
		
		// Creates a personButton for each teacher and adds it to the school hover panel
		for(int i = 0; i < city.getTeachers().size(); i++){
			PersonButton pb = new PersonButton(city.getTeachers().get(i));
			pb.setBtnText("Teacher #" + Integer.toString(i+1));
			pb.getBtn().setBackground(Color.RED);
			pb.getBtn().setForeground(Color.WHITE);
			hoverSchoolPanel.add(pb.getBtn());
			// If the button is clicked, the person is selected and the button is removed
			// from its current parent.
			// Correct info on person is displayed.
			pb.getBtn().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(pb.getBtn() != selectedBtn){
						buttonClicked(pb);
						personInfoPanel.setVisible(true);
						city.removeOccupant(pb.getPerson());
						if(pb.getBtn().getParent() != hoverSchoolPanel){
							thoseOutAndAbout.remove(pb);
						}
						personInfo.setText(pb.getInfo());
					}
				}
			});
		}
	}
	
	/**
	 * Adds a button to the hover city hall panel and updates the UI to display button
	 * @param hoverCityHallPanel	The panel that gets the button
	 */
	private void refreshCityHall(JPanel hoverCityHallPanel){
		hoverCityHallPanel.add(selectedBtn);
		hoverCityHallPanel.updateUI();
	}
	
	/**
	 * Adds a button to the hover school panel and updates the UI to display button.
	 * @param hoverSchoolPanel	The panel that gets the button
	 */
	private void refreshSchool(JPanel hoverSchoolPanel){
		hoverSchoolPanel.add(selectedBtn);
		hoverSchoolPanel.updateUI();
	}
	
	/**
	 * Adds a button to the hover school panel and updates the UI to display button.
	 * @param hoverOutAndAboutPanel	The panel that gets the button
	 */
	private void refreshOutAndAbout(JPanel hoverOutAndAboutPanel){
		hoverOutAndAboutPanel.add(selectedBtn);
		hoverOutAndAboutPanel.updateUI();
	}
	
	/**
	 * Called when a personButton is clicked, removes the button from its parent and refreshes UI.
	 * @param pb	The personButton clicked
	 */
	private void buttonClicked(PersonButton pb){
		JPanel parent = (JPanel) pb.getBtn().getParent();
		parent.remove(pb.getBtn());
		parent.updateUI();
		resetSelected(pb);
	}
	
	/**
	 * Selects a button and personButton.
	 * Resets the currently selected button and personButton to null if passed null value.
	 * @param pb	The personButton to be selected or to reset selected person
	 * 				and button to null	
	 */
	private void resetSelected(PersonButton pb){
		if(pb != null){
			if(this.selectedBtn != null)
				this.selectedBtn.setEnabled(true);
			this.selectedBtn = pb.getBtn();
			this.selectedPerson = pb;
		}
		else{
			this.selectedBtn = null;
			this.selectedPerson = null;
		}
			
	}
	
	/**
	 * Creates a new main to run program
	 * @param args	Standard
	 */
	public static void main(String [] args){
		Main m = new Main();
	}
}

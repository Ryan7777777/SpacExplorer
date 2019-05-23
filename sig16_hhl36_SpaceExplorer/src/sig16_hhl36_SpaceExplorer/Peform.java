package sig16_hhl36_SpaceExplorer;

import java.awt.EventQueue;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Peform {

	private JFrame frmPerformAnAction;
	JFrame parent = new JFrame();
	private GameManager manager;
	/**
	 * Launch the application.
	 */
	public Peform(GameManager incomingManager){
		manager = incomingManager;
		initialize();
		frmPerformAnAction.setVisible(true);
	}
	public void closeWindow() {
		frmPerformAnAction.dispose();
	}
	public void finishedWindow() {
		manager.closePeform(this);
	}
	public void goUseItem() {
		manager.gotoUseItem(this);
	}
	public void toScore() {
		manager.gotoScore(this);
	}
	public void toPilot() {
		manager.gotoPilot(this);
	}
	/**
	 * Create the application.
	 * @wbp.parser.constructor
	 */
	public Peform() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPerformAnAction = new JFrame();
		frmPerformAnAction.setTitle("Perform an action");
		frmPerformAnAction.setBounds(100, 100, 697, 436);
		frmPerformAnAction.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPerformAnAction.getContentPane().setLayout(null);
		
		JLabel lblSelectedCrew = new JLabel("Selected Crew:");
		lblSelectedCrew.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectedCrew.setBounds(60, 26, 174, 16);
		frmPerformAnAction.getContentPane().add(lblSelectedCrew);
		
		JLabel lblCrewname = new JLabel(manager.selectcrew.getName());
		lblCrewname.setBounds(280, 27, 204, 16);
		frmPerformAnAction.getContentPane().add(lblCrewname);
		
		JButton btnEat = new JButton("Eat/Use Medical Item ");
		btnEat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.crew_food.size() == 0 && manager.crew_medical.size() == 0) {
					JOptionPane.showMessageDialog(parent, "No item in your ship!");
				}else {
					goUseItem();
				}
			} 
		});
		btnEat.setBounds(44, 112, 174, 46);
		frmPerformAnAction.getContentPane().add(btnEat);
		
		JButton btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.selectcrew.getaction() > 0) {
					manager.crewasleep(manager.selectcrew);
					finishedWindow();
				}
			} 
		});
		btnSleep.setBounds(230, 111, 174, 46);
		frmPerformAnAction.getContentPane().add(btnSleep);
		
		JButton btnRepair = new JButton("Repair");
		btnRepair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.selectcrew.getaction() > 0) {
					if (manager.getShieldhealth() < 200) {
						manager.repair(manager.selectcrew);
						finishedWindow();
					} else {
						JOptionPane.showMessageDialog(parent, "Spaceship shield already at 200%");
					}
				}
			} 
		});
		btnRepair.setBounds(420, 111, 174, 46);
		frmPerformAnAction.getContentPane().add(btnRepair);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.selectcrew.getaction() > 0) {
					manager.searchParts(manager.selectcrew);
					if(manager.getteditem != "") {
						if(manager.getpices() == 0) {
							JOptionPane.showMessageDialog(parent, "Congratulation you get " + manager.getteditem);
							toScore();
						}else {
						JOptionPane.showMessageDialog(parent, "Congratulation you get " + manager.getteditem);
						finishedWindow();
						}
					} else {
						finishedWindow();
					}
				}
			} 
		});
		btnSearch.setBounds(44, 178, 174, 46);
		frmPerformAnAction.getContentPane().add(btnSearch);
		
		JButton btnExit = new JButton("Return");
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnExit.setBounds(455, 289, 139, 46);
		frmPerformAnAction.getContentPane().add(btnExit);
		
		JButton btnNewButton = new JButton("Go to a new planet");
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				toPilot();
			}
		});
		btnNewButton.setBounds(230, 178, 174, 46);
		frmPerformAnAction.getContentPane().add(btnNewButton);
	}

}

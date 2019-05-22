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

	private JFrame frame;
	JFrame parent = new JFrame();
	private GameManager manager;
	/**
	 * Launch the application.
	 */
	public Peform(GameManager incomingManager){
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	public void closeWindow() {
		frame.dispose();
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
	 */
	public Peform() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 564, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSelectedCrew = new JLabel("Selected Crew:");
		lblSelectedCrew.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectedCrew.setBounds(60, 26, 174, 16);
		frame.getContentPane().add(lblSelectedCrew);
		
		JLabel lblCrewname = new JLabel(manager.selectcrew.getName());
		lblCrewname.setBounds(280, 27, 204, 16);
		frame.getContentPane().add(lblCrewname);
		
		JButton btnEat = new JButton("Eat/Use Medical Item ");
		btnEat.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.crew_food.size() == 0 && manager.crew_medical.size() == 0) {
					JOptionPane.showMessageDialog(parent, "No item in your ship!");
				}else {
					goUseItem();
				}
			} 
		});
		btnEat.setBounds(44, 112, 139, 46);
		frame.getContentPane().add(btnEat);
		
		JButton btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.selectcrew.getaction() > 0) {
					manager.crewasleep(manager.selectcrew);
					finishedWindow();
				}
			} 
		});
		btnSleep.setBounds(195, 112, 139, 46);
		frame.getContentPane().add(btnSleep);
		
		JButton btnRepair = new JButton("Repair");
		btnRepair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.selectcrew.getaction() > 0) {
					manager.repair(manager.selectcrew);
					finishedWindow();
				}
			} 
		});
		btnRepair.setBounds(345, 112, 139, 46);
		frame.getContentPane().add(btnRepair);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.selectcrew.getaction() > 0) {
					manager.searchParts(manager.selectcrew);
					if(manager.getteditem != "") {
						JOptionPane.showMessageDialog(parent, "Congratulation you get "+manager.getteditem);
						if(manager.getpices() == 0) {
							toScore();
						}else {
						finishedWindow();
						}
					} else {
						finishedWindow();
					}
				}
			} 
		});
		btnSearch.setBounds(44, 178, 139, 46);
		frame.getContentPane().add(btnSearch);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnExit.setBounds(401, 318, 97, 25);
		frame.getContentPane().add(btnExit);
		
		JButton btnNewButton = new JButton("Go to new planet ");
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				toPilot();
			}
		});
		btnNewButton.setBounds(195, 178, 139, 46);
		frame.getContentPane().add(btnNewButton);
	}

}

package sig16_hhl36_SpaceExplorer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;

public class mainGame {

	private JFrame frame;
	private GameManager manager;
<<<<<<< HEAD
	private String btn1;
	private String btn2;
	private String btn3;
	private String btn4;
	private int index;
	
=======
>>>>>>> branch 'master' of https://github.com/Ryan7777777/SpacExplorer.git

	/**
	 * Launch the application.
	 */
	public mainGame(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	public void closeWindow() {
		frame.dispose();
	}
	public void goStore() {
		manager.gotoStore(this);
	}
	public void finishedWindow() {
		manager.closeMainScreen(this);
	}
	public void setStringButton() {
		if(manager.getcrewsize() == 0) {
			btn1 = "";
			btn2 = "";
			btn3 = "";
			btn4 = "";
		} else {
			index = -1;
			for (CrewMember member: manager.crew_members) {
				index += 1;
				if(index == 0) {
					btn1 = ("Crew1 :"+member.getName());
					btn2 = "";
					btn3 = "";
					btn4 = "";		
				}
				else if (index == 1) {
					btn2 = ("Crew2 :"+member.getName());
					btn3 = "";
					btn4 = "";	
				} else if(index == 2) {
					btn3 =("Crew3: "+member.getName());
				} else {
					btn4 = ("Crew4: "+member.getName());
				}
		}
		}
	}
	public mainGame() {
		initialize();
	}
	/**
	 * Create the application.
	 */
	public mainGame(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 825, 605);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		setStringButton();
		JLabel lblDay = new JLabel("Day:");
		lblDay.setBounds(12, 71, 56, 16);
		frame.getContentPane().add(lblDay);
		
		JLabel lblCrewname = new JLabel("Crew name:");
		lblCrewname.setBounds(12, 13, 115, 16);
		frame.getContentPane().add(lblCrewname);
		
		JLabel lblShipname = new JLabel("Ship name:");
		lblShipname.setBounds(12, 42, 83, 16);
		frame.getContentPane().add(lblShipname);
		
		JLabel lblLostDebris = new JLabel("Lost debris:");
		lblLostDebris.setBounds(12, 100, 83, 16);
		frame.getContentPane().add(lblLostDebris);
		
		JLabel lblShip = new JLabel("Shield Health:");
		lblShip.setBounds(12, 129, 83, 16);
		frame.getContentPane().add(lblShip);
		
		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setBounds(12, 158, 56, 16);
		frame.getContentPane().add(lblMoney);
		
		JLabel lblFood = new JLabel("Crew's Food");
		lblFood.setBounds(553, 13, 104, 22);
		frame.getContentPane().add(lblFood);
		
		JLabel lblMedical = new JLabel("Crew's Medical Item");
		lblMedical.setBounds(553, 264, 150, 22);
		frame.getContentPane().add(lblMedical);
		
		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.setBounds(12, 483, 97, 25);
		frame.getContentPane().add(btnNextDay);
		
		JButton btnStore = new JButton("Go to Store");
		btnStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goStore();
			}
		});
		btnStore.setBounds(174, 483, 97, 25);
		frame.getContentPane().add(btnStore);
		
		JButton btnPeform = new JButton("peform");
		btnPeform.setBounds(12, 412, 97, 25);
		frame.getContentPane().add(btnPeform);
		
		JButton btnStatus = new JButton("Status");
		btnStatus.setBounds(174, 412, 97, 25);
		frame.getContentPane().add(btnStatus);
		
		JTextArea textStstus = new JTextArea();
		textStstus.setBackground(SystemColor.menu);
		textStstus.setBounds(317, 264, 206, 173);
		frame.getContentPane().add(textStstus);
		
		JTextArea txtFood = new JTextArea();
		txtFood.setBackground(SystemColor.menu);
		txtFood.setBounds(553, 54, 242, 197);
		txtFood.setText(manager.getFood());
		frame.getContentPane().add(txtFood);
		
		JTextPane txtMedicial = new JTextPane();
		txtMedicial.setBackground(SystemColor.menu);
		txtMedicial.setBounds(553, 314, 242, 213);
		txtMedicial.setText(manager.getMedical());
		frame.getContentPane().add(txtMedicial);
		
		JLabel lblCrewName = new JLabel(manager.getCrewname());
		lblCrewName.setBounds(112, 13, 159, 16);
		frame.getContentPane().add(lblCrewName);
		
		JLabel lblShipName = new JLabel(manager.getShipname());
		lblShipName.setBounds(112, 42, 159, 16);
		frame.getContentPane().add(lblShipName);
		
		JLabel lblDays = new JLabel(manager.getdays());
		lblDays.setBounds(112, 71, 159, 16);
		frame.getContentPane().add(lblDays);
		
		JLabel lblLostPices = new JLabel(Integer.toString(manager.getpices()));
		lblLostPices.setBounds(112, 100, 159, 16);
		frame.getContentPane().add(lblLostPices);
		
		JLabel lblShipHealth = new JLabel(Integer.toString(manager.getShieldhealth()));
		lblShipHealth.setBounds(112, 129, 159, 16);
		frame.getContentPane().add(lblShipHealth);
		
		JLabel lblCrewMoney = new JLabel(Double.toString(manager.getmoney()));
		lblCrewMoney.setBounds(112, 158, 159, 16);
		frame.getContentPane().add(lblCrewMoney);
		
		JLabel lblCrewStatus = new JLabel("Crew Status");
		lblCrewStatus.setBounds(317, 216, 97, 16);
		frame.getContentPane().add(lblCrewStatus);
		
		JButton btnCrew1 = new JButton(btn1);
		btnCrew1.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrew1.setVerticalAlignment(SwingConstants.TOP);
		btnCrew1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			 index = 0;
			 for(CrewMember member: manager.crew_members) {
					index +=1;
					if(index == 1) {
						textStstus.setText(member.viewStatus());
				}
			}
		}
		});
		btnCrew1.setBounds(12, 245, 130, 25);
		frame.getContentPane().add(btnCrew1);
		
		JButton btnCrew3 = new JButton(btn3);
		btnCrew3.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrew3.setVerticalAlignment(SwingConstants.TOP);
		btnCrew3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			 index = 0;
			 for(CrewMember member: manager.crew_members) {
					index +=1;
					if(index == 3) {
						textStstus.setText(member.viewStatus());
				}
			}
		}
		});
		btnCrew3.setBounds(12, 311, 130, 25);
		frame.getContentPane().add(btnCrew3);
		
		JButton btnCrew2 = new JButton(btn2);
		btnCrew2.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrew2.setVerticalAlignment(SwingConstants.TOP);
		btnCrew2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			 index = 0;
			 for(CrewMember member: manager.crew_members) {
					index +=1;
					if(index == 2) {
						textStstus.setText(member.viewStatus());
				}
			}
		}
		});
		btnCrew2.setBounds(174, 245, 131, 25);
		frame.getContentPane().add(btnCrew2);
		
		JButton btnCrew4 = new JButton(btn4);
		btnCrew4.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrew4.setVerticalAlignment(SwingConstants.TOP);
		btnCrew4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			 index = 0;
			 for(CrewMember member: manager.crew_members) {
					index +=1;
					if(index == 4) {
						textStstus.setText(member.viewStatus());
				}
			}
		}
		});
		btnCrew4.setBounds(174, 311, 131, 25);
		frame.getContentPane().add(btnCrew4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(466, 245, -136, 140);
		frame.getContentPane().add(separator);
		
		
	}
}

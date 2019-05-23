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
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;

public class mainGame {

	private JFrame frmSpaceExplorer;
	JFrame parent = new JFrame();
	private GameManager manager;
	private String btn1;
	private String btn2;
	private String btn3;
	private String btn4;
	private int index;
	


	/**
	 * Launch the application.
	 */
	public mainGame(GameManager incomingManager) {
		manager = incomingManager;
		setStringButton();
		initialize();
		frmSpaceExplorer.setVisible(true);
	}
	public void closeWindow() {
		frmSpaceExplorer.dispose();
	}
	public void goStore() {
		manager.gotoStore(this);
	}
	public void goPeform() {
		manager.gotoPeform(this);
	}
	
	public void finishedWindow() {
		manager.closeMainScreen(this);
	}
	public void setStringButton() {
		if(manager.crew_members.size() == 0) {
			btn1 = "";
			btn2 = "";
			btn3 = "";
			btn4 = "";
		} else {
			index = -1;
			for (CrewMember member: manager.crew_members) {
				index += 1;
				if(index == 0) {
					btn1 = (member.getName());
					btn2 = "";
					btn3 = "";
					btn4 = "";		
				}
				else if (index == 1) {
					btn2 = (member.getName());
					btn3 = "";
					btn4 = "";	
				} else if(index == 2) {
					btn3 =(member.getName());
				} else {
					btn4 = (member.getName());
				}
		}
		}
	}

	/**
	 * Create the application.
	 * @wbp.parser.constructor
	 */

	public mainGame() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpaceExplorer = new JFrame();
		frmSpaceExplorer.setTitle("Space Explorer");
		frmSpaceExplorer.setBounds(100, 100, 825, 605);
		frmSpaceExplorer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpaceExplorer.getContentPane().setLayout(null);
		setStringButton();
		JLabel lblDay = new JLabel("Day:");
		lblDay.setBounds(12, 71, 56, 16);
		frmSpaceExplorer.getContentPane().add(lblDay);
		
		JLabel lblCrewname = new JLabel("Crew name:");
		lblCrewname.setBounds(12, 13, 115, 16);
		frmSpaceExplorer.getContentPane().add(lblCrewname);
		
		JLabel lblShipname = new JLabel("Ship name:");
		lblShipname.setBounds(12, 42, 83, 16);
		frmSpaceExplorer.getContentPane().add(lblShipname);
		
		JLabel lblLostDebris = new JLabel("Lost debris:");
		lblLostDebris.setBounds(12, 100, 83, 16);
		frmSpaceExplorer.getContentPane().add(lblLostDebris);
		
		JLabel lblShip = new JLabel("Shield Health:");
		lblShip.setBounds(12, 129, 83, 16);
		frmSpaceExplorer.getContentPane().add(lblShip);
		
		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setBounds(12, 158, 56, 16);
		frmSpaceExplorer.getContentPane().add(lblMoney);
		
		JLabel lblFood = new JLabel("Crew's Food");
		lblFood.setBounds(347, 10, 104, 22);
		frmSpaceExplorer.getContentPane().add(lblFood);
		
		JLabel lblMedical = new JLabel("Crew's Medical Item");
		lblMedical.setBounds(570, 178, 150, 22);
		frmSpaceExplorer.getContentPane().add(lblMedical);
		
		JLabel lblDays = new JLabel(manager.getdays());
		lblDays.setBounds(112, 71, 159, 16);
		frmSpaceExplorer.getContentPane().add(lblDays);
		
		JLabel lblShipHealth = new JLabel(Integer.toString(manager.getShieldhealth()));
		lblShipHealth.setBounds(112, 129, 159, 16);
		frmSpaceExplorer.getContentPane().add(lblShipHealth);
		
		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.day > 1) {
					manager.newday();
					lblDays.setText(manager.getdays());
					lblShipHealth.setText(Integer.toString(manager.getShieldhealth()));
					JOptionPane.showMessageDialog(parent, "Event " + manager.randomevent + " occured!");
					
				} else {
					finishedWindow();
				}
			}
		});
		btnNextDay.setBounds(12, 483, 97, 25);
		frmSpaceExplorer.getContentPane().add(btnNextDay);
		
		JButton btnStore = new JButton("Store");
		btnStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goStore();
			}
		});
		btnStore.setBounds(174, 412, 97, 25);
		frmSpaceExplorer.getContentPane().add(btnStore);
		
		JButton btnPeform = new JButton("action");
		btnPeform.setBounds(12, 412, 97, 25);
		btnPeform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.selectcrew == null) {
					JOptionPane.showMessageDialog(parent, "Please select a crew by clicking their name");
				} else {
					if (manager.selectcrew.getaction() <= 0) {
					JOptionPane.showMessageDialog(parent, "No action left for this crew!");
				} else {
					goPeform();
				}
			}
		}
		});
		frmSpaceExplorer.getContentPane().add(btnPeform);
		
		JTextArea textStstus = new JTextArea();
		textStstus.setBackground(SystemColor.menu);
		textStstus.setBounds(570, 39, 206, 135);
		frmSpaceExplorer.getContentPane().add(textStstus);
		
		JTextArea txtFood = new JTextArea();
		txtFood.setBackground(SystemColor.menu);
		txtFood.setBounds(317, 42, 227, 503);
		txtFood.setText(manager.getFood());
		frmSpaceExplorer.getContentPane().add(txtFood);
		
		JTextPane txtMedicial = new JTextPane();
		txtMedicial.setBackground(SystemColor.menu);
		txtMedicial.setBounds(570, 213, 242, 315);
		txtMedicial.setText(manager.getMedical());
		frmSpaceExplorer.getContentPane().add(txtMedicial);
		
		JLabel lblCrewName = new JLabel(manager.getCrewname());
		lblCrewName.setBounds(112, 13, 159, 16);
		frmSpaceExplorer.getContentPane().add(lblCrewName);
		
		JLabel lblShipName = new JLabel(manager.getShipname());
		lblShipName.setBounds(112, 42, 159, 16);
		frmSpaceExplorer.getContentPane().add(lblShipName);
		
		JLabel lblLostPices = new JLabel(Integer.toString(manager.getpices()));
		lblLostPices.setBounds(112, 100, 159, 16);
		frmSpaceExplorer.getContentPane().add(lblLostPices);
		
		JLabel lblCrewMoney = new JLabel(Double.toString(manager.getmoney()));
		lblCrewMoney.setBounds(112, 158, 159, 16);
		frmSpaceExplorer.getContentPane().add(lblCrewMoney);
		
		JLabel lblCrewStatus = new JLabel("Crew Status");
		lblCrewStatus.setBounds(570, 13, 97, 16);
		frmSpaceExplorer.getContentPane().add(lblCrewStatus);
		
		JButton btnCrew1 = new JButton(btn1);
		btnCrew1.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrew1.setVerticalAlignment(SwingConstants.TOP);
		btnCrew1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			 index = 0;
			 for(CrewMember member: manager.crew_members) {
					index +=1;
					if(index == 1) {
						manager.selectcrew = member;
						textStstus.setText(member.viewStatus());
				}
			}
		}
		});
		btnCrew1.setBounds(12, 245, 130, 25);
		frmSpaceExplorer.getContentPane().add(btnCrew1);
		
		JButton btnCrew3 = new JButton(btn3);
		btnCrew3.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrew3.setVerticalAlignment(SwingConstants.TOP);
		btnCrew3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			 index = 0;
			 for(CrewMember member: manager.crew_members) {
					index +=1;
					if(index == 3) {
						manager.selectcrew = member;
						textStstus.setText(member.viewStatus());
				}
			}
		}
		});
		btnCrew3.setBounds(12, 311, 130, 25);
		frmSpaceExplorer.getContentPane().add(btnCrew3);
		
		JButton btnCrew2 = new JButton(btn2);
		btnCrew2.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrew2.setVerticalAlignment(SwingConstants.TOP);
		btnCrew2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			 index = 0;
			 for(CrewMember member: manager.crew_members) {
					index +=1;
					if(index == 2) {
						manager.selectcrew = member;
						textStstus.setText(member.viewStatus());
				}
			}
		}
		});
		btnCrew2.setBounds(174, 245, 131, 25);
		frmSpaceExplorer.getContentPane().add(btnCrew2);
		
		JButton btnCrew4 = new JButton(btn4);
		btnCrew4.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrew4.setVerticalAlignment(SwingConstants.TOP);
		btnCrew4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			 index = 0;
			 for(CrewMember member: manager.crew_members) {
					index +=1;
					if(index == 4) {
						manager.selectcrew = member;
						textStstus.setText(member.viewStatus());
				}
			}
		}
		});
		btnCrew4.setBounds(174, 311, 131, 25);
		frmSpaceExplorer.getContentPane().add(btnCrew4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(466, 245, -136, 140);
		frmSpaceExplorer.getContentPane().add(separator);
		
		
	}
}

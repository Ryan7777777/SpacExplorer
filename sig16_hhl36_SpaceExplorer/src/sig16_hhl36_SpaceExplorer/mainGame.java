package sig16_hhl36_SpaceExplorer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class mainGame {

	private JFrame frame;
	private GameManager manager;

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
	public void finishedWindow() {
		manager.closeMainScreen(this);
	}

	/**
	 * Create the application.
	 */
	public mainGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 825, 605);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		
		JLabel lblFoodItem = new JLabel("");
		lblFoodItem.setVerticalAlignment(SwingConstants.TOP);
		lblFoodItem.setBounds(553, 42, 242, 209);
		frame.getContentPane().add(lblFoodItem);
		
		JLabel lblMedical = new JLabel("Crew's Medical Item");
		lblMedical.setBounds(553, 264, 150, 22);
		frame.getContentPane().add(lblMedical);
		
		JLabel lblMedicalItem = new JLabel("");
		lblMedicalItem.setVerticalAlignment(SwingConstants.TOP);
		lblMedicalItem.setBounds(553, 299, 242, 209);
		frame.getContentPane().add(lblMedicalItem);
		
		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.setBounds(12, 483, 97, 25);
		frame.getContentPane().add(btnNextDay);
		
		JButton btnBuyFood = new JButton("Buy Food");
		btnBuyFood.setBounds(174, 483, 97, 25);
		frame.getContentPane().add(btnBuyFood);
		
		JButton btnBuyMedical = new JButton("Buy Medical Item");
		btnBuyMedical.setBounds(352, 483, 97, 25);
		frame.getContentPane().add(btnBuyMedical);
		
		JButton btnPeform = new JButton("peform");
		btnPeform.setBounds(12, 412, 97, 25);
		frame.getContentPane().add(btnPeform);
		
		JButton btnStatus = new JButton("Status");
		btnStatus.setBounds(174, 412, 97, 25);
		frame.getContentPane().add(btnStatus);
		
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
		
		JLabel lblCrewMoney = new JLabel("");
		lblCrewMoney.setBounds(112, 158, 159, 16);
		frame.getContentPane().add(lblCrewMoney);
		
		JLabel lblCrewStatus = new JLabel("Crew Status");
		lblCrewStatus.setBounds(317, 216, 97, 16);
		frame.getContentPane().add(lblCrewStatus);
		
		JLabel lblStatus = new JLabel("");
		lblStatus.setVerticalAlignment(SwingConstants.TOP);
		lblStatus.setBounds(317, 245, 180, 170);
		frame.getContentPane().add(lblStatus);
		
		JButton btnCrew1 = new JButton("");
		btnCrew1.setVerticalAlignment(SwingConstants.TOP);
		btnCrew1.setBounds(12, 245, 97, 25);
		frame.getContentPane().add(btnCrew1);
		
		JButton btnCrew3 = new JButton("");
		btnCrew3.setVerticalAlignment(SwingConstants.TOP);
		btnCrew3.setBounds(12, 311, 97, 25);
		frame.getContentPane().add(btnCrew3);
		
		JButton btnCrew2 = new JButton("");
		btnCrew2.setVerticalAlignment(SwingConstants.TOP);
		btnCrew2.setBounds(135, 245, 97, 25);
		frame.getContentPane().add(btnCrew2);
		
		JButton btnCrew4 = new JButton("");
		btnCrew4.setVerticalAlignment(SwingConstants.TOP);
		btnCrew4.setBounds(135, 311, 97, 25);
		frame.getContentPane().add(btnCrew4);
	}
}

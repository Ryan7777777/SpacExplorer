package sig16_hhl36_SpaceExplorer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class UseItem {

	private JFrame frame;
	private GameManager manager;
	/**
	 * Launch the application.
	 */
	public UseItem(GameManager incomingManager){
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	public void closeWindow() {
		frame.dispose();
	}
	public void finishedWindow() {
		manager.closeUseItem(this);
	}
	
	/**
	 * Create the application.
	 */
	public UseItem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 742, 548);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEat = new JLabel("Eat:");
		lblEat.setBounds(12, 67, 56, 16);
		frame.getContentPane().add(lblEat);
		
		JButton btnFood1 = new JButton("");
		btnFood1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnFood1.setBounds(12, 131, 138, 41);
		frame.getContentPane().add(btnFood1);
		
		JButton btnFood2 = new JButton("");
		btnFood2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnFood2.setBounds(178, 131, 138, 41);
		frame.getContentPane().add(btnFood2);
		
		JButton btnFood3 = new JButton("");
		btnFood3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnFood3.setBounds(348, 131, 138, 41);
		frame.getContentPane().add(btnFood3);
		
		JButton btnFood4 = new JButton("");
		btnFood4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnFood4.setBounds(12, 197, 138, 41);
		frame.getContentPane().add(btnFood4);
		
		JButton btnFood5 = new JButton("");
		btnFood5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnFood5.setBounds(178, 197, 138, 41);
		frame.getContentPane().add(btnFood5);
		
		JButton btnFood6 = new JButton("");
		btnFood6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnFood6.setBounds(348, 197, 138, 41);
		frame.getContentPane().add(btnFood6);
		
		JLabel lblMedicalItem = new JLabel("Medical Item:");
		lblMedicalItem.setBounds(12, 308, 100, 16);
		frame.getContentPane().add(lblMedicalItem);
		
		JButton btnMed1 = new JButton("");
		btnMed1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMed1.setBounds(12, 364, 138, 41);
		frame.getContentPane().add(btnMed1);
		
		JButton btnMed2 = new JButton("");
		btnMed2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMed2.setBounds(178, 364, 138, 41);
		frame.getContentPane().add(btnMed2);
		
		JButton btnMed3 = new JButton("");
		btnMed3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMed3.setBounds(348, 364, 138, 41);
		frame.getContentPane().add(btnMed3);
		
		JLabel lblCrewStatus = new JLabel("Crew Status");
		lblCrewStatus.setBounds(530, 98, 94, 16);
		frame.getContentPane().add(lblCrewStatus);
		
		JTextArea txtStatus = new JTextArea();
		txtStatus.setBackground(SystemColor.control);
		txtStatus.setBounds(530, 127, 182, 215);
		frame.getContentPane().add(txtStatus);
		
		JLabel lblNewLabel = new JLabel("No action left cannot use anymore item to day");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(41, 13, 431, 57);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnExit.setBounds(615, 452, 97, 25);
		frame.getContentPane().add(btnExit);
	}

}

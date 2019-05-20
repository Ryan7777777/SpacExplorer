package sig16_hhl36_SpaceExplorer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Store {

	private JFrame frame;
	private GameManager manager;
	/**
	 * Launch the application.
	 */
	public Store(GameManager incomingManager){
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	public void closeWindow() {
		frame.dispose();
	}
	public void finishedWindow() {
		manager.closeStore(this);
	}

	/**
	 * Create the application.
	 */
	public Store() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 649, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnFood1 = new JButton("New button");
		btnFood1.setBounds(46, 112, 97, 25);
		frame.getContentPane().add(btnFood1);
		
		JButton btnFood2 = new JButton("New button");
		btnFood2.setBounds(193, 112, 97, 25);
		frame.getContentPane().add(btnFood2);
		
		JButton btnFood3 = new JButton("New button");
		btnFood3.setBounds(344, 112, 97, 25);
		frame.getContentPane().add(btnFood3);
		
		JButton btnFood4 = new JButton("New button");
		btnFood4.setBounds(46, 150, 97, 25);
		frame.getContentPane().add(btnFood4);
		
		JButton btnFood5 = new JButton("New button");
		btnFood5.setBounds(193, 150, 97, 25);
		frame.getContentPane().add(btnFood5);
		
		JButton btnFood6 = new JButton("New button");
		btnFood6.setBounds(344, 150, 97, 25);
		frame.getContentPane().add(btnFood6);
		
		JButton btnMed1 = new JButton("New button");
		btnMed1.setBounds(46, 245, 97, 25);
		frame.getContentPane().add(btnMed1);
		
		JButton bntMed2 = new JButton("New button");
		bntMed2.setBounds(193, 245, 97, 25);
		frame.getContentPane().add(bntMed2);
		
		JButton btnMed3 = new JButton("New button");
		btnMed3.setBounds(344, 245, 97, 25);
		frame.getContentPane().add(btnMed3);
		
		JButton btnMed4 = new JButton("New button");
		btnMed4.setBounds(46, 283, 97, 25);
		frame.getContentPane().add(btnMed4);
		
		JButton btnMed5 = new JButton("New button");
		btnMed5.setBounds(193, 283, 97, 25);
		frame.getContentPane().add(btnMed5);
		
		JButton btnMed6 = new JButton("New button");
		btnMed6.setBounds(344, 283, 97, 25);
		frame.getContentPane().add(btnMed6);
		
		JLabel lblNewLabel = new JLabel("Space Outpost:");
		lblNewLabel.setBounds(12, 13, 161, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblFoodItems = new JLabel("Food Items");
		lblFoodItems.setBounds(12, 66, 97, 16);
		frame.getContentPane().add(lblFoodItems);
		
		JLabel lblMediaclItems = new JLabel("Mediacl Items");
		lblMediaclItems.setBounds(12, 207, 85, 16);
		frame.getContentPane().add(lblMediaclItems);
		
		JButton btnExit = new JButton("Exit Store");
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnExit.setBounds(498, 334, 97, 25);
		frame.getContentPane().add(btnExit);
	}

}

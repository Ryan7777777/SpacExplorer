package sig16_hhl36_SpaceExplorer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class Store {

	private JFrame frame;
	private GameManager manager;
	JFrame parent = new JFrame();
	private double price;
	Food_Item banana = new Banana();
	Food_Item butterchicken = new ButterChicken();
	Food_Item hamsandwihes = new HamSandwiches();
	Food_Item peaches = new Peaches();
	Food_Item spaghetti_bolonese = new SpaghettiBolognese();
	Food_Item straeberries = new Strawberries();
	Medical_Item plagurcure = new PlagueCure();
	Medical_Item samllmedpack = new SmallMedPack();
	Medical_Item bigmedpack = new LargeMedPack();

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
	 * @wbp.parser.constructor
	 */
	public Store() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 935, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblError = new JLabel("");
		lblError.setBounds(290, 42, 249, 16);
		frame.getContentPane().add(lblError);
		
		JLabel lblMoney = new JLabel(Double.toString(manager.getmoney()));
		lblMoney.setBounds(253, 42, 97, 16);
		frame.getContentPane().add(lblMoney);
		
		JButton btnFood1 = new JButton("Banana");
		btnFood1.setBounds(46, 104, 127, 47);
		btnFood1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			if(manager.getmoney() >= banana.getPrice()) {
				manager.foodPurchase(banana);
				price = manager.getmoney();
				lblMoney.setText(Double.toString(price));
			} else {
				JOptionPane.showMessageDialog(parent, "Not enough money");
			}
		}
		});
		frame.getContentPane().add(btnFood1);
		
		JButton btnFood2 = new JButton("Butter Chicken");
		btnFood2.setBounds(205, 104, 127, 47);
		btnFood2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			if(manager.getmoney() >= butterchicken.getPrice()) {
				manager.foodPurchase(butterchicken);
				price = manager.getmoney();
				lblMoney.setText(Double.toString(price));
			} else {
				JOptionPane.showMessageDialog(parent, "Not enough money");
			}
		}
		});
		frame.getContentPane().add(btnFood2);
		
		JButton btnFood3 = new JButton("Ham Sandwihes");
		btnFood3.setBounds(376, 104, 127, 47);
		btnFood3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			if(manager.getmoney() >= hamsandwihes.getPrice()) {
				manager.foodPurchase(hamsandwihes);
				price = manager.getmoney();
				lblMoney.setText(Double.toString(price));
			} else {
				JOptionPane.showMessageDialog(parent, "Not enough money");
			}
		}
		});
		frame.getContentPane().add(btnFood3);
		
		JButton btnFood4 = new JButton("Peaches");
		btnFood4.setBounds(46, 182, 127, 47);
		btnFood4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			if(manager.getmoney() >= peaches.getPrice()) {
				manager.foodPurchase(peaches);
				price = manager.getmoney();
				lblMoney.setText(Double.toString(price));
			} else {
				JOptionPane.showMessageDialog(parent, "Not enough money");
			}
		}
		});
		frame.getContentPane().add(btnFood4);
		
		JButton btnFood5 = new JButton("Spaghetti Bolonese");
		btnFood5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnFood5.setBounds(205, 183, 127, 47);
		btnFood5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			if(manager.getmoney() >= spaghetti_bolonese.getPrice()) {
				manager.foodPurchase(spaghetti_bolonese);
				price = manager.getmoney();
				lblMoney.setText(Double.toString(price));
			} else {
				JOptionPane.showMessageDialog(parent, "Not enough money");
			}
		}
		});
		frame.getContentPane().add(btnFood5);
		
		JButton btnFood6 = new JButton("Straeberries");
		btnFood6.setBounds(376, 182, 127, 47);
		btnFood6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			if(manager.getmoney() >= straeberries.getPrice()) {
				manager.foodPurchase(straeberries);
				price = manager.getmoney();
				lblMoney.setText(Double.toString(price));
			} else {
				JOptionPane.showMessageDialog(parent, "Not enough money");
			}
		}
		});
		frame.getContentPane().add(btnFood6);
		
		JButton btnMed1 = new JButton("Plagurcure");
		btnMed1.setBounds(46, 281, 127, 42);
		btnMed1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			if(manager.getmoney() >= plagurcure.getPrice()) {
				manager.medPurchase(plagurcure);
				price = manager.getmoney();
				lblMoney.setText(Double.toString(price));
			} else {
				JOptionPane.showMessageDialog(parent, "Not enough money");
			}
		}
		});
		frame.getContentPane().add(btnMed1);
		
		JButton bntMed2 = new JButton("Small Med Pack");
		bntMed2.setBounds(205, 278, 127, 45);
		bntMed2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			if(manager.getmoney() >= samllmedpack.getPrice()) {
				manager.medPurchase(samllmedpack);
				price = manager.getmoney();
				lblMoney.setText(Double.toString(price));
			} else {
				JOptionPane.showMessageDialog(parent, "Not enough money");
			}
		}
		});
		frame.getContentPane().add(bntMed2);
		
		JButton btnMed3 = new JButton("Large Med Pack");
		btnMed3.setBounds(376, 276, 127, 47);
		btnMed3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			if(manager.getmoney() >= bigmedpack.getPrice()) {
				manager.medPurchase(bigmedpack);
				price = manager.getmoney();
				lblMoney.setText(Double.toString(price));
			} else {
				JOptionPane.showMessageDialog(parent, "Not enough money");
			}
		}
		});
		frame.getContentPane().add(btnMed3);
	
		
		JLabel lblNewLabel = new JLabel("Space Outpost:");
		lblNewLabel.setBounds(12, 13, 161, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblFoodItems = new JLabel("Food Items");
		lblFoodItems.setBounds(12, 66, 97, 16);
		frame.getContentPane().add(lblFoodItems);
		
		JLabel lblMediaclItems = new JLabel("Mediacl Items");
		lblMediaclItems.setBounds(12, 241, 85, 16);
		frame.getContentPane().add(lblMediaclItems);
		
		JButton btnExit = new JButton("Exit Store");
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnExit.setBounds(406, 395, 97, 25);
		frame.getContentPane().add(btnExit);
		
		JLabel lblCrewMoney = new JLabel("Crew's Money");
		lblCrewMoney.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCrewMoney.setBounds(82, 37, 118, 25);
		frame.getContentPane().add(lblCrewMoney);
		
		JTextPane txtFood = new JTextPane();
		txtFood.setText(manager.viewFood());
		txtFood.setBackground(SystemColor.control);
		txtFood.setBounds(554, 99, 161, 369);
		frame.getContentPane().add(txtFood);
		
		JTextPane txtMed = new JTextPane();
		txtMed.setText((String) null);
		txtMed.setText(manager.viewMed());
		txtMed.setBackground(SystemColor.menu);
		txtMed.setBounds(744, 99, 161, 369);
		frame.getContentPane().add(txtMed);
	}

}

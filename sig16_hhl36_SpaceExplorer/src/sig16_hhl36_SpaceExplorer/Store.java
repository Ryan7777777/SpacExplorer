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

	private JFrame frmSpaceOutpost;
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
		frmSpaceOutpost.setVisible(true);
	}
	public void closeWindow() {
		frmSpaceOutpost.dispose();
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
		frmSpaceOutpost = new JFrame();
		frmSpaceOutpost.setTitle("Space Outpost");
		frmSpaceOutpost.setBounds(100, 100, 935, 545);
		frmSpaceOutpost.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpaceOutpost.getContentPane().setLayout(null);
		
		JLabel lblError = new JLabel("");
		lblError.setBounds(290, 42, 249, 16);
		frmSpaceOutpost.getContentPane().add(lblError);
		
		JLabel lblMoney = new JLabel(Double.toString(manager.getmoney()));
		lblMoney.setBounds(253, 42, 97, 16);
		frmSpaceOutpost.getContentPane().add(lblMoney);
		
		JButton btnFood1 = new JButton("Banana");
		btnFood1.setBounds(46, 104, 159, 47);
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
		frmSpaceOutpost.getContentPane().add(btnFood1);
		
		JButton btnFood2 = new JButton("Butter Chicken");
		btnFood2.setBounds(217, 104, 159, 47);
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
		frmSpaceOutpost.getContentPane().add(btnFood2);
		
		JButton btnFood3 = new JButton("Ham Sandwiches");
		btnFood3.setBounds(388, 104, 159, 47);
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
		frmSpaceOutpost.getContentPane().add(btnFood3);
		
		JButton btnFood4 = new JButton("Peaches");
		btnFood4.setBounds(46, 182, 159, 47);
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
		frmSpaceOutpost.getContentPane().add(btnFood4);
		
		JButton btnFood5 = new JButton("Spaghetti Bolognese");
		btnFood5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFood5.setBounds(217, 182, 159, 47);
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
		frmSpaceOutpost.getContentPane().add(btnFood5);
		
		JButton btnFood6 = new JButton("Strawberries");
		btnFood6.setBounds(388, 182, 159, 47);
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
		frmSpaceOutpost.getContentPane().add(btnFood6);
		
		JButton btnMed1 = new JButton("Plagurcure");
		btnMed1.setBounds(46, 278, 159, 47);
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
		frmSpaceOutpost.getContentPane().add(btnMed1);
		
		JButton bntMed2 = new JButton("Small Med Pack");
		bntMed2.setBounds(217, 278, 159, 47);
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
		frmSpaceOutpost.getContentPane().add(bntMed2);
		
		JButton btnMed3 = new JButton("Large Med Pack");
		btnMed3.setBounds(388, 278, 159, 47);
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
		frmSpaceOutpost.getContentPane().add(btnMed3);
	
		
		JLabel lblNewLabel = new JLabel("Space Outpost:");
		lblNewLabel.setBounds(12, 13, 161, 16);
		frmSpaceOutpost.getContentPane().add(lblNewLabel);
		
		JLabel lblFoodItems = new JLabel("Food Items");
		lblFoodItems.setBounds(12, 66, 97, 16);
		frmSpaceOutpost.getContentPane().add(lblFoodItems);
		
		JLabel lblMediaclItems = new JLabel("Medical Items");
		lblMediaclItems.setBounds(12, 241, 85, 16);
		frmSpaceOutpost.getContentPane().add(lblMediaclItems);
		
		JButton btnExit = new JButton("Exit Store");
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnExit.setBounds(394, 407, 159, 47);
		frmSpaceOutpost.getContentPane().add(btnExit);
		
		JLabel lblCrewMoney = new JLabel("Crew's Money");
		lblCrewMoney.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCrewMoney.setBounds(82, 37, 118, 25);
		frmSpaceOutpost.getContentPane().add(lblCrewMoney);
		
		JTextPane txtFood = new JTextPane();
		txtFood.setText(manager.viewFood());
		txtFood.setBackground(SystemColor.control);
		txtFood.setBounds(554, 99, 161, 369);
		frmSpaceOutpost.getContentPane().add(txtFood);
		
		JTextPane txtMed = new JTextPane();
		txtMed.setText((String) null);
		txtMed.setText(manager.viewMed());
		txtMed.setBackground(SystemColor.menu);
		txtMed.setBounds(744, 99, 161, 369);
		frmSpaceOutpost.getContentPane().add(txtMed);
	}

}

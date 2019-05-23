package sig16_hhl36_SpaceExplorer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;

public class UseItem {

	private JFrame frame;
	JFrame parent = new JFrame();
	private GameManager manager;
	private String btn1;
	private String btn2;
	private String btn3;
	private String btn4;
	private String btn5;
	private String btn6;
	private String btn7;
	private String btn8;
	private String btn9;
	private int index;
	/**
	 * Launch the application.
	 */
	public UseItem(GameManager incomingManager){
		manager = incomingManager;
		setFoodButton();
		setMedicalButton();
		initialize();
		frame.setVisible(true);
	}
	public void closeWindow() {
		frame.dispose();
	}
	public void finishedWindow() {
		manager.closeUseItem(this);
	}
	public void setFoodButton() {
		if(manager.crew_food.size() == 0) {
			btn1 = "";
			btn2 = "";
			btn3 = "";
			btn4 = "";
			btn5 = "";
			btn6 = "";
		} else {
			index = -1;
			for (Food_Item food: manager.crew_food) {
				index += 1;
				if(index == 0) {
					btn1 = food.getFoodName();
					btn2 = "";
					btn3 = "";
					btn4 = "";
					btn5 = "";
					btn6 = "";
				}
				else if (index == 1) {
					btn2 = food.getFoodName();
					btn3 = "";
					btn4 = "";
					btn5 = "";
					btn6 = "";
				} else if(index == 2) {
					btn3 = food.getFoodName();
					btn4 = "";
					btn5 = "";
					btn6 = "";
				} else if(index == 3) {
					btn4 = food.getFoodName();
					btn5 = "";
					btn6 = "";
				} else if(index == 4) {
					btn5 = food.getFoodName();
					btn6 ="";
				} else {
					btn6 =food.getFoodName();
				}
		}
		}
	}
	public void setMedicalButton() {
		if(manager.crew_medical.size() == 0) {
			btn7 = "";
			btn8 = "";
			btn9 = "";
		} else {
			index = -1;
			for (Medical_Item med: manager.crew_medical) {
				index += 1;
				if(index == 0) {
					btn7 = med.getMedName();
					btn8 = "";
					btn9 = "";
				}
				else if (index == 1) {
					btn8 =  med.getMedName();
					btn9= "";
				} else{
					btn9 =  med.getMedName();
				}
			}
		}
	}

	/**
	 * Create the application.
	 * @wbp.parser.constructor
	 */
	public UseItem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 801, 557);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEat = new JLabel("Eat:");
		lblEat.setBounds(12, 67, 56, 16);
		frame.getContentPane().add(lblEat);
		
		JTextArea txtStatus = new JTextArea();
		txtStatus.setText(manager.selectCrew.viewStatus());
		txtStatus.setBackground(SystemColor.control);
		txtStatus.setBounds(589, 175, 182, 215);
		frame.getContentPane().add(txtStatus);
		
		JButton btnFood1 = new JButton(btn1);
		JButton btnFood2 = new JButton(btn2);
		JButton btnFood3 = new JButton(btn3);
		JButton btnFood4 = new JButton(btn4);
		JButton btnFood5 = new JButton(btn5);
		JButton btnFood6 = new JButton(btn6);
		btnFood1.setHorizontalAlignment(SwingConstants.LEFT);
		btnFood1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(manager.crew_food.size()>0 && manager.selectCrew.getAction()>0) {
			index = 1;
			for (Food_Item food: manager.crew_food) {
				if(index ==1) {
				System.out.println(food);
				manager.eat(manager.selectCrew, food);
				setFoodButton();
				txtStatus.setText(manager.selectCrew.viewStatus());
				btnFood1.setText(btn1);
				btnFood2.setText(btn2);
				btnFood3.setText(btn3);
				btnFood4.setText(btn4);
				btnFood5.setText(btn5);
				btnFood6.setText(btn6);
				if(manager.selectCrew.getAction() == 0) {
					JOptionPane.showMessageDialog(parent, "No action left");
					finishedWindow();
				}
				break;
			}
		}
		}
		}
		});
		btnFood1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnFood1.setBounds(12, 131, 170, 25);
		frame.getContentPane().add(btnFood1);
		
		btnFood2.setHorizontalAlignment(SwingConstants.LEFT);
		btnFood2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(manager.crew_food.size()>0 && manager.selectCrew.getAction()>0) {
			index = 1;
			for (Food_Item food: manager.crew_food) {
				if(index == 2) {
				manager.eat(manager.selectCrew, food);
				setFoodButton();
				txtStatus.setText(manager.selectCrew.viewStatus());
				btnFood1.setText(btn1);
				btnFood2.setText(btn2);
				btnFood3.setText(btn3);
				btnFood4.setText(btn4);
				btnFood5.setText(btn5);
				btnFood6.setText(btn6);
				if(manager.selectCrew.getAction() == 0) {
					JOptionPane.showMessageDialog(parent, "No action left");
					finishedWindow();
				}
				break;
			}
				index +=1;
		}
		}
		}
		});
		btnFood2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnFood2.setBounds(206, 131, 170, 25);
		frame.getContentPane().add(btnFood2);
		
		btnFood3.setHorizontalAlignment(SwingConstants.LEFT);
		btnFood3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.crew_food.size()>0 && manager.selectCrew.getAction()>0) {
				index = 1;
				for (Food_Item food: manager.crew_food) {
					if(index == 3) {
					manager.eat(manager.selectCrew, food);
					setFoodButton();
					txtStatus.setText(manager.selectCrew.viewStatus());
					btnFood1.setText(btn1);
					btnFood2.setText(btn2);
					btnFood3.setText(btn3);
					btnFood4.setText(btn4);
					btnFood5.setText(btn5);
					btnFood6.setText(btn6);
					if(manager.selectCrew.getAction() == 0) {
						JOptionPane.showMessageDialog(parent, "No action left");
						finishedWindow();
					}
					break;
				}
					index +=1;
			}
			}
			}
			});
		btnFood3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnFood3.setBounds(407, 131, 170, 25);
		frame.getContentPane().add(btnFood3);
		
		btnFood4.setHorizontalAlignment(SwingConstants.LEFT);
		btnFood4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.crew_food.size()>0 && manager.selectCrew.getAction()>0) {
				index = 1;
				for (Food_Item food: manager.crew_food) {
					if(index == 4) {
					manager.eat(manager.selectCrew, food);
					setFoodButton();
					txtStatus.setText(manager.selectCrew.viewStatus());
					btnFood1.setText(btn1);
					btnFood2.setText(btn2);
					btnFood3.setText(btn3);
					btnFood4.setText(btn4);
					btnFood5.setText(btn5);
					btnFood6.setText(btn6);
					if(manager.selectCrew.getAction() == 0) {
						JOptionPane.showMessageDialog(parent, "No action left");
						finishedWindow();
					}
					break;
				}
					index +=1;
			}
			}
			}
			});
		btnFood4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnFood4.setBounds(12, 197, 170, 25);
		frame.getContentPane().add(btnFood4);
		
		btnFood5.setHorizontalAlignment(SwingConstants.LEFT);
		btnFood5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.crew_food.size()>0 && manager.selectCrew.getAction()>0) {
				index = 1;
				for (Food_Item food: manager.crew_food) {
					if(index == 5) {
					manager.eat(manager.selectCrew, food);
					setFoodButton();
					txtStatus.setText(manager.selectCrew.viewStatus());
					btnFood1.setText(btn1);
					btnFood2.setText(btn2);
					btnFood3.setText(btn3);
					btnFood4.setText(btn4);
					btnFood5.setText(btn5);
					btnFood6.setText(btn6);
					if(manager.selectCrew.getAction() == 0) {
						JOptionPane.showMessageDialog(parent, "No action left");
						finishedWindow();
					}
					break;
				}
					index +=1;
			}
			}
			}
			});
		btnFood5.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnFood5.setBounds(206, 197, 170, 25);
		frame.getContentPane().add(btnFood5);
		
		btnFood6.setHorizontalAlignment(SwingConstants.LEFT);
		btnFood6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.crew_food.size()>0 && manager.selectCrew.getAction()>0) {
				index = 1;
				for (Food_Item food: manager.crew_food) {
					if(index == 6) {
					manager.eat(manager.selectCrew, food);
					setFoodButton();
					txtStatus.setText(manager.selectCrew.viewStatus());
					btnFood1.setText(btn1);
					btnFood2.setText(btn2);
					btnFood3.setText(btn3);
					btnFood4.setText(btn4);
					btnFood5.setText(btn5);
					btnFood6.setText(btn6);
					if(manager.selectCrew.getAction() == 0) {
						JOptionPane.showMessageDialog(parent, "No action left");
						finishedWindow();
					}
					break;
				}
					index +=1;
			}
			}
			}
			});
		btnFood6.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnFood6.setBounds(407, 197, 170, 25);
		frame.getContentPane().add(btnFood6);
		
		JLabel lblMedicalItem = new JLabel("Medical Item:");
		lblMedicalItem.setBounds(12, 308, 100, 16);
		frame.getContentPane().add(lblMedicalItem);
		
		JButton btnMed1 = new JButton(btn7);
		JButton btnMed2 = new JButton(btn8);
		JButton btnMed3 = new JButton(btn9);
		btnMed1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.crew_medical.size()>0 && manager.selectCrew.getAction()>0) {
				index = 1;
				for (Medical_Item med: manager.crew_medical) {
					if(index ==1) {
					manager.useemditem(manager.selectCrew, med);
					setMedicalButton();
					txtStatus.setText(manager.selectCrew.viewStatus());
					btnMed1.setText(btn7);
					btnMed2.setText(btn8);
					btnMed3.setText(btn9);
					if(manager.selectCrew.getAction() == 0) {
						JOptionPane.showMessageDialog(parent, "No action left");
						finishedWindow();
					}
					break;
				}
			}
			}
			}
			});
		btnMed1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMed1.setBounds(12, 380, 170, 25);
		frame.getContentPane().add(btnMed1);
		
		btnMed2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.crew_medical.size()>0 && manager.selectCrew.getAction()>0) {
				index = 1;
				for (Medical_Item med: manager.crew_medical) {
					if(index ==2) {
					manager.useemditem(manager.selectCrew, med);
					setMedicalButton();
					txtStatus.setText(manager.selectCrew.viewStatus());
					btnMed1.setText(btn7);
					btnMed2.setText(btn8);
					btnMed3.setText(btn9);
					if(manager.selectCrew.getAction() == 0) {
						JOptionPane.showMessageDialog(parent, "No action left");
						finishedWindow();
					}
					break;
				}
					index+=1;
			}
			}
			}
			});
		btnMed2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMed2.setBounds(206, 380, 170, 27);
		frame.getContentPane().add(btnMed2);
		
		btnMed3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.crew_medical.size()>0 && manager.selectCrew.getAction()>0) {
				index = 1;
				for (Medical_Item med: manager.crew_medical) {
					if(index == 3) {
					manager.useemditem(manager.selectCrew, med);
					setMedicalButton();
					txtStatus.setText(manager.selectCrew.viewStatus());
					btnMed1.setText(btn7);
					btnMed2.setText(btn8);
					btnMed3.setText(btn9);
					if(manager.selectCrew.getAction() == 0) {
						JOptionPane.showMessageDialog(parent, "No action left");
						finishedWindow();
					}
					break;
				}
					index+=1;
			}
			}
			}
			});
		btnMed3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMed3.setBounds(407, 380, 170, 25);
		frame.getContentPane().add(btnMed3);
		
		JLabel lblCrewStatus = new JLabel("Crew Status");
		lblCrewStatus.setBounds(589, 131, 94, 16);
		frame.getContentPane().add(lblCrewStatus);
		
		
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

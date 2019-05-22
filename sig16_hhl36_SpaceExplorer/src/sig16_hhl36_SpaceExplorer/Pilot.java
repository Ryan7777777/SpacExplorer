package sig16_hhl36_SpaceExplorer;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Pilot {

	private JFrame frame;
	private GameManager manager;
	public CrewMember member2;
	public CrewMember member3;
	public CrewMember member4;
	JFrame parent = new JFrame();
	private String btn1;
	private String btn2;
	private String btn3;
	private int index;
	/**
	 * Launch the application.
	 */
	public Pilot(GameManager incomingManager){
		manager = incomingManager;
		setup();
		initialize();
		frame.setVisible(true);
	}
	public void closeWindow() {
		frame.dispose();
	}
	public void finishedWindow() {
		manager.closePilot(this);
	}
	public void setup() {
		index = 0;
		for (CrewMember member: manager.crew_members) {
			if(member == manager.selectcrew) {}else {
				index += 1;
				if(index == 1 && member.getaction()>0) {
					member2 = member;
					btn1 = (member.getName());
				}
				else if (index == 2 &&member.getaction()>0) {
					member3 = member;
					btn2 = (member.getName());
					
				} else{if(member.getaction()>0) {
					member4=  member;
					btn3 = member.getName();
					}}
		}
		}
	}
	/**
	 * Create the application.
	 * @wbp.parser.constructor
	 */
	public Pilot() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.setBounds(100, 100, 517, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblChooseOneMore = new JLabel("Choose one more to drive with ");
		lblChooseOneMore.setBounds(28, 27, 185, 16);
		frame.getContentPane().add(lblChooseOneMore);
		
		JLabel lblCrew1 = new JLabel(manager.selectcrew.getName());
		lblCrew1.setBounds(225, 27, 56, 16);
		frame.getContentPane().add(lblCrew1);
		
		JButton btnCrew2 = new JButton(btn1);
		btnCrew2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(member2 == null) {}else {
				if(member2.action>0) {
				manager.newPlannet(manager.selectcrew,member2);
				JOptionPane.showMessageDialog(parent, "Event "+manager.randomevent+" occur!");
				finishedWindow();
			}
				}
			}
		});
		btnCrew2.setBounds(27, 94, 97, 25);
		frame.getContentPane().add(btnCrew2);
		
		JButton btnCrew3 = new JButton(btn2);
		btnCrew3.setBounds(156, 94, 97, 25);
		btnCrew3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(member3 == null) {}else {
				if(member3.action>0) {
				manager.newPlannet(manager.selectcrew, member3);
				JOptionPane.showMessageDialog(parent, "Event "+manager.randomevent+" occur!");
				finishedWindow();
			}
			}
			}
		});
		frame.getContentPane().add(btnCrew3);
		
		JButton btnCrew4 = new JButton(btn3);
		btnCrew4.setBounds(281, 94, 97, 25);
		btnCrew4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(member4 == null) {}else {
					if(member4.action>0 ) {
				manager.newPlannet(manager.selectcrew, member4);
				JOptionPane.showMessageDialog(parent, "Event "+manager.randomevent+" occur!");
				finishedWindow();
			}
			}
			}
		});
		frame.getContentPane().add(btnCrew4);
		
		JButton btnToMainScreen = new JButton("To Main Screen");
		btnToMainScreen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnToMainScreen.setBounds(347, 243, 140, 42);
		frame.getContentPane().add(btnToMainScreen);

}
}


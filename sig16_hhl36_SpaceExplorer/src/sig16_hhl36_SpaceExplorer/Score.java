package sig16_hhl36_SpaceExplorer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;

public class Score {

	private JFrame frame;
	private GameManager manager;
	/**
	 * Launch the application.
	 */
	public Score(GameManager incomingManager){
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	public void closeWindow() {
		frame.dispose();
	}
	public void finishedWindow() {
		manager.closeScore(this);
	}

	/**
	 * Create the application.
	 */
	public Score() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 620, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your score is:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblNewLabel.setBounds(24, 140, 296, 69);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblGameOver = new JLabel("Game Over!!");
		lblGameOver.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblGameOver.setForeground(Color.RED);
		lblGameOver.setBounds(174, 13, 215, 59);
		frame.getContentPane().add(lblGameOver);
		
		JLabel lblScore = new JLabel(String.valueOf(manager.Calaulatescore()));
		lblScore.setBackground(new Color(192, 192, 192));
		lblScore.setForeground(new Color(255, 255, 0));
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 44));
		lblScore.setBounds(317, 152, 247, 57);
		frame.getContentPane().add(lblScore);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(494, 248, 97, 25);
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		frame.getContentPane().add(btnExit);
	}
}

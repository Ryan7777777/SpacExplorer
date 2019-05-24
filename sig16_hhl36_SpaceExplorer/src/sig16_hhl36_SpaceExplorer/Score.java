package sig16_hhl36_SpaceExplorer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.UIManager;

public class Score {

	private JFrame frmGameOver;
	private GameManager manager;
	/**
	 * Launch the application.
	 */
	public Score(GameManager incomingManager){
		manager = incomingManager;
		initialize();
		frmGameOver.setVisible(true);
	}
	public void closeWindow() {
		frmGameOver.dispose();
	}
	public void finishedWindow() {
		manager.closeScore(this);
	}

	/**
	 * Create the application.
	 * @wbp.parser.constructor
	 */
	public Score() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGameOver = new JFrame();
		frmGameOver.setTitle("Game Over!");
		frmGameOver.setBounds(100, 100, 620, 343);
		frmGameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGameOver.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your score is:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblNewLabel.setBounds(24, 140, 296, 69);
		frmGameOver.getContentPane().add(lblNewLabel);
		
		JLabel lblGameOver = new JLabel("Game Over!!");
		lblGameOver.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblGameOver.setForeground(Color.RED);
		lblGameOver.setBounds(201, 43, 237, 69);
		frmGameOver.getContentPane().add(lblGameOver);
		
		JLabel lblScore = new JLabel(String.valueOf(manager.calcScore()));
		lblScore.setBackground(new Color(192, 192, 192));
		lblScore.setForeground(new Color(128, 128, 128));
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 44));
		lblScore.setBounds(299, 146, 247, 57);
		frmGameOver.getContentPane().add(lblScore);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(494, 248, 97, 25);
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		frmGameOver.getContentPane().add(btnExit);
	}
}

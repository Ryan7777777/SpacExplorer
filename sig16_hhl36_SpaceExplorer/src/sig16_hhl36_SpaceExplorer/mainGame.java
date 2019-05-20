package sig16_hhl36_SpaceExplorer;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class mainGame {

	private JFrame frame;
	private GameManager manager;
	/**
	 * Launch the application.
	 */
	public  mainGame(GameManager incomingManager){
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

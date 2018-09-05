package rhymes;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
	
	public static void startGUI() {
		
	JFrame frame = new JFrame("Rhyming Game");
	GameModel gameModel = new GameModel("src/rhymingDictionary.txt");
	GUI instance = new GUI(gameModel);
	
	frame.getContentPane().add(instance.getWordPanel(), BorderLayout.NORTH);
	frame.getContentPane().add(instance.getChoicesPanel(), BorderLayout.CENTER);
	frame.getContentPane().add(instance.getScorePanel(), BorderLayout.SOUTH);
	
	frame.pack();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
	public static void main(String [] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				startGUI();
			}
		});
//		RhymingDictionary test = new RhymingDictionary("src/rhymingDictionary.txt");
//		boolean b = test.isRhyme("STORM", "ghcvhj");
//		System.out.println(b);
	}
	
}

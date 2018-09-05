package rhymes;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {
	private GameModel gameModel;
	private String label1;
	private String label2;
	private String button1;
	private String button2;
	private String button3;
	private String button4;
	
	private JLabel l1;
	private JLabel l2;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;

	public GUI(GameModel gameModel) {
		super();
		this.gameModel = gameModel;
		this.label1 = gameModel.getGivenWord();
		Integer s =  gameModel.getScore();
		this.label2 = s.toString();
		this.button1 = gameModel.getChoices().get(0);
		this.button2 = gameModel.getChoices().get(1);
		this.button3 = gameModel.getChoices().get(2);
		this.button4 = gameModel.getChoices().get(3);
		this.l1 = new JLabel();
		this.l2 = new JLabel();
		this.b1 = new JButton();
		this.b2 = new JButton();
		this.b3 = new JButton();
		this.b4 = new JButton();
	}
	public String getButton1() {
		return button1;
	}
	public String getButton2() {
		return button2;
	}
	public String getButton3() {
		return button3;
	}
	public String getButton4() {
		return button4;
	}
	public void update() {
		gameModel.refresh();
		this.label1 = gameModel.getGivenWord();
		Integer s =  gameModel.getScore();
		this.label2 = s.toString();		
		this.button1 = gameModel.getChoices().get(0);
		this.button2 = gameModel.getChoices().get(1);
		this.button3 = gameModel.getChoices().get(2);
		this.button4 = gameModel.getChoices().get(3);
		l1.setText(this.label1);
		l2.setText(this.label2);
		b1.setText(this.button1);
		b2.setText(this.button2);
		b3.setText(this.button3);
		b4.setText(this.button4);
		
		//System.out.println("y");
	}
	public JPanel getWordPanel() {
		JPanel p = new JPanel();
		l1.setText(this.label1);
		p.add(l1);
		return p;
	}
	public JPanel getChoicesPanel() {
		JPanel p = new JPanel();
		b1.setText(this.button1);
		b1.addMouseListener(new AnswerListener(b1, gameModel, this));
		p.add(b1);
		b2.setText(this.button2);
		b2.addMouseListener(new AnswerListener(b2, gameModel, this));
		p.add(b2);
		b3.setText(this.button3);
		b3.addMouseListener(new AnswerListener(b3, gameModel, this));
		p.add(b3);
		b4.setText(this.button4);
		b4.addMouseListener(new AnswerListener(b4, gameModel, this));
		p.add(b4);
		return p;
	}
	public JPanel getScorePanel() {
		JPanel p = new JPanel();
		l2.setText(label2);
		p.add(l2);
		return p;
	}
}

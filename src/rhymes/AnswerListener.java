package rhymes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class AnswerListener implements MouseListener{
	private JButton button;
	private GameModel gameModel;
	private GUI gui;
	
	public AnswerListener(JButton button, GameModel gameModel, GUI gui) {
		super();
		this.button = button;
		this.gameModel = gameModel;
		this.gui = gui;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		button.setForeground(Color.BLUE);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		button.setForeground(Color.BLACK);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		button.setForeground(Color.WHITE);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		button.setForeground(Color.BLUE);
		gameModel.makeChoice(button.getText());
		gui.update();
	}
	
}

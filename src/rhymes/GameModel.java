package rhymes;

import java.util.ArrayList;

import rhymes.dictionary.RhymingDictionary;

public class GameModel {
	private String filename;
	private RhymingDictionary dict;
	private int score;
	private String referenceWord;
	private ArrayList<String> choices;
	
	public GameModel(String filename) {
		super();
		this.dict = new RhymingDictionary(filename);
		this.filename = filename;
		this.score = 0;
		this.referenceWord = dict.randomWord();
		this.choices = dict.getChoices(this.referenceWord);
	}
	public void refresh() {
		this.referenceWord = dict.randomWord();
		this.choices = dict.getChoices(this.referenceWord);
	}
	public void makeChoice(String in) {
		if(dict.isRhyme(this.referenceWord, in) == true) {
			this.score++;
		} else {
			this.score--;
		}
		System.out.println(getScore());
	}
	public int getScore() {
		return this.score;
	}
	public String getGivenWord() {
		return referenceWord;
	}
	public ArrayList<String> getChoices() {
		return choices;
	}
	

}

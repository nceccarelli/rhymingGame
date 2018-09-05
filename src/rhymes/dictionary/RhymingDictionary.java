package rhymes.dictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class RhymingDictionary {
	private String filename;
	private HashMap<String, ArrayList<String>> words;

	public RhymingDictionary(String filename) {
		super();
		//this.filename = "rhymingDictionary.txt";
		this.filename = filename;
		this.words = parseDictionary();
	}
	public HashMap<String, ArrayList<String>> parseDictionary(){
		HashMap<String, ArrayList<String>> lines = new HashMap<>();
		try {
			for (String line : Files.readAllLines(Paths.get(filename))) {
				ArrayList<String> desc = new ArrayList<>();
				String [] data = line.split(" ");
				String word = data[0];
				for (int i = 2; i < data.length; i++) {
					desc.add(data[i]);
				}
				lines.put(word, desc);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	public String parseInfo(String id) {
		String in = id.toUpperCase();
		ArrayList<String> info = new ArrayList<>();
		info = words.get(in);
		int n = info.size() - 1;
		String resp = "";
		for (int i = n; i >= 0; i--) {
			if (info.get(i).contains("0") || info.get(i).contains("1") || info.get(i).contains("2")) {
				String v1 = info.get(i);
				String v1N = v1.replaceAll("0", "");
				String v2N = v1N.replaceAll("1", "");
				String v = v2N.replaceAll("2", "");
				resp = resp + v;
				break;
			} else {
				resp = resp + info.get(i);
			}
		}
		return resp;
	}
	public boolean isRhyme(String in1, String in2) {
		boolean tf = false;
		String info1 = parseInfo(in1);
		String info2 = parseInfo(in2);
		if (info1.contentEquals(info2)) {
			tf = true;
		}
		return tf;
	}
	public ArrayList<String> getAllWords(){
		ArrayList<String> keys = new ArrayList<>();
		for (String s : words.keySet()) {
			keys.add(s);
		}
		return keys;
	}
	public String randomWord() {
		ArrayList<String> keys = getAllWords();
		Collections.shuffle(keys);
		return keys.get(0);
	}
	public ArrayList<String> getChoices(String in){
		ArrayList<String> rhyme = new ArrayList<>();
		ArrayList<String> notRhyme = new ArrayList<>();
		ArrayList<String> options = new ArrayList<>();
		for(String word : getAllWords()) {
			if (isRhyme(in, word) == true) {
				rhyme.add(word);
			} else {
				notRhyme.add(word);
			}
		}
		Collections.shuffle(rhyme);
		Collections.shuffle(notRhyme);
		options.add(rhyme.get(0));
		options.add(notRhyme.get(0));
		options.add(notRhyme.get(1));
		options.add(notRhyme.get(2));
		Collections.shuffle(options);
		return options;
	}
}

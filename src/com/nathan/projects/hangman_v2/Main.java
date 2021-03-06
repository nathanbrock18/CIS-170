package com.nathan.projects.hangman_v2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.nathan.projects.hangman_v2.Logic;





public class Main {
	
	public static String word;
	
	public String getWord() {
		return word;
	}

	/*public void setWord(String word) {
		this.word = word;
	}*/
	
	static List<String> words = new ArrayList<String>();
	
	public void loadFile() throws IOException {
		File f = new File("src/com/nathan/projects/hangman_v2/Util.txt");
		if(f.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String s;
			while((s = br.readLine()) != null) {
				words.add(s);
			}
		}
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		Logic l = new Logic();
		try {
			m.loadFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true) {
			while(l.keepRunning()) {
				l.checkStatus();
				try {
					l.writeFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				l.createMask();
				l.promptGuess();
				l.getInput();
				
			}
		}

		
		
		
	}
}

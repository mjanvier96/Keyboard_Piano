/*
 * Programming Homework 3
 *
 *
 * (c) 2015 Michael V. Janvier
 *
 * I pledge my honor that I have abided by the Stevens honor System
 *
 */

package Assign3;

import cos126.StdDraw;
import cos126.StdAudio;

public class GuitarHeroLite {
	static final String keyboard = "1234567890qwertyuiopasdfghjklzxcvbnm,";
	
	
    /**
     * @return user inputs a key from 1234567890qwertyuiopasdfghjklzxcvbnm,
     * which correspond to a note and plays the note slowly fading out
     *
     */
	public static void main(String args[]){
		GuitarString notes[] = new GuitarString[keyboard.length()];
		
		for(int i = 0; i < keyboard.length(); i++){//initiates frequency of notes
			notes[i] = new GuitarString(440 * Math.pow(2, (i-24)/12));
		}		

		while("pigs" != "fly"){
			 if(StdDraw.hasNextKeyTyped()){
				 char key = StdDraw.nextKeyTyped();//detects key press
                 if(keyboard.indexOf(key) != -1)
                     notes[keyboard.indexOf(key)].pluck();
			 }
			 double sample = 0;
			 for(int i = 0; i < notes.length; i++){//adds total of string samples
				 sample += notes[i].sample();
			 }
			 
			 StdAudio.play(sample);
			 
			 for(int i = 0; i < notes.length; i++){
				 notes[i].tic();//advances strings sound to 0
			 }
		}
	}
}



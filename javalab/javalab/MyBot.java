package main;

/*this class is part of the superclass Player
 * where it is one of the available moves
 * that the player can choose. My bot is 
 * a bot that will always win, it gets the
 * opponents move and then randomly decides
 * which of the two win cases it wants to use
 * to win.*/

import java.util.Random;

public class MyBot extends Player{

	public MyBot(String name) {														//Initialize the mybot method and return the name of this instance
		super(name);
	}

	@Override																		//override the method play that is found in the superclass Player
	public Element play() {															//play defines the logic that this bot will use to finish its turn
		Random rand = new Random();													//this bot uses the random number generator to chose either a 1 or a 2
		int i = rand.nextInt(2) + 0;												//based on that number it will choose one of the two options it is 
																					//presented with in order to beat the opponent.
		this.setPrevious(this.currentMove);											//when finished the method will return the move that it will use to beat the opponent
		
		if(this.getPrevious().getName() == "Rock") {
			if(i == 1) {
				Element mybot = new Paper("Paper");
				this.setCurrentMove(mybot);
				return mybot;
			}
			else{
				Element mybot = new Spock("Spock");
				this.setCurrentMove(mybot);
				return mybot;
			}
		}
		else if(this.getPrevious().getName() == "Paper") {
			if(i == 1) {
				Element mybot = new Scissors("Scissors");
				this.setCurrentMove(mybot);
				return mybot;
			}
			else {
				Element mybot = new Lizard("Lizard");
				this.setCurrentMove(mybot);
				return mybot;
			}
		}
		else if(this.getPrevious().getName() == "Scissors") {
			if(i == 1) {
				Element mybot = new Rock("Rock");
				this.setCurrentMove(mybot);
				return mybot;
			}
			else {
				Element mybot = new Spock("Spock");
				this.setCurrentMove(mybot);
				return mybot;
			}
		}
		else if(this.getPrevious().getName() == "Lizard") {
			if(i == 1) {
				Element mybot = new Scissors("Scissors");
				this.setCurrentMove(mybot);
				return mybot;
			}
			else {
				Element mybot = new Rock("Rock");
				this.setCurrentMove(mybot);
				return mybot;
			}
		}
		else{
			if(i == 1) {
				Element mybot = new Paper("Paper");
				this.setCurrentMove(mybot);
				return mybot;
			}
			else {
				Element mybot = new Lizard("Lizard");
				this.setCurrentMove(mybot);
				return mybot;
			}
		}
	}
	
	
}
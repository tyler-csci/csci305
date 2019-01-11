package main;

/*this class is part of the superclass Player
 * where is one of the available options of
 * a bot to play against. This bot uses a random 
 * generator to chose one of the options and
 * create an instance of that player.*/

import java.util.Random;

public class RandomBot extends Player{

	public RandomBot(String name) {														//initialize the method and return the name of the instance
		super(name);
	}

	@Override																			//override the play method in the superclass Player
	public Element play() {																//inside this method it returns everything that this bot will do
		Random rand = new Random();														// for the random bot it randomly chooses one of the available moves
		int randomNum = rand.nextInt(4) + 0;											//based on the random generator, will then return the bot instance that 
		if(randomNum == 0) {															//was chosen
			Element randombot = new Rock("Rock");
			return randombot;

		}
		else if(randomNum == 1) {
			Element randombot = new Paper("Paper");
			return randombot;

		}
		else if(randomNum == 2) {
			Element randombot = new Scissors("Scissors");
			return randombot;

		}
		else if(randomNum == 3) {
			Element randombot = new Lizard("Lizard");
			return randombot;

		}
		else {
			Element randombot = new Spock("Spock");
			return randombot;
		}
	}	
}
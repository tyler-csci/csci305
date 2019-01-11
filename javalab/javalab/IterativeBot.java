package main;

/*this bot is part of the superclass Player
 * where it is one of the available bots
 * to play against. this bot will iterate 
 * through the available options of moves
 * with each new round.*/

public class IterativeBot extends Player{

	public int itter = 0;
	
	public IterativeBot(String name) {													//initialize the bot method and return the name of this instance
		super(name);
	}

	@Override																			//override the play method in superclass Player 
	public Element play() {																//this method will iterate over the different 
		itter++;																		//moves that the player can choose, each new round
		if(itter == 1) {																//it will iterate to the next move. in the end it 
			Element iterativebot = new Rock("Rock");									//return the move that this bot will be using for the round.
			return iterativebot;
		}
		else if(itter == 2) {
			Element iterativebot = new Paper("Paper");
			return iterativebot;
		}
		else if(itter == 3) {
			Element iterativebot = new Scissors("Scissors");
			return iterativebot;
		}
		else if(itter == 4) {
			Element iterativebot = new Lizard("Lizard");
			return iterativebot;
		}
		else if(itter == 5){
			Element iterativebot = new Spock("Spock");
			itter = 0;
			return iterativebot;
		}
		else {
			itter = 0;
			play();
			return null;
		}
	}
	
	
}
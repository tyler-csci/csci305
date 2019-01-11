package main;

/*this bot is part of the superclass Player
 * where it is one of the available bots that
 * the player can choose to play. This bot
 * takes in the opponents last move and then
 * uses it as its current move.*/

public class LastPlayBot extends Player{
	public boolean firstPlay = false;
	public LastPlayBot(String name) {											//initialize the lastplaybot and return the name of the instance
		super(name);
	}

	@Override																	//override the play method in superclass Player
	public Element play() {														//play method gets the opponents previous move
		if(firstPlay) {															//then assigns that previous move to its current move
			System.out.println(this.currentMove.getName());						//when finished it returns the move that it will be 
			this.setPrevious(this.currentMove);									//using for the current move
			Element play = this.previous;
			this.setCurrentMove(play);
			return play;
		}
		else {
			Element rock = new Rock("Rock");
			firstPlay = true;
			return rock;
		}
	}
	
	
}
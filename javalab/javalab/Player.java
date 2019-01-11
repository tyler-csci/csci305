package main;

/*superclass that houses all the methods for the seperate players
 * that will be playing at any given time. */

public abstract class Player{
	
	public String name;
	public Element currentMove;
	public Element previous;
	public int score;

	public Player(String name) {											//initialize the Player method and give a name for this instance
		this.name = name;
	}
	
	public String getName() {												//get the name of this instances Player
		return this.name;
	}
	
	public Element getCurrentMove() {										//get the move that this instances Player will do on this turn
		return this.currentMove;
	}
	
	public Element getPrevious() {											//get the move that this instances Player did on the last turn
		return this.previous;
	}
	
	public int getScore() {													//get the score of how many rounds this instance of Player has won
		return this.score;
	}
	
	public void setScore(int score) {										//set the number of rounds this instance of Player has won
		this.score = this.score + score;
	}
	
	public void setPrevious(Element currentMove) {							// set the move that this instance of player did on the last turn
		this.previous = currentMove;
	}
	
	public void setCurrentMove(Element currentMove) {						// set the move that this instance of player is going to do on this turn
		this.currentMove = currentMove;
	}
	
	abstract public Element play();											//abstract class that all instances of Player must have which will have the logic to do that Players move

	
}
package main;

/*class is part of the superclass element that 
 * defines the moves that a player can make
 * Scissors wins against paper and lizard but 
 * loses to rock and spock.*/

public class Scissors extends Element{													//initialize the scissors method
	String win = "";																	//return the name of the method
	public Scissors(String name) {
		super(name);
	}
	
	@Override																			//override the method compareto from the element superclass
	public String compareTo(Element element) {											//compare the move of this class to that of the opponent
		Outcome outcome = new Outcome();												//does this with the logic and then returns the final output
		String result = null;															// of who won lost or tied
		String round = null;
		if(element.getName() == "Rock" || element.getName() == "Spock") {
			round = "lose";
			win = "\n   Player 2 won the round";
		}
		else if(element.getName() == "Paper" || element.getName() == "Lizard") {
			round = "win";
			win = "\n   Player 1 won the round";
		}
		else if(element.getName() == "Scissors") {
			round = "tie";
			win = "\n   Round was a tie";
		}
		result = outcome.outcome(this.getName(), element.getName(),round);
		result = result + win;
		return result;
	}
	
}
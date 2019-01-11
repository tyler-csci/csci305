package main;

/*this class is a part of the superclass Element
 * where it is a move that a Player could choose.
 * Rock wins against scissors and lizard but 
 * loses to spock and paper.*/

public class Rock extends Element{																//initiliaze the class rock 		
	String win = "";																			//initialize and return teh name of the instance
	public Rock(String name) {
		super(name);
	}
	
	@Override																					//override the method in element compareto
	public String compareTo(Element element) {
		Outcome outcome = new Outcome();														//compares the move of this class to that of the opponents
		String round = null;																	// with the logic in this method
		if(element.getName() == "Paper" || element.getName() == "Spock") {						//then returns the final output
			round = "lose";																		//which entails win lose tie and the outcome
			win = "\n   Player 2 won the round";
		}
		else if(element.getName() == "Scissors" || element.getName() == "Lizard") {
			round = "win";
			win = "\n   Player 1 won the round";
		}
		else if(element.getName() == "Rock") {
			round = "tie";
			win = "\n   Round was a tie";
		}
		String result = outcome.outcome(this.getName(), element.getName(),round);
		result = result + win;
		return result;
	}
}

package main;

/*this class is a part of the superclass Element
 * where it is one of the moves available for 
 * the player to choose. Paper wins against rock, 
 * and spock but loses to scissors and lizard.*/

public class Paper extends Element{
	String win = "";
	public Paper(String name) {																//initialize the method Paper and return the name of this instance
		super(name);
	}

	@Override																				//override the method compareto in the superclass Element
	public String compareTo(Element element) {												//this method compares the instance of this class to that 
		Outcome outcome = new Outcome();													//of the opponents and then once done with the logic
		String result = null;																//returns the final output which include whether it was
		String round = null;																//a win loss or tie and also the outcome from class Outcome
		if(element.getName() == "Scissors" || element.getName() == "Lizard") {
			round = "lose";
			win = "\n   Player 2 won the round";
		}
		else if(element.getName() == "Rock" || element.getName() == "Spock") {
			round = "win";
			win = "\n   Player 1 won the round";
		}
		else if(element.getName() == "Paper") {
			round = "tie";
			win = "\n   Round was a tie";
		}
		result = outcome.outcome(this.getName(), element.getName(),round);
		result = result + win;
		return result;
	}
	
	
}
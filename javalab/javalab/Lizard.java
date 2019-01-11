package main;

/*this class is part of the superclass Element
 * that defines one of the moves that is 
 * available to the player to use. Lizard wins 
 * against paper, and spock but loses to rock 
 * and scissors. */

public class Lizard extends Element{
	String win = "";
	public Lizard(String name) {																//initialize the method lizard and return the name of this instance
		super(name);
	}

	@Override																					//override the compareto method that is in superclass element
	public String compareTo(Element element) {													//then do the logic that is need to determine if this move	
		Outcome outcome = new Outcome();														//either wins looses or ties the opponent
		String result = null;																	//when finished it will return the final output which consists
		String round = null;																	//of whether or not it won and the outcome output 
		if(element.getName() == "Rock" || element.getName() == "Scissors") {
			round = "lose";
			win = "\n   Player 2 won the round";
		}
		else if(element.getName() == "Paper" || element.getName() == "Spock") {
			round = "win";
			win = "\n   Player 1 won the round";
		}
		else if(element.getName() == "Lizard") {
			round = "tie";
			win = "\n   Round was a tie";
		}
		result = outcome.outcome(this.getName(), element.getName(),round);
		result = result + win;
		return result;
	}
	
}
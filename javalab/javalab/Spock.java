package main;

/*this class is part of the element superclass that 
 * defines the moves that are possible to chose. Spock
 * wins against rock and scissors but loses to paper 
 * and lizard*/

public class Spock extends Element{														//initialize the spock element
	String win = "";																	//and return the name
	public Spock(String name) {
		super(name);
	}

	@Override																			//override the compareto method in Element
	public String compareTo(Element element) {											//this method compares its element to that of the 
		Outcome outcome = new Outcome();												//opponent and returns the final output
		String result = null;															//does the logic which decides the output for win/lose/tie
		String round = null;
		if(element.getName() == "Paper" || element.getName() == "Lizard") {
			round = "lose";
			win = "\n   Player 2 won the round";
		}
		else if(element.getName() == "Rock" || element.getName() == "Scissors") {
			round = "win";
			win = "\n   Player 1 won the round";
		}
		else if(element.getName() == "Spock") {
			round = "tie";
			win = "\n   Round was a tie";
		}
		result = outcome.outcome(this.getName(), element.getName(),round);
		result = result + win;
		return result;
	}
	
}
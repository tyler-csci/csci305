package main;

/*this class is used by all the subclasses
 * of the superclass Element to return the 
 * final outcome string.*/

public class Outcome{
	String output = null;
	String value = null;
	public String outcome(String value1, String value2, String value3) {					//This method sorts everything by whether it won or lost
		if(value3 == "tie") {																// if its a tie then it checks out right here
			output = value1 + " equals "+value2;												
		}
		else if(value3 == "win") {															//if its a win then it checks here
			if(value1 == "Rock" && value2 == "Lizard") {									//then it checks the two elements so that it can return the correct string 
				output = "Rock crushes Lizard";
			}
			else if(value1 == "Rock" && value2 == "Scissors") {
				output = "Rock crushes Scissors";
			}
			else if(value1 == "Paper" && value2 == "Rock") {
				output = "Paper covers Rock";
			}
			else if(value1 == "Paper" && value2 == "Spock") {
				output = "Paper disproves Spock";
			}
			else if(value1 == "Scissors" && value2 == "Lizard") {
				output = "Scissors decapitates Lizard";
			}
			else if(value1 == "Scissors" && value2 == "Paper") {
				output = "Scissors cuts Paper";
			}
			else if(value1 == "Lizard" && value2 == "Spock") {
				output = "Lizard poisons Spock";
			}
			else if(value1 == "Lizard" && value2 == "Paper") {
				output = "Lizard eats Paper";
			}
			else if(value1 == "Spock" && value2 == "Rock") {
				output = "Spock vaporizes Rock";
			}
			else if(value1 == "Spock" && value2 == "Scissors") {
				output = "Spock smashes scissors";
			}
		}
		else if(value3 == "lose") {															//if its a loss then it checks here
			if(value2 == "Rock" && value1 == "Lizard") {
				output = "Rock crushes Lizard";
			}
			else if(value2 == "Rock" && value1 == "Scissors") {
				output = "Rock crushes Scissors";
			}
			else if(value2 == "Paper" && value1 == "Rock") {
				output = "Paper covers Rock";
			}
			else if(value2 == "Paper" && value1 == "Spock") {
				output = "Paper disproves Spock";
			}
			else if(value2 == "Scissors" && value1 == "Lizard") {
				output = "Scissors decapitates Lizard";
			}
			else if(value2 == "Scissors" && value1 == "Paper") {
				output = "Scissors cuts Paper";
			}
			else if(value2 == "Lizard" && value1 == "Spock") {
				output = "Lizard poisons Spock";
			}
			else if(value2 == "Lizard" && value1 == "Paper") {
				output = "Lizard eats Paper";
			}
			else if(value2 == "Spock" && value1 == "Rock") {
				output = "Spock vaporizes Rock";
			}
			else if(value2 == "Spock" && value1 == "Scissors") {
				output = "Spock smashes scissors";
			}
		}
		else {
			output = "Something went wrong and you did not get expected two values";
		}
		output = output;
		return output;																						//when finished it returns the output back to the element
	}
}
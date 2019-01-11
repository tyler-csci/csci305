package main;

/*this class is part of the superclass Player
 * where it is one of the available options
 * that a player can be. This class allows a 
 * human to play against another human or against
 * one of the available bots.*/

import java.util.Scanner;

public class Human extends Player{

	public Scanner userInput = new Scanner(System.in);
	public int userChoice;
	
	public Human(String name) {																		//inialize the human method and return the name of this instance
		super(name);
	}

	@Override																						//override the method play in the superclass Player
	public Element play() {																			//this class defines a menu for the human player 
		System.out.println("(1) : Rock\n(2) : Paper\n(3) : Scissors\n(4) : Lizard\n(5) : Spock");	//to select which move they would like to make
		System.out.println("Enter your move: ");													//it then returns that move as the element 
		userChoice = userInput.nextInt();															//that this human player will use for this current round
		
		if(userChoice == 1) {
			Element humanbot = new Rock("Rock");
			return humanbot;
		}
		else if(userChoice == 2) {
			Element humanbot = new Paper("Paper");
			return humanbot;
		}
		else if(userChoice == 3) {
			Element humanbot = new Scissors("Scissors");
			return humanbot;
		}
		else if(userChoice == 4) {
			Element humanbot = new Lizard("Lizard");
			return humanbot;
		}
		else if(userChoice == 5){
			Element humanbot = new Spock("Spock");
			return humanbot;
		}
		else {
			System.out.println("Invalid move, Please pick a number between 1 and 5.");
			Element play = play();
			return play;
		}
	}
	
	
}
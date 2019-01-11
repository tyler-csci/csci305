package main;

/*this is the main class that
 * contains the main method that 
 * will be executed when run.*/

import java.util.Scanner;

public class Main{	
	public static void main(String args[]) {
		boolean valid1 = false;
		boolean valid2 = false;
		Player p1 = null;
		Player p2 = null;
		Scanner userInput = new Scanner(System.in);
		int player1, player2;
		String finalResult = "";
		int x = 1;
		
		System.out.println("Welcome to Rock, Paper, Scissors, Lizard, Spock, implemented by Chance Coleman.");
		System.out.println("Please choose two players:");
		System.out.println("   (1) Human\n   (2) StupidBot\n   (3) RandomBot\n   (4) IterativeBot\n   (5) LastPlayBot\n   (6) MyBot\n");
		System.out.println("Select Player 1: ");
		player1 = userInput.nextInt();
		while(!valid1) {																								//Wait for the user input for picking player1
			if(player1 == 1) {																							//depending on user input logic assigns Player type
				p1 = new Human("Human");
				valid1 = true;
			}
			else if(player1 == 2) {
				p1 = new StupidBot("StupidBot");
				valid1 = true;
			}
			else if(player1 == 3) {
				p1 = new RandomBot("RandomBot");
				valid1 = true;
			}
			else if(player1 == 4) {
				p1 = new IterativeBot("IterativeBot");
				valid1 = true;
			}
			else if(player1 == 5){
				p1 = new LastPlayBot("LastPlayBot");
				valid1 = true;
			}
			else if(player1 == 6) {
				p1 = new MyBot("MyBot");
				valid1 = true;
			}
		}
		System.out.println("Select Player 2: ");
		player2 = userInput.nextInt();
		while(!valid2) {																								//wait for the user input for picking player2
			if(player2 == 1) {																							//depending on user input logic assigns player type
				p2 = new Human("Human");
				valid2 = true;
			}
			else if(player2 == 2) {
				p2 = new StupidBot("StupidBot");
				valid2 = true;
			}
			else if(player2 == 3) {
				p2 = new RandomBot("RandomBot");
				valid2 = true;
			}
			else if(player2 == 4) {
				p2 = new IterativeBot("IterativeBot");
				valid2 = true;
			}
			else if(player2 == 5){
				p2 = new LastPlayBot("LastPlayBot");
				valid2 = true;
			}
			else if(player2 == 6) {
				p2 = new MyBot("MyBot");
				valid2 = true;
			}
			else {
				System.out.println("Invalid move, Please pick a number between 1 and 6.");
			}
		}
		
		System.out.println("\n" + p1.name + " vs " + p2.name + ". Go!");
		
		for(x = 1; x<6; x++) {																									//loop to play through five rounds of rpsls
			
			Element p1move = p1.play();																							//initialize player1's move
			p2.setCurrentMove(p1move);																							//set the current move for player1
			Element p2move = p2.play();																							//initialize player2's move
			p1.setCurrentMove(p2move);																							//set the current move for player2
			
			System.out.println("\nRound "+x+":");
			System.out.println("   Player 1 chose " + p1move.getName());
			System.out.println("   Player 2 chose " + p2move.getName());
			
			finalResult = "   "+p1move.compareTo(p2move);																		//get the results for the two selected moves
			if(finalResult.contains("Player 1 won the round")) {																//if the result contains a player 1 win 
				p1.setScore(1);																									//set the score for player1 to +1
			}	
			else if(finalResult.contains("Player 2 won the round")) {															//if the result conatins a player 2 win
				p2.setScore(1);																									//set the score for the player2 to +1
			}
			else{																												//else it was a tie and no points are awarded
				continue;
			}
			System.out.println(finalResult);																					//print the finalresult which is the element verb element
		}
		System.out.println("\nThe score is "+p1.getScore()+" to "+p2.getScore());												//print the score of the two players
		if(p1.getScore() > p2.getScore()) {																						//if player1's score is higher print winner as player1 
			System.out.println("Player 1 wins\n");
		}
		else if(p1.getScore() < p2.getScore()) {																				//if player2's score is higher print winner as player2
			System.out.println("Player 2 wins\n");
		}
		else {																													//if player1 and player2s' scores are equal print Draw
			System.out.println("Game was a draw\n");
		}
		userInput.close();																										//close the scanner to prevent leaky scanner error
	}
}		

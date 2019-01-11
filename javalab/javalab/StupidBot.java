package main;

/*This class is the stupid bot that was detailed in the
 * lab instructions, it always returns the same exact 
 * outcome, in my case i chose rock so that any time this 
 * bot is used it returns rock, also very good for testing 
 * other code.*/

public class StupidBot extends Player{

	public StupidBot(String name) {										//intialize the bot and give it a name
		super(name);
	}

	@Override															// this method overrides the abstract method in player
	public Element play() {												//inside this method it defines what this bot does and returns
		Element rock = new Rock("Rock");
		return rock;
	}
	
	
}
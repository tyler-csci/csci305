package main;

/*this class is the superclass that 
 * defines all of the moves that 
 * player can use to play. */

public abstract class Element{

	public String name;
	
	public Element(String name) {									//initialize the method Element and return the name of the instance
		this.name = name; 
	}
	
	public String getName() {										//get the name of the current instance
		return this.name;
	}

	abstract public String compareTo(Element ele);					//create an abstract method compareto that will be in all subclass of this superclass
}
	


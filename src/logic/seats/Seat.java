package logic.seats;

//seat object, has seat number, if it is taken, and the owner of the seat if it is
public class Seat{
	
	private boolean taken; //if seat is taken
	private String owner; //who got the ticket
	private int number; //seat number
	protected String name; //seat name, ex.A27 or E09
	
	public Seat(int number){
		taken = false;
		owner = "";
		this.number = number;
	}
	
	//constructor if seat is made with already an owner
	public Seat(int number, String owner){
		taken = true;
		this.owner = owner;
		this.number = number;
	}
	
	//getters
	public boolean getTaken(){
		return taken;
	}
	
	public String getOwner(){
		return owner;
	}
	
	public int getNumber(){
		return number;
	}
	
	public String getName(){
		return name;
	}
	
	//setters
	public void setTaken(boolean b){
		taken = b;
	}
	
	public void setOwner(String s){
		owner = s;
	}
	
	public void setNumber(int num){
		number = num;
	}
	
	public void setName(String n){
		name = n;
	}
	
}
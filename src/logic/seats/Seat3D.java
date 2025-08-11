package logic.seats;

public class Seat3D extends Seat{
	
	public Seat3D(int number){
		super(number);
		name = converter(number);
	}
	
	public Seat3D(int number, String owner){
		super(number, owner);
		name = converter(number);
	}
	
	//converts seat number into a name, using the seat pattern of this specific cinema
	private String converter(int num){
		if(num < 14){ //A1 - A14
			return "A" + (num + 1);
		} else if(num < 86){ //B1 - D24
			int number = num - 14;
			String[] letter = {"B", "C", "D"};
			int letterInt = number / 24;
			return letter[number / 24] + ((number - (letterInt * 24)) - 1);
		} else { // E1 - K22
			int number = num - 86;
			String[] letter = {"E", "F", "G", "H", "I", "J", "K"};
			int letterInt = number / 22;
			return letter[number / 22] + ((number - (letterInt * 22) - 1));
		}
	}
}
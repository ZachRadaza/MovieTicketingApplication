package logic.seats;

public class SeatRegular extends Seat{
	
	public SeatRegular(int number){
		super(number);
		name = converter(number);
	}
	
	public SeatRegular(int number, String owner){
		super(number, owner);
		name = converter(number);
	}
	
	//converts seat number into a name, using the seat pattern of this specific cinema
	private String converter(int num){
		if(num <= 48){ //A1 - C16
			String[] letter = {"A", "B", "C"};
			int letterInt = num / 16;
			return letter[num / 16] + (num - (letterInt * 16));
		} else if(num <= 152){ //D1 - K13
			int number = num - 48;
			String[] letter = {"D", "E", "F", "G", "H", "I", "J", "K"};
			int letterInt = number / 13;
			return letter[number / 13] + (number - (letterInt * 13));
		} else { // L1 - L20
			return "L" + (num - 152);
		}
	}
}
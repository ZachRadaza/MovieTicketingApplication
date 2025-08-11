package logic.seats;

public class SeatImax extends Seat{
	
	public SeatImax(int number){
		super(number);
		name = converter(number);
	}
	
	public SeatImax(int number, String owner){
		super(number, owner);
		name = converter(number);
	}
	
	//converts seat number into a name, using the seat pattern of this specific cinema
	private String converter(int num){
		if(num < 27){ //A1 - A27
			return "A" + (num + 1);
		} else if(num < 57){ //B1 - B30
			return "B" + ((num - 27) + 1);
		} else { // C1 - L37
			int number = num - 57;
			String[] letter = {"C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
			int letterInt = number / 37;
			return letter[number / 37] + ((number - (letterInt * 37)) + 1);
		}
	}
}
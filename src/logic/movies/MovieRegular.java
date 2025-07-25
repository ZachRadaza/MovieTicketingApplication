package logic.movies;

import logic.seats.Seat;
import logic.seats.SeatRegular;

public class MovieRegular extends Movie{
	
	public MovieRegular(String name, float length, float time, String rating){
		super(name, length, time, rating);
		iniSeats(172);
	}
	
	private void iniSeats(int num){
		seats = new SeatRegular[num];
		for(int i = 0; i < num; i++){
			seats[i] = new Seat(i + 1);
		}
	}
	
}
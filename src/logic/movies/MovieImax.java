package logic.movies;

import logic.seats.Seat;
import logic.seats.SeatImax;


//for imax showings
public class MovieImax extends Movie{
	
	public MovieImax(String name, float length, float time, String rating){
		super(name, length, time, rating);
		iniSeats(381); //381 seats available f0r imax
		
	}
	
	private void iniSeats(int num){
		seats = new SeatImax[num];
		for(int i = 0; i < num; i++){
			seats[i] = new Seat(i + 1);
		}
	}
	
}
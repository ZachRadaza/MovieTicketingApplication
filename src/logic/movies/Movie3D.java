package logic.movies;

import logic.seats.Seat;
import logic.seats.Seat3D;

public class Movie3D extends Movie{
	
	public Movie3D(String name, float length, float time, String rating){
		super(name, length, time, rating);
		iniSeats(420);
	}
	
	private void iniSeats(int num){
		seats = new Seat3D[num];
		for(int i = 0; i < num; i++){
			seats[i] = new Seat(i + 1);
		}
	}
	
}
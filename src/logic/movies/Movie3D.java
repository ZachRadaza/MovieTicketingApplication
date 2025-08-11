package logic.movies;

import logic.seats.Seat3D;

public class Movie3D extends Movie{
	
	public Movie3D(String name, float length, float time, String rating){
		super(name, length, time, rating);
		iniSeats(240);
		this.setLongestRow(24);
		this.setNumberOfRows(11);
	}
	
	public Movie3D(String name, float length){
		super(name, length);
		iniSeats(240);
		this.setLongestRow(24);
		this.setNumberOfRows(11);
	}
	
	public Movie3D(Movie c){
		super(c);
		iniSeats(240);
		this.setLongestRow(24);
		this.setNumberOfRows(11);
	}
	
	private void iniSeats(int num){
		seats = new Seat3D[num];
		for(int i = 0; i < num; i++){
			seats[i] = new Seat3D(i);
		}
	}
	
	//makes a copy of itself
	public Movie3D makeCopy(){
		Movie3D copy = new Movie3D(getTitle(), getLength(), getTime(), getRating());
		copy.setDescription(getDescription());
		copy.iniSeats(240);
		return copy;
	}
	
}
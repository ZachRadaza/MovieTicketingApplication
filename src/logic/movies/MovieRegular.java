package logic.movies;

import logic.seats.SeatRegular;

public class MovieRegular extends Movie{
	
	public MovieRegular(String name, float length, float time, String rating){
		super(name, length, time, rating);
		iniSeats(172);
		this.setLongestRow(20);
		this.setNumberOfRows(12);
	}
	
	public MovieRegular(String name, float length){
		super(name, length);
		iniSeats(172);
		this.setLongestRow(20);
		this.setNumberOfRows(12);
	}
	
	public MovieRegular(Movie c){
		super(c);
		iniSeats(172);
		this.setLongestRow(20);
		this.setNumberOfRows(12);
	}
	
	private void iniSeats(int num){
		seats = new SeatRegular[num];
		for(int i = 0; i < num; i++){
			seats[i] = new SeatRegular(i);
		}
	}
	
	//makes a copy of itself
	public MovieRegular makeCopy(){
		MovieRegular copy = new MovieRegular(getTitle(), getLength(), getTime(), getRating());
		copy.setDescription(getDescription());
		copy.iniSeats(172);
		return copy;
	}
}
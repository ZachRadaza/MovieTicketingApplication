package logic.movies;

import logic.seats.SeatImax;


//for imax showings
public class MovieImax extends Movie{
	
	public MovieImax(String name, float length, float time, String rating){
		super(name, length, time, rating);
		iniSeats(381); //381 seats available f0r imax
		this.setLongestRow(37);
		this.setNumberOfRows(12);
	}
	
	public MovieImax(String name, float length){
		super(name, length);
		iniSeats(381);
		this.setLongestRow(37);
		this.setNumberOfRows(12);
	}
	
	public MovieImax(Movie c){
		super(c);
		iniSeats(381);
		this.setLongestRow(37);
		this.setNumberOfRows(12);
	}
	
	private void iniSeats(int num){
		seats = new SeatImax[num];
		for(int i = 0; i < num; i++){
			seats[i] = new SeatImax(i);
		}
	}
	
	//makes a copy of itself
	public MovieImax makeCopy(){
		MovieImax copy = new MovieImax(getTitle(), getLength(), getTime(), getRating());
		copy.setDescription(getDescription());
		copy.iniSeats(420);
		return copy;
	}
	
}
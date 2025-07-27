package logic.theater;

import logic.movies.Movie;

//holds a specific theater room, but has the schedule for all 7 days
public class TheaterWeek{
	
	private TheaterRoom[] rooms; //7 rooms, one room for each day
	private Movie[] movieList;
	private int number; //number of the theater room
	
	public TheaterWeek(int number, Movie[] movieList){
		this.rooms = new TheaterRoom[7];
		this.movieList = new Movie[7]; //one for each day of the week
		this.number = number;
		
		for(int i = 0; i < this.movieList.length; i++){
			if(movieList.length >= i) this.movieList[i] = null;
			this.movieList[i] = movieList[i];
		}
		
		for(int i = 0; i < rooms.length; i++){
			rooms[i] = new TheaterRoom(number, movieList[i]);
		}
	}
	
	//getters
	public TheaterRoom getRoom(int i){
		if(i - 1 >= rooms.length) return null;
		return rooms[i - 1];
	}
	
	public Movie movieList(int i){
		if(i >= rooms.length) return null;
		return movieList[i];
	}
	
	public int getNumber(){
		return number;
	}
	
	//setters
	public void setRoom(TheaterRoom t, int i){
		rooms[i] = t;
	}
	
	public void setMovieList(Movie m, int i){
		movieList[i] = m;
	}
	
	public void setNumber(int n){
		number = n;
	}
	
	//methods
	
}
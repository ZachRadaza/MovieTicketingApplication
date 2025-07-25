package logic.theater;

import java.util.ArrayList;

import logic.movies.Movie;

//a specific theater in the theater house, holds number of movies in a day in sequential order
public class TheaterRoom{
	
	private int number; //number of this theater house, like its name basically
	private Movie movie; //the movie the theater will play the whole day
	private ArrayList<Movie> movies; //all the movies, with the bookings the theater is about to play in the day;
	
	
	public TheaterRoom(int number, Movie movie){
		this.number = number;
		this.movie = movie;
		movies = new ArrayList<>();
		scheduleMovies();
		
	}
	
	//getters
	public int getNumber(){
		return number;
	}
	
	public Movie getMovie(){
		return movie;
	}
	
	public Movie getMovies(int index){
		if(index >= movies.size()) return null;
		return movies.get(index);
	}
	
	//setters
	public void setNumber(int n){
		number = n;
	}
	
	public void setMovie(Movie m){
		movie = m;
		scheduleMovies();
	}
	
	//methods
	private void scheduleMovies(){ //populates movies and schedules times through the day, open from 11 am to 12 am
		
	}
}
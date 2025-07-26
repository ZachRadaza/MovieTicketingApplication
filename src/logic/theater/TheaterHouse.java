package logic.theater;

import java.util.ArrayList;
import java.util.HashSet;

import logic.movies.Movie;

//houses all theater rooms week
public class TheaterHouse{
	
	private TheaterWeek[] regular;
	private TheaterWeek threeD;
	private TheaterWeek imax;
	private ArrayList<Movie> movieList;
	
	public TheaterHouse(Movie[] movieListReg1, Movie[] movieListReg2, Movie[] movieList3D, Movie[] movieListImax){ //array is passed because the movies list is for the week
		regular = new TheaterWeek[2];
		regular[0] = new TheaterWeek(1, movieListReg1);
		regular[1] = new TheaterWeek(2, movieListReg2);
		
		threeD = new TheaterWeek(3, movieList3D);
		imax = new TheaterWeek(4, movieListImax);
		
		movieList = new ArrayList<>();
		
		setMovieList(movieListReg1, movieListReg2, movieList3D, movieListImax);
	}
	
	//getters
	public TheaterWeek getRegular1(){
		return regular[0];
	}
	
	public TheaterWeek getRegular2(){
		return regular[1];
	}
	
	public TheaterWeek get3D(){
		return threeD;
	}
	
	public TheaterWeek getImax(){
		return imax;
	}
	
	public ArrayList<Movie> getMovieList(){
		return movieList;
	}
	
	//setters
	public void setRegular1(TheaterWeek t){
		regular[0] = t;
	}
	
	public void setRegular2(TheaterWeek t){
		regular[1] = t;
	}
	
	public void set3D(TheaterWeek t){
		threeD = t;
	}
	
	public void setImax(TheaterWeek t){
		imax = t;
	}
	
	//methods
	private void setMovieList(Movie[] movieListReg1, Movie[] movieListReg2, Movie[] movieList3D, Movie[] movieListImax){
		movieList.clear();
		HashSet<Movie> set = new HashSet<>();
		ArrayList<Movie[]> list = new ArrayList<>();
		
		list.add(movieListReg1);
		list.add(movieListReg2);
		list.add(movieList3D);
		list.add(movieListImax);
		//adds to set
		for(int i = 0; i < list.size(); i++){
			for(int j = 0; j < list.get(i).length; j++){
				set.add(list.get(i)[j]);
			}
		}
		//adds to movieList
		for(Movie mov : set){
			movieList.add(mov);
		}
	}
	
}
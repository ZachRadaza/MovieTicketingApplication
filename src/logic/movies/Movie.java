package logic.movies;

import logic.seats.Seat;

//seats to book for a specific showing/movie
public class Movie{
	
	protected Seat[] seats; //seats to movie
	
	private String title; //name of movie
	private float length; //length of movie
	private float time; //time movie shows
	private String rating; //rating of movie ex. PG-13
	private String description;
	private String poster; //file path to poster
	private int longestRow; //longest row in the name
	private int numberOfRows; //number of rows
	
	public Movie(String title, float length){
		this.title = title.trim();
		this.length = length;
		this.time = 0f;
		this.rating = "PG-13";
		description = "";
		//poster = "";
		poster = "resources/photos/superman.jpg";
		longestRow = 30;
		numberOfRows = 12;
	}
	
	public Movie(String title, float length, float time, String rating){
		this.title = title.trim();
		this.length = length;
		this.time = time;
		this.rating = rating;
		description = "";
		//poster = "";
		poster = "resources/photos/superman.jpg";
		longestRow = 30;
		numberOfRows = 12;
	}
	//copies everything
	public Movie(Movie copy){
		this.title = copy.getTitle();
		this.length = copy.getLength();
		this.time = copy.getTime();
		this.rating = copy.getRating();
		description = copy.getDescription();
		poster = copy.getPoster();
		longestRow = copy.getLongestRow();
		numberOfRows = copy.getNumberOfRows();
	}
	
	//getters
	public String getTitle(){
		return title;
	}
	
	public float getLength(){
		return length;
	}
	
	public float getTime(){
		return time;
	}
	
	public Seat getSeats(int i){
		return seats[i];
	}
	
	public int getSeatsSize(){
		return seats.length;
	}
	
	public String getRating(){
		return rating;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getPoster(){
		return poster;
	}
	
	public int getLongestRow(){
		return longestRow;
	}
	
	public int getNumberOfRows(){
		return numberOfRows;
	}
	
	//setters
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setLength(float l){
		length = l;
	}

	public void setTime(float time){
		this.time = time;
	}
	
	public void setSeats(int i, Seat s){
		seats[i] = s;
	}
	
	public void setRating(String rating){
		this.rating = rating;
	}
	
	public void setDescription(String des){
		description = des;
	}
	
	public void setPoster(String poster){
		this.poster = poster;
	}
	
	public void setLongestRow(int num){
		this.longestRow = num;
	}
	
	public void setNumberOfRows(int num){
		this.numberOfRows = num;
	}
	//methods
	public void bookSeat(int number, String owner){ //books seat by number
		seats[number - 1].setTaken(true);
		seats[number - 1].setOwner(owner);
	}
	
	public void unBookSeat(int number){
		seats[number - 1].setTaken(false);
		seats[number - 1].setOwner("");
	}
	
	public void bookSeat(Seat seat, String owner){ //books seat by number
		seat.setTaken(true);
		seat.setOwner(owner);
	}
	
	public void unBookSeat(Seat seat){
		seat.setTaken(false);
		seat.setOwner("");
	}
	
	//makes a copy of itself
	public Movie makeCopy(){
		Movie copy = new Movie(title, length, time, rating);
		copy.setDescription(description);
		return copy;
	}
	
}
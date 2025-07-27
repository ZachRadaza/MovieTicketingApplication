package main;

import java.awt.GraphicsEnvironment;

import guiComponents.MainFrame;
import logic.TimeConverter;
import logic.movies.Movie;
import logic.movies.Movie3D;
import logic.movies.MovieImax;
import logic.movies.MovieRegular;
import logic.theater.TheaterHouse;

public class Main{
	
	private static TheaterHouse house;
	private static MainFrame gui;
	
	public static void main(String[] args){

		Movie[] reg1 = new Movie[7];
		Movie[] reg2 = new Movie[7];
		Movie[] threeD = new Movie[7];
		Movie[] imax = new Movie[7];
		setRegular1(reg1);
		setRegular2(reg2);
		set3D(threeD);
		setImax(imax);
		
		house = new TheaterHouse(reg1, reg2, threeD, imax);
		gui = new MainFrame(house);
		
		int i = 0;
		while(house.getImax().getRoom(1).getMovies(i) != null){
			System.out.println((i + 1) + ". " + house.getImax().getRoom(1).getMovies(i).getTitle() + ", " + house.getImax().getRoom(1).getMovies(i).getLength() + ", " + TimeConverter.converterToString(house.getImax().getRoom(1).getMovies(i).getTime()));
			i++;
		}
		
		listFonts();
	}
	
	//testing
	private static void setRegular1(Movie[] reg1){
		String[] titles = {"SuperMan", "SuperMan", "SuperMan", "Avangers", "Avangers", "Avangers", "Avangers"};
		float[] lengths = {1.5f, 1.5f, 1.5f, 2f, 2f, 2f, 2f};
		
		for(int i = 0; i < reg1.length; i++){
			reg1[i] = new MovieRegular(titles[i], lengths[i]);
		}
	}
	
	private static void setRegular2(Movie[] reg1){
		String[] titles = {"Batman", "Batman", "Batman", "Batman", "Batman", "Batman", "Batman"};
		float[] lengths = {1.75f, 1.75f, 1.75f, 1.75f, 1.75f, 1.75f, 1.75f};
		
		for(int i = 0; i < reg1.length; i++){
			reg1[i] = new MovieRegular(titles[i], lengths[i]);
		}
	}
	
	private static void set3D(Movie[] reg1){
		String[] titles = {"SuperMan", "SuperMan", "SuperMan", "Avangers", "Avangers", "Avangers", "Avangers"};
		float[] lengths = {1.5f, 1.5f, 1.5f, 2f, 2f, 2f, 2f };
		
		for(int i = 0; i < reg1.length; i++){
			reg1[i] = new Movie3D(titles[i], lengths[i]);
		}
	}
	
	private static void setImax(Movie[] reg1){
		String[] titles = {"SuperMan", "SuperMan", "SuperMan", "Avangers", "Avangers", "Avangers", "Avangers"};
		float[] lengths = {1.5f, 1.5f, 1.5f, 2f, 2f, 2f, 2f };
		
		for(int i = 0; i < reg1.length; i++){
			reg1[i] = new MovieImax(titles[i], lengths[i]);
		}
	}
	
	
	private static void listFonts(){
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
        String[] fontNames = ge.getAvailableFontFamilyNames();

        for (String fontName : fontNames) {
            System.out.println(fontName);
        }
	}
	
}
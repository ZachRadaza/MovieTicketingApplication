package main;

import guiComponents.Frame;
import logic.seats.SeatImax;

public class Main{
	public static void main(String[] args){
		
		Frame window = new Frame();
		
		System.out.println("chickem");
		SeatImax seat = new SeatImax(97);
		System.out.println(seat.getName());
	}
}
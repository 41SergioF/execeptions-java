package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] arg) throws ParseException {
		
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = scan.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(scan.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(scan.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}else {
			
			Reservation r = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(r.toString());
			System.out.println();
			
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(scan.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(scan.next());
			  	
		    String erro = r.updateDates(checkIn, checkOut);
			if (erro != null) {
				System.out.println("Error in reservation: "+erro);
			}else {
				System.out.println(r.toString());
			} 
		}
		
		scan.close();
		
	}

}

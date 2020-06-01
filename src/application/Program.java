package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exeptions.DomainExeptions;

public class Program {

	public static void main(String[] arg) {
		
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int roomNumber = scan.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(scan.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(scan.next()); 
			
		
			Reservation r = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(r.toString());
			System.out.println();
			
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(scan.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(scan.next());
			  
			r.updateDates(checkIn, checkOut);
			System.out.println(r.toString());
		}
		catch(ParseException e){//trata as exeções 
			System.out.println("invalid date");
		}
		catch(DomainExeptions e){
			System.out.println("Reservation erro: "+e.getMessage());
		}
		catch (InputMismatchException e) {
			System.out.println("Nunber erro!");
		}
		
		scan.close();
		
	}

}

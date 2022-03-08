package com.th.TrainTicketProjectTeam3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import com.th.model.Passenger;
import com.th.model.Train;
import com.th.operation.Ticket;
import com.th.operation.TrainDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException
    {
    	Scanner sc = new Scanner(System.in);
    	TrainDAO trainDAO = new TrainDAO();
    	Passenger passenger = null;
    	Ticket ticket = null;
//    	TrainDAO train = new TrainDAO();
//    	Train train1 = new Train(1001, "xyz", "Bangalore", "Delhi", 2500);
//    	
//    	
    	System.out.println("Enter the date");
    	String date = sc.next();
    	Date currDate = new Date();
    	Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
    	System.out.println(currDate);
    	System.out.println(date1);
    	if(!date1.after(currDate)) {
    			System.out.println("Enter the correct date");
    	}else {
    		System.out.println("Enter Train no:");    		
    		int trainNo = sc.nextInt();
    		Train train  = trainDAO.findTrain(trainNo);
    		if(train == null) {
    			System.out.println("No train found.");
    		}else {
	    		ticket = new Ticket(date1,train);
	    		System.out.println("Enter the no of passenger:");
	    		int no = sc.nextInt();
	    		for(int i=0; i<no; i++) {
	    			System.out.println("Enter passanger name: ");
	    			sc.nextLine();
	    			String passengerName = sc.nextLine();
	    			System.out.println("Enter age: ");
	    			int passengerAge = sc.nextInt();
	    			System.out.println("Enter Gender: ");
	    			char passengerGender = sc.next().charAt(0);
	    			passenger = new Passenger(passengerName, passengerAge, passengerGender);
	    			ticket.addPassenger(passengerName, passengerAge, passengerGender);
	    		}
	    		ticket.displayTreeMap();
    		}
    }
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
//    	StringBuilder strb = new StringBuilder();
//		strb.append("PNR \t\t:BD_20211127_100");
//		strb.append("\nTrain no \t:1001");
//		strb.append("\nTrain Name \t:xyz");
//		strb.append("\nFrom \t\t:Bangelore");
//		strb.append("\nTo \t\t:Delhi");
//		strb.append("\nTravel Date \t:27/11/2021");
//		strb.append("\n\nPassanger:");
//		strb.append("\nName\t\tage\t\tGender\t\tFare");
//		strb.append("\nMohammad\t23\t\tM\t\t2500");
//		
//		System.out.println(strb);
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	//Date
//    	LocalDateTime localDate = new LocalDateTime.no
    	
//    	Date date = null;
//    	Date fixedDate = null;
//    	String filterDate = sc.next();
//    	
//    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//    	String date1 = filterDate.formatted(dtf);
//    	System.out.println(date1);

    	
    	
    	
    	sc.close();
    }
    
}

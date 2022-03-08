package com.th.operation;
import java.util.Date;
import java.util.TreeMap;

import com.th.model.Passenger;
import com.th.model.Train;

public class Ticket {
	private static int counter=100;
	private String pnr;
	private Date travelDate;
	private Train train;
	TreeMap<Passenger, Integer> passenger;
	Passenger p = null;
	
	public Ticket(Date travelDate, Train train) {
		super();
		this.travelDate = travelDate;
		this.train = train;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public Date getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	public TreeMap<Passenger, Integer> getPassenger() {
		return passenger;
	}
	public void setPassenger(TreeMap<Passenger, Integer> passenger) {
		this.passenger = passenger;
	}
	
	
	
	private String generatePNR() {
		char sourse = train.getSource().charAt(0);
		char destination = train.getDestination().charAt(0);
		counter++;
		return (sourse+""+destination+"_"+travelDate+"_"+counter);
	}
	private double calcPassengerFare(Passenger p) {
		double mainFare =0;
		if(p.getAge()<=12) {
			mainFare = train.getTicketPrice()/2;
		}
		if(p.getAge()>=60) {
			mainFare = (train.getTicketPrice()*3)/5;
		}
		if(p.getAge()=='F' || p.getAge()=='f') {
			mainFare = train.getTicketPrice()/4;					
		}
		return mainFare;
		
	}
	public void addPassenger(String name, int age, char gender) {
		p = new Passenger(name, age, gender);
		Integer fare =  (int) calcPassengerFare(p);
		passenger.put(p, fare);
		 
	}
	
	private double calculateTotalFare() {
		double totalFare=0;
		for(Passenger p:passenger.keySet()) {
			totalFare += passenger.get(p);
		}		
		return totalFare;
//		int total = 0;
//		for(String p:pmap.keySet()) {
//			total += pmap.get(p);
//		}
		
	}
	
	private StringBuilder generateTicket() {
		StringBuilder strb = new StringBuilder();
		strb.append("PNR \t\t:BD_20211127_100");
		strb.append("\nTrain no \t:1001");
		strb.append("\nTrain Name \t:xyz");
		strb.append("\nFrom \t\t:Bangelore");
		strb.append("\nTo \t\t:Delhi");
		strb.append("\nTravel Date \t:27/11/2021");
		strb.append("\n\nPassanger:");
//		for(int i=0; i<passenger.size(); i++) {
//			strb.append();
//		}
		
		return null;
		
	}
	
	public void writeTicket() {
		
	}
	
	public void displayTreeMap() {
		System.out.println(passenger);
	}
}

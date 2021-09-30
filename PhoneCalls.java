import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneCalls {
	
	private String phoneNumber;
	private int duration;
	private String callDate;
	private String calleeName;
	private double cost;
	
	public PhoneCalls(){
		
		this.phoneNumber = "";
		this.duration = 0;
		this.callDate = "";
		this.calleeName = "";
		this.cost = 0.0;
	}
	
	public PhoneCalls(String phoneNumber, int duration, String callDate, String calleeName, double cost) {
		
		this.phoneNumber = phoneNumber;
		this.duration = duration;
		this.callDate = callDate;
		this.calleeName = calleeName;
		this.cost = cost;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public double getCost() {
		return cost;
	}
	
	public String toString() {
		return "Phone Number: " + phoneNumber + "\nDuration: " + duration + "\nCall Date: " 
				+ callDate + "\nCallee Name: " + calleeName + "\nCost: $" + cost + "\n";
	}

}

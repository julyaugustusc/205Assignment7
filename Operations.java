import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Operations {
	
	private String lineString;
	private String[] arrInput;
	
	private ArrayList<PhoneCalls> phoneCallArray;
	
	private File inputFile;
	private Scanner in;
	private PrintWriter out;
	
	private PhoneCalls longestPhoneCall;
	private PhoneCalls shortestPhoneCall;
	
	private double costOfAll;
	
	public Operations() {
		
	}
	
	public void AssignArray(String input) throws FileNotFoundException{
		
		inputFile = new File(input);
		in = new Scanner(inputFile);
		
		phoneCallArray = new ArrayList<PhoneCalls>();
		
		while(in.hasNextLine()) {
			
			lineString = in.nextLine();
			arrInput = lineString.split("/");
			
			String phoneNumber = arrInput[0].trim();
			int duration = Integer.parseInt(arrInput[1].trim());
			String callDate = arrInput[2];
			String calleeName = arrInput[3];
			double cost = Double.parseDouble(arrInput[4].trim());
			
			PhoneCalls pc = new PhoneCalls(phoneNumber, duration, callDate, calleeName, cost);
			phoneCallArray.add(pc);
		}
		in.close();
		
	}
	
	public void Search(String phoneNumber){
		
		boolean tf = false;
		
		for(int i = 0; i < phoneCallArray.size(); i++) {
			
			PhoneCalls phoneCall = phoneCallArray.get(i);
			String phoneNum = phoneCall.getPhoneNumber();
			phoneNumber.trim();
			
			if(phoneNumber.equals(phoneNum)) {
				System.out.println(phoneCall);
				tf = true;
			}
		}  
		if(tf = false) {
			System.out.println("That was not found");
		}
	}
	
	public void longestCall() {
		
		int longestDur = -1;
		PhoneCalls phoneCall;
		int dur;
		
		for(int i = 0; i < phoneCallArray.size(); i++) {
			
			phoneCall = phoneCallArray.get(i);
			dur = phoneCall.getDuration();
			
			if(dur >= longestDur) {
				longestDur = dur;
				longestPhoneCall = phoneCall;
			}
				
		}
		
		System.out.println(longestPhoneCall);
		
	}
	
	public void shortestCall() {
		
		int shortestDur = 100;
		PhoneCalls phoneCall;
		int dur;
		
		for(int i = 0; i < phoneCallArray.size(); i++) {
			
			phoneCall = phoneCallArray.get(i);
			dur = phoneCall.getDuration();
			
			if(dur <= shortestDur) {
				shortestDur = dur;
				shortestPhoneCall = phoneCall;
			}
				
		}
		
		System.out.println(shortestPhoneCall);
	}
	
	public void sortCallDuration(){
		
		Collections.sort(phoneCallArray, new Comparator<PhoneCalls>() {
	        @Override 
	        public int compare(PhoneCalls p1, PhoneCalls p2) {
	            return p1.getDuration() - p2.getDuration(); // Ascending
	        }
		});
		System.out.println("\n" +phoneCallArray);
	}
	
	public void PhoneBill() throws FileNotFoundException{
		
		out = new PrintWriter("phone_bills.txt");
		
		costOfAll = 0.0;
		for(int i = 0; i < phoneCallArray.size(); i++) {
			double cost = phoneCallArray.get(i).getCost();
			costOfAll = costOfAll + cost;
		}
		
		out.println("Destination Number:\tDuration: (m)\tCost ($)");
		for(int i = 0; i < phoneCallArray.size(); i++) {
			out.println(phoneCallArray.get(i).getPhoneNumber() + "\t" + phoneCallArray.get(i).getDuration() + "\t" + phoneCallArray.get(i).getCost());
		}
		out.println("Total: $" + costOfAll);
		
		out.close();
	}
	
	
		
}


	
	
	
	




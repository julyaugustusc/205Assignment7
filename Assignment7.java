import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment7 {
	
	public static void main (String[] args) throws FileNotFoundException{
		
		char choice = 'Q';
		String line = new String();
		
		Operations o = new Operations();

		Scanner scan = new Scanner(System.in);
		
		o.AssignArray("phoneCalls.txt");
		
		do { 
			
			System.out.print("What action would you like to perform?\n");
			printMenu();
			line = scan.nextLine();
			
			if(line.length() == 1) {
				//get the choice as a character
				choice = line.charAt(0);
				choice = Character.toUpperCase(choice);
				
				//matches one of the case statement
				switch (choice) {
				
				case 'A': 
					System.out.println("Enter 10 digit number: ");
					String phoneNumber = scan.nextLine();
					o.Search(phoneNumber);
					
					break;
					
				case 'B':
					o.longestCall();
					
					break;
					
				case 'C':
					o.shortestCall();
					
					break;
					
				case 'D':
					o.sortCallDuration();
					
					break;
					
				case 'E':
					o.PhoneBill();
					
					break;
					
				case 'F':
					break;
					
				case '?':
					printMenu();
					
					break;
					
				default:
					System.out.print("Unknown action\n");
					break;
				}
			}
				
			else {
				System.out.print("Unknown action");
			}
				
		} while(choice != 'F');
			
		scan.close();
	}
		
	public static void printMenu() {
		System.out.print("Choice\t\tAction\n"+
							"------\t\t------\n"+
							"A\t\tSearch a call\n"+
							"B\t\tDisplay Longest Call Info\n"+
							"C\t\tDisplay Shortest Call Info\n"+
							"D\t\tSort Phone Calls by Duration\n"+
							"E\t\tPrepare Phone Bill\n"+								"F\t\tQuit\n"+
							"?\t\tDisplay Menu Again\n\n");
		}
					
					
					
					
					
					
}




// Project Package Name
package sumofHours;
/*
 * List of built in packages
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/* Class Declaration */
public class AddHours {
/* Define class object */
static AddHours execute = new AddHours();
/* Main method - Driver method */
	public static void main(String[] args) throws ParseException {
/* Call method askUser */
		execute.askUser();
	}
/* A Method that ask user to prompt values */
/* This method contain Exception */	
	public void askUser() throws ParseException {
		/* Allow user to add any many values as their wish
		 * To achieve this aim list is declared
		 * The List store values only if values is valid and specific to hour format
		 *  */
		List<String> values = new ArrayList<>();
		Scanner input = new Scanner (System.in);
		String button, IN;
		int num = 0;
		do {
			System.out.print("Enter a value (HH:MM:SS): ");
			IN = input.next();
			/* Check user desired to enter another value */
			if (execute.verifyInput(IN) == true) {
				values.add(IN);
				System.out.println("Do you wish to add another value?");	
				System.out.print("Press Y or No: ");
				button = input.next();
				num = num+1;
			}
			else {
				button = "N";
				System.out.println("Invalid !"+"\n" + "Please enter a value in specify format, Example 01:10:05");
			}
		} while(execute.buttonValue(button));
		if (execute.verifyInput(IN) == true) {
			execute.displayInputs(values);
			
		}
		else {
			execute.askUser();
		}
	}
	/*Robotic Method which verify user response regard to Yes or No*/
	public boolean buttonValue(String value) {
		if (value.equalsIgnoreCase("Y")) {
			return true;
		}
		else {
			return false;
		}
	}
	/*Magical Method can perform conversion from String to Hours*/
	public void displayInputs (List<String> values) throws ParseException {
		/*Required to perform conversion*/
		long sum = 0;
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
		/* Take values store inside array list and assign it to Date object array*/
		Date [ ] d = new Date [values.size()];
		/* Create array of objects as many as wanted*/		
		for (int i = 0; i < values.size(); i++) {
		/* Release values store into array list as argument to Date Constructor */
			d [i] = df.parse(values.get(i));
			sum += d [i].getTime();
		}	
		/*Display Final conversion result*/
		System.out.print("\n" + "Sum of Hours -  ");
		System.out.println(df.format(new Date (sum)));
	}
	/* If value is true then perform conversion String to Hour conversion
	 * Else it will ask user to enter value again of valid requirement
     */
	public boolean verifyInput (String input ) {
		if (input.contains(":")) {
			return true;
		}
		else {
			
			return false;	
		}
	}
}

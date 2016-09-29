// Driver class for HackDFW project
// HackDFW Project
// Aaron Van De Brook
// Started on 4/16/16

package hackdfw.project;
import java.util.Scanner;

public class HackDFWProject {
            
    public static void main(String[] args) throws Exception {
        
        TimeAndDate currentTime = new TimeAndDate();
        Scanner keyboard = new Scanner(System.in);
        Brightness brightness = new Brightness();
        
        //@TODO set up main method to set the brightness of the computer.
        
        System.out.println(currentTime);
        
        System.out.print("Enter a time to dim the screen(Specify \'AM\' or \'PM\'): ");
        String dimTime = keyboard.nextLine();
        
        System.out.print("Enter a time to relight the screen(Specify \'AM\' or \'PM\'): ");
        String brightenTime = keyboard.nextLine();
        
        System.out.print("Enter a brightness level to dim to: ");
        String dimLevel = keyboard.next();
        
        System.out.print("Enter a brightness level to relight to: ");
        String brightenLevel = keyboard.next();
        
        System.out.print("Type quit at any time to close the program.\n");
        String action = keyboard.nextLine();
        
        //System.out.print("Type help for a list of commands.");
        //action = keyboard.nextLine();
        
        
        while(true) {
            
            Thread.sleep(60000);
            currentTime.setTime();

            if (currentTime.getTime().equals(dimTime)) {
                brightness.setBrightness(dimLevel);
                System.out.println("Dimmed screen" + dimLevel);
            } else if (currentTime.getTime().equals(brightenTime)) {
                brightness.setBrightness(brightenLevel);
                System.out.println("Screen brightened to" + brightenLevel);
            //} else if (action.toLowerCase().equals("help")) {
            	//System.out.print();
            } else if (action.toLowerCase().equals("quit")) {
               System.out.println("Quitting...");
               break;
            }
        }
    }
}
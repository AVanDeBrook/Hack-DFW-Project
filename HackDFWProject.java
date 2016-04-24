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
        
        
        while (true) {
            
            currentTime.setTime();
            
            if (currentTime.getTime().equals(dimTime)) {
                
                brightness.setBrightness(dimLevel);
                break;
                                
            } else if (currentTime.getTime().equals(brightenTime)) {
                
                brightness.setBrightness(brightenLevel);
                break;
                
            }                                
        }        
    }   
}    
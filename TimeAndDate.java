// Third helper class, check time and date based on the computer's settings

package hackdfw.project;
import java.util.Calendar;

public class TimeAndDate {
    
    // Instance Variables    
    private int hour;
    private int minute;
    private int amPM;
    
    //Constructor
    public TimeAndDate() {                
        getTime();
        setTime();        
    }
    
    public void setTime() {        
        hour = Calendar.getInstance().get(Calendar.HOUR);
        minute = Calendar.getInstance().get(Calendar.MINUTE);
        amPM = Calendar.getInstance().get(Calendar.AM_PM);        
    }                   
    
    public int getAmOrPm() {        
        return amPM;        
    }
    
    public String getTime() {        
        String amOrPM;        
        if(amPM == 0) {            
            amOrPM = "AM";            
        } else {            
            amOrPM = "PM";            
        }                                                                    
        String output = hour + ":" + minute + " " + amOrPM;        
        return output;        
    }
    
    @Override
    public String toString() {                        
        return getTime();        
    }    
}
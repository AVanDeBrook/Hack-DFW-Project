// First helper class
// Gets the Driver addresses from cmd.exe

package hackdfw.project;
import java.io.*;

public class DriverAddress {
        
    // Instance Variables    
    private String powerSchemeGUID;
    private String display;
    private String displayBrightness;
    
    // No-arg constructor for the DriverAddress class    
    public DriverAddress() throws Exception {        
        setPowerSchemeGUID();
        setDisplay();
        setDisplayBrightness();        
    }
    
    public void setPowerSchemeGUID() throws Exception {        
        ProcessBuilder  builder = new ProcessBuilder("cmd.exe", "/c", "powercfg -q | find \"Power Scheme GUID\" ");
        builder.redirectErrorStream(true);        
        Process p = builder.start();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));        
        powerSchemeGUID = reader.readLine().trim();                        
    }
    
    public void setDisplay() throws Exception {        
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "powercfg -q | find \"(Display)\"");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        display = reader.readLine().trim();        
    }
    
    public void setDisplayBrightness() throws Exception {        
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "powercfg -q | find \"(Display brightness\"");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        displayBrightness = reader.readLine().trim();                
    }
    
    public String getPowerSchemeGUID() {                        
        return powerSchemeGUID;        
    }
    
    public String getDisplay() {        
        return display;        
    }
    
    public String getDisplayBrightness() {       
        return displayBrightness;       
    }
    
    @Override
    public String toString() {                               
        return powerSchemeGUID + "\n" + display + "\n" + displayBrightness + "\n";
    }                
}
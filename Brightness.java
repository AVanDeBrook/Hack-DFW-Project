// Second helper class

// Brightness should be set in the following way:
// POWERCFG -SETDCVALUEINDEX <SCHEME_GUID> <SUBGROUP_GUID> <SETTING_GUID> value
// value being the display brightness vale (0-100)

package hackdfw.project;

public class Brightness {
        
    //Instance Variables    
    private String powerSchemeGUID;
    private String displayAddress; 
    private String displayBrightnessAddress;
    
    // No arg constructor for Brightness class
    public Brightness() throws Exception {
        
        setAddresses();        
        
    }
    
    // Parameterized Constructor for Brightness class
    public Brightness(String aBrightness) throws Exception {
        
        setAddresses();
        setBrightness(aBrightness);
        
    }
    
    // Set Driver Adresses
    public void setAddresses() throws Exception {
        
        powerSchemeGUID = getPowerSchemeGuid();
        displayAddress = getDisplayGuid();
        displayBrightnessAddress = getDisplayBrightness();
        
    }
    
    // Get the Power Scheme GUID for use in other classes
    public String getPowerSchemeGuid() throws Exception {
        
        DriverAddress returnSchemeGuid = new DriverAddress();
        
        String line = returnSchemeGuid.getPowerSchemeGUID();
        String output = line.substring(line.indexOf(":") + 1, line.indexOf("(")).trim();
        
        return output;
        
    }
    
    // Get Display for use in other classes
    public String getDisplayGuid() throws Exception {
        
        DriverAddress returnDisplayGuid = new DriverAddress();
        
        String line = returnDisplayGuid.getDisplay();                             
        String output = line.substring(line.indexOf(":") + 1, line.indexOf("(")).trim();
        
        return output;
        
    }
    
    //Get Display brightness for use in other classes
    public String getDisplayBrightness() throws Exception {                                
        
        DriverAddress returnDisplayBrightness = new DriverAddress();
        
        String line = returnDisplayBrightness.getDisplayBrightness();                        
        String output = line.substring(line.indexOf(":") + 1, line.indexOf("(")).trim();
                
        return output;
    }
    
    //Set the AC Brightness Value Index (When the computer is plugged in)
    public void setBrightnessAcValue(String brightnessLevel) throws Exception {
        
        // -SetAcValueIndex sets the values for when the computer is plugged in
        // -SetDcValueIndex sets the values for when the computer is unplugged
        
        String command = "powercfg -SetAcValueIndex " + powerSchemeGUID + " " + displayAddress + " " + displayBrightnessAddress + " " + brightnessLevel + " & powercfg -S " + powerSchemeGUID;        
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);        
        
        builder.start();
                
    }
    
    // Sets the DC Value Index (When the computer is unplugged and running on battery power)
    public void setBrightnessDcValue(String brightnessLevel) throws Exception {
        
        // -SetAcValueIndex sets the values for when the computer is plugged in
        // -SetDcValueIndex sets the values for when the computer is unplugged
        
        String command = "powercfg -SetDcValueIndex " + powerSchemeGUID + " " + displayAddress + " " + displayBrightnessAddress + " " + brightnessLevel + " & powercfg -S " + powerSchemeGUID;        
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);        
        
        builder.start();
        
    }
    
    // Sets both DC and AC Brightness Values
    public void setBrightness(String aBrightness) throws Exception {
        
        setBrightnessDcValue(aBrightness);
        setBrightnessAcValue(aBrightness);
        
    }
    
    @Override
    public String toString() {
        
        String output = powerSchemeGUID + "\n" + displayAddress + "\n" + displayBrightnessAddress + "\n";
        
        return output;
        
    }    
}
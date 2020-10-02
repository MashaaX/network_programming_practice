
package java_filter_stream_practice;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_filter_stream_practice.AreaCalc;

/**
 *
 * @author Arga
 */
public class Logs {
    AreaCalc view;
    public static PrintStream output;
    public static PrintStream outputErr;
    public static boolean isError;

    public Logs(AreaCalc view) {
        this.view = view;
        try {
            output=new PrintStream("Log.log");
            outputErr = new PrintStream("Log.err");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Logs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setLog(String message){
        output.println(message);
    }
    public void setLogErr(String message){
        outputErr.println(message);
        
    }
}

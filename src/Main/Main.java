package Main;

import Parsers.CVParser;
import Subjects.StudentCV;



/**
 *
 * @author abdo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Parsers.Parser studentPrintWriter = new CVParser();
        
        StudentCV studentCV =   (StudentCV) studentPrintWriter.read().get(0);
        
        String sCv = studentCV.toString();
        
        for (int i = 0; i <sCv.length(); i++) {
            
           
            
        }
    }

}

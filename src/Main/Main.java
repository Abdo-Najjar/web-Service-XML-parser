package Main;

import Parsers.FinancialParser;
import Parsers.GradeParser;
import Parsers.Parser;


/**
 *
 * @author abdo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       Parser cvp = new GradeParser();
       
       
          cvp.read().forEach((t) -> {
            
              
              System.out.println(t);
          });
          
        
        
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GachaSim;
import static GachaSim.Frontend.WishSim.*;
import static GachaSim.Frontend.WishSimGUI.*;
import static GachaSim.Frontend.WishSimFX.*;

/*
 * The main method calls all the other front-ends that are available to the user.
 * The frontends are Located in GachaSim.Frontend.
 * By default, the simulator uses the JavaFX frontend by default.
 *
 * @author dyhar
 */
public class WishSimMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringBuilder help = new StringBuilder();
        help.append("\nThese are the valid arguments for GachaSim: \n");
        help.append("--cli or -c: Calls the cli frontend.\n");
        help.append("--swing or -c: Calls the Swing-based frontend. \n");
        help.append("--fx or -f: (Default) Calls the experimental JavaFX-based frontend.\n");
        if (args.length > 0)
            {
                String one = args[0];
        
                switch (one)
                    {
                        case "--cli":
                        case "-c":
                            cli();
                            break;
                        case "--swing":
                        case "-s":
                            swing();
                            break;
                        case "--javafx":
                        case "-j":
                            fx();
                            break;
                        default:
                            System.out.print(help);
                            break;
                    }
            }
        else
            fx();
       
    }
    
}

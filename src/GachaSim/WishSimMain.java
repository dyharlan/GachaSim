
package GachaSim;
import static GachaSim.Backend.GachaPool.*;
import static GachaSim.Frontend.WishSim.*;
import static GachaSim.Frontend.WishSimFX.*;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.util.Arrays;

/**
 * The main method calls all the other front-ends that are available to the user.
 * The front-ends are Located in GachaSim.Front-end.
 * By default, the simulator uses the JavaFX front-end.
 * @author dyhar
 */
public class WishSimMain {

    /**
     * @param args This changes what front-end to use for the program.
     * Options include:
     * "-c" or "--cli" for the command-line fallback.
     * "-f" or "--javafx" for the JavaFX front-end.
     * 
     */
    //public static String _5StarCharRateUp = chars[0][chars[0].length-2];
    //public static String _5StarCharRateUp2 = chars[0][chars[0].length-1];
    public static void main(String[] args) throws FileNotFoundException, IOException {
        load5StarCharPool("5starchars");
        load4StarCharPool("4starchars");
        load5StarWpnPool("5starwpns");
        load4StarWpnPool("4starwpns");
        
        
        
        if (args.length > 0)
            {
                StringBuilder help = new StringBuilder();
                help.append("\nThese are the valid arguments for GachaSim: \n");
                help.append("--cli or -c: Calls the cli frontend.\n");
                help.append("--javafx or -fx: (Default) Calls the JavaFX-based frontend.\n");
                String one = args[0];
                switch (one.toLowerCase())
                    {
                        case "--cli":
                        case "-c":
                            cli();
                            break;
                        case "--javafx":
                        case "-fx":
                            fx();
                            break;
                        default:
                        case "-h":
                        case "--help":
                            System.out.print(help);
                            break;
                    }
            }
        else
            fx();
            //cli();
            //System.out.println(Arrays.deepToString(chars));
            //System.out.println(Arrays.deepToString(wpns));

       
    }
    
}

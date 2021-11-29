
package GachaSim;
import static GachaSim.Frontend.WishSim.*;
import static GachaSim.Frontend.WishSimGUI.*;
import static GachaSim.Frontend.WishSimFX.*;

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
     */
    public static void main(String[] args) {
        StringBuilder help = new StringBuilder();
        help.append("\nThese are the valid arguments for GachaSim: \n");
        help.append("--cli or -c: Calls the cli frontend.\n");
        help.append("--javafx or -fx: (Default) Calls the experimental JavaFX-based frontend.\n");
        if (args.length > 0)
            {
                String one = args[0];
                switch (one)
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
                            System.out.print(help);
                            break;
                    }
            }
        else
            cli();
       
    }
    
}

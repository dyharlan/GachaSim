package GachaSim.Frontend;
import GachaSim.Banners.StdBanner;
import GachaSim.Banners.CharacterBanner;
import GachaSim.Banners.WeaponBanner;
import static GachaSim.Backend.GachaPool.*;
import java.util.Scanner;
import java.util.Arrays;
/**
 * TODO: SIMPLIFY/STREAMLINE LOOKUP TABLES FOR THE GACHA POOL [Partially Done, Decoupled Gacha Pool from backend] 
 * TODO: FIND SOMEONE TO VERIFY THE ACCURACY OF THE RATES (From my own testing with n=1000, the accumulated rate (1.6%) matches that of what the game presents.)
 * TODO: ADD AN ACTUAL LICENSE
 * TODO: IMPLEMENT FATE POINTS
 * @author dyhar
 */
public class WishSim 
{
    public static void cli() {
       
        boolean isFinished = false; 
        //declaring a new scanner class.
        String[] pulls = new String[10];
        Arrays.fill(pulls, "");
        int SinglePullCounter=0;
        Scanner input = new Scanner(System.in);
        int choice;
        while(!isFinished) //keeps the program running until the isFinished flag is turned on.
        {
            //System.out.println("\r");
            //The simulator header. W.I.P.
            System.out.println("Welcome to shit gacha!");
            System.out.println(" ");
            //System.out.printf("%.9f\n",Backend.Csoftpity);
            //System.out.printf("%.9f\n",Backend.Wsoftpity);
            //System.out.printf("%.9f\n",Backend.Ssoftpity);
            System.out.println("Rolls on the Standard Banner: " + StdBanner.Srolls);
            System.out.println("Rolls since last 4* on the Standard Banner: " + StdBanner._4Spity);
            System.out.println("What do you want to do?\n1. Roll on the Character Banner Once \n"
                    + "2. Roll on the Weapon Banner Once \n3. Roll on the Standard Banner \n"
                    + "4. Roll on the Character Banner 10x\n5. Roll on the Weapon banner 10x\n"
                    + "6. Roll on the Standard Banner 10x\n7. Exit");
            System.out.println(" ");
            System.out.println("Rolls on the Character Banner: " + CharacterBanner.Crolls);
            System.out.println("Rolls since last 4* on the Character Banner: " + CharacterBanner._4Spity);
            System.out.println("Guaranteed 5* character? " + CharacterBanner.guaranteed5);
            System.out.println(" ");
            System.out.println("Rolls on the Weapon Banner: " + WeaponBanner.Wrolls);
            System.out.println("Rolls since last 4* on the Character Banner: " + WeaponBanner._4Spity);
            System.out.println(" ");
            System.out.println("Rolls on the Standard Banner: " + StdBanner.Srolls);
            System.out.println("Rolls since last 4* on the Standard Banner: " + StdBanner._4Spity);
            System.out.println(" ");
            System.out.println(pulls[0]);
            System.out.println(pulls[1]);
            System.out.println(pulls[2]);
            System.out.println(pulls[3]);
            System.out.println(pulls[4]);
            System.out.println(pulls[5]);
            System.out.println(pulls[6]);
            System.out.println(pulls[7]);
            System.out.println(pulls[8]);
            System.out.println(pulls[9]);
            
            //This switch statement presents all the program functions.
            choice = input.nextInt();
            switch (choice)
            {
                case 1://Rolls on the character banner "rate up" once
                    if(SinglePullCounter < pulls.length)
                    {
                        pulls[SinglePullCounter] = CharacterBanner.CharRoll(chars[0][chars[0].length-2]);
                        SinglePullCounter++;
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    }
                    else
                    {
                        SinglePullCounter = 0;
                        pulls[SinglePullCounter] = CharacterBanner.CharRoll(chars[0][chars[0].length-2]);
                        SinglePullCounter++;
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    }
                    break;
                case 2:          
                    //System.out.println(WeaponBanner.WpnRoll());
                    if(SinglePullCounter < pulls.length)
                    {
                        pulls[SinglePullCounter] = WeaponBanner.WpnRoll();
                        SinglePullCounter++;
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    }
                    else
                    {
                        SinglePullCounter = 0;
                        pulls[SinglePullCounter] = WeaponBanner.WpnRoll();
                        SinglePullCounter++;
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    }
                    break;
                case 3:
                    //System.out.println(StdBanner.StdRoll());
                    if(SinglePullCounter < pulls.length)
                    {
                        pulls[SinglePullCounter] = StdBanner.StdRoll();
                        SinglePullCounter++;
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    }
                    else
                    {
                        SinglePullCounter = 0;
                        pulls[SinglePullCounter] = StdBanner.StdRoll();
                        SinglePullCounter++;
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    }
                    break;
                case 4:
                    for(SinglePullCounter = 0; SinglePullCounter < pulls.length; SinglePullCounter++)//Rolls on the character banner "rate up" ten times
                        pulls[SinglePullCounter] = CharacterBanner.CharRoll(chars[0][chars[0].length-2]);
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    break;
                case 5:
                    //for(int ctr = 0; ctr < 10; ctr++)//Rolls on the character banner "rate up" ten times
                    //    System.out.println(WeaponBanner.WpnRoll());
                    //break;
                    for(SinglePullCounter = 0; SinglePullCounter < pulls.length; SinglePullCounter++)//Rolls on the character banner "rate up" ten times
                        pulls[SinglePullCounter] = WeaponBanner.WpnRoll();
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    break;
                case 6:
                    //for(int ctr = 0; ctr < 10; ctr++)//Rolls on the character banner "rate up" ten times
                    //    System.out.println(StdBanner.StdRoll());
                    // break;
                    for(SinglePullCounter = 0; SinglePullCounter < pulls.length; SinglePullCounter++)//Rolls on the character banner "rate up" ten times
                        pulls[SinglePullCounter] = StdBanner.StdRoll();
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    break;
                case 7:
                   isFinished = true;
                   break;
            }   
        }
    }  
   
}

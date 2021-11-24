
package ShitGacha;

import java.util.Scanner;
/**
 * TODO: SIMPLIFY/STREAMLINE LOOKUP TABLES FOR THE GACHA POOL [Partially Done, Decoupled Gacha Pool from backend] 
 * TODO: FIND SOMEONE TO VERIFY THE ACCURACY OF THE RATES (From my own testing with n=1000, the accumulated rate (1.6%) matches that of what the game presents.)
 * TODO: CLEANUP/FIX OUTPUT
 * TODO: ADD AN ACTUAL LICENSE
 * TODO: IMPLEMENT FATE POINTS
 * @author dyhar
 */
public class WishSim 
{
    public static void main(String[] args) {
        //Creating an instance of the Character Banner Class
        //in order to check the counters for the 5 and 4 star pity, and the 5* guarantee.
        CharacterBanner CbannerStatus = new CharacterBanner(); 
        //Creating an instance of the Weapon Banner Class
        //in order to check the counters for the 5 and 4 star pity, and the 5* guarantee.
        WeaponBanner WbannerStatus = new WeaponBanner();
        //Creating an instance of the Standard Banner Class
        //in order to check the counters for the 5 and 4 star pity, and the 5* guarantee.
        StdBanner SbannerStatus = new StdBanner();
        //disables the flag to exit the program
        boolean isFinished = false; 
        //declaring a new scanner class.
        Scanner input = new Scanner(System.in);
        int choice;
        while(!isFinished) //keeps the program running until the isFinished flag is turned on.
        {
            //The simulator header. W.I.P.
            System.out.println("Welcome to shit gacha!");
            System.out.println(" ");
            System.out.println("Rolls on the Character Banner: " + CbannerStatus.Crolls);
            System.out.println("Rolls since last 4* on the Character Banner: " + CbannerStatus._4Spity);
            System.out.println("Guaranteed 5* character? " + CbannerStatus.guaranteed5);
            System.out.println(" ");
            System.out.println("Rolls on the Weapon Banner: " + WbannerStatus.Wrolls);
            System.out.println("Rolls since last 4* on the Character Banner: " + WbannerStatus._4Spity);
            System.out.println(" ");
            //System.out.printf("%.9f\n",Backend.Csoftpity);
            //System.out.printf("%.9f\n",Backend.Wsoftpity);
            //System.out.printf("%.9f\n",Backend.Ssoftpity);
            System.out.println("Rolls on the Standard Banner: " + SbannerStatus.Srolls);
            System.out.println("Rolls since last 4* on the Standard Banner: " + SbannerStatus._4Spity);
            System.out.println("What do you want to do?\n1. Roll on the Character Banner Once \n"
                    + "2. Roll on the Weapon Banner Once \n3. Roll on the Standard Banner \n"
                    + "4. Roll on the Character Banner 10x\n5. Roll on the Weapon banner 10x\n"
                    + "6. Roll on the Standard Banner 10x\n7. Exit");

            //This switch statement presents all the program functions.
            choice = input.nextInt();
            switch (choice)
            {
                case 1://Rolls on the character banner "rate up" once
                    System.out.println(CharacterBanner.CharRoll("Albedo", "Rosaria", "Bennett", "Noelle"));
                    break;
                case 2:          
                    System.out.println(WeaponBanner.WpnRoll("Freedom-Sworn", "Song of Broken Pines", "Wine and Song", "Alley Hunter", "Lion's Roar", "Sac. Greatsword", "Dragon's Bane"));
                    break;
                case 3:
                    System.out.println(StdBanner.StdRoll());
                    break;
                case 4:
                    for(int ctr = 0; ctr < 10; ctr++)//Rolls on the character banner "rate up" ten times
                        System.out.println(CharacterBanner.CharRoll("Albedo", "Rosaria", "Bennett", "Noelle"));
                    break;
                case 5:
                    for(int ctr = 0; ctr < 10; ctr++)//Rolls on the character banner "rate up" ten times
                        System.out.println(WeaponBanner.WpnRoll("Freedom-Sworn", "Song of Broken Pines", "Wine and Song", "Alley Hunter", "Lion's Roar", "Sac. Greatsword", "Dragon's Bane"));
                    break;
                case 6:
                     for(int ctr = 0; ctr < 10; ctr++)//Rolls on the character banner "rate up" ten times
                        System.out.println(StdBanner.StdRoll());
                     break;
                case 7:
                   isFinished = true;
                    break;
            }   
        }
    }  
   
}

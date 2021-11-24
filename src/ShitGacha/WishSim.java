
package ShitGacha;

import java.util.Scanner;
/**
 *
 * @author dyhar
 */
public class WishSim 
{
    public static int choice;
    
    public static void main(String[] args) {
        //Creating an instance of the Character Banner Class
        //in order to check the counters for the 5 and 4 star pity, and the 5* guarantee.
        CharacterBanner CbannerStatus = new CharacterBanner(); 
        //Creating an instance of the Weapon Banner Class
        //in order to check the counters for the 5 and 4 star pity, and the 5* guarantee.
        WeaponBanner WbannerStatus = new WeaponBanner();
        //disables the flag to exit the program
        boolean isFinished = false; 
        //declaring a new scanner class.
        Scanner input = new Scanner(System.in);
        while(!isFinished) //keeps the program running until the isFinished flag is turned on.
        {
            //The simulator header. W.I.P.
            System.out.println("Welcome to shit gacha!");
            System.out.println("Rolls on the Character Banner: " + CbannerStatus.Crolls);
            System.out.println("Rolls since last 4* on the Character Banner: " + CbannerStatus._4Spity);
            System.out.println("Guaranteed 5* character? " + CbannerStatus.guaranteed5);
            System.out.println(" ");
            System.out.println("Rolls on the Weapon Banner: " + WbannerStatus.Wrolls);
            System.out.println("Rolls since last 4* on the Character Banner: " + WbannerStatus._4Spity);
            System.out.println("What do you want to do?\n1. Roll on the Character Banner Once \n"
                    + "2. Roll on the Weapon Banner Once \n3. Roll on the Character Banner 10x\n4. Roll on the Weapon Banner 10x\n5. Exit");
            //This switch statement presents all the program functions.
            choice = input.nextInt();
            switch (choice)
            {
                case 1://Rolls on the character banner "rate up" once
                    System.out.println(CharacterBanner.CharRoll("Albedo", "Rosaria", "Bennett", "Noelle"));
                    break;
                case 2:          
                    System.out.println(WeaponBanner.WpnRoll("Freedom-Sworn", "Song of Broken Pines", "Wine and Song", "Alley Hunter", "Lion's Road", "Sac. Greatsword", "Dragon's Bane"));
                    break;
                case 3:
                    for(int ctr = 0; ctr < 10; ctr++)//Rolls on the character banner "rate up" ten times
                        System.out.println(CharacterBanner.CharRoll("Albedo", "Rosaria", "Bennett", "Noelle"));
                    break;
                case 4:
                    for(int ctr = 0; ctr < 10; ctr++)//Rolls on the character banner "rate up" ten times
                        System.out.println(WeaponBanner.WpnRoll("Freedom-Sworn", "Song of Broken Pines", "Wine and Song", "Alley Hunter", "Lion's Road", "Sac. Greatsword", "Dragon's Bane"));
                    break;
                case 5:
                    isFinished = true;
                    break;
            }   
        }
    }  
   
}

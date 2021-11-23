/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShitGacha;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author dyhar
 */
public class WishSim 
{
    public static int choice;
    
    public static void main(String[] args) {
        Middleware bannerStatus = new Middleware();
        boolean isFinished = false; 
        Scanner input = new Scanner(System.in);
        while(!isFinished)
        {
            System.out.println("Welcome to shit gacha!");
            System.out.println("Rolls on the Character Banner: " + bannerStatus.Crolls);
            System.out.println("Rolls since last 4* on the Character Banner: " + bannerStatus._4Spity);
            System.out.println("Rolls on the Weapon Banner: " + bannerStatus.Wrolls);
            System.out.println("Guaranteed 5* character? " + bannerStatus.guaranteed5);
            System.out.println("What do you want to do?\n1. Roll on the Character Banner Once \n"
                    + "2. Roll on the Weapon Banner Once \n3. Roll on the Character Banner 10x\n4. Roll on the Weapon Banner 10x\n5. Exit");
            choice = input.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println(Middleware.CharRoll("Hu Tao", "Thoma"));
                    break;
                case 2:                   
                    break;
                case 3:
                    for(int ctr = 0; ctr < 10; ctr++)
                        System.out.println(Middleware.CharRoll("Hu Tao", "Thoma"));
                    break;
                case 4:
                    break;
                case 5:
                    isFinished = true;
                    break;
            }   
        }
    }  
   
}

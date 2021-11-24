/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShitGacha;
import java.util.Random;
/**
 *
 * @author dyhar
 */
public class WeaponBanner {
    // public static boolean guaranteed5 = false; 
    public static int _4Spity=0; 
    public static Random rngd = new Random();
    public static int Wrolls=0;
    //rolls a banner once. Arguments are the 5 rate up weapons
    public static String WpnRoll(String $5wrateup1, String $5rateup2 
            ,String  $4wrateup1, String  $4wrateup2, String  $4wrateup3, String  $4wrateup4, String  $4wrateup5)
     {
                //  _____    _____ _                 
                // | ____|  / ____| |                
                // | |__   | (___ | |_ __ _ _ __ ___ 
                // |___ \   \___ \| __/ _` | '__/ __|
                //  ___) |  ____) | || (_| | |  \__ \
                // |____/  |_____/ \__\__,_|_|  |___/
         
                //You randomly got a 5* pull.
                if(Backend.Rarity(Backend.gachaChance('w'), 'w') == 5) 
                {
                    Wrolls = 0; //resets pity counter to 0
                    _4Spity++; // add 4* pity
                    Backend.resetChance('w'); //resets accumulated odds
                    return Backend._5_Star__Weapons($5wrateup1, $5rateup2); //pray to God.
                }
                
                //If you reach 80 pulls, but don't have the guarantee, you have a 50/50 chance to get a rate up 5*.
                //Otherwise, flags guarantee.
                else if(Wrolls == 79)
                {
                    Wrolls = 0;
                    _4Spity++;
                    Backend.resetChance('w');
                    return Backend._5_Star__Weapons($5wrateup1, $5rateup2);
                }
                //  _  _      _____ _                 
                // | || |    / ____| |                
                // | || |_  | (___ | |_ __ _ _ __ ___ 
                // |__   _|  \___ \| __/ _` | '__/ __|
                //    | |    ____) | || (_| | |  \__ \
                //    |_|   |_____/ \__\__,_|_|  |___/   
                
                //You obtain a 4*. You also reset the 4* counter
                else if(Backend.Rarity(Backend.gachaChance('w'), 'w') == 4)
                {
                    _4Spity = 0; //resets 4* count
                    Wrolls++; //adds pity
                    //you either get a rate up 4* weapon or char
                    return (rngd.nextBoolean() == true)? Backend._4_Star__Characters() : Backend._4_Star__Weapons($4wrateup1, $4wrateup2, $4wrateup2, $4wrateup4, $4wrateup5);
                }
                //You are guaranteed a 4* every 10 pulls, but you also reset the 4* counter.
                else if(Backend.Rarity(Backend.gachaChance('w'), 'w') == 3 && _4Spity == 9)
                {
                    _4Spity = 0;
                    Wrolls++;
                    return (rngd.nextBoolean() == true)? Backend._4_Star__Characters() : Backend._4_Star__Weapons($4wrateup1, $4wrateup2, $4wrateup2, $4wrateup4, $4wrateup5);
                }
                //  _______                         _     
                // |__   __|                       | |    
                //    | |     _ __    __ _   ___   | |__  
                //    | |    | '__|  / _` | / __|  | '_ \ 
                //    | |    | |    | (_| | \__ \  | | | |
                //    |_|    |_|     \__,_| |___/  |_| |_|  
                
                //You stepped on dogshit.
                else 
                {
                    _4Spity++;
                    Wrolls++;
                    return Backend._3_Star__Weapons();
                }
    }

}

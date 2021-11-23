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
public class Middleware {
    public static boolean guaranteed5 = false; public static int Crolls=0,_4Spity=0,Wrolls=0; 
    public static Random rngd = new Random();
     //rolls a banner once.
    public static String CharRoll(String $5rateup, String  $4rateup)
    {
                //  _____    _____ _                 
                // | ____|  / ____| |                
                // | |__   | (___ | |_ __ _ _ __ ___ 
                // |___ \   \___ \| __/ _` | '__/ __|
                //  ___) |  ____) | || (_| | |  \__ \
                // |____/  |_____/ \__\__,_|_|  |___/
                //If you randomly got a 5* pull, and you're guaranteed, you get the rate up character
                if(guaranteed5 == true && Backend.Rarity(Backend.Rates()) == 5) 
                {
                    Crolls = 0;
                    _4Spity++;
                    guaranteed5 = false;
                    return $5rateup;
                }
                //If you got to 90 pulls and you're guaranteed, you get the rate up character.
                else if(guaranteed5 == true  && Crolls == 89)  
                {
                    Crolls = 0;
                    _4Spity++;
                    guaranteed5 = false;
                    return $5rateup;
                }
                //If you reach 90 pulls, but don't have the guarantee, you have a 50/50 chance to get a rate up 5*.
                //Otherwise, flags guarantee.
                else if(Crolls == 89)
                {
                    Crolls = 0;
                    _4Spity++;
                    //if(Backend.Rates() >= .5f)
                    if(rngd.nextBoolean() == true)
                    {
                       return  $5rateup;
                    }
                    else
                    {
                   guaranteed5 = true;
                   return Backend._5_Star__Characters();
                    }
                }
                //If you randomly got a 5* pull but don't have a guarantee, you have a 50/50 chance to get a rate up 5*.
                //Otherwise, flags guarantee.
                else if(Backend.Rarity(Backend.Rates()) == 5)
                {
                    Crolls = 0;
                    _4Spity++;
                    //if(Backend.Rates() >= .5f)
                    if(rngd.nextBoolean() == true)
                    {
                       guaranteed5 = false;
                       return  $5rateup;
                    }
                    else{
                   guaranteed5 = true;
                   return Backend._5_Star__Characters();
                    }
                }
                //  _  _      _____ _                 
                // | || |    / ____| |                
                // | || |_  | (___ | |_ __ _ _ __ ___ 
                // |__   _|  \___ \| __/ _` | '__/ __|
                //    | |    ____) | || (_| | |  \__ \
                //    |_|   |_____/ \__\__,_|_|  |___/                                                        
                //You obtain a 4*. You also reset the 4* counter
                else if(Backend.Rarity(Backend.Rates()) == 4)
                {
                    _4Spity = 0;
                    Crolls++;
                    return Backend._4_Star__Characters($4rateup);
                }
                //You are guaranteed a 4* every 10 pulls, but you also reset the 4* counter.
                else if(Backend.Rarity(Backend.Rates()) == 3 && _4Spity >= 9)
                {
                    _4Spity = 0;
                    Crolls++;
                    return Backend._4_Star__Characters($4rateup);
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
                    Crolls++;
                    return Backend._3_Star__Weapons();
                }  
    }

}

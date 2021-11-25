/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShitGacha;
import java.util.Random;
import static ShitGacha.GachaPool.*;
/**
 *
 * @author dyhar
 */
public class WeaponBanner {
    public static int _4Spity=0; 
    public static Random rngd = new Random();
    public static int Wrolls=0;
    //rolls a banner once.
    public static String WpnRoll(String $5wrateup1, String $5rateup2 
            ,String  $4wrateup1, String  $4wrateup2, String  $4wrateup3, String  $4wrateup4, String  $4wrateup5)
     {
                //  _____    _____ _                 
                // | ____|  / ____| |                
                // | |__   | (___ | |_ __ _ _ __ ___ 
                // |___ \   \___ \| __/ _` | '__/ __|
                //  ___) |  ____) | || (_| | |  \__ \
                // |____/  |_____/ \__\__,_|_|  |___/
                int rarity = Backend.Rarity(Backend.gachaChance('w'), 'w');
                //You randomly got a 5* pull or if you reach 80 pulls, you have a 50/50 chance to get a rate up 5*.
                if(rarity == 5 || Wrolls == 79) 
                {
                    Wrolls = 0; //resets pity counter to 0
                    _4Spity++; // add 4* pity
                    Backend.resetChance('w'); //resets accumulated odds
                    return _5_Star__Weapons($5wrateup1, $5rateup2); //pray to God.
                }
                //  _  _      _____ _                 
                // | || |    / ____| |                
                // | || |_  | (___ | |_ __ _ _ __ ___ 
                // |__   _|  \___ \| __/ _` | '__/ __|
                //    | |    ____) | || (_| | |  \__ \
                //    |_|   |_____/ \__\__,_|_|  |___/   
                
                //You obtain a 4*. You also reset the 4* counter
                else if(rarity == 4 || ( (rarity == 3 || rarity == 4) && _4Spity >= 9) )
                {
                    _4Spity = 0; //resets 4* count
                    Wrolls++; //adds pity
                    //you either get a rate up 4* weapon or char
                    return (rngd.nextBoolean() == true)? _4_Star__Characters() : _4_Star__Weapons($4wrateup1, $4wrateup2, $4wrateup2, $4wrateup4, $4wrateup5);
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
                    return _3_Star__Weapons();
                }
    }

}

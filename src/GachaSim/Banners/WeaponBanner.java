/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GachaSim.Banners;
import GachaSim.Backend.CoreBackend;
import java.util.Random;
import static GachaSim.Backend.GachaPool.*;
/**
 *
 * @author dyhar
 */
public class WeaponBanner {
    //Declaring these variables as static so others classes can access them.
    public static int _4Spity=0; 
    public static int Wrolls=0;
     /**
      * Rolls the weapon banner once. Arguments are the 7 rate up weapons
      * 
      * @param $5wrateup1 The first current 5* rate-up weapon.
      * @param $5wrateup2 The second current 5* rate-up weapon.
      * @param $4wrateup1 The first rate-up 4*.
      * @param $4wrateup2 The second rate-up 4*.
      * @param $4wrateup3 The third rate-up 4*.
      * @param $4wrateup4 The fourth rate-up 4*.
      * @param $4wrateup5 The fifth rate-up 4*.
      * @return the weapon/char you pulled.
     */
    public static String WpnRoll(String $5wrateup1, String $5wrateup2 
            ,String  $4wrateup1, String  $4wrateup2, String  $4wrateup3, String  $4wrateup4, String  $4wrateup5)
     {
        Random rngd = new Random();
                //  _____    _____ _                 
                // | ____|  / ____| |                
                // | |__   | (___ | |_ __ _ _ __ ___ 
                // |___ \   \___ \| __/ _` | '__/ __|
                //  ___) |  ____) | || (_| | |  \__ \
                // |____/  |_____/ \__\__,_|_|  |___/
                int rarity = CoreBackend.Rarity(CoreBackend.gachaChance('w'), 'w');
                //You randomly got a 5* pull or if you reach 80 pulls, you have a 50/50 chance to get a rate up 5*.
                if(rarity == 5 || Wrolls == 79) 
                {
                    Wrolls = 0; //resets pity counter to 0
                    _4Spity++; // add 4* pity
                    CoreBackend.resetChance('w'); //resets accumulated odds
                    return _5_Star__Weapons($5wrateup1, $5wrateup2); //pray to God.
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

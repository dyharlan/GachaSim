/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GachaSim.Banners;

import GachaSim.Backend.CoreBackend; //importing the CoreBackend services for rarity detection
import java.util.Random;
import static GachaSim.Backend.GachaPool.*; //importing GachaPool class for the gacha pool
/**
 * This class handles the rolling of the Standard banner.
 * @author dyhar
 */

public class StdBanner {
    //Declaring these variables as static so frontends can access them.
    public static int Srolls=0,_4Spity=0; 
    /**
     * Rolls on the standard banner once.
     * @return The character/weapon you pulled. 
     */
    public static String StdRoll()
    {
                Random rngd = new Random();
                //  _____    _____ _                 
                // | ____|  / ____| |                
                // | |__   | (___ | |_ __ _ _ __ ___ 
                // |___ \   \___ \| __/ _` | '__/ __|
                //  ___) |  ____) | || (_| | |  \__ \
                // |____/  |_____/ \__\__,_|_|  |___/
                int rarity = CoreBackend.Rarity(CoreBackend.gachaChance('s'), 'c');
                //You get a std 5*. Either if you reach 90 pulls or randomly, you get a 5* weapon or character.
                if(rarity == 5 || Srolls == 89) 
                {
                    Srolls = 0; //resets rolls to 0.
                    _4Spity++; //builds 4* pity
                    CoreBackend.resetChance('s'); //clears accumulated pity.
                    //returns either a 5* weapon or character
                    return (rngd.nextBoolean() == true)? _5_Star__Characters() : _5_Star__Weapons("nr"); 
                }
                //  _  _      _____ _                 
                // | || |    / ____| |                
                // | || |_  | (___ | |_ __ _ _ __ ___ 
                // |__   _|  \___ \| __/ _` | '__/ __|
                //    | |    ____) | || (_| | |  \__ \
                //    |_|   |_____/ \__\__,_|_|  |___/                                                        
                //You obtain a 4*. You also reset the 4* counter
                //You are guaranteed a 4* every 10 pulls, but you also reset the 4* counter.
                else if(rarity == 4 || ( (rarity == 3 || rarity == 4) && _4Spity >= 9) )
                {
                    _4Spity = 0;
                    Srolls++;
                    // 50/50 chance to get a rate up char or weapon
                    return (rngd.nextBoolean() == true)? _4_Star__Characters("nr") : _4_Star__Weapons();
                }
                //  _______                         _     
                // |__   __|                       | |    
                //    | |     _ __    __ _   ___   | |__  
                //    | |    | '__|  / _` | / __|  | '_ \ 
                //    | |    | |    | (_| | \__ \  | | | |
                //    |_|    |_|     \__,_| |___/  |_| |_|                                            
                //You stepped on trash.
                else 
                {
                    _4Spity++;
                    Srolls++;
                    return _3_Star__Weapons();
                }
                
    }
}

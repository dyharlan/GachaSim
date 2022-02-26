
package GachaSim.Banners;
import GachaSim.Backend.CoreBackend; //importing the CoreBackend services for rarity detection
import java.util.Random;
import static GachaSim.Backend.GachaPool.*; //importing GachaPool class for the gacha pool
/**
 * This class handles the rolling of the Character Rate-up banner.
 * Arguments in order are: The 5* rate up, and three rate up 4*. Separated by commas.

 * @author dyhar
 */
public class CharacterBanner {
    //Declaring these variables as static so frontends can access them.
    public static boolean guaranteed5 = false;
    public static int Crolls=0,_4Spity=0; 
     /**
      * Rolls the Character banner once. Arguments are the 4 rate up chars.
      * 
      * @param $5srateup The current 5* rate-up character.
      * @return the character you pulled.
     */
    public static String CharRoll(String $5srateup)
    {
                Random rngd = new Random();
                //  _____    _____ _                 
                // | ____|  / ____| |                
                // | |__   | (___ | |_ __ _ _ __ ___ 
                // |___ \   \___ \| __/ _` | '__/ __|
                //  ___) |  ____) | || (_| | |  \__ \
                // |____/  |_____/ \__\__,_|_|  |___/
                int rarity = CoreBackend.Rarity(CoreBackend.gachaChance('c'), 'c');
                //If you randomly got a 5* pull or to 90 pulls, and you're guaranteed, you get the rate up character.
                if( (guaranteed5 == true && rarity == 5) || (guaranteed5 == true && Crolls == 89) ) 
                {
                    Crolls = 0; //resets rolls to 0.
                    _4Spity++; //builds 4* pity
                    guaranteed5 = !guaranteed5; //resets guarantee
                    CoreBackend.resetChance('c'); //clears accumulated pity.
                    return $5srateup; //returns the character rolled
                }
                //If you randomly got a 5* pull or got to 90 pulls but don't have a guarantee, you have a 50/50 chance to get a rate up 5*.
                //Otherwise, guarantees that the next 5* you pull on this banner is the rate up.
                else if(rarity == 5 || Crolls == 89)
                {
                    Crolls = 0;
                    _4Spity++;
                    CoreBackend.resetChance('c');
                    if(rngd.nextBoolean() == true)
                    {
                       guaranteed5 = false;
                       return $5srateup;
                    }
                       guaranteed5 = true;
                       return _5_Star__Characters();
                }
                //  _  _      _____ _                 
                // | || |    / ____| |                
                // | || |_  | (___ | |_ __ _ _ __ ___ 
                // |__   _|  \___ \| __/ _` | '__/ __|
                //    | |    ____) | || (_| | |  \__ \
                //    |_|   |_____/ \__\__,_|_|  |___/                                                        
                //You obtain a 4*. You also reset the 4* counter
                //You are also guaranteed a 4* every 10 pulls, but you also reset the 4* counter.
                else if( ( (rarity == 3 || rarity == 4) && _4Spity >= 9 ) || rarity == 4 )
                {
                    _4Spity = 0;
                    Crolls++;
                    // 50/50 chance to get a rate up char or weapon
                    return (rngd.nextBoolean() == true)? _4_Star__Characters() : _4_Star__Weapons();
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
                    Crolls++;
                    return _3_Star__Weapons();
                }

    }

}

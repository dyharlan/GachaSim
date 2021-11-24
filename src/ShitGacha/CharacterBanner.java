
package ShitGacha;
import java.util.Random;
import static ShitGacha.GachaPool.*;
/**
 *
 * @author dyhar
 */
public class CharacterBanner {
    public static boolean guaranteed5 = false; 
    public static int Crolls=0,_4Spity=0; 
    public static Random rngd = new Random();
     //rolls a banner once. Arguments are the 4 rate up chars
    public static String CharRoll(String $5rateup, String  $4rateup1, String $4rateup2, String $4rateup3)
    {
                //  _____    _____ _                 
                // | ____|  / ____| |                
                // | |__   | (___ | |_ __ _ _ __ ___ 
                // |___ \   \___ \| __/ _` | '__/ __|
                //  ___) |  ____) | || (_| | |  \__ \
                // |____/  |_____/ \__\__,_|_|  |___/
                int rarity = Backend.Rarity(Backend.gachaChance('c'), 'c');
                //If you randomly got a 5* pull, and you're guaranteed, you get the rate up character.
                if(guaranteed5 == true && rarity == 5) 
                {
                    Crolls = 0; //resets rolls to 0.
                    _4Spity++; //builds 4* pity
                    guaranteed5 = !guaranteed5; //resets guarantee
                    Backend.resetChance('c'); //clears accumulated pity.
                    return $5rateup; //returns the character rolled
                }
                //If you got to 90 pulls and you're guaranteed, you get the rate up character.
                else if(guaranteed5 == true && Crolls == 89)  
                {
                    Crolls = 0;
                    _4Spity++;
                    guaranteed5 = !guaranteed5;
                    Backend.resetChance('c');
                    return $5rateup;
                }
                //If you reach 90 pulls, but don't have the guarantee, you have a 50/50 chance to get a rate up 5*.
                //Otherwise, flags guarantee.
                else if(Crolls == 89)
                {
                    Crolls = 0;
                    _4Spity++;
                    Backend.resetChance('c');
                    if(rngd.nextBoolean() == true) //determines if you'll get the rate up or not. 50/50 chance
                    {
                       guaranteed5 = false;
                       return  $5rateup;
                    }
                    else
                       guaranteed5 = true;
                       return _5_Star__Characters();
                }
                //If you randomly got a 5* pull but don't have a guarantee, you have a 50/50 chance to get a rate up 5*.
                //Otherwise, guarantees that the next 5* you pull on this banner is the rate up.
                else if(rarity == 5)
                {
                    Crolls = 0;
                    _4Spity++;
                    Backend.resetChance('c');
                    if(rngd.nextBoolean() == true)
                    {
                       guaranteed5 = false;
                       return  $5rateup;
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
                else if(rarity == 4)
                {
                    _4Spity = 0;
                    Crolls++;
                    // 50/50 chance to get a rate up char or weapon
                    return (rngd.nextBoolean() == true)? _4_Star__Characters($4rateup1, $4rateup2, $4rateup2) : _4_Star__Weapons();
                }
                //You are guaranteed a 4* every 10 pulls, but you also reset the 4* counter.
                else if( (rarity == 3 || rarity == 4) && _4Spity >= 9)
                {
                    _4Spity = 0;
                    Crolls++;
                    // 50/50 chance to get a rate up char or weapon
                    return (rngd.nextBoolean() == true)? _4_Star__Characters($4rateup1, $4rateup2, $4rateup2) : _4_Star__Weapons();
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
                    return _3_Star__Weapons();
                }
    }

}

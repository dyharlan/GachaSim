
package GachaSim.Backend;
import GachaSim.Banners.StdBanner;
import GachaSim.Banners.CharacterBanner;
import GachaSim.Banners.WeaponBanner;
import java.util.Random;
/**
 * This class mainly handles the algorithms to determine the rarity of the pull on each
 * of the in-game banners. (Standard, Weapon, and Character)
 * 
 * @author dyhar
 */
public class CoreBackend {
    
   //=======================Game-specific Variables================================//
    //Creating an instance of the Character, Weapon and Standard Banner Classes
    //in order to check the counters for the 5 and 4 star pity, and the 5* guarantee.
    static CharacterBanner CbannerStatus = new CharacterBanner(); 
    static WeaponBanner WbannerStatus = new WeaponBanner();
    static StdBanner SbannerStatus = new StdBanner();
    static float Csoftpity=0.0f;  //resets the Character softpity to 0f
    static float Wsoftpity=0.0f;  //resets the Weapon softpity to 0f
    static float Ssoftpity=0.0f;  //resets the Std banner softpity to 0f
  //==============================================================================//  
    
    static Random garborates = new Random(); //Declaring a new random class
    
 //==============================================================================//
    
    /**
    * This method determines the chance that will be used by Rarity() to determine the rarity of the wish.
    * Starting with the 74/64th pull, an additional 6.25% is deducted until the percentage is equal to or less than 0.
    * @param b Determines when to start the soft pity of the selected banner. "c" and "s" starts at the 74th pull. "w" starts at the 64th pull.
    * @return a float value between 0 and 1.
    */
    
    public static float gachaChance(char b)
    {
        //this switch determines when the soft pity will start.
        //selecting c will kickstart the soft pity at the 74th pull, while w is at 64th.
        //soft pity will kickstart at (n-1) pulls
        switch (b)
        {
        case  'c':
            //starting with the 74th pull on the character banner, an additional 6.25% is added to the odds.
            if(CbannerStatus.Crolls >= 73){ 
                Csoftpity+=0.0625f;
                return garborates.nextFloat()-Csoftpity; 
            }
            //if it's less than 74 pulls, it returns the odds without manipulation.
                return garborates.nextFloat(); 
                
        case 'w': 
            //starting with the 64th pull on the weapon banner, an additional 6.25% is added to the odds.
            if(WbannerStatus.Wrolls >= 63){
                Wsoftpity+=0.0625f;
                return garborates.nextFloat()-Wsoftpity; 
            }
            //if it's less than 64 pulls, it returns the odds without manipulation.
                return garborates.nextFloat();
        case 's': 
            //starting with the 74th pull on the Std banner, an additional 6.25% is added to the odds.
            if(SbannerStatus.Srolls >= 73){
                Ssoftpity+=0.0625f;
                return garborates.nextFloat()-Ssoftpity; 
            }
            //if it's less than 74 pulls, it returns the odds without manipulation.
                return garborates.nextFloat();
        }
        return 0.0f;
    }
   
    /**Determines the rarity based-off a float value passed on to it.
    * @param x accepts any float value between 0 and 1. The method checks what rarity you got based off the float value.
    * @param b accepts 'w' or 'c' to adjust the rates for the specific banner.
    * 
    * @return returns the rarity of the character of weapon from the pull.
    */
    public static int Rarity(float x, char b)
    {
        switch(b)
        {
            case 'w':
                if(x <= 0.007f) //rarity is 5* if the number is less than or equal to 0.7% or 0.007
                    return 5;
                else if(x <= 0.06f)// rarity is 4* if the number is less than or equal to 6% or 0.06
                    return 4;
                else if (x > 0.06f && x <= 1f) //fockin shit
                    return 3;
                    break;
            case 'c':
                if(x <= 0.006f) //rarity is 5* if the number is less than or equal to 0.6% or 0.006
                    return 5;
                else if(x <= 0.051f)// rarity is 4* if the number is less than or equal to 5.1% or 0.051
                    return 4;
                else if (x > 0.051f && x <= 1f) //3* star...
                    return 3;
        }
        return 0;
    }
    /**this method manually resets the accumulated soft pity
    * for each of the banners.
    * @param b resets the accumulated pity of the selected banner. 'c' resets the soft-pity for the character banner,
    * 'w' resets the weapon banner, and
    * 's' resets the standard banner.
    */
    public static void resetChance(char b)
    {
        switch (b)
        {
        //if c is invoked, soft pity accumulated odds for the char banner are reset.
            case 'c':
                Csoftpity = 0.0f;
                break;
        //if w is invoked, soft pity accumulated odds for the weapon banner are reset.
            case 'w':
                Wsoftpity = 0.0f;
                break;
        //if w is invoked, soft pity accumulated odds for the weapon banner are reset.
            case 's':
                Ssoftpity = 0.0f;
                break;
        }
    }
      
}

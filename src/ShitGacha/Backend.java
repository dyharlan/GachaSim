
package ShitGacha;
import java.util.Random;
/**
 *
 * @author dyhar
 */
public class Backend {
    //Creating an instance of the Character Banner Class
    //in order to check the counters for the 5 and 4 star pity, and the 5* guarantee.
    static CharacterBanner CbannerStatus = new CharacterBanner(); 
    //Creating an instance of the Weapon Banner Class
    //in order to check the counters for the 5 and 4 star pity, and the 5* guarantee.
    static WeaponBanner WbannerStatus = new WeaponBanner();
    static Random garborates = new Random(); //Declaring a new random class
    static float Csoftpity=0.0f;  //resets the Character softpity to 0f
    static float Wsoftpity=0.0f;  //resets the Weapon softpity to 0f
    //This method determines the chance that will be used by Rarity() to determine the rarity of the wish.
    //Starting with the 74/64th pull, an additional 6.25% is deducted until the percentage is equal to or less than 0.
    //char b determines what banner is used to appropriately kickstart the soft pity.
    public static float gachaChance(char b)
    {
        //this switch determines when the soft pity will start.
        //selecting c will kickstart the soft pity at the 74th pull, while w is at 64th.
        switch (b)
        {
        case  'c':
            //starting with the 74th pull on the character banner, an additional 6.25% is added to the odds.
            if(CbannerStatus.Crolls >= 74){ 
                Csoftpity+=0.0625f;
                return garborates.nextFloat()-Csoftpity; 
            }
            //if it's less than 74 pulls, it returns the odds without manipulation.
                return garborates.nextFloat(); 
                
        case 'w': 
            //starting with the 64th pull weapon banner, an additional 6.25% is added to the odds.
            if(WbannerStatus.Wrolls >= 64){
                Wsoftpity+=0.0625f;
                return garborates.nextFloat()-Wsoftpity; 
            }
            //if it's less than 64 pulls, it returns the odds without manipulation.
                return garborates.nextFloat();
      
        }
        return 0.0f;
    }
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
        }
    }
    //Determines the rarity based-off a float value passed on to it.
    //invoking w will adjust the rates to match the weapon banner
    //invoking c will adjust the rates to match the char banner
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
                else if (x > 0.051f && x <= 1f) //fockin shit
                    return 3;
        }
        return 0;
    }

//These methods store an array wherein if invoked, will return any character/weapon stored in the array.
//invoking the x amount of args needed by the method will allow you to insert an x amount of rate up chars or weapons
    //Arrays for the 5 and 4 star weapons
//==================================================//
    //character pool
    public static String _5_Star__Characters()
    {
        String[] _5character = {"Jean", "Diluc", "Qiqi", "Keqing", "Mona"};
        return _5character[garborates.nextInt(_5character.length)];
    }
    
    public static String _4_Star__Characters()
    {
        String[] _4character = {"Barbara", "Razor", "Bennett", "Noelle", "Fischl", "Sucrose", 
        "Beidou", "Ningguang", "Xiangling", "Xingqiu", "Chongyun", "Diona", "Xinyan", "Rosaria", 
        "Yanfei", "Sayu", "Sara"};
        return _4character[garborates.nextInt(_4character.length)];
    }
    
    public static String _4_Star__Characters(String rateup1, String rateup2, String rateup3)
    {
        String[] _4character = {"Barbara", "Razor", "Bennett", "Noelle", "Fischl", "Sucrose", 
        "Beidou", "Ningguang", "Xiangling", "Xingqiu", "Chongyun", "Diona", "Xinyan", "Rosaria", 
        "Yanfei", "Sayu", "Sara", rateup1, rateup2, rateup3};
        return _4character[garborates.nextInt(_4character.length)];
    }
    
//==================================================//
    //weapon pool
    
    public static String _5_Star__Weapons()
    {
        String[] _5weapon = {"Amos' Bow", "Aquila Favonia", "Lost Prayer to the Sacred Winds", 
            "Primordial Jade Spear", "S. Atlas", "S. Blade", "S. Harp", "S. Pride", 
            "S. Spine", "Wolf's Gravestone"};
        return _5weapon[garborates.nextInt(_5weapon.length)];
    }
    
    public static String _5_Star__Weapons(String rateup1, String rateup2)
    {
        String[] _5weapon = {"Amos' Bow", "Aquila Favonia", "Lost Prayer to the Sacred Winds", 
            "Primordial Jade Spear", "S. Atlas", "S. Blade", "S. Harp", "S. Pride", 
            "S. Spine", "Wolf's Gravestone",rateup1,rateup2};
        return _5weapon[garborates.nextInt(_5weapon.length)];
    }
    
    public static String _4_Star__Weapons()
    {
        String[] _4weapon = {"Dragon's Bane", "Eye of Perception", 
            "F. Codex", "F. Greatsword", "F. Lance", "F. Sword", "F. Warbow", 
            "Lion's Roar", "Rainslasher", "Rust", "Sac. Bow", "Sac. Fragments", "Sac. Greatsword", "Sac. Sword", 
            "The Bell", "The Flute", "The Stringless", "The Widsith"};
        return _4weapon[garborates.nextInt(_4weapon.length)];
    }
    
    public static String _4_Star__Weapons(String rateup1, String rateup2, String rateup3, String rateup4, String rateup5)
    {
        String[] _4weapon = {"Dragon's Bane", "Eye of Perception", 
            "F. Codex", "F. Greatsword", "F. Lance", "F. Sword", "F. Warbow", 
            "Lion's Roar", "Rainslasher", "Rust", "Sac. Bow", "Sac. Fragments", "Sac. Greatsword", "Sac. Sword", 
            "The Bell", "The Flute", "The Stringless", "The Widsith", rateup1, rateup2, rateup3, rateup4, rateup5};
        return _4weapon[garborates.nextInt(_4weapon.length)];
    }
//I didn't even bother
    public static String _3_Star__Weapons()
    {
        //String[] wpn = {"Cool Steel", "Dull Blade"} ;
        //return wpn[garborates.nextInt(wpn.length)];
        return "fucking trash";
    }


    
}

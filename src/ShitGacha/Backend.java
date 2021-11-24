
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
    static float softpity=0.0f;  //resets the softpity to 0f
    
    //This method determines the rates that will be used by Rarity() to determine the rarity of the wish.
    //Starting with the 74/64th pull, an additional 6.25% is deducted until the percentage is equal to or less than 0.
    //char b determines what banner is used to appropriately kickstart the soft pity.
    //Typing char 'r' resets the accumulated soft pity % to 0.
    public static float gachaChance(char b)
    {
        switch (b)
        {
        case 'c':
            //starting with the 74th pull on the character banner, an additional 6.25% is added to the odds.
            if(CbannerStatus.Crolls >= 74){ 
                softpity+=0.0625f;
                return garborates.nextFloat()-softpity; 
            }
            //if it's less than 64 pulls, it returns the odds without manipulation.
                return garborates.nextFloat(); 
        case 'w': 
            //starting with the 64th pull weapon banner, an additional 6.25% is added to the odds.
            if(WbannerStatus.Wrolls >= 64){
                softpity+=0.0625f;
                return garborates.nextFloat()-softpity; 
            }
            //if it's less than 64 pulls, it returns the odds without manipulation.
                return garborates.nextFloat();
        //if r is invoked, soft pity accumulated odds are reset.
        case 'r':
            softpity = 0.0f;
            break;
        }
        return 0.0f;
    }
    //Determines the rarity based-off a float value passed on to it.
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
   
    //character pool
  
    public static String _5_Star__Characters()
    {
        String[] _5character = {"Jean", "Diluc", "Qiqi", "Keqing", "Mona"};
        return _5character[garborates.nextInt(_5character.length)];
    }
    
    public static String _5_Star__Characters(String rateup)
    {
        String[] _5character = {"Jean", "Diluc", "Qiqi", "Keqing", "Mona", rateup};
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
    
    public static String _3_Star__Weapons()
    {
        //String[] wpn = {"Cool Steel", "Dull Blade"} ;
        //return wpn[garborates.nextInt(wpn.length)];
        return "fucking trash";
    }


    
}

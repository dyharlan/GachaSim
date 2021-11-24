
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
    static Random garborates = new Random();
    static float softpity=0;
    public static float Rates(char b)
    {
        switch (b)
        {
        case 'c':
            if(CbannerStatus.Crolls >= 74){
                softpity+=0.0625f;
                return garborates.nextFloat()-softpity; 
            }
                return garborates.nextFloat(); 
        case 'w':
            if(CbannerStatus.Crolls >= 64){
                softpity+=0.0625f;
                return garborates.nextFloat()-softpity; 
            }
                return garborates.nextFloat();
        case 'r':
            softpity = 0;
            break;
        }
        return 0.0f;
    }
    
    public static int Rarity(float x)
    {
        int rarity=0;
        if(x <= 0.006f) //rarity is 5* if the number is less than or equal to 0.6% or 0.006
            rarity = 5;
        else if(x <= 0.051f)// rarity is 4* if the number is less than or equal to 5.1% or 0.051
            rarity = 4;
        else if (x > 0.051f && x <= 1f)
            rarity = 3;
        return rarity;
    }
   
    //character pool
    public static String _5_Star__Characters(String rateup)
    {
        String[] _5character = {"Jean", "Diluc", "Qiqi", "Keqing", "Mona", rateup};
        return _5character[garborates.nextInt(_5character.length)];
    }
    
     public static String _5_Star__Characters()
    {
        String[] _5character = {"Jean", "Diluc", "Qiqi", "Keqing", "Mona"};
        return _5character[garborates.nextInt(_5character.length)];
    }
     
    public static String _4_Star__Characters(String rateup)
    {
        String[] _4character = {"Barbara", "Razor", "Bennett", "Noelle", "Fischl", "Sucrose", 
        "Beidou", "Ningguang", "Xiangling", "Xingqiu", "Chongyun", "Diona", "Xinyan", "Rosaria", 
        "Yanfei", "Sayu", "Sara", rateup};
        return _4character[garborates.nextInt(_4character.length)];
    }
    
    public static String _4_Star__Characters()
    {
        String[] _4character = {"Barbara", "Razor", "Bennett", "Noelle", "Fischl", "Sucrose", 
        "Beidou", "Ningguang", "Xiangling", "Xingqiu", "Chongyun", "Diona", "Xinyan", "Rosaria", 
        "Yanfei", "Sayu", "Sara"};
        return _4character[garborates.nextInt(_4character.length)];
    }
    public static String _3_Star__Weapons()
    {
        //String[] wpn = {"Cool Steel", "Dull Blade"} ;
        //return wpn[garborates.nextInt(wpn.length)];
        return "fucking trash";
    }


    
}

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
public class Backend {
    static Random garborates = new Random();
    public static float Rates()
    {
        return garborates.nextFloat();
    }
    
    public static int Rarity(float x)
    {
        int rarity=0;
        if(x <=0.006f) //rarity is 5* if the number is less than or equal to 0.6% or 0.006
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

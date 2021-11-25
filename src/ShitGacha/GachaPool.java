/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShitGacha;

import java.util.Random;

/**
 * This class contains the Pool that the banners use to determine
 * the character or weapon to give to the user.
 * @author dyhar
 */
public class GachaPool {
    static Random garborates = new Random(); //Declaring a new random class
        //These methods store an array wherein if invoked, will return any character/weapon stored in the array.
    //invoking the x amount of args needed by the method will allow you to insert an x amount of rate up chars or weapons
//=======================================================================================================================//
    //character pool
    public static String _5_Star__Characters()
    {
        String[] _5character = {"Jean", "Diluc", "Qiqi", "Keqing", "Mona"};
        return _5character[garborates.nextInt(_5character.length)]; //returns a random char from the pool
    }
    
    public static String _4_Star__Characters()
    {
        String[] _4character = {"Barbara", "Razor", "Bennett", "Noelle", "Fischl", "Sucrose", 
        "Beidou", "Ningguang", "Xiangling", "Xingqiu", "Chongyun", "Diona", "Xinyan", "Rosaria", 
        "Yanfei", "Sayu", "Sara", };
        return _4character[garborates.nextInt(_4character.length)];
    }
    
    public static String _4_Star__Characters(String rateup1, String rateup2, String rateup3)
    {
        String[] _4character = {"Barbara", "Razor", "Bennett", "Noelle", "Fischl", "Sucrose", 
        "Beidou", "Ningguang", "Xiangling", "Xingqiu", "Chongyun", "Diona", "Xinyan", "Rosaria", 
        "Yanfei", "Sayu", "Sara", "Thoma", rateup1, rateup2, rateup3};
        return _4character[garborates.nextInt(_4character.length)];
    }
    
//=======================================================================================================================//
    //weapon pool
    
    public static String _5_Star__Weapons()
    {
        String[] _5weapon = {"Amos' Bow", "Aquila Favonia", "Lost Prayer to the Sacred Winds", 
            "Primordial Jade Spear", "Skyward Atlas", "Skyward Blade", "Skyward Harp", "Skyward Pride", 
            "Skyward Spine", "Wolf's Gravestone"};
        return _5weapon[garborates.nextInt(_5weapon.length)]; //returns a random weapon from the pool
    }
    
    public static String _5_Star__Weapons(String rateup1, String rateup2)
    {
        String[] _5weapon = {"Amos' Bow", "Aquila Favonia", "Lost Prayer to the Sacred Winds", 
            "Primordial Jade Spear", "Skyward Atlas", "Skyward Blade", "Skyward Harp", "Skyward Pride", 
            "Skyward Spine", "Wolf's Gravestone",rateup1,rateup2};
        return _5weapon[garborates.nextInt(_5weapon.length)];
    }
    
    public static String _4_Star__Weapons()
    {
        String[] _4weapon = {"Dragon's Bane", "Eye of Perception", 
            "Favonius Codex", "Favonius Greatsword", "Favonius Lance", "Favonius Sword", "Favonius Warbow", 
            "Lion's Roar", "Rainslasher", "Rust", "Sacrificial Bow", "Sacrificial Fragments", "Sacrificial Greatsword", "Sacrificial Sword", 
            "The Bell", "The Flute", "The Stringless", "The Widsith"};
        return _4weapon[garborates.nextInt(_4weapon.length)];
    }
    
    public static String _4_Star__Weapons(String rateup1, String rateup2, String rateup3, String rateup4, String rateup5)
    {
        String[] _4weapon = {"Dragon's Bane", "Eye of Perception", 
            "Favonius Codex", "Favonius Greatsword", "Favonius Lance", "Favonius Sword", "Favonius Warbow", 
            "Lion's Roar", "Rainslasher", "Rust", "Sacrificial Bow", "Sacrificial Fragments", "Sacrificial Greatsword", "Sacrificial Sword", 
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

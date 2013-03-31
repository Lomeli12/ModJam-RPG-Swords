package com.lomeli.rpgsword.core;

import java.io.File;

import net.minecraftforge.common.Configuration;

import com.lomeli.rpgsword.lib.RPGInts;

public class ModConfig
{
    /**
     * Registered all the id(s) for all the items and other variables
     */
    @SuppressWarnings("static-access")
    public static void configureIDs(String Loc)
    {
        Configuration config = new Configuration(new File(Loc,
                "RPGSwordID.cfg"));
        
        config.load();
        
        RPGInts.basicSwordID = config.get(config.CATEGORY_ITEM, "starter-sword", 2300).getInt(2300);
        RPGInts.broadSwordID = config.get(config.CATEGORY_ITEM, "broad-sword", 2301).getInt(2301);
        RPGInts.longSwordID = config.get(config.CATEGORY_ITEM, "long-sword", 2302).getInt(2302);
        RPGInts.flameSwordID = config.get(config.CATEGORY_ITEM, "flame-sword", 2303).getInt(2303);
        RPGInts.weakSwordID = config.get(config.CATEGORY_ITEM, "weak-sword", 2304).getInt(2304);
        RPGInts.wingedSwordID = config.get(config.CATEGORY_ITEM, "winged-sword", 2305).getInt(2305);
        
        RPGInts.lightIngotID = config.get(config.CATEGORY_ITEM, "lightIngot", 2320).getInt(2320);
        RPGInts.flameIngotID = config.get(config.CATEGORY_ITEM, "flameIngot", 2321).getInt(2321);
        
        config.save();
    }
}

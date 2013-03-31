package com.lomeli.rpgsword.items;

import com.lomeli.rpgsword.lib.RPGInts;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModItems
{
    public static Item lightIngot;
    public static Item flameIngot;
    /**
     * Registers the item added
     */
    public static void registerItems()
    {
        lightIngot = new ItemRPG(RPGInts.lightIngotID, "ingotlight").setUnlocalizedName("ingotlight");
        flameIngot = new ItemRPG(RPGInts.flameIngotID, "ingotflame").setUnlocalizedName("ingotflame");
        
        LanguageRegistry.addName(lightIngot, "Light Ingot");
        LanguageRegistry.addName(flameIngot, "Flame Ingot");
    }
    /**
     * Registers recipes for basic items
     */
    public static void registerRecipes()
    {
        GameRegistry.addRecipe(new ItemStack(lightIngot, 1), new Object[]
        {
           " G ", "GIG", " G ", 'G',Item.lightStoneDust, 'I',Item.ingotIron 
        });
        GameRegistry.addRecipe(new ItemStack(flameIngot, 1), new Object[]
        {
           " B ", "BGB", " B ", 'B',Item.blazeRod, 'G',Item.ingotGold 
        });
    }
}

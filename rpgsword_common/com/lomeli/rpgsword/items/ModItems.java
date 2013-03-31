package com.lomeli.rpgsword.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.lomeli.rpgsword.items.swords.*;
import com.lomeli.rpgsword.lib.RPGInts;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems
{
    public static Item lightIngot;
    public static Item flameIngot;

    /**
     * Registers the item added
     */
    public static void registerItems()
    {
        lightIngot = new ItemRPG(RPGInts.lightIngotID, "ingotlight")
                .setUnlocalizedName("ingotlight");
        flameIngot = new ItemRPG(RPGInts.flameIngotID, "ingotflame")
                .setUnlocalizedName("ingotflame");

        LanguageRegistry.addName(lightIngot, "Light Ingot");
        LanguageRegistry.addName(flameIngot, "Flame Ingot");
    }

    /**
     * Registers recipes for basic items
     */
    public static void registerRecipes()
    {
        GameRegistry.addRecipe(new ItemStack(lightIngot, 1), new Object[] {
                " G ", "GIG", " G ", 'G', Item.lightStoneDust, 'I',
                Item.ingotIron });
        GameRegistry.addRecipe(new ItemStack(flameIngot, 1), new Object[] {
                " B ", "BGB", " B ", 'B', Item.blazeRod, 'G', Item.ingotGold });
    }

    public static Item basicSword;
    public static Item flameSword;
    public static Item broadSword;

    /**
     * Register swords
     */
    public static void registerSwords()
    {
        basicSword = new ItemRPGSword(RPGInts.basicSwordID, null, "basicsword")
                .setUnlocalizedName("basicsword");
        flameSword = new ItemFlameSword(RPGInts.flameSwordID, "flamesword")
                .setUnlocalizedName("flameSword");
        broadSword = new ItemBroadSword(RPGInts.broadSwordID, null, "broadsword")
                .setUnlocalizedName("broadsword");

        LanguageRegistry.addName(basicSword, "Starter Sword");
        LanguageRegistry.addName(flameSword, "Sword of Flame");
        LanguageRegistry.addName(broadSword, "Broad Sword");
    }

    public static void registerSwordRecipes()
    {
        GameRegistry.addRecipe(new ItemStack(basicSword, 1), new Object[] 
        {
            "  I", "LSL", "S  ", 'I',Item.ingotIron, 'S',Item.stick, 'L',new ItemStack(Item.dyePowder, 1, 4)
        });
        GameRegistry.addRecipe(new ItemStack(flameSword, 1), new Object[]
        {
            "FLF","FSF", " L ", 'L',lightIngot, 'F',flameIngot, 'S',Item.swordSteel
        });
        GameRegistry.addRecipe(new ItemStack(broadSword, 1), new Object[]
        {
           "ILI","ILI","LSL", 'I',Item.ingotIron, 'S',Item.stick, 'L',lightIngot
        });
        
    }
}

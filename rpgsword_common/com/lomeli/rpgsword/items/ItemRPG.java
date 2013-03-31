package com.lomeli.rpgsword.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.lomeli.rpgsword.lib.RPGStrings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRPG extends Item
{
    private String itemTexture;

    public ItemRPG(int par1, String texture)
    {
        super(par1);
        itemTexture = texture;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister iconRegister)
    {
        iconIndex = iconRegister.registerIcon(RPGStrings.modID.toLowerCase()
                + ":" + itemTexture);
    }
}

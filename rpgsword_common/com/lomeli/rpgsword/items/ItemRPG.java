package com.lomeli.rpgsword.items;

import com.lomeli.rpgsword.lib.RPGStrings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemRPG extends Item
{
    private String itemTexture;
    
    public ItemRPG(int par1, String texture)
    {
        super(par1);
        this.itemTexture = texture;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister iconRegister)
    {
        this.iconIndex = iconRegister.registerIcon(RPGStrings.modID.toLowerCase() + ":" + this.itemTexture);
    }
}

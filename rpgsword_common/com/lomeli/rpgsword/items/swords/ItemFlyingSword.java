package com.lomeli.rpgsword.items.swords;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemFlyingSword extends ItemRPGSword
{
    public ItemFlyingSword(int par1, EnumToolMaterial material, String texture)
    {
        super(par1, material, texture);
    }
    
    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity,
            int par4, boolean par5)
    {
        level = getLevel(itemStack);
        if (entity != null)
        {
            if (entity instanceof EntityPlayer)
            {
                EntityPlayer player = (EntityPlayer) entity;
                if(player.capabilities.isCreativeMode == false)
                {
                    if(player.inventory.hasItemStack(itemStack))
                    {
                        if (player.inventory.getCurrentItem() == itemStack)
                        {
                            if(getLevel(itemStack) >= 5)
                                player.addPotionEffect(new PotionEffect(5, -1, ((getLevel(itemStack) / 5)-1)));
                            else{}
                            if (player.inventory.getCurrentItem().getItemDamage() == 0 && getLevel(itemStack) < 25)
                            {  
                                itemStack.setItemDamage(itemStack.getMaxDamage() - 1);
                                setLevel(itemStack, 1);
                            }
                        
                        }
                    }
                }
            }
        }
    }
}

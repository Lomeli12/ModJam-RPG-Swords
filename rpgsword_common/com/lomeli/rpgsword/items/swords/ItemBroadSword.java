package com.lomeli.rpgsword.items.swords;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemBroadSword extends ItemRPGSword
{
    public ItemBroadSword(int par1, EnumToolMaterial material, String texture)
    {
        super(par1, EnumToolMaterial.STONE, texture);
    }
    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLiving entityLiving,
            EntityLiving player)
    {
        if (entityLiving != null)
        {
            if (getLevel(itemStack) >= 0)
            {
                itemStack.setItemDamage(itemStack.getItemDamage()
                        - entityLiving.getMaxHealth() / (getLevel(itemStack)+2));
            }
            else
            {
                itemStack.setItemDamage(itemStack.getItemDamage()
                            - entityLiving.getMaxHealth());
            }
            if (itemStack.getItemDamage() == 0 && getLevel(itemStack) < 25)
            {
                itemStack.setItemDamage(itemStack.getMaxDamage() - 1);
                setLevel(itemStack, 1);
            } else{}
        } else
        {
        }
        return true;
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
                if(player.inventory.hasItemStack(itemStack))
                {
                    if (player.inventory.getCurrentItem() == itemStack)
                    {
                        if(getLevel(itemStack) >= 5)
                            player.addPotionEffect(new PotionEffect(5, -1, ((getLevel(itemStack)*2))));
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

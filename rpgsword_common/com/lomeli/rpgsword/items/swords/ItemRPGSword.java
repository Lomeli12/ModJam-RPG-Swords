package com.lomeli.rpgsword.items.swords;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.lomeli.rpgsword.core.helper.NBTHelper;
import com.lomeli.rpgsword.lib.RPGStrings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRPGSword extends ItemSword
{
    private String itemTexture;
    public int level;

    public ItemRPGSword(int par1, String texture)
    {
        super(par1, EnumToolMaterial.WOOD);
        itemTexture = texture;
        this.setMaxDamage(1000);
        level = 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister iconRegister)
    {
        iconIndex = iconRegister.registerIcon(RPGStrings.modID.toLowerCase()
                + ":" + itemTexture);
    }

    @Override
    public void onCreated(ItemStack itemStack, World world,
            EntityPlayer entityPlayer)
    {
        itemStack.damageItem(itemStack.getMaxDamage() - 1, entityPlayer);
        setLevel(itemStack, 0);
        level = getLevel(itemStack);
    }

    private int getLevel(ItemStack itemStack)
    {
        return NBTHelper.getInt(itemStack, "Level");
    }

    private void setLevel(ItemStack itemStack, int plus)
    {
        NBTHelper.setInteger(itemStack, "Level", level + plus);
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLiving entityLiving,
            EntityLiving player)
    {
        if (entityLiving != null)
        {
            if (entityLiving.getHealth() <= 0)
            {
                if (level > 1)
                {
                    itemStack.setItemDamage(itemStack.getItemDamage()
                            - entityLiving.getMaxHealth() / level);
                    
                } else
                {
                    itemStack.setItemDamage(itemStack.getItemDamage()
                            - entityLiving.getMaxHealth() / level);
                }
            } else if (itemStack.getItemDamage() == 0 && this.level < 25)
            {
                itemStack.setItemDamage(itemStack.getMaxDamage() - 1);
                setLevel(itemStack, 1);
            } else
            {
            }
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
                if (player.inventory.currentItem == this.itemID)
                {
                    if (player.inventory.getCurrentItem().getItemDamage() == 0 && this.level < 25)
                    {
                        itemStack.setItemDamage(itemStack.getMaxDamage() - 1);
                        setLevel(itemStack, 1);
                    }
                    player.addPotionEffect(new PotionEffect(5, -1, (this.level / 3)));
                }
            }
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player,
            List infoList, boolean bool)
    {
        int max = itemStack.getMaxDamage() - 1;
        infoList.add("Level " + getLevel(itemStack) + " EXP: "
                + (max - itemStack.getItemDamage()) + "/" + max);
    }
}

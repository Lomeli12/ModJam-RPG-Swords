package com.lomeli.rpgsword.items.swords;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemFlameSword extends ItemRPGSword
{
    public ItemFlameSword(int par1, String texture)
    {
        super(par1, EnumToolMaterial.IRON, texture);
    }
    
    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLiving entityLiving,
            EntityLiving player)
    {
        if (entityLiving != null)
        {
            entityLiving.setFire(2);
            if (getLevel(itemStack) >= 10)
            {
                itemStack.setItemDamage(itemStack.getItemDamage()
                        - entityLiving.getMaxHealth() / (getLevel(itemStack)/2));
            }
            else
            {
                itemStack.setItemDamage(itemStack.getItemDamage()
                            - entityLiving.getMaxHealth());
            }
            if (itemStack.getItemDamage() == 0 && getLevel(itemStack) < 40)
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
                        if (player.inventory.getCurrentItem().getItemDamage() == 0 && getLevel(itemStack) < 40)
                        {  
                            itemStack.setItemDamage(itemStack.getMaxDamage() - 1);
                            setLevel(itemStack, 1);
                        }
                        
                    }
                }
            }
        }
    }
    
    public static void fireGhastBall(World world, EntityPlayer player, int ballStrenght)
    {
        Vec3 look = player.getLookVec();
        EntityLargeFireball entitylargefireball = new EntityLargeFireball(world, player, 0, 0, 0);
        entitylargefireball.field_92057_e = ballStrenght;
        entitylargefireball.setPosition(player.posX + look.xCoord *2, player.posY + look.yCoord + 1, player.posZ + look.zCoord * 2);
        entitylargefireball.accelerationX = look.xCoord * 0.3;
        entitylargefireball.accelerationY = look.yCoord * 0.3;
        entitylargefireball.accelerationZ = look.zCoord * 0.3;
        world.spawnEntityInWorld(entitylargefireball);
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        level = getLevel(itemStack);
        if(player != null)
        {
            if(level >= 1)
            {
                float teep = itemRand.nextFloat();
                world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (teep * 0.4F + 0.8F));
                if (!world.isRemote)
                {
                    Vec3 look = player.getLookVec();
                    EntitySmallFireball fireball = new EntitySmallFireball(world, player, 0, 0, 0);
                    fireball.setPosition(player.posX + look.xCoord * 2, player.posY + look.yCoord + 1, player.posZ + look.zCoord * 2);
                    fireball.accelerationX = look.xCoord * 0.1;
                    fireball.accelerationY = look.yCoord * 0.1;
                    fireball.accelerationZ = look.zCoord * 0.1;
                    world.spawnEntityInWorld(fireball);
                    setLevel(itemStack, -1);
                }
            }else if(level >= 10)
            {
                if(!world.isRemote)
                {
                    if(level >= 20)
                    {
                        fireGhastBall(world, player, 3);
                    }
                    else
                    {
                        fireGhastBall(world, player, 1);
                    }
                    setLevel(itemStack, -1);
                }
            }else{}
        }
        return itemStack;
    }

}

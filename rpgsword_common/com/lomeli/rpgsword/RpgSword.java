package com.lomeli.rpgsword;

import com.lomeli.rpgsword.core.proxy.CommonProxy;
import com.lomeli.rpgsword.lib.*;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;


@Mod(modid = RPGStrings.modID, name = RPGStrings.modName, version = RPGStrings.version)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class RpgSword
{
    @SidedProxy(clientSide =RPGStrings.clientProxy, serverSide = RPGStrings.commonProxy)
    public static CommonProxy proxy;
    
    @Instance(RPGStrings.modID)
    public static RpgSword instance;
    
    public static String configDir;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event)
    {
        configDir = event.getModConfigurationDirectory() + "\\RPGSwords\\";
    }
    @Init
    public void main(FMLInitializationEvent event)
    {
    }
    @PostInit
    public void postLoad(FMLPostInitializationEvent event)
    {
    }
}

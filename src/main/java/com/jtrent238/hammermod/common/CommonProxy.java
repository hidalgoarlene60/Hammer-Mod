package com.jtrent238.hammermod.common;

import com.jtrent238.hammermod.HammerMod;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class CommonProxy {
	
	
	private static final String modid = HammerMod.MODID;
	private String owner;

	public void init(FMLInitializationEvent e) {
	    
		}
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
	    
	}

	
}

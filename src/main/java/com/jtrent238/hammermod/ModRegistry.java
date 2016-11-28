package com.jtrent238.hammermod;

import java.util.logging.Level;

import com.jtrent238.hammermod.lib.LogHelper;

import cpw.mods.fml.common.Loader;

public class ModRegistry {

	private static boolean isepicproportionsmodLoaded;

	public ModRegistry(){
		
		
	
	registerMods();
	
}

	static void registerMods() {
		
		
		isepicproportionsmodLoaded = Loader.isModLoaded("epicproportionsmod");
		
		if (isepicproportionsmodLoaded) {
			
			System.out.println("EpicProportions Mod Loaded");
			try {
	            LogHelper.log(Level.INFO, "Loaded EpicProportions Mod");
	        }
	        catch (Exception e) {
	            LogHelper.log(Level.SEVERE, "Could not load EpicProportions Mod");
	            e.printStackTrace(System.err);
	        }
	    
			}
		
	}
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.antanicraft.advancedbrewery;

import java.util.logging.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 *
 * @author admiral0
 */
@Mod(name = "Advanced Brewery",version = "0.1",useMetadata = false,modid = "AdvancedBrewery",dependencies = "required-after:Forge@[7.7.2.682,)")
public class AdvancedBrewery {
    @Instance("AdvancedBrewery")
    public static AdvancedBrewery instance;
   
    @PreInit
    public void preInit(FMLPreInitializationEvent evt){
        Logger logger= Logger.getLogger("AdvancedBrewery");
        logger.setParent(FMLLog.getLogger());
        logger.info("Hello World!");
    }
}

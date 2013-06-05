package it.antanicraft.advancedbrewery;

import java.util.logging.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.SidedProxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import it.antanicraft.advancedbrewery.proxy.CommonProxy;

/**
 *
 * @author admiral0, Andreabont
 */
@Mod(name = "Advanced Brewery", version = "0.1", useMetadata = false, modid = "AdvancedBrewery", dependencies = "required-after:Forge@[7.7.2.682,)")
public class AdvancedBrewery {

    @Instance("AdvancedBrewery")
    public static AdvancedBrewery instance;
    
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide = "it.antanicraft.advancedbrewery.proxy.ClientProxy", serverSide = "it.antanicraft.advancedbrewery.proxy.CommonProxy")
    public static CommonProxy proxy;

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        Logger logger = Logger.getLogger("AdvancedBrewery");
        logger.setParent(FMLLog.getLogger());
        logger.info("Hello World!");
    }

    @Init
    public void load(FMLInitializationEvent event) {

        ItemStack dirtStack = new ItemStack(Block.cobblestone);
        ItemStack diamondsStack = new ItemStack(Item.diamond, 64);

        GameRegistry.addShapelessRecipe(diamondsStack, dirtStack);

    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        // Stub Method
    }
    
}

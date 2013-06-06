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

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

/**
 *
 * @author admiral0, Andreabont
 */
@Mod(
    name = "Advanced Brewery",
    version = "0.1",
    useMetadata = false,
    modid = "AdvancedBrewery",
    dependencies = "required-after:Forge@[7.7.2.682,)"
)
public class AdvancedBrewery {

    @Instance("AdvancedBrewery")
    public static AdvancedBrewery instance;

    private static Logger logger= Logger.getLogger("AdvancedBrewery");

    public static Block concentrator;

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        logger.setParent(FMLLog.getLogger());
        logger.info("Hello World!" );
    }

    @Init
    public void load(FMLInitializationEvent event) {
        logger.info("Registering Concentrator");
        concentrator=new Concentrator(666, Material.iron);
        concentrator.setUnlocalizedName("concentrator");
        concentrator.setCreativeTab(CreativeTabs.tabBrewing);
        LanguageRegistry.addName(concentrator,"Concentrator");
        MinecraftForge.setBlockHarvestLevel(concentrator,"pickaxe",2);
        GameRegistry.registerBlock(concentrator,"concentrator");

    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        // Stub Method
    }
    
}

package it.antanicraft.advancedbrewery;

import java.util.logging.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 *
 * @author admiral0, Andreabont
 */
@Mod(
    name = "Advanced Brewery",
    version = "0.1",
    useMetadata = false,
    modid = "AdvancedBrewery",
    dependencies = "required-after:Forge@[7.7.2.684,)"
)
@NetworkMod(
        clientSideRequired = true,
        serverSideRequired = true
)
public class AdvancedBrewery {

    @Instance("AdvancedBrewery")
    public static AdvancedBrewery instance;
    private static Logger logger;


    @SidedProxy(
            clientSide = "it.antanicraft.advancedbrewery.client.ClientProxy",
            serverSide = "it.antanicraft.advancedbrewery.CommonProxy"
    )
    public static CommonProxy proxy;

    public static Block concentrator;
    public static Item suicidepill;

    public static RecipeItem obsidianshard,obsidianingot;
    public static EnumArmorMaterial OBSIDIANARMOR;
    public static Item obsidianHelmet;
    public static Item obsidianChestplate;
    public static Item obsidianLeggings;
    public static Item obsidianBoots;


    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        logger = Logger.getLogger("AdvancedBrewery");
        logger.setParent(FMLLog.getLogger());
        logger.info("May the Forge be with you!" );
    }

    @Init
    public void load(FMLInitializationEvent event) {
        setItems();
        setBlocks();
        setCraftingRecipes();
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        // Stub Method
    }

    private void setItems() {
        logger.info("Registering Suicide Pill");
        suicidepill = new SuicidePill(5000);
        suicidepill.setCreativeTab(CreativeTabs.tabBrewing);
        LanguageRegistry.addName(suicidepill, "Suicide Pill");

        obsidianshard=new ObsidianShard(3990);
        obsidianingot=new ObsidianIngot(3991);
        LanguageRegistry.addName(obsidianshard, "Obsidian Shard");
        LanguageRegistry.addName(obsidianingot, "Obsidian Ingot");


        OBSIDIANARMOR = EnumHelper.addArmorMaterial("OBSIDIAN", 45, new int[]{12,20 ,17, 12}, 10);
        obsidianHelmet = new ItemArmor(1195, OBSIDIANARMOR,3,0).setUnlocalizedName("helmetObsidian");
        obsidianChestplate = new ItemArmor(1196, OBSIDIANARMOR,3,1).setUnlocalizedName("chestObsidian");
        obsidianLeggings = new ItemArmor(1197, OBSIDIANARMOR,3,2).setUnlocalizedName("legginssObsidian");
        obsidianBoots = new ItemArmor(1198, OBSIDIANARMOR,3,3).setUnlocalizedName("bootsObsidian");
        LanguageRegistry.addName(obsidianHelmet, "Obsidian Helmet");
        LanguageRegistry.addName(obsidianChestplate, "Obsidian Chestplate");
        LanguageRegistry.addName(obsidianLeggings, "Obsidian Leggins");
        LanguageRegistry.addName(obsidianBoots, "Obsidian Boots");

    }

    private void setBlocks() {
        logger.info("Registering Concentrator");
        concentrator=new Concentrator(666, Material.iron);
        concentrator.setUnlocalizedName("concentrator");
        concentrator.setCreativeTab(CreativeTabs.tabBrewing);
        LanguageRegistry.addName(concentrator, "Concentrator");
        MinecraftForge.setBlockHarvestLevel(concentrator,"pickaxe",2);
        GameRegistry.registerBlock(concentrator, "concentrator");
    }

    private void setCraftingRecipes() {
        // TEST
        ItemStack dirtStack = new ItemStack(Block.dirt);
        ItemStack sPillStack = new ItemStack(suicidepill);
        GameRegistry.addShapelessRecipe(sPillStack, dirtStack);



       ItemStack obshardStack=new ItemStack(obsidianshard);
       ItemStack obingotStack= new ItemStack(obsidianingot);
       GameRegistry.addShapedRecipe(obingotStack,"xxx","xxx"," y ", 'x',obshardStack,'y', new ItemStack(Item.bucketLava));





    }
    
}

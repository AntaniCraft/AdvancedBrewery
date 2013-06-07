package it.antanicraft.advancedbrewery;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created with IntelliJ IDEA.
 * User: Tony61989
 * Date: 06/06/13
 * Time: 19.57
 * To change this template use File | Settings | File Templates.
 */

/** Simple  class to handle better Items that are just used for recipes and nothing else
 *
 */
public abstract class RecipeItem extends Item {


    /**Basic constructor, Items instantiated will stack up to 64 for slot and will be available in Miscellaneous Creative Tab
     *
     * @param id  initial ID used for the Item (before internal-shifting)
     */
    public RecipeItem(int id, String name) {
        super(id);
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName(name);
    }

    /** More detailed constructor
     *
     * @param id  initial ID used for istantiation of the Item
     * @param maxStackSize set the max number of occurrences of Item for slot
     * @param tab specifies which Creative mode tab will contain the Item
     * @param name specifies internal name for the Item.
     */
    public RecipeItem(int id, int maxStackSize, CreativeTabs tab, String name)   {
        super(id);
        setMaxStackSize(maxStackSize);
        setCreativeTab(tab);
        setUnlocalizedName(name);

    }





}

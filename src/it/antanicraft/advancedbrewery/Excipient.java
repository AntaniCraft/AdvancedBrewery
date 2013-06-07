package it.antanicraft.advancedbrewery;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created with IntelliJ IDEA.
 * User: andreabont
 * Date: 06/06/13
 * Time: 13.27
 * To change this template use File | Settings | File Templates.
 */

public class Excipient extends RecipeItem {

    public Excipient(int id) {
        super(id, "Excipient");

        // Constructor Configuration
        maxStackSize = 64;
        setCreativeTab(CreativeTabs.tabBrewing);
    }

    public Excipient(int id, int maxStackSize, CreativeTabs tab,
                     int texture, String name) {
        super(id, "Excipient");
        setMaxStackSize(maxStackSize);
        setCreativeTab(tab);
    }

    public void registerIcons(IconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon("AdvancedBrewery:Excipient");
    }

}

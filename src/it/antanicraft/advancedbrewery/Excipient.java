package it.antanicraft.advancedbrewery;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created with IntelliJ IDEA.
 * User: andreabont
 * Date: 06/06/13
 * Time: 13.27
 * To change this template use File | Settings | File Templates.
 */

public class Excipient extends Item {

    public Excipient(int id) {
        super(id);

        // Constructor Configuration
        maxStackSize = 64;
        setCreativeTab(CreativeTabs.tabBrewing);
    }

    public Excipient(int id, int maxStackSize, CreativeTabs tab,
                     int texture, String name) {
        super(id);
        setMaxStackSize(maxStackSize);
        setCreativeTab(tab);
    }
}

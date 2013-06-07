package it.antanicraft.advancedbrewery;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Concentrator extends Block {
    public Concentrator(int itemId, Material material){
        super(itemId, material);
    }

    public String getTextureFile () {
        return CommonProxy.BLOCK_PNG;
    }
}

package armory.blocks;

import armory.lib.ArmoryOreRef;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockArmoryOre extends ItemBlock
{
	public ItemBlockArmoryOre(Block block)
	{
		super(block);
		setHasSubtypes(true);
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemstack)
	{
		return ArmoryOreRef.oreTypes[itemstack.getItemDamage()] + " Ore";
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}

}

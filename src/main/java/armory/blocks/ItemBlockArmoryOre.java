package armory.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import armory.lib.ArmoryNames;

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
		return ArmoryNames.Items.ORE_TYPES[itemstack.getItemDamage()] + " Ore";
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}
}

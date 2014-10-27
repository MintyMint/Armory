package armory.core;

import net.minecraft.item.Item;

public class SmithingFurnaceRecipes
{
	public static class Iron
	{
		//public static final ItemStack[] input = {new ItemStack(ItemHelper.oreIngots, 1, 0), };
	
		public static final Item[] output = {ItemHelper.smithingHammer};
	}

	public static class FurnaceRecipes
	{
		public static final Item[] input = {ItemHelper.smithingHammer_broken};
	
		public static final Item[] output = {ItemHelper.smithingHammer};
	}
}

package armory.core;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class CraftingHelper
{
	public static void init()
	{
		registerRecipes();
	}

	private static void registerRecipes()
	{
		GameRegistry.addSmelting(new ItemStack(BlockHelper.armoryOre, 1, 0) , new ItemStack(ItemHelper.obsidiumOre), 1f);
		GameRegistry.addSmelting(new ItemStack(BlockHelper.armoryOre, 1, 1) , new ItemStack(ItemHelper.azuriteOre), 1f);
		GameRegistry.addSmelting(new ItemStack(BlockHelper.armoryOre, 1, 2) , new ItemStack(ItemHelper.crimsoniteOre), 1f);
		GameRegistry.addSmelting(new ItemStack(BlockHelper.armoryOre, 1, 3) , new ItemStack(ItemHelper.titaniumOre), 1f);
		
		//GameRegistry.addShapelessRecipe(output, params);
	}
}

package armory.core;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class CraftingHelper
{
	public static void init()
	{
		registerOreDictionary();
		registerRecipes();
	}

	private static void registerOreDictionary()
	{
		OreDictionary.registerOre("ingotIron", Items.iron_ingot);
	}
	
	private static void registerRecipes()
	{
		GameRegistry.addSmelting(new ItemStack(BlockHelper.armoryOre, 1, 0) , new ItemStack(ItemHelper.oreChunks, 1, 0), 1f);
		GameRegistry.addSmelting(new ItemStack(BlockHelper.armoryOre, 1, 1) , new ItemStack(ItemHelper.oreChunks, 1, 1), 1f);
		GameRegistry.addSmelting(new ItemStack(BlockHelper.armoryOre, 1, 2) , new ItemStack(ItemHelper.oreChunks, 1, 2), 1f);
		GameRegistry.addSmelting(new ItemStack(BlockHelper.armoryOre, 1, 3) , new ItemStack(ItemHelper.oreChunks, 1, 3), 1f);
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(ItemHelper.smithingHammer, ItemHelper.smithingHammer_broken, "ingotIron", "ingotIron"));
	}
	

}

package armory.core;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import armory.lib.ArmoryNames;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingHelper
{
	public static void init()
	{
		registerVanillaOreDictionary();
		registerRecipes();
		registerPartPlannerRecipes();
	}

	private static void registerVanillaOreDictionary()
	{
		OreDictionary.registerOre("ingotIron", Items.iron_ingot);
	}
	
	private static void registerRecipes()
	{
        for (int meta = 0; meta < ArmoryNames.Items.ORE_TYPES.length; meta++)
        {
        	GameRegistry.addSmelting(new ItemStack(BlockHelper.armoryOre, 1, meta) , new ItemStack(ItemHelper.oreChunks, 1, meta), 1f);
        	GameRegistry.addSmelting(new ItemStack(ItemHelper.oreChunks, 1, meta) , new ItemStack(ItemHelper.oreIngots, 1, meta), 1f);
        }
		
		//GameRegistry.addRecipe(new ShapedOreRecipe(ItemHelper.smithingHammer, ItemHelper.smithingHammer_broken, "ingotIron", "ingotIron"));
	}
	
	private static void registerPartPlannerRecipes()
	{
    	PartPlannerCraftingHandler.addRecipe(new ItemStack(ItemHelper.smithingHammer, 1), new Object[] {"iii",
    																			  						"iii",
    																			  						" s ",
    																			  						" s ",
    																			  						" s ", 'i', Items.iron_ingot, 's', Items.stick});
	}
}

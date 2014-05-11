package armory.core;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import armory.items.ArmoryItems;
import armory.items.ArmoryOreChunks;
import armory.items.ArmoryOreIngots;
import armory.items.SmithingHammer;
import armory.items.SmithingHammerBroken;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemHelper
{
	public static Item oreChunks;
	;
	public static Item oreIngots;
	
	public static Item smithingHammer;
	public static Item smithingHammer_broken;
	
	public static void init()
	{
		oreChunks = new ArmoryOreChunks();
		
		oreIngots = new ArmoryOreIngots();
		
		smithingHammer = new SmithingHammer();
		smithingHammer_broken = new SmithingHammerBroken();
		
	}
	
	public static void registerOreDictionary()
	{
		OreDictionary.registerOre("oreObsidium", new ItemStack(oreChunks, 1, 0));
		//OreDictionary.registerOre("ingotObsidium", obsidiumIngot);
		
		//OreDictionary.registerOre("oreAzurite", azuriteOre);
		//OreDictionary.registerOre("ingotTitanium", azuriteIngot);
		
		//OreDictionary.registerOre("oreCrimsonite", crimsoniteOre);
		//OreDictionary.registerOre("ingotTitanium", crimsoniteIngot);
		
		//OreDictionary.registerOre("oreTitanium", titaniumOre);
		//OreDictionary.registerOre("ingotTitanium", titaniumIngot);
	}

	public static void registerItems(ArmoryItems item)
	{
		GameRegistry.registerItem(item, item.getUnwrappedUnlocalizedName(item.getUnlocalizedName()));
	}
	
}

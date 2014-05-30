package armory.core;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import armory.items.ArmoryItems;
import armory.items.ArmoryOreChunks;
import armory.items.ArmoryOreIngots;
import armory.items.CrudeWeaponParts;
import armory.items.HeatedWeaponParts;
import armory.items.SmithingHammer;
import armory.items.SmithingHammerBroken;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemHelper
{
	private static final Item HeatedWeaponParts = null;
	public static Item oreChunks;	
	public static Item oreIngots;
	
	public static Item crudeWeaponParts;
	public static Item heatedWeaponParts;
	
	public static Item smithingHammer;
	public static Item smithingHammer_broken;
	
	public static void init()
	{
		oreChunks = new ArmoryOreChunks();
		oreIngots = new ArmoryOreIngots();
		
		crudeWeaponParts = new CrudeWeaponParts();
		heatedWeaponParts = new HeatedWeaponParts();
		
		smithingHammer = new SmithingHammer();
		smithingHammer_broken = new SmithingHammerBroken();
		
	}
	
	public static void registerOreDictionary()
	{
		OreDictionary.registerOre("oreObsidium", new ItemStack(oreChunks, 1, 0));
		OreDictionary.registerOre("ingotObsidium",  new ItemStack(oreIngots, 1, 0));
		
		OreDictionary.registerOre("oreAzurite", new ItemStack(oreChunks, 1, 1));
		OreDictionary.registerOre("ingotTitanium", new ItemStack(oreIngots, 1, 1));
		
		OreDictionary.registerOre("oreCrimsonite", new ItemStack(oreChunks, 1, 2));
		OreDictionary.registerOre("ingotTitanium", new ItemStack(oreIngots, 1, 2));
		
		OreDictionary.registerOre("oreTitanium", new ItemStack(oreChunks, 1, 3));
		OreDictionary.registerOre("ingotTitanium", new ItemStack(oreIngots, 1, 3));
	}

	public static void registerItems(ArmoryItems item)
	{
		GameRegistry.registerItem(item, item.getUnwrappedUnlocalizedName(item.getUnlocalizedName()));
	}
	
}

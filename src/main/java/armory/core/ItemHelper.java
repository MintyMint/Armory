package armory.core;

import armory.items.ArmoryItems;
import armory.items.AzuriteOre;
import armory.items.CrimsoniteOre;
import armory.items.ObsidiumOre;
import armory.items.TitaniumOre;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemHelper
{
	public static Item obsidiumOre;
	public static Item obsidiumIngot;
	
	public static Item azuriteOre;
	public static Item azuriteIngot;
	
	public static Item crimsoniteOre;
	public static Item crimsoniteIngot;
	
	public static Item titaniumOre;
	public static Item titaniumIngot;
	
	public static void init()
	{
		obsidiumOre = new ObsidiumOre();
		azuriteOre = new AzuriteOre();
		crimsoniteOre = new CrimsoniteOre();
		titaniumOre = new TitaniumOre();
		
	}
	
	public static void registerOreDictionary()
	{
		OreDictionary.registerOre("oreObsidium", obsidiumOre);
		OreDictionary.registerOre("ingotObsidium", obsidiumIngot);
		
		OreDictionary.registerOre("oreAzurite", azuriteOre);
		OreDictionary.registerOre("ingotTitanium", azuriteIngot);
		
		OreDictionary.registerOre("oreCrimsonite", crimsoniteOre);
		OreDictionary.registerOre("ingotTitanium", crimsoniteIngot);
		
		OreDictionary.registerOre("oreTitanium", titaniumOre);
		OreDictionary.registerOre("ingotTitanium", titaniumIngot);
	}

	public static void registerItems(ArmoryItems item)
	{
		GameRegistry.registerItem(item, item.getUnwrappedUnlocalizedName(item.getUnlocalizedName()));
	}
}

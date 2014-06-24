package armory.core;

import cpw.mods.fml.common.registry.GameRegistry;
import armory.blocks.ArmoryBlocks;
import armory.blocks.ArmoryOre;
import armory.blocks.PartPlanner;
import armory.blocks.SmithingAnvil;
import armory.blocks.SmithingFurnace;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class BlockHelper
{
	public static Block armoryOre;
	
	public static Block armoryStorageBlock;
	
	public static Block smithingAnvil;
	
	public static Block smithingFurnace;
	
	public static Block partPlanner;
	
	
	public static void init()
	{
		armoryOre = new ArmoryOre();
		
		smithingAnvil = new SmithingAnvil();
		
		smithingFurnace = new SmithingFurnace();
		
		partPlanner = new PartPlanner();
	}
	
	public static void registerBlocks(ArmoryBlocks block)
	{
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
	}
	
	public static void registerBlocksWithMetadata(ArmoryBlocks block, Class<? extends ItemBlock> itemBlockClass, String name)
	{
		GameRegistry.registerBlock(block, itemBlockClass, name);
	}
}

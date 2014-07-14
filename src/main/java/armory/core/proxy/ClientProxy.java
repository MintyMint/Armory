package armory.core.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import armory.core.BlockHelper;
import armory.core.render.ItemSmithingFurnaceRenderer;
import armory.core.render.RenderOreBlock;
import armory.core.render.RenderPartPlanner;
import armory.core.render.RenderSmithingFurnace;
import armory.tile_entity.PartPlannerDummyTE;
import armory.tile_entity.smithing_furnace.TileSmithingFurnace;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	public static int oreBlockRenderID;
	public static int smithingFurnaceRenderID;
	public static int partPlannerRenderID;
    
	@Override
    public void registerRendering()
    {
		oreBlockRenderID = RenderingRegistry.getNextAvailableRenderId();
		smithingFurnaceRenderID = RenderingRegistry.getNextAvailableRenderId();
		partPlannerRenderID = RenderingRegistry.getNextAvailableRenderId();
		
		RenderingRegistry.registerBlockHandler(oreBlockRenderID, new RenderOreBlock());

		ClientRegistry.bindTileEntitySpecialRenderer(TileSmithingFurnace.class, new RenderSmithingFurnace());		
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockHelper.smithingFurnace), new ItemSmithingFurnaceRenderer());
		
		ClientRegistry.bindTileEntitySpecialRenderer(PartPlannerDummyTE.class, new RenderPartPlanner());
    }
}

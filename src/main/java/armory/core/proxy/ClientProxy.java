package armory.core.proxy;

import armory.core.render.RenderOreBlock;
import armory.core.render.RenderSmithingFurnace;
import armory.tile_entity.smithing_furnace.TileSmithingFurnace;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	public static int OreBlockRenderID;
    
	@Override
    public void registerRendering()
    {
		OreBlockRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(OreBlockRenderID, new RenderOreBlock());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileSmithingFurnace.class, new RenderSmithingFurnace());
    }
}

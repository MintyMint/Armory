package armory.core.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import armory.tile_entity.ArmoryTE;
import armory.tile_entity.smithing_anvil.TileSmithingAnvil;
import armory.tile_entity.smithing_furnace.TileSmithingFurnace;

public class CommonProxy
{
	public void registerRendering(){}

	public void registerSoundHandler(){}
	
    public void registerTileEntities()
    {
    	GameRegistry.registerTileEntity(ArmoryTE.class, "ArmoryTE");
    	
    	GameRegistry.registerTileEntity(TileSmithingAnvil.class, "TileSmithingAnvil");
    	GameRegistry.registerTileEntity(TileSmithingFurnace.class, "TileSmithingFurnace");
    }
}

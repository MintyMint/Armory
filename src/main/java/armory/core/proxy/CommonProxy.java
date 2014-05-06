package armory.core.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import armory.tile_entity.ArmoryTE;
import armory.tile_entity.TileSmithingAnvil;
import armory.tile_entity.TileSmithingFurnace;

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

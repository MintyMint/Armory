package armory.core.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import armory.tile_entity.ArmoryTE;
import armory.tile_entity.PartPlannerDummyTE;
import armory.tile_entity.smithing_anvil.TileSmithingAnvil;
import armory.tile_entity.smithing_furnace.TileSmithingFurnace;

public abstract class CommonProxy implements IProxy
{	
	public void registerTileEntities()
    {
    	GameRegistry.registerTileEntity(ArmoryTE.class, "ArmoryTE");
    	
    	GameRegistry.registerTileEntity(TileSmithingAnvil.class, "TileSmithingAnvil");
    	GameRegistry.registerTileEntity(TileSmithingFurnace.class, "TileSmithingFurnace");
    	GameRegistry.registerTileEntity(PartPlannerDummyTE.class, "PartPlannerDummyTE");
    }
}

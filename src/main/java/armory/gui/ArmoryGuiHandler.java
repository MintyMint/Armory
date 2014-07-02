package armory.gui;

import armory.lib.ArmoryRef;
import armory.tile_entity.part_planner.ContainerPartPlanner;
import armory.tile_entity.part_planner.GuiPartPlanner;
import armory.tile_entity.smithing_anvil.ContainerSmithingAnvil;
import armory.tile_entity.smithing_anvil.GuiSmithingAnvil;
import armory.tile_entity.smithing_anvil.TileSmithingAnvil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class ArmoryGuiHandler implements IGuiHandler
{
	public ArmoryGuiHandler(){}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
        if(ID == ArmoryRef.SMITHING_FURNACE_GUI_ID)
        { 
            TileSmithingAnvil tileSmithingAnvil = (TileSmithingAnvil) world.getTileEntity(x, y, z);
            return new ContainerSmithingAnvil(player.inventory, tileSmithingAnvil);
        }
        
        if (ID == ArmoryRef.PART_PLANNER_GUI_ID)
        {
        	return new ContainerPartPlanner(player.inventory, world, x, y, z);
        }
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
        if(ID == ArmoryRef.SMITHING_FURNACE_GUI_ID)
        { 
            TileSmithingAnvil tileSmithingAnvil = (TileSmithingAnvil) world.getTileEntity(x, y, z);
            return new GuiSmithingAnvil(player.inventory, tileSmithingAnvil);
        }
        
        if (ID == ArmoryRef.PART_PLANNER_GUI_ID)
        {
        	return new GuiPartPlanner(player.inventory, world, x, y, z);
        }
		
		return null;
	}

}

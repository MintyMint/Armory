package armory.tile_entity.smithing_anvil;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSmithingAnvil extends Container
{
	private TileSmithingAnvil tileEntity;
	
	public ContainerSmithingAnvil(InventoryPlayer playerInventory, TileSmithingAnvil tileSmithingAnvil)
	{
		tileEntity = tileSmithingAnvil;
		this.bindPlayerInventory(playerInventory);
	}
	
	public void bindPlayerInventory(InventoryPlayer playerInventory)
	{
		
		int id = 0;
		int id2 = 0;
		
		//binds the players "pack" inventory
		for (int row = 0; row < 3; row++)
		{
			for (int column = 0; column < 9; column++)
			{ this.addSlotToContainer(new Slot(playerInventory, column + row * 9 + 9, 8 + column * 18, 132 + row * 18)); }
		}
    
		//binds the players hotbar inventory
		for (int barslot = 0; barslot < 9; barslot++)
		{ this.addSlotToContainer(new Slot(playerInventory, barslot, 8 + barslot * 18, 190)); }
		
        //bind machine slots
		/*for(int i = 0; i < 3; i ++)
        {
            for(int j = 0; j < 3; j++)
            {
                addSlotToContainer(new Slot(tileEntity, id2, i * 18 + 62, j * 18 + 20)); //Adds custom slots
                id2++;
            }
        }
        addSlotToContainer(new Slot(tileEntity, id2, 81, 96));*/
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int slotIndex)
	{
		return null;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer var1)
	{
		return true;
	}

}

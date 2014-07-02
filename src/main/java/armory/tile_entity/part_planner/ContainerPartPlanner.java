package armory.tile_entity.part_planner;

import armory.core.BlockHelper;
import armory.core.PartPlannerCraftingHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;

public class ContainerPartPlanner extends Container
{
	public InventoryCrafting craftMatrix;
	public IInventory craftResult;
	
	private World worldObject;
	private int posX;
	private int posY;
	private int posZ;
	
	public ContainerPartPlanner(InventoryPlayer playerinventory, World world, int x, int y, int z)
	{
		this.craftMatrix = new InventoryCrafting(this, 5, 5);
		this.craftResult = new InventoryCraftResult();
		
		this.worldObject = world;
		this.posX = x;
		this.posY = y;
		this.posZ = z;
		
		//adds result slot
		this.addSlotToContainer(new SlotCrafting(playerinventory.player, this.craftMatrix, craftResult, 0, 141, 43));
		
		//adds crafting grid
		for (int row = 0; row < 5; row++)
		{
			for (int col = 0; col < 5; col++)
			{
				this.addSlotToContainer(new Slot(this.craftMatrix, col + row * 5, 8 + col * 18, 7 + row *18));
			}
		}
		
		//binds the players "pack" inventory
		for (int row = 0; row < 3; row++)
		{
			for (int col = 0; col < 9; col++)
			{
				this.addSlotToContainer(new Slot(playerinventory, col + row * 9 + 9, 8 + col * 18, 109 + row * 18));
			}
		}
    
		//binds the players hotbar inventory
		for (int barslot = 0; barslot < 9; barslot++)
		{ 
			this.addSlotToContainer(new Slot(playerinventory, barslot, 8 + barslot * 18, 167));
		}
	}
	
	public void onCraftMatrixChanged(IInventory iiventory)
	{
		craftResult.setInventorySlotContents(0, PartPlannerCraftingHandler.getInstance().findMatchingRecipe(craftMatrix, worldObject));
	}
	
	@Override
    public boolean canInteractWith(EntityPlayer player)
    {
        if(this.worldObject.getBlock(posX, posY, posZ) != BlockHelper.partPlanner)
        {
        	return false;
        }
    	
        else
        {
        	return player.getDistanceSq((double)posX + 0.5D, (double)posY + 0.5D, (double)posZ + 0.5D) <= 64.0D;
        }
    }


    //Called when the container is closed.
	@Override
    public void onContainerClosed(EntityPlayer par1EntityPlayer)
    {
        super.onContainerClosed(par1EntityPlayer);

        if (!this.worldObject.isRemote)
        {
            for (int i = 0; i < 9; ++i)
            {
                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

                if (itemstack != null)
                {
                    par1EntityPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
        }
    }
	
	//Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	@Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 0)
            {
                if (!this.mergeItemStack(itemstack1, 10, 46, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 >= 10 && par2 < 37)
            {
                if (!this.mergeItemStack(itemstack1, 37, 46, false))
                {
                    return null;
                }
            }
            else if (par2 >= 37 && par2 < 46)
            {
                if (!this.mergeItemStack(itemstack1, 10, 37, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }

}

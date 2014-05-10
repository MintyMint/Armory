package armory.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import armory.Armory;
import armory.core.ItemHelper;
import armory.lib.ArmoryNames;
import armory.lib.ArmoryRef;
import armory.tile_entity.smithing_anvil.TileSmithingAnvil;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SmithingAnvil extends ArmoryBlocks implements ITileEntityProvider
{	
	public SmithingAnvil()
    {
		super(Material.rock);
		this.setBlockName(ArmoryNames.Blocks.SMITHING_ANVIL_NAME);
        this.setCreativeTab(Armory.getCreativeTab());
        GameRegistry.registerBlock(this, this.getUnlocalizedName());
    }

	@Override
	public boolean hasTileEntity(int meta)
	{
		return true;
	}
 
	@Override
	public TileEntity createNewTileEntity(World var1, int var2)
	{
		return new TileSmithingAnvil();
	}
   
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par1, float par2, float par3, float par4)
	{
		TileEntity attachedTE = world.getTileEntity(x, y, z);

		if (player.isSneaking() == true){ player.openGui(Armory.instance, 0, world, x ,y, z); return true;}

		if (player.getHeldItem() != null && player.getHeldItem().getItem() == ItemHelper.smithingHammer)
		{
			((TileSmithingAnvil) attachedTE).increaseProgress();
			if (player.getHeldItem().attemptDamageItem(1, null) == true)
			{
				if (player.getHeldItem() != null && player.getHeldItem().getItem() == ItemHelper.smithingHammer)
				{ player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(ItemHelper.smithingHammer_broken)); }
			}
				
			return true;
		}

		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
}

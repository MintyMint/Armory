package armory.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import armory.Armory;
import armory.core.BlockHelper;
import armory.core.proxy.ClientProxy;
import armory.lib.ArmoryNames;
import armory.tile_entity.smithing_furnace.TileSmithingFurnace;

public class SmithingFurnace extends ArmoryBlocks implements ITileEntityProvider
{
	public SmithingFurnace()
	{
		super(Material.iron);
		this.setBlockName(ArmoryNames.Blocks.SMITHING_FURNACE_NAME);
        this.setCreativeTab(Armory.getCreativeTab());
        BlockHelper.registerBlocks(this);
        setBlockBounds(0f, 0f, 0f, 1f, 1f, 1f);
	}
	
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    @Override
    public int getRenderType()
    {
        return ClientProxy.smithingFurnaceRenderID;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
	@Override
	public boolean hasTileEntity(int meta)
	{
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2)
	{
		return new TileSmithingFurnace();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par1, float par2, float par3, float par4)
	{
		player.openGui(Armory.instance, 2, world, x ,y, z); return true;
	}
}

package armory.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import armory.Armory;
import armory.core.BlockHelper;
import armory.core.proxy.ClientProxy;
import armory.lib.ArmoryNames;
import armory.lib.ArmoryRef;
import armory.tile_entity.PartPlannerDummyTE;
import armory.tile_entity.smithing_anvil.TileSmithingAnvil;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class PartPlanner extends ArmoryBlocks implements ITileEntityProvider
{
    public static IIcon validRecipe;
	
	public PartPlanner()
    {
        this.setBlockName(ArmoryNames.Blocks.PART_PLANNER);
        this.setHardness(1f);
        this.setResistance(3f);
        this.setCreativeTab(Armory.getCreativeTab());
        this.setStepSound(Block.soundTypeMetal);
        BlockHelper.registerBlocks(this);
    }
	
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    @Override
    public int getRenderType()
    {
        return ClientProxy.partPlannerRenderID;
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
		return new PartPlannerDummyTE();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par1, float par2, float par3, float par4)
	{
		if (player.isSneaking() == false && world.isRemote == false)
		{
			player.openGui(Armory.instance, 1, world, x, y, z);
			return true;
		}
		
		return false;
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        validRecipe = iconRegister.registerIcon(ArmoryRef.MOD_ID + ":" + "valid_recipe");
    	
    	//blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }
}

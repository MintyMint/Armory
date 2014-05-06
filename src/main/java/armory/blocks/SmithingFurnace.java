package armory.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import armory.Armory;
import armory.lib.ArmoryNames;
import armory.lib.ArmoryRef;
import armory.tile_entity.ArmoryTE;
import armory.tile_entity.TileSmithingFurnace;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SmithingFurnace extends BlockContainer
{
	public SmithingFurnace()
	{
		super(Material.iron);
		this.setBlockName(ArmoryNames.Blocks.SMITHING_FURNACE_NAME);
        this.setCreativeTab(Armory.getCreativeTab());
        GameRegistry.registerBlock(this, this.getUnlocalizedName());
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
        return -1;
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
		player.openGui(Armory.instance, 1, world, x ,y, z); return true;
	}
	
	public String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	@Override
	public String getUnlocalizedName()
	{
	     return String.format("%s%s", ArmoryRef.RESOURCES_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(ArmoryRef.RESOURCES_PREFIX + getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack)
    {
        if (world.getTileEntity(x, y, z) instanceof ArmoryTE)
        {
            int direction = 0;
            int facing = MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

            if (facing == 0)
            {
                direction = ForgeDirection.NORTH.ordinal();
            }
            
            else if (facing == 1)
            {
                direction = ForgeDirection.EAST.ordinal();
            }
            
            else if (facing == 2)
            {
                direction = ForgeDirection.SOUTH.ordinal();
            }
            else if (facing == 3)
            
            {
                direction = ForgeDirection.WEST.ordinal();
            }

            
            if (itemStack.hasDisplayName())
            {
                ((ArmoryTE) world.getTileEntity(x, y, z)).setCustomName(itemStack.getDisplayName());
            }

            ((ArmoryTE) world.getTileEntity(x, y, z)).setOrientation(direction);
        }
    }
}

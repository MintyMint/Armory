package armory.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import armory.lib.ArmoryRef;
import armory.tile_entity.ArmoryTE;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmoryBlocks extends Block
{
	public ArmoryBlocks()
	{
		super(Material.rock);
	}
	
	public ArmoryBlocks(Material material)
	{
		super(material);
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

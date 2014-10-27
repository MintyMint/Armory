package armory.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TestBlock extends Block
{

    @SideOnly(Side.CLIENT)
    public IIcon[] icons;
 
    public TestBlock() {
        super(Material.iron);
        this.setBlockName("TestBlock");
        //this.setCreativeTab(DarkCraft.DarkCraftTab);
        //BlockHelper.register(this);
        icons = new IIcon[4];
    }
 
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        for(int count = 0; count < icons.length; count++)
        {
            String name;
            switch(count)
            {
                case 0: name = "front"; break;
                case 1: name = "top"; break;
                case 2: name = "bottom"; break;
                case 3: name = "sides"; break;
                
                default: name = "front";
            }
            //icons[count] = iconRegister.registerIcon(getUnwrappedUnlocalizedName(super.getUnlocalizedName()) + name);
        }
    }
 
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {	
    	//front icon//
    	if(side == meta){ return icons[0]; }
    	//top icon//
    	else if (side == ForgeDirection.UP.ordinal()){ return icons[1]; }
    	//bottom icon//
    	else if (side == ForgeDirection.DOWN.ordinal()){ return icons[2]; }
    	//sides icon//
    	else { return icons[3]; }
     }
 
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack)
    {
        world.scheduleBlockUpdate(x, y, z, this, 1);
 
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
 
        world.setBlockMetadataWithNotify(x, y, z, direction, 0);
    }
}


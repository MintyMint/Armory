package armory.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import armory.Armory;
import armory.core.BlockHelper;
import armory.lib.ArmoryNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class PartPlanner extends ArmoryBlocks
{
	@SideOnly(Side.CLIENT)
    public IIcon[] blockIcons;
	
	public PartPlanner()
    {
        this.setBlockName(ArmoryNames.Blocks.PART_PLANNER);
        this.setHardness(1f);
        this.setResistance(3f);
        this.setCreativeTab(Armory.getCreativeTab());
        this.setStepSound(Block.soundTypeMetal);
        BlockHelper.registerBlocks(this);
        blockIcons = new IIcon[6];
    }
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par1, float par2, float par3, float par4)
	{
		if (player.isSneaking() == false)
		{
			player.openGui(Armory.instance, 1, world, x, y, z);
			return true;
		}
		
		return false;
	}

}

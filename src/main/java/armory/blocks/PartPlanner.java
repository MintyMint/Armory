package armory.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import armory.Armory;
import armory.core.BlockHelper;
import armory.lib.ArmoryNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;

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
        this.setStepSound(Block.soundTypeGravel);
        BlockHelper.registerBlocks(this);
        blockIcons = new IIcon[6];
    }

}

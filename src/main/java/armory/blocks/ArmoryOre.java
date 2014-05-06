package armory.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import armory.Armory;
import armory.core.BlockHelper;
import armory.core.ItemHelper;
import armory.core.proxy.ClientProxy;
import armory.lib.ArmoryNames;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmoryOre extends ArmoryBlocks
{
    @SideOnly(Side.CLIENT)
    public IIcon[] blockIcons;
	
	public ArmoryOre()
    {
        this.setBlockName(ArmoryNames.Blocks.ORE_BLOCK_NAME);
        this.setHardness(1f);
        this.setResistance(3f);
        this.setCreativeTab(Armory.getCreativeTab());
        this.setStepSound(Block.soundTypeGravel);
        BlockHelper.registerBlocksWithMetadata(this, ItemBlockArmoryOre.class, "ore");
        blockIcons = new IIcon[6];
    }
	
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        for(int i = 0; i < blockIcons.length; i++)
        {
            String icon;
            switch(i)
            {
                case 0: icon = "Lava_Overlay"; break;
                case 1: icon = "Azurite_Overlay"; break;
                case 2: icon = "Crimsonite_Overlay"; break;
                case 3: icon = "Titanium_Overlay"; break;
                case 4: icon = "Lava_Glitter"; break;
                case 5: icon = "Ore_Glitter"; break;

                default: icon = "Ore_Glitter";
            }
            blockIcons[i] = iconRegister.registerIcon(getUnwrappedUnlocalizedName(super.getUnlocalizedName()) + "_" + icon);
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {	
    	return blockIcons[meta];
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        Random chance = new Random();
    	ArrayList<ItemStack> itemDropped = new ArrayList<ItemStack>();
        ArrayList<ItemStack> possibleDropped = new ArrayList<ItemStack>();
        
        possibleDropped.add(new ItemStack(ItemHelper.obsidiumOre, 1));
        possibleDropped.add(new ItemStack(ItemHelper.azuriteOre, 1));
        possibleDropped.add(new ItemStack(ItemHelper.crimsoniteOre, 1));
        
        itemDropped.add(possibleDropped.get(metadata));
        
        return itemDropped;
    }
    
    @Override
    public boolean isOpaqueCube()
    {
        return true;
    }
    
    
    public boolean renderAsNormalBlock()
    {
      return false;
    }

    public int getRenderType()
    {
      return ClientProxy.OreBlockRenderID;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        for (int i = 0; i < 4; i++)
        {
            list.add(new ItemStack(item, 1, i));
        }
    }
}
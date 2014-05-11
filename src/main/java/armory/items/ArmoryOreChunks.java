package armory.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import armory.Armory;
import armory.blocks.ItemBlockArmoryOre;
import armory.core.ConfigHelper;
import armory.core.ItemHelper;
import armory.lib.ArmoryNames;
import armory.lib.ArmoryOreRef;
import armory.lib.ArmoryRef;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmoryOreChunks extends ArmoryItems
{
    @SideOnly(Side.CLIENT)
    public IIcon[] chunkIcons;
	
	public ArmoryOreChunks()
    {
    	this.setUnlocalizedName(ArmoryNames.Items.ORE_CHUNKS_NAME);
    	setHasSubtypes(true);
    	setMaxStackSize(64);
    	setMaxDamage(0);
        setCreativeTab(Armory.getCreativeTab());
        ItemHelper.registerItems(this);
        chunkIcons = new IIcon[4];
    }
    
	@SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack itemstack, int par2)
    {
    	int color = Integer.parseInt(ArmoryOreRef.colors[itemstack.getItemDamage()], 16);
    	return color;
    }
    
	@Override
	public String getItemStackDisplayName(ItemStack itemstack)
    {
    	String name = "Chunks of " + ArmoryOreRef.oreTypes[itemstack.getItemDamage()] + " Ore";
    	return name;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        for(int count = 0; count < chunkIcons.length; count++)
        {
            String icon;
            switch(count)
            {
                case 0: icon = "obsidium"; break;

                default: icon = "base";
            }
            chunkIcons[count] = iconRegister.registerIcon(getUnwrappedUnlocalizedName(super.getUnlocalizedName()) + "_" + icon);
        }
    }
    

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta)
    {
    	return chunkIcons[meta];
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list)
    {
        for (int count = 0; count < 4; count++)
        {
            list.add(new ItemStack(item, 1, count));
        }
    }
}

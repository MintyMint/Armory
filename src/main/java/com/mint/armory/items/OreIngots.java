package armory.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import armory.Armory;
import armory.core.ItemHelper;
import armory.lib.ArmoryNames;
import armory.lib.ArmoryRef;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OreIngots extends ArmoryItems
{
    public IIcon[] ingotIcons;
	
	public OreIngots()
    {
    	this.setUnlocalizedName(ArmoryNames.Items.ORE_INGOTS_NAME);
    	setHasSubtypes(true);
    	setMaxStackSize(64);
    	setMaxDamage(0);
        setCreativeTab(Armory.getCreativeTab());
        ItemHelper.registerItems(this);
        ingotIcons = new IIcon[ArmoryNames.Items.ORE_TYPES.length];
    }
    
	@SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack itemstack, int par2)
    {
    	int color = Integer.parseInt(ArmoryRef.colors[itemstack.getItemDamage()], 16);
    	return color;
    }
    
	@Override
	public String getItemStackDisplayName(ItemStack itemstack)
    {
    	String name = ArmoryNames.Items.ORE_TYPES[itemstack.getItemDamage()] + " Ingot";
    	return name;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        for(int count = 0; count < ingotIcons.length; count++)
        {
            String icon;
            switch(count)
            {
                case 0: icon = "obsidium"; break;

                default: icon = "base";
            }
            
            ingotIcons[count] = iconRegister.registerIcon(ArmoryRef.RESOURCES_PREFIX + getUnwrappedUnlocalizedName(super.getUnlocalizedName()) + "_" + icon);
        }
    }
    

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta)
    {
    	return ingotIcons[meta];
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

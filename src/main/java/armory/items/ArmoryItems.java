package armory.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import armory.core.ConfigHelper;
import armory.lib.ArmoryRef;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmoryItems extends Item
{
    public String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
 
    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s",ArmoryRef.RESOURCES_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
 
    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", ArmoryRef.RESOURCES_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
 
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(ArmoryRef.RESOURCES_PREFIX + getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    
    public int getIntColorFromHex(String hexColor)
    {
		return Integer.parseInt(hexColor, 16);
    }
}

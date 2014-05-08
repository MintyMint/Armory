package armory.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import armory.Armory;
import armory.core.ItemHelper;
import armory.lib.ArmoryNames;

public class SmithingHammer extends ArmoryItems
{
    public SmithingHammer()
    {
        this.setUnlocalizedName(ArmoryNames.Items.SMITHING_HAMMER_NAME);
        this.setCreativeTab(Armory.getCreativeTab());
        this.setMaxDamage(12);
        this.maxStackSize = 1;
        
        ItemHelper.registerItems(this);
    }
    
    /*@Override
    public ItemStack onItemRightClick(ItemStack itemstack, World worldorld, EntityPlayer player)
    {
        if 
    	itemstack.damageItem(1, player);
        return itemstack;
    }*/
    
}

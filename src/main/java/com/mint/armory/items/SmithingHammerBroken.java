package armory.items;

import armory.Armory;
import armory.core.ItemHelper;
import armory.lib.ArmoryNames;
import net.minecraft.item.Item;

public class SmithingHammerBroken extends ArmoryItems
{
    public SmithingHammerBroken()
    {
        this.setUnlocalizedName(ArmoryNames.Items.SMITHING_HAMMER_BROKEN_NAME);
        this.setCreativeTab(Armory.getCreativeTab());
        this.maxStackSize = 1;

        ItemHelper.registerItems(this);
    }  
}

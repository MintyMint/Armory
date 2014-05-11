package armory.items;

import armory.Armory;
import armory.core.ItemHelper;
import armory.lib.ArmoryNames;
import net.minecraft.item.Item;

public class TitaniumOre extends ArmoryItems
{
    public TitaniumOre()
    {
        this.setUnlocalizedName(ArmoryNames.Items.TITANIUM_CHUNK_NAME);
        this.setCreativeTab(Armory.getCreativeTab());
        //ItemHelper.registerItems(this);
    }
}

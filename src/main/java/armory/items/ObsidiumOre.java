package armory.items;

import armory.Armory;
import armory.core.ItemHelper;
import armory.lib.ArmoryNames;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ObsidiumOre extends ArmoryItems
{
    public ObsidiumOre()
    {
        this.setUnlocalizedName(ArmoryNames.Items.OBSIDIUM_CHUNK_NAME);
        this.setCreativeTab(Armory.getCreativeTab());
        ItemHelper.registerItems(this);
    }
}

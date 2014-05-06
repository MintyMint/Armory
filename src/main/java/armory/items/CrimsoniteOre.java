package armory.items;

import armory.Armory;
import armory.core.ItemHelper;
import armory.lib.ArmoryNames;

public class CrimsoniteOre extends ArmoryItems
{
    public CrimsoniteOre()
    {
        this.setUnlocalizedName(ArmoryNames.Items.CRIMSONITE_CHUNK_NAME);
        this.setCreativeTab(Armory.getCreativeTab());
        ItemHelper.registerItems(this);
    }
}

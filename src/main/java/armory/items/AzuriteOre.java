package armory.items;

import armory.Armory;
import armory.core.ItemHelper;
import armory.lib.ArmoryNames;

public class AzuriteOre extends ArmoryItems
{
    public AzuriteOre()
    {
        this.setUnlocalizedName(ArmoryNames.Items.AZURITE_CHUNK_NAME);
        this.setCreativeTab(Armory.getCreativeTab());
        ItemHelper.registerItems(this);
    }
}

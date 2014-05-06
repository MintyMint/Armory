package armory.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ArmoryTab extends CreativeTabs
{

	public ArmoryTab(int id, String mod_id)
	{
		super(id, mod_id);
	}
	
    @Override
    public Item getTabIconItem()
    {
        return ItemHelper.obsidiumOre;
    }
}

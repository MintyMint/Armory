package armory.lib;

import net.minecraft.util.ResourceLocation;

public class ArmoryRef
{
	public static final String MOD_ID = "armory";
	public static final String MOD_NAME = "Armory";
	public static final String VERSION = "0.1";	
	
	public static final String CLIENT_PROXY = MOD_ID + ".core.proxy.ClientProxy";
	public static final String COMMON_PROXY = MOD_ID + ".core.proxy.CommonProxy";
	
	public static final String RESOURCES_PREFIX = MOD_ID.toLowerCase() + ":";
	
	public static final String MODELS_LOCATION = "models/";
	public static final String BLOCK_TEXTURE_LOCATION = "textures/blocks/";
	public static final String ITEM_TEXTURE_LOCATION = "textures/items/";
	public static final String GUI_TEXTURE_LOCATION = "textures/gui/";
	
	//models//
	public static final ResourceLocation SMITHING_FURNACE_MODEL = getResourceLocation(MOD_ID, MODELS_LOCATION + "smithing_furnace.obj");
	public static final ResourceLocation SMITHING_FURNACE_TEXTURE = getResourceLocation(MOD_ID, BLOCK_TEXTURE_LOCATION + "smithing_furnace.png");
		
	//GUIs//
	public static final ResourceLocation SMITHING_ANVIL_GUI = getResourceLocation(MOD_ID, GUI_TEXTURE_LOCATION + "smithing_anvil_gui.png");
	public static final ResourceLocation PART_PLANNER_GUI = getResourceLocation(MOD_ID, GUI_TEXTURE_LOCATION + "part_planner_gui.png");
	
	public static final int SMITHING_FURNACE_GUI_ID = 0;
	public static final int PART_PLANNER_GUI_ID = 1;
	
	public static String[] colors = {"FFFFFF", "123456", "AA0000", "FFFFFF"};
	
    public static ResourceLocation getResourceLocation(String modId, String path)
    {
        return new ResourceLocation(modId, path);
    }

    public static ResourceLocation getResourceLocation(String path)
    {
        return getResourceLocation(MOD_ID.toLowerCase(), path);
    }
}

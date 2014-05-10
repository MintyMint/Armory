package armory.lib;

import net.minecraft.util.ResourceLocation;

public class ArmoryRef
{
	public static final String MOD_ID = "armory";
	public static final String MOD_NAME = "Armory";
	public static final String VERSION = "0.0.1";	
	
	public static final String CLIENT_PROXY = MOD_ID + ".core.proxy.ClientProxy";
	public static final String COMMON_PROXY = MOD_ID + ".core.proxy.CommonProxy";
	
	public static final String RESOURCES_PREFIX = MOD_ID.toLowerCase() + ":";
	
	public static final String MODELS_LOCATION = "models/";
	
	//models//
	public static final ResourceLocation SMITHING_FURNACE_MODEL = getResourceLocation(MOD_ID, MODELS_LOCATION + "smithing_furnace.obj");
	public static final ResourceLocation SMITHING_FURNACE_TEXTURE = getResourceLocation(MOD_ID, MODELS_LOCATION + "smithing_furnace.png");
		
	//GUIs//
	public static final ResourceLocation SMITHING_ANVIL_GUI = getResourceLocation(MOD_ID, "textures/gui/smithing_anvil_gui.png");
	
    public static ResourceLocation getResourceLocation(String modId, String path)
    {
        return new ResourceLocation(modId, path);
    }

    public static ResourceLocation getResourceLocation(String path)
    {
        return getResourceLocation(MOD_ID.toLowerCase(), path);
    }
}

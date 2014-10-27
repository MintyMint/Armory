package armory;

import java.util.logging.Logger;

import net.minecraft.creativetab.CreativeTabs;
import armory.core.ArmoryTab;
import armory.core.BlockHelper;
import armory.core.ConfigHelper;
import armory.core.CraftingHelper;
import armory.core.ItemHelper;
import armory.core.proxy.CommonProxy;
import armory.core.proxy.IProxy;
import armory.gui.ArmoryGuiHandler;
import armory.lib.ArmoryRef;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = ArmoryRef.MOD_ID, name = ArmoryRef.MOD_NAME, version = ArmoryRef.VERSION)

public class Armory
{
	@Mod.Instance(ArmoryRef.MOD_ID)
	public static Armory instance;

	@SidedProxy(clientSide = ArmoryRef.CLIENT_PROXY, serverSide = ArmoryRef.SERVER_PROXY)
	public static IProxy proxy;
	
	public static Logger armoryLogger;

	private static CreativeTabs armoryTab = new ArmoryTab(CreativeTabs.getNextID(), ArmoryRef.MOD_ID);

	public static CreativeTabs getCreativeTab()
	{
		return armoryTab;
	}

	@Mod.EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		armoryLogger = Logger.getLogger(ArmoryRef.MOD_ID);
		
		ConfigHelper.init(event.getSuggestedConfigurationFile());
		
		BlockHelper.init();
		
		ItemHelper.init();
		
		ItemHelper.registerOreDictionary();
		
		CraftingHelper.init();		

		//Adds our worldgenerator. The int is the weight. How higher the number, how later your generator will be called
		//GameRegistry.registerWorldGenerator(new TutorialWorldGenerator(), 1);

		proxy.registerTileEntities();

	}

	@Mod.EventHandler
	public static void init(FMLInitializationEvent event)
	{
		proxy.registerRendering();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new ArmoryGuiHandler());
	}
	
	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event)
	{
		FMLLog.info("Armory: Looks like everything ran correctly!");
	}
}

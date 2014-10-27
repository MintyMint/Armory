package armory.core;

import java.io.File;
import java.util.logging.Level;

import armory.Armory;
import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.config.Configuration;

public class ConfigHelper
{	
	public static void init(File ArmoryConfig)
	{
		Configuration config = new Configuration(ArmoryConfig);
		
		try
		{
			config.load();
			
			
		}
		
		catch (Exception exception)
		{
			Armory.armoryLogger.log(Level.SEVERE, "Armory has encountered a problem loading its configuration!", exception);
		}
		
		finally
		{
			config.save();
		}
	}

}

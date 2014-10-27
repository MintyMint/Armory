package armory.core.proxy;

public interface IProxy
{
	public abstract void registerTileEntities();
	
	public abstract void registerRendering();
	
	public abstract void registerEventHandlers();
	
	public abstract void playSound(String soundName, float xCoord, float yCoord, float zCoord, float volume, float pitch);
}

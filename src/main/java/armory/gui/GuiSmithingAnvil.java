package armory.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import armory.lib.ArmoryRef;
import armory.tile_entity.TileSmithingAnvil;

public class GuiSmithingAnvil extends GuiContainer
{
    private static final ResourceLocation backgroundImage = new ResourceLocation(ArmoryRef.MOD_ID.toLowerCase() + ":" + "textures/gui/mygui.png");
    private static TileSmithingAnvil tileEntity;
	
	public GuiSmithingAnvil(InventoryPlayer playerInventory,TileSmithingAnvil tileSmithingAnvil)
	{
        super(new ContainerSmithingAnvil(playerInventory, tileSmithingAnvil));
        xSize = 176;
        ySize = 214;
        
        tileEntity = tileSmithingAnvil;
	}
  

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) 
	{
        //Bind Texture
        this.mc.getTextureManager().bindTexture(backgroundImage);
        // set the x for the texture, Total width - textureSize / 2
        var2 = (this.width - xSize) / 2;
        // set the y for the texture, Total height - textureSize - 30 (up) / 2,
        int j = (this.height - ySize) / 2;
        // draw the texture
        drawTexturedModalRect(var2, j, 0, 0, xSize,  ySize);
	}
	
    public boolean doesGuiPauseGame()
    {
        return false;
    }

}

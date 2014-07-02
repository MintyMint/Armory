package armory.tile_entity.part_planner;

import org.lwjgl.opengl.GL11;

import armory.lib.ArmoryRef;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class GuiPartPlanner extends GuiContainer
{
	private ResourceLocation guiTexture = ArmoryRef.PART_PLANNER_GUI;
	
	public GuiPartPlanner(InventoryPlayer playerinventory, World world, int x, int y, int z)
	{
		super(new ContainerPartPlanner(playerinventory, world, x, y, z));
		
		this.xSize = 176;
		this.ySize = 191;
	}
	
	public void onGuiClosed()
	{
		super.onGuiClosed();
	}
	
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Part Planner"), 105, 7, 0x000000);
		
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Inventory"), 8, 98, 0x000000);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
	{
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(guiTexture);
		
		this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}

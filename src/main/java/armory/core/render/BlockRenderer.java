package armory.core.render;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

public class BlockRenderer
{
	public static void drawFaces(RenderBlocks renderblocks, Block block, Icon icon)
	  {
	    drawFaces(renderblocks, block, icon, icon, icon, icon, icon, icon);
	  }

	  public static void drawFaces(RenderBlocks renderblocks, Block block, Icon i1, Icon i2, Icon i3, Icon i4, Icon i5, Icon i6)
	  {
	    Tessellator tessellator = Tessellator.instance;
	    GL11.glTranslatef(-0.5F, -0.5F, -0.5F);


	    tessellator.startDrawingQuads();
	    tessellator.setNormal(0.0F, 1.0F, 0.0F);
	    renderblocks.renderTopFace(block, 0.0D, 0.0D, 0.0D, i2);
	    tessellator.draw();
	    
	    tessellator.startDrawingQuads();
	    tessellator.setNormal(0.0F, -1.0F, 0.0F);
	    renderblocks.renderBottomFace(block, 0.0D, 0.0D, 0.0D, i1);
	    tessellator.draw();

	    tessellator.startDrawingQuads();
	    tessellator.setNormal(0.0F, 0.0F, 1.0F);
	    renderblocks.renderNorthFace(block, 0.0D, 0.0D, 0.0D, i3);
	    tessellator.draw();

	    tessellator.startDrawingQuads();
	    tessellator.setNormal(0.0F, 0.0F, -1.0F);
	    renderblocks.renderSouthFace(block, 0.0D, 0.0D, 0.0D, i4);
	    tessellator.draw();

	    tessellator.startDrawingQuads();
	    tessellator.setNormal(1.0F, 0.0F, 0.0F);
	    renderblocks.renderEastFace(block, 0.0D, 0.0D, 0.0D, i5);
	    tessellator.draw();

	    tessellator.startDrawingQuads();
	    tessellator.setNormal(-1.0F, 0.0F, 0.0F);
	    renderblocks.renderWestFace(block, 0.0D, 0.0D, 0.0D, i6);
	    tessellator.draw();
	    
	    GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	  }

	  protected static int setBrightness(IBlockAccess blockAccess, int i, int j, int k, Block block) {
	    Tessellator tessellator = Tessellator.instance;
	    int mb = block.getMixedBrightnessForBlock(blockAccess, i, j, k);
	    tessellator.setBrightness(mb);

	    float f = 1.0F;

	    int l = block.colorMultiplier(blockAccess, i, j, k);
	    float f1 = (l >> 16 & 0xFF) / 255.0F;
	    float f2 = (l >> 8 & 0xFF) / 255.0F;
	    float f3 = (l & 0xFF) / 255.0F;
	    if (EntityRenderer.anaglyphEnable)
	    {
	      float f6 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
	      float f4 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
	      float f7 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
	      f1 = f6;
	      f2 = f4;
	      f3 = f7;
	    }
	    tessellator.setColorOpaque_F(f * f1, f * f2, f * f3);
	    return mb;
	  }

	  protected static void renderAllSides(IBlockAccess world, int x, int y, int z, Block block, RenderBlocks renderer, Icon texture)
	  {
	    renderAllSides(world, x, y, z, block, renderer, texture, true);
	  }

	  protected static void renderAllSides(IBlockAccess world, int x, int y, int z, Block block, RenderBlocks renderer, Icon texture, boolean allsides)
	  {
	    if ((allsides) || (block.shouldSideBeRendered(world, x + 1, y, z, 6))) renderer.renderSouthFace(block, x, y, z, texture);
	    if ((allsides) || (block.shouldSideBeRendered(world, x - 1, y, z, 6))) renderer.renderNorthFace(block, x, y, z, texture);
	    if ((allsides) || (block.shouldSideBeRendered(world, x, y, z + 1, 6))) renderer.renderWestFace(block, x, y, z, texture);
	    if ((allsides) || (block.shouldSideBeRendered(world, x, y, z - 1, 6))) renderer.renderEastFace(block, x, y, z, texture);
	    if ((allsides) || (block.shouldSideBeRendered(world, x, y + 1, z, 6))) renderer.renderTopFace(block, x, y, z, texture);
	    if ((allsides) || (block.shouldSideBeRendered(world, x, y - 1, z, 6))) renderer.renderBottomFace(block, x, y, z, texture);
	  }

	  protected static void renderAllSidesInverted(IBlockAccess world, int x, int y, int z, Block block, RenderBlocks renderer, Icon tex, boolean allsides)
	  {
	    if ((allsides) || (!block.shouldSideBeRendered(world, x - 1, y, z, 6))) renderer.renderSouthFace(block, x - 1, y, z, tex);
	    if ((allsides) || (!block.shouldSideBeRendered(world, x + 1, y, z, 6))) renderer.renderNorthFace(block, x + 1, y, z, tex);
	    if ((allsides) || (!block.shouldSideBeRendered(world, x, y, z - 1, 6))) renderer.renderWestFace(block, x, y, z - 1, tex);
	    if ((allsides) || (!block.shouldSideBeRendered(world, x, y, z + 1, 6))) renderer.renderEastFace(block, x, y, z + 1, tex);
	    if ((allsides) || (!block.shouldSideBeRendered(world, x, y - 1, z, 6))) renderer.renderTopFace(block, x, y - 1, z, tex);
	    if ((allsides) || (!block.shouldSideBeRendered(world, x, y + 1, z, 6))) renderer.renderBottomFace(block, x, y + 1, z, tex);
	  }

	  protected static void renderAllSides(int x, int y, int z, Block block, RenderBlocks renderer, Icon tex)
	  {
	    renderer.renderSouthFace(block, x - 1, y, z, tex);
	    renderer.renderNorthFace(block, x + 1, y, z, tex);
	    renderer.renderWestFace(block, x, y, z - 1, tex);
	    renderer.renderEastFace(block, x, y, z + 1, tex);
	    renderer.renderTopFace(block, x, y - 1, z, tex);
	    renderer.renderBottomFace(block, x, y + 1, z, tex);
	  }
}

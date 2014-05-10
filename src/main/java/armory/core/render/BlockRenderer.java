package armory.core.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

public class BlockRenderer
{
	public static void drawFaces(RenderBlocks renderblocks, Block block, IIcon texture)
	  {
	    drawFaces(renderblocks, block, texture, texture, texture, texture, texture, texture);
	  }

	  public static void drawFaces(RenderBlocks renderblocks, Block block, IIcon tTex, IIcon bTex, IIcon nTex, IIcon eTex, IIcon sTex, IIcon wTex)
	  {
		  Tessellator tessellator = Tessellator.instance;
		  GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

		  tessellator.startDrawingQuads();
		  tessellator.setNormal(0.0F, 1.0F, 0.0F);
		  renderblocks.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, tTex);
		  tessellator.draw();
		
		  tessellator.startDrawingQuads();
		  tessellator.setNormal(0.0F, -1.0F, 0.0F);
		  renderblocks.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, bTex);
		  tessellator.draw();
		
		  tessellator.startDrawingQuads();
		  tessellator.setNormal(0.0F, 0.0F, 1.0F);
		  renderblocks.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, nTex);
		  tessellator.draw();
		
		  tessellator.startDrawingQuads();
		  tessellator.setNormal(0.0F, 0.0F, -1.0F);
		  renderblocks.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, eTex);
		  tessellator.draw();
		
		  tessellator.startDrawingQuads();
		  tessellator.setNormal(1.0F, 0.0F, 0.0F);
		  renderblocks.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, sTex);
		  tessellator.draw();
		
		  tessellator.startDrawingQuads();
		  tessellator.setNormal(-1.0F, 0.0F, 0.0F);
		  renderblocks.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, wTex);
		  tessellator.draw();
		
		  GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}

	protected static void renderAllSides(IBlockAccess world, int x, int y, int z, Block block, RenderBlocks renderer, IIcon texture)
	{
		renderAllSides(world, x, y, z, block, renderer, texture, true);
	}

	protected static void renderAllSides(IBlockAccess world, int x, int y, int z, Block block, RenderBlocks renderer, IIcon texture, boolean allsides)
	{
		if ((allsides) || (block.shouldSideBeRendered(world, x, y + 1, z, 6))) renderer.renderFaceYPos(block, x, y, z, texture);
		if ((allsides) || (block.shouldSideBeRendered(world, x, y - 1, z, 6))) renderer.renderFaceYNeg(block, x, y, z, texture);
		if ((allsides) || (block.shouldSideBeRendered(world, x - 1, y, z, 6))) renderer.renderFaceZNeg(block, x, y, z, texture);
		if ((allsides) || (block.shouldSideBeRendered(world, x, y, z - 1, 6))) renderer.renderFaceXPos(block, x, y, z, texture);		
		if ((allsides) || (block.shouldSideBeRendered(world, x + 1, y, z, 6))) renderer.renderFaceZPos(block, x, y, z, texture);
		if ((allsides) || (block.shouldSideBeRendered(world, x, y, z + 1, 6))) renderer.renderFaceXNeg(block, x, y, z, texture);
	}
}

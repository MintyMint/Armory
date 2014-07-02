package armory.core.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import armory.blocks.ArmoryOre;
import armory.core.proxy.ClientProxy;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderOreBlock extends BlockRenderer implements ISimpleBlockRenderingHandler
{
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{

		ArmoryOre handlerBlock = (ArmoryOre) block;

		block.setBlockBoundsForItemRender();

		Tessellator tess = Tessellator.instance;

		if (modelID == ClientProxy.oreBlockRenderID)
		{
			tess.startDrawingQuads();

			renderer.setRenderBounds(0.0001, 0.0001, 0.0001, 0.9999, 0.9999, 0.9999);

			tess.setColorOpaque_I(handlerBlock.colors[metadata]);

			if (metadata == 0)
			{ drawFaces(renderer, block, handlerBlock.lavaGlint); }

			else
			{ drawFaces(renderer, block, handlerBlock.oreGlint); }

			tess.setColorOpaque_I(0xFFFFFF);
			renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
			drawFaces(renderer, block, handlerBlock.overlays[metadata]);

			tess.draw();
		}
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelID, RenderBlocks renderer)
	{
		int metadata = world.getBlockMetadata(x, y, z);

		Tessellator tess = Tessellator.instance;

		ArmoryOre handlerBlock = (ArmoryOre) block;

		if (modelID == ClientProxy.oreBlockRenderID)
		{
			renderer.setRenderBounds(0.001, 0.001, 0.001, 0.999, 0.999, 0.999);

			tess.setColorOpaque_I(handlerBlock.colors[metadata]);

			tess.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z) + handlerBlock.brightness[metadata]);

			if (metadata == 0)
			{ renderAllSides(world, x, y, z, handlerBlock, renderer, handlerBlock.lavaGlint, true); }

			else
			{ renderAllSides(world, x, y, z, handlerBlock, renderer, handlerBlock.oreGlint, true); }

			renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
			renderer.clearOverrideBlockTexture();
			renderer.renderStandardBlock(block, x, y, z);
		}

		return true;
	}

	@Override
	public int getRenderId()
	{
		return ClientProxy.oreBlockRenderID;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId)
	{
		return true;
	}
}
package armory.core.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
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
        if(modelID == ClientProxy.OreBlockRenderID)
        {
        	ArmoryOre handlerBlock = (ArmoryOre)block;
            
        	block.setBlockBoundsForItemRender();

        	renderer.setRenderBounds(0.0001, 0.0001, 0.0001, 0.9999, 0.9999, 0.9999);
        	
        	if (metadata == 0)
        	{
        		GL11.glColor3f(1f, 1f,1f);
        		drawFaces(renderer, block, handlerBlock.blockIcons[4]);
        	}
        	
        	else if (metadata == 1)
        	{
        		GL11.glColor3f(0.070f, 0.203f, 0.337f);
        		drawFaces(renderer, block, handlerBlock.blockIcons[5]);
        	}
        	
        	else if (metadata == 2)
        	{
        		GL11.glColor3f(1f, 0f, 0f);
        		drawFaces(renderer, block, handlerBlock.blockIcons[5]);
        	}
        	
        	else if (metadata == 3)
        	{
        		GL11.glColor3f(1f, 1f,1f);
        		drawFaces(renderer, block, handlerBlock.blockIcons[4]);
        	}
        	
        	
        	GL11.glColor3f(1f, 1f,1f);
        	renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
        	drawFaces(renderer, block, handlerBlock.blockIcons[metadata]);
        }
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelID, RenderBlocks renderer)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		
		Tessellator tess = Tessellator.instance;
		
		ArmoryOre handlerBlock = (ArmoryOre)block;
			
		renderer.setRenderBounds(0.001, 0.001, 0.001, 0.999, 0.999, 0.999);
		
		if(modelID == ClientProxy.OreBlockRenderID)
		{
			if (metadata == 0)
			{
				tess.setBrightness(200);
				tess.setColorOpaque_I(0xFFFFFF);
				renderAllSides(world, x, y, z, handlerBlock, renderer, handlerBlock.blockIcons[4], true);
			}
			
			else if (metadata == 1)
			{
				tess.setBrightness(225);
				tess.setColorOpaque_I(0x012345);
				renderAllSides(world, x, y, z, handlerBlock, renderer, handlerBlock.blockIcons[5], true);
			}
	
			else if (metadata == 2)
			{
				tess.setBrightness(150);
				tess.setColorOpaque_I(0xFF0000);
				renderAllSides(world, x, y, z, handlerBlock, renderer, handlerBlock.blockIcons[5], true);
			}
			
			else if (metadata == 3)
			{
				tess.setBrightness(handlerBlock.getMixedBrightnessForBlock(world, x, y, z));
				tess.setColorOpaque_I(0xFFFFFF);
				renderAllSides(world, x, y, z, handlerBlock, renderer, handlerBlock.blockIcons[5], true);
			}
			
			renderer.renderStandardBlock(block, x, y, z);
		}
		
		renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
		renderer.clearOverrideBlockTexture();
		renderer.renderStandardBlock(block, x, y, z);
		
		return true;
	}

	@Override
	public int getRenderId()
	{
		return ClientProxy.OreBlockRenderID;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId)
	{
		return true;
	}
}
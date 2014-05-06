package armory.core.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import armory.blocks.ArmoryOre;
import armory.core.proxy.ClientProxy;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderOreBlock implements ISimpleBlockRenderingHandler
{
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		
		Tessellator tessellator = Tessellator.instance;
        if(modelID == ClientProxy.OreBlockRenderID)
        {
        	ArmoryOre handlerBlock = (ArmoryOre)block;
            
        	block.setBlockBoundsForItemRender();
            
        	GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

            //top renderFaceYPos//
        	tessellator.startDrawingQuads();
        	tessellator.setNormal(0F, +1.0F, 0F);
        	renderer.setRenderBounds(0.0001, 0.0001, 0.0001, 0.9999, 0.9999, 0.9999);
        	
        	if (metadata == 0)
        	{
        		tessellator.setColorOpaque_I(0xFFFFFF);
        		renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[4]);
        		renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[4]);
        		renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[4]);
        		renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[4]);
        		renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[4]);
        		renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[4]);
        	}
        	
        	else if (metadata == 1)
        	{
        		tessellator.setColorOpaque_I(0x012345);
        		renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[5]);
        		renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[5]);
        		renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[5]);
        		renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[5]);
        		renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[5]);
        		renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[5]);
        	}
        	
        	else if (metadata == 2)
        	{
        		tessellator.setColorOpaque_I(0xFF0000);
        		renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[5]);
        		renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[5]);
        		renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[5]);
        		renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[5]);
        		renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[5]);
        		renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[5]);
        	}
        	
        	else if (metadata == 3)
        	{
        		tessellator.setColorOpaque_I(0xFFFFFF);
        		renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[5]);
        		renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[5]);
        		renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[5]);
        		renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[5]);
        		renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[5]);
        		renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[5]);
        	}
        	
        	
        	tessellator.setColorOpaque_I(0xFFFFFF);
        	renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
        	renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[metadata]);
        	renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[metadata]);
        	renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[metadata]);
        	renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[metadata]);
        	renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[metadata]);
        	renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, handlerBlock.blockIcons[metadata]);
        	tessellator.draw();
            
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        }
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		
		Tessellator tess = Tessellator.instance;
		
		ArmoryOre handlerBlock = (ArmoryOre)block;
			
		
		if (metadata == 0)
		{
			tess.setBrightness(200);
			tess.setColorOpaque_I(0xFFFFFF);
			renderer.renderFaceYPos(block, x, y, z, ((ArmoryOre)block).blockIcons[4]);
			renderer.renderFaceYNeg(block, x, y, z, ((ArmoryOre)block).blockIcons[4]);
			renderer.renderFaceZNeg(block, x, y, z, ((ArmoryOre)block).blockIcons[4]);
			renderer.renderFaceXPos(block, x, y, z, ((ArmoryOre)block).blockIcons[4]);
			renderer.renderFaceZPos(block, x, y, z, ((ArmoryOre)block).blockIcons[4]);
			renderer.renderFaceXNeg(block, x, y, z, ((ArmoryOre)block).blockIcons[4]);
		}
		
		else if (metadata == 1)
		{
			tess.setBrightness(225);
			tess.setColorOpaque_I(0x012345);
			renderer.renderFaceYPos(block, x, y, z, ((ArmoryOre)block).blockIcons[5]);
			renderer.renderFaceYNeg(block, x, y, z, ((ArmoryOre)block).blockIcons[5]);
			renderer.renderFaceZNeg(block, x, y, z, ((ArmoryOre)block).blockIcons[5]);
			renderer.renderFaceXPos(block, x, y, z, ((ArmoryOre)block).blockIcons[5]);
			renderer.renderFaceZPos(block, x, y, z, ((ArmoryOre)block).blockIcons[5]);
			renderer.renderFaceXNeg(block, x, y, z, ((ArmoryOre)block).blockIcons[5]);
		}

		else if (metadata == 2)
		{
			tess.setBrightness(150);
			tess.setColorOpaque_I(0xFF0000);
			renderer.renderFaceYPos(block, x, y, z, ((ArmoryOre)block).blockIcons[5]);
			renderer.renderFaceYNeg(block, x, y, z, ((ArmoryOre)block).blockIcons[5]);
			renderer.renderFaceZNeg(block, x, y, z, ((ArmoryOre)block).blockIcons[5]);
			renderer.renderFaceXPos(block, x, y, z, ((ArmoryOre)block).blockIcons[5]);
			renderer.renderFaceZPos(block, x, y, z, ((ArmoryOre)block).blockIcons[5]);
			renderer.renderFaceXNeg(block, x, y, z, ((ArmoryOre)block).blockIcons[5]);
		}
		
		else if (metadata == 3)
		{
			//tess.setBrightness(handlerBlock.getMixedBrightnessForBlock(world, x, y, z));
			tess.setColorOpaque_I(0xFFFFFF);
			renderer.renderFaceYPos(block, x, y, z, ((ArmoryOre)block).blockIcons[5]);
			renderer.renderFaceYNeg(block, x, y, z, ((ArmoryOre)block).blockIcons[5]);
			renderer.renderFaceZNeg(block, x, y, z, ((ArmoryOre)block).blockIcons[5]);
			renderer.renderFaceXPos(block, x, y, z, ((ArmoryOre)block).blockIcons[5]);
			renderer.renderFaceZPos(block, x, y, z, ((ArmoryOre)block).blockIcons[5]);
			renderer.renderFaceXNeg(block, x, y, z, ((ArmoryOre)block).blockIcons[5]);
		}
		
		renderer.setRenderBounds(0.001, 0.001, 0.001, 0.999, 0.999, 0.999);
		renderer.renderStandardBlock(block, x, y, z);
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
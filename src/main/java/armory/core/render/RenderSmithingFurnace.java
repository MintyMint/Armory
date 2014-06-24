package armory.core.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import armory.lib.ArmoryRef;
import armory.tile_entity.smithing_furnace.TileSmithingFurnace;
import cpw.mods.fml.client.FMLClientHandler;

public class RenderSmithingFurnace extends TileEntitySpecialRenderer
{
	public static final ResourceLocation furanceTexture = ArmoryRef.SMITHING_FURNACE_TEXTURE;
	private IModelCustom furnaceModel;
	
	public RenderSmithingFurnace()
	{
		furnaceModel = AdvancedModelLoader.loadModel(ArmoryRef.SMITHING_FURNACE_MODEL);
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float var8)
	{
		TileSmithingFurnace tileSmithingFurnace = (TileSmithingFurnace) tileEntity;
		
        GL11.glPushMatrix();
  
            FMLClientHandler.instance().getClient().getTextureManager().bindTexture(furanceTexture);

            renderByOrientation(x, y, z, tileSmithingFurnace.getOrientation());
            
            furnaceModel.renderAll();

        GL11.glPopMatrix();
	}
	
    private void renderByOrientation(double x, double y, double z, ForgeDirection forgeDirection)
    {
        switch (forgeDirection)
        {

            case NORTH:
            {
                GL11.glScalef(1.0F, 1.0F, 1.0F);
                GL11.glTranslatef((float) x + 1.0F, (float) y + 0.0F, (float) z + 1.0F);
                GL11.glRotatef(180F, 0F, 1F, 0F);
                return;
            }
            case SOUTH:
            {
                GL11.glScalef(1.0F, 1.0F, 1.0F);
                GL11.glTranslatef((float) x, (float) y, (float) z);
                return;
            }
            case EAST:
            {
                GL11.glScalef(1.0F, 1.0F, 1.0F);
                GL11.glTranslatef((float) x, (float) y, (float) z + 1F);
                GL11.glRotatef(90F, 0F, 1F, 0F);
                return;
            }
            case WEST:
            {
                GL11.glScalef(1.0F, 1.0F, 1.0F);
                GL11.glTranslatef((float) x + 1.0F, (float) y, (float) z);
                GL11.glRotatef(-90F, 0F, 1F, 0F);
                return;
            }
            
            case UNKNOWN:{return;}
            
            default:{}
        }
    }
}

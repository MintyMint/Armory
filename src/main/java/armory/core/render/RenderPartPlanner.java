package armory.core.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import armory.core.ItemHelper;
import armory.lib.ArmoryRef;
import armory.tile_entity.PartPlannerDummyTE;
import cpw.mods.fml.client.FMLClientHandler;

public class RenderPartPlanner extends TileEntitySpecialRenderer
{
	public static final ResourceLocation plannerTexture = ArmoryRef.PART_PLANNER_TEXTURE;
	private IModelCustom plannerModel;
	
	public RenderPartPlanner()
	{
		plannerModel = AdvancedModelLoader.loadModel(ArmoryRef.PART_PLANNER_MODEL);
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float var8)
	{
		PartPlannerDummyTE dummyTE = (PartPlannerDummyTE) tileEntity;
		
        GL11.glPushMatrix();
  
            FMLClientHandler.instance().getClient().getTextureManager().bindTexture(plannerTexture);

            renderByOrientation(x, y, z, dummyTE.getOrientation());
            
            plannerModel.renderAll();

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
                GL11.glRotatef(90F, 0F, 1F, 0F);
                return;
            }
            case SOUTH:
            {
                GL11.glScalef(1.0F, 1.0F, 1.0F);
                GL11.glTranslatef((float) x, (float) y, (float) z);
                GL11.glRotatef(-90F, 0F, 1F, 0F);
                return;
            }
            case EAST:
            {
                GL11.glScalef(1.0F, 1.0F, 1.0F);
                GL11.glTranslatef((float) x, (float) y, (float) z + 1F);
                GL11.glRotatef(0F, 0F, 1F, 0F);
                return;
            }
            case WEST:
            {
                GL11.glScalef(1.0F, 1.0F, 1.0F);
                GL11.glTranslatef((float) x + 1.0F, (float) y, (float) z);
                GL11.glRotatef(180F, 0F, 1F, 0F);
                return;
            }
            
            case UNKNOWN:{return;}
            
            default:{}
        }
    }

}

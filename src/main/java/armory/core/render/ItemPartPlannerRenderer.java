package armory.core.render;

import org.lwjgl.opengl.GL11;

import armory.lib.ArmoryRef;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ItemPartPlannerRenderer implements IItemRenderer
{
	public static final ResourceLocation PART_PLANNER_MODEL = new ResourceLocation(ArmoryRef.MOD_ID, ArmoryRef.MODELS_LOCATION + "part_planner.obj");
	public static final ResourceLocation PART_PLANNER_TEXTURE = new ResourceLocation(ArmoryRef.MOD_ID, ArmoryRef.BLOCK_TEXTURE_LOCATION + "part_planner.png");
	
	private final IModelCustom partPlannerModel;
	
    public ItemPartPlannerRenderer()
    {
    	partPlannerModel = AdvancedModelLoader.loadModel(PART_PLANNER_MODEL);
    }

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
        switch (type)
        {
            case ENTITY:
            {
            	renderPartPlanner(-0.5F, 0F, 0.5F);
                return;
            }
            
            case EQUIPPED:
            {
            	GL11.glRotatef(-90, 0F, 1F, 0F);
            	renderPartPlanner(0F, 0F, 0F);
                return;
            }
            
            case EQUIPPED_FIRST_PERSON:
            {
            	GL11.glRotatef(180, 0F, 1F, 0F);
            	renderPartPlanner(-0.5F, 0.5F, -0.2F);
                return;
            }
            
            case INVENTORY:
            {
            	renderPartPlanner(-0.8F, -1F, 0.2F);
                return;
            }
            
            default:{ }
        }	
	}
	
    private void renderPartPlanner(float x, float y, float z)
    {
        GL11.glPushMatrix();

        GL11.glScalef(0.8F, 0.8F, 0.8F);
        GL11.glTranslatef(x, y, z);

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(PART_PLANNER_TEXTURE);

        partPlannerModel.renderAll();

        GL11.glPopMatrix();
    }
}
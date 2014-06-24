package armory.core.render;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import armory.lib.ArmoryRef;
import cpw.mods.fml.client.FMLClientHandler;

public class ItemSmithingFurnaceRenderer implements IItemRenderer
{
	private final IModelCustom furnaceModel;
	
    public ItemSmithingFurnaceRenderer()
    {
        furnaceModel = AdvancedModelLoader.loadModel(ArmoryRef.SMITHING_FURNACE_MODEL);
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
            	renderSmithingFurnace(0.5F, 0.5F, 0.5F);
                break;
            }
            
            case EQUIPPED:
            {
            	renderSmithingFurnace(1.0F, 1.0F, 1.0F);
                break;
            }
            
            case EQUIPPED_FIRST_PERSON:
            {
            	renderSmithingFurnace(1.0F, 1.0F, 1.0F);
                break;
            }
            
            case INVENTORY:
            {
            	renderSmithingFurnace(0.0F, 0.075F, 0.0F);
                break;
            }
            
            default: break;
        }	
	}
	
    private void renderSmithingFurnace(float x, float y, float z)
    {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);

        // Scale, Translate, Rotate
        GL11.glScalef(1F, 1F, 1F);
        GL11.glTranslatef(x, y, z);

        // Bind texture
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(ArmoryRef.SMITHING_FURNACE_TEXTURE);

        // Render
        furnaceModel.renderAll();

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }
}

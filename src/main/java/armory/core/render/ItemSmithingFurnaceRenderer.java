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
            	renderSmithingFurnace(-0.5F, 0.0F, -0.5F);
                return;
            }
            
            case EQUIPPED:
            {
            	renderSmithingFurnace(0F, 0f, 0F);
                return;
            }
            
            case EQUIPPED_FIRST_PERSON:
            {
            	GL11.glRotatef(-90, 0F, 1F, 0F);
            	renderSmithingFurnace(0F, 0.2F, -0.5F);
                return;
            }
            
            case INVENTORY:
            {
            	renderSmithingFurnace(-0.5F, -0.5F, -0.5F);
                return;
            }
            
            default:{ }
        }	
	}
	
    private void renderSmithingFurnace(float x, float y, float z)
    {
        GL11.glPushMatrix();

        GL11.glScalef(1F, 1F, 1F);
        GL11.glTranslatef(x, y, z);

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(ArmoryRef.SMITHING_FURNACE_TEXTURE);

        furnaceModel.renderAll();

        GL11.glPopMatrix();
    }
}

package armory.core;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class PartPlannerRecipeSorter implements Comparator
{
	final PartPlannerCraftingHandler partPlannerHandler;
	
	public PartPlannerRecipeSorter(PartPlannerCraftingHandler craftingHandler)
	{
		this.partPlannerHandler = craftingHandler;
	}
	
	public int compareRecipes(IRecipe recipe1, IRecipe recipe2)
	{
		if(recipe1 instanceof PartPlannerShapelessRecipes && recipe2 instanceof PartPlannerShapedRecipes){ return 1; }
		
		if(recipe2 instanceof PartPlannerShapelessRecipes && recipe1 instanceof PartPlannerShapedRecipes){ return -1; }
			
		if(recipe2.getRecipeSize() < recipe1.getRecipeSize()){ return -1; }
		
		if(recipe2.getRecipeSize() > recipe1.getRecipeSize()){ return 1; }
		
		else return 0;
	}

	@Override
	public int compare(Object recipe1, Object recipe2)
	{
		return this.compareRecipes((IRecipe)recipe1, (IRecipe)recipe2);
	}

}

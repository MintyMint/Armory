package armory.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import armory.Armory;
import armory.core.BlockHelper;
import armory.core.ItemHelper;
import armory.core.proxy.ClientProxy;
import armory.lib.ArmoryNames;
import armory.lib.ArmoryRef;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmoryOre extends ArmoryBlocks
{
	@SideOnly(Side.CLIENT)
	public IIcon lavaGlint;
	public IIcon oreGlint;
	public IIcon[] overlays = new IIcon[4];
	public String[] iconNames = { "obsidium_overlay", "azurite_overlay", "crimsonite_overlay", "titanium_overlay" };
	public int[] colors = { 0xFFFFFF, 0x123456, 0xFF0000, 0xFFFFFF };
	public int[] brightness = { 200, 225, 150, 0 };

	public float[] hardnesses = { 30f, 4f, 4f, 4.2f };
	public float[] resistances = { 1750f, 5.5f, 5.5f, 6f };

	public ArmoryOre()
	{
		this.setBlockName(ArmoryNames.Blocks.ORE_BLOCK_NAME);
		this.setCreativeTab(Armory.getCreativeTab());
		this.setStepSound(Block.soundTypeGravel);
		BlockHelper.registerBlocksWithMetadata(this, ItemBlockArmoryOre.class, "ore");
	}

	@Override
	public float getBlockHardness(World world, int x, int y, int z)
	{
		if (world.getBlockMetadata(x, y, z) <= this.hardnesses.length)
		{
			return this.hardnesses[world.getBlockMetadata(x, y, z)];
		}

		else return 0.1f;
	}

	@Override
	public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
	{
		if (world.getBlockMetadata(x, y, z) <= this.resistances.length)
		{
			return this.resistances[world.getBlockMetadata(x, y, z)];
		}

		else return 0.1f;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		lavaGlint = iconRegister.registerIcon(ArmoryRef.RESOURCES_PREFIX + "lava_glint");
		oreGlint = iconRegister.registerIcon(ArmoryRef.RESOURCES_PREFIX + "ore_glint");

		for (int count = 0; count < iconNames.length; count++)
		{ overlays[count] = iconRegister.registerIcon(ArmoryRef.RESOURCES_PREFIX + iconNames[count]); }
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		return overlays[meta];
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	{
		Random chance = new Random();
		ArrayList<ItemStack> itemDropped = new ArrayList<ItemStack>();
		ArrayList<ItemStack> possibleDropped = new ArrayList<ItemStack>();

		possibleDropped.add(new ItemStack(ItemHelper.oreChunks, 1, 0));
		possibleDropped.add(new ItemStack(ItemHelper.oreChunks, 1, 1));
		possibleDropped.add(new ItemStack(ItemHelper.oreChunks, 1, 2));
		possibleDropped.add(new ItemStack(ItemHelper.oreChunks, 1, 3));

		itemDropped.add(possibleDropped.get(metadata));

		return itemDropped;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public int getRenderType()
	{
		return ClientProxy.OreBlockRenderID;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int count = 0; count < 4; count++)
		{
			list.add(new ItemStack(item, 1, count));
		}
	}
}
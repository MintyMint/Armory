package armory.tile_entity;

import armory.lib.ArmoryNames;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class ArmoryTE extends TileEntity
{
    protected ForgeDirection orientation;
    protected byte state;
    protected String customName;
    protected String owner;

    public ArmoryTE()
    {
        if (orientation == null){orientation = ForgeDirection.SOUTH;}
        state = 0;
        customName = "";
        owner = "";
    }

    public ForgeDirection getOrientation()
    {
        return orientation;
    }

    public void setOrientation(ForgeDirection orientation)
    {
        this.orientation = orientation;
    }

    public void setOrientation(int orientation)
    {
        this.orientation = ForgeDirection.getOrientation(orientation);
    }

    public short getState()
    {
        return state;
    }

    public void setState(byte state)
    {
        this.state = state;
    }

    public boolean hasCustomName()
    {
        return customName != null && customName.length() > 0;
    }

    public String getCustomName()
    {
        return customName;
    }

    public void setCustomName(String customName)
    {
        this.customName = customName;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);

        if (nbtTagCompound.hasKey(ArmoryNames.NBT.DIRECTION))
        {
            this.orientation = ForgeDirection.getOrientation(nbtTagCompound.getByte(ArmoryNames.NBT.DIRECTION));
        }


        if (nbtTagCompound.hasKey(ArmoryNames.NBT.CUSTOM_NAME))
        {
            this.customName = nbtTagCompound.getString(ArmoryNames.NBT.CUSTOM_NAME);
        }

    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);

        nbtTagCompound.setByte(ArmoryNames.NBT.DIRECTION, (byte) orientation.ordinal());

        if (this.hasCustomName())
        {
            nbtTagCompound.setString(ArmoryNames.NBT.CUSTOM_NAME, customName);
        }
    }
}

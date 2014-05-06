package armory.tile_entity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import armory.lib.ArmoryNames;

public class ArmoryTE extends TileEntity
{
    protected ForgeDirection orientation;
    protected String customName;

    public ArmoryTE()
    {
    	orientation = ForgeDirection.SOUTH;
        customName = "";

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
    
    @Override
    public Packet getDescriptionPacket ()
    {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }
    
    @Override
    public void onDataPacket (NetworkManager net, S35PacketUpdateTileEntity packet)
    {
        readFromNBT(packet.func_148857_g());
    }
}

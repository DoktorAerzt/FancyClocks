package de.empty2k12.fancyclocks.common.block.tile;

import de.empty2k12.fancyclocks.common.misc.ModInfo;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import java.util.Calendar;

public class TileDoubleClock extends TileEntity {

	private int orientation = 0;
	private static int oldSeconds;
	private static int oldMinutes;
	private static int oldHours;
	private boolean silent = false;
	private static boolean hasPower = true;

	private static Calendar calendar;

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.silent = compound.getBoolean("silent");
        this.hasPower = compound.getBoolean("hasPower");
		this.orientation = compound.getInteger("orientation");
        this.oldSeconds = compound.getInteger("oldSeconds");
        this.oldMinutes = compound.getInteger("oldMinutes");
        this.oldHours = compound.getInteger("oldHours");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setBoolean("silent", silent);
        compound.setBoolean("hasPower", hasPower);
		compound.setInteger("orientation", orientation);
        compound.setInteger("oldSeconds", oldSeconds);
        compound.setInteger("oldMinutes", oldMinutes);
        compound.setInteger("oldHours", oldHours);
	}

	@Override
	public void updateEntity() {
		calendar = Calendar.getInstance();
		if(oldSeconds != calendar.get(Calendar.SECOND) && hasPower) {
			oldSeconds = calendar.get(Calendar.SECOND);
            if(calendar.get(Calendar.MINUTE) == 0) {
                for(int times = 0; times < calendar.get(Calendar.MINUTE); times++) {
                    if(oldSeconds != calendar.get(Calendar.SECOND)) {
                        getWorldObj().playSound(xCoord, yCoord, zCoord, ModInfo.MOD_ID + ":" + "full_hour_gong", 1F, 1F, true);
                    }

                }
            } else {
                if(!silent) {
                    getWorldObj().playSound(xCoord, yCoord, zCoord, ModInfo.MOD_ID + ":" + "clock_tick", 1F, 1F, true);
                }
            }
		}
	}

	public static int getRotationFromSeconds() {
		if (hasPower) {
			oldSeconds = calendar.get(Calendar.SECOND);
			return calendar == null ? 0 : calendar.get(Calendar.SECOND) * 6;
		} else {
			return oldSeconds * 6;
		}
		
	}

	public static int getRotationFromMinutes() {
		if (hasPower) {
			oldMinutes = calendar.get(Calendar.MINUTE);
			return calendar == null ? 0 : calendar.get(Calendar.MINUTE) * 6;
		} else {
			return oldMinutes * 6;
		}
		
	}

	public static int getRotationFromHours() {
		if (hasPower) {
			oldHours = calendar.get(Calendar.HOUR_OF_DAY);
			return calendar == null ? 0 : (calendar.get(Calendar.HOUR_OF_DAY) * 30 + calendar.get(Calendar.MINUTE) / 6);
		} else {
			return oldHours * 30 + oldMinutes / 6;
		}
		
	}

	public void toggleSounds() {
		if(silent) {
			silent = false;
		} else {
			silent = true;
		}
	}

	public boolean getSilent() {
		return silent;
	}

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}

}

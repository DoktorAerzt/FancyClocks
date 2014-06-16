package de.empty2k12.fancyclocks.common.block.tile;

import java.util.Calendar;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import de.empty2k12.fancyclocks.common.misc.ModInfo;

public class TileClock extends TileEntity {

	private int orientation = 0;
	private static int oldSeconds;
	private boolean silent = false;

	private static Calendar calendar;

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.silent = compound.getBoolean("silent");
		this.orientation = compound.getInteger("orientation");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setBoolean("silent", silent);
		compound.setInteger("orientation", orientation);
	}

	@Override
	public void updateEntity() {
		calendar = Calendar.getInstance();
		if(oldSeconds != calendar.get(Calendar.SECOND)) {
			oldSeconds = calendar.get(Calendar.SECOND);
			if(!silent) {
				getWorldObj().playSound(xCoord, yCoord, zCoord, ModInfo.MOD_ID + ":" + "clock_tick", 1F, 1F, true);
			}
		}
	}

	public static int getRotationFromSeconds() {
		return calendar == null ? 0 : calendar.get(Calendar.SECOND) * 6;
	}

	public static int getRotationFromMinutes() {
		return calendar == null ? 0 : calendar.get(Calendar.MINUTE) * 6;
	}

	public static int getRotationFromHours() {
		return calendar == null ? 0 : (calendar.get(Calendar.HOUR_OF_DAY) * 30 + calendar.get(Calendar.MINUTE) / 6);
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

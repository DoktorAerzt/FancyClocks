package de.empty2k12.fancyclocks.common.block.tile;

import java.util.Calendar;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import de.empty2k12.fancyclocks.common.misc.ModInfo;

public class TileModernClock extends TileEntity {

	private static int oldSeconds;

	private boolean silent = false;

	private static Calendar calendar;

	public TileModernClock() {
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		this.silent = compound.getBoolean("silent");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		compound.setBoolean("silent", silent);
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
}

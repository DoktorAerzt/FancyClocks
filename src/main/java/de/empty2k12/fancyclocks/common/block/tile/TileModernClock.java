package de.empty2k12.fancyclocks.common.block.tile;

import java.util.Calendar;
import java.util.TimeZone;

import de.empty2k12.fancyclocks.client.misc.SoundHandler;
import de.empty2k12.fancyclocks.common.misc.ModInfo;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileModernClock extends TileEntity {

	private static int oldSeconds;

	private boolean silent = false;
	public boolean dummy = false;

	private static Calendar calendar;

	public TileModernClock(boolean dummy) {
		this.dummy = dummy;
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
		calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Berlin"));
		if(oldSeconds != calendar.get(Calendar.SECOND)) {
			oldSeconds = calendar.get(Calendar.SECOND);
			if(!silent) {
				getWorldObj().playSound(xCoord, yCoord, zCoord, ModInfo.MOD_ID + ":" + "clock_tick", 1F, 1F, true);
			}
		}
	}

	public static int getRotationFromSeconds() {
		return calendar == null ? 0 : calendar.get(Calendar.SECOND)*6;
	}

	public static int getRotationFromMinutes() {
		return calendar == null ? 0 : calendar.get(Calendar.MINUTE)*6;
	}

	public static int getRotationFromHours() {
		return calendar == null ? 0 : (calendar.get(Calendar.HOUR_OF_DAY)*30 + calendar.get(Calendar.MINUTE)/6);
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

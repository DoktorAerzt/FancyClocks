package de.empty2k12.fancyclocks.common.block.tile;

import de.empty2k12.fancyclocks.common.misc.ModInfo;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import java.util.Calendar;

public class TileModernClock extends TileEntity {

	private static int oldSeconds;
	private static int oldMinutes;
	private static int oldHours;
	private boolean silent = false;
	private static boolean haspower = true;

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
		if(oldSeconds != calendar.get(Calendar.SECOND) && haspower) {
			oldSeconds = calendar.get(Calendar.SECOND);
			if(!silent) {
				getWorldObj().playSound(xCoord, yCoord, zCoord, ModInfo.MOD_ID + ":" + "clock_tick", 1F, 1F, true);
			}
		}
	}

	public static int getRotationFromSeconds() {
		if (haspower) {
			oldSeconds = calendar.get(calendar.SECOND);
			return calendar == null ? 0 : calendar.get(Calendar.SECOND) * 6;
		} else {
			return oldSeconds * 6;
		}
		
	}

	public static int getRotationFromMinutes() {
		if (haspower) {
			oldMinutes = calendar.get(Calendar.MINUTE);
			return calendar == null ? 0 : calendar.get(Calendar.MINUTE) * 6;
		} else {
			return oldMinutes * 6;
		}
		
	}

	public static int getRotationFromHours() {
		if (haspower) {
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
}

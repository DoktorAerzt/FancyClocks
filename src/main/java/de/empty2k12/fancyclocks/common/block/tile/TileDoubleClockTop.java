package de.empty2k12.fancyclocks.common.block.tile;

import java.util.Calendar;
import java.util.TimeZone;

import de.empty2k12.fancyclocks.common.misc.ModInfo;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileDoubleClockTop extends TileEntity {

	public int direction;

	public int rotationForPendel;

	private static int oldSeconds;

	private boolean silent = true; //XXX: change back its just for development

	private static Calendar calendar;

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		this.direction = compound.getInteger("direction");
		this.silent = compound.getBoolean("silent");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		compound.setInteger("direction", direction);
		compound.setBoolean("silent", silent);
	}

	@Override
	public void updateEntity() {
		calculatePendelRotation();
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
		return calendar == null ? 0 : calendar.get(Calendar.HOUR_OF_DAY)*30;
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
	
	public void calculatePendelRotation() {
		if(rotationForPendel == 10) {
			rotationForPendel = 9;
		} else if(rotationForPendel == 9) {
			rotationForPendel = 8;
		} else if(rotationForPendel == 8) {
			rotationForPendel = 7;
		} else if(rotationForPendel == 7) {
			rotationForPendel = 6;
		} else if(rotationForPendel == 6) {
			rotationForPendel = 5;
		} else if(rotationForPendel == 5) {
			rotationForPendel = 4;
		} else if(rotationForPendel == 4) {
			rotationForPendel = 3;
		} else if(rotationForPendel == 3) {
			rotationForPendel = 2;
		} else if(rotationForPendel == 2) {
			rotationForPendel = 1;
		}
	}

}

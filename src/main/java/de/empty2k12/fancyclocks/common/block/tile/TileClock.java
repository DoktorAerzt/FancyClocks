package de.empty2k12.fancyclocks.common.block.tile;

import java.util.Calendar;
import java.util.TimeZone;

import de.empty2k12.fancyclocks.client.misc.SoundHandler;
import de.empty2k12.fancyclocks.common.misc.ModInfo;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileClock extends TileEntity {

	static int oldSeconds;

	private boolean silent;
	
	private static Calendar calendar;
	
	public TileClock() {
		calendar = Calendar.getInstance();
		calendar.setTimeZone(TimeZone.getTimeZone("Berlin"));
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
		if(oldSeconds != Calendar.getInstance().get(Calendar.SECOND)) {
			oldSeconds = Calendar.getInstance().get(Calendar.SECOND);
			if(!silent) {
				getWorldObj().playSound(xCoord, yCoord, zCoord, ModInfo.MOD_ID + ":" + "clock_tick", 1F, 1F, true);
			}
		}
	}

	public static int getRotationFromSeconds() {
		return calendar.get(Calendar.SECOND)*6;
	}

	public static int getRotationFromMinutes() {
		return calendar.getInstance().get(Calendar.MINUTE)*6;
	}

	public static int getRotationFromHours() {
		return calendar.getInstance().get(Calendar.HOUR)*15;
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

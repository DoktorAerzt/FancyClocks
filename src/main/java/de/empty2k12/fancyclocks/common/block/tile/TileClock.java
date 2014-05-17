package de.empty2k12.fancyclocks.common.block.tile;

import java.util.Calendar;

import de.empty2k12.fancyclocks.client.misc.SoundHandler;
import de.empty2k12.fancyclocks.common.misc.ModInfo;
import net.minecraft.tileentity.TileEntity;

public class TileClock extends TileEntity {

	static int oldSeconds;

	//TODO: save these!
	private boolean silent;

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
		return Calendar.getInstance().get(Calendar.SECOND)*6;
	}

	public static int getRotationFromMinutes() {
		return Calendar.getInstance().get(Calendar.MINUTE)*6;
	}

	public static int getRotationFromHours() {
		return Calendar.getInstance().get(Calendar.HOUR)*15;
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

	/*
	 * Once around = 360°
	 * one minute = 60 secs
	 * 360/60
	 * dangit that was eZZZZ :)
	 * */
}

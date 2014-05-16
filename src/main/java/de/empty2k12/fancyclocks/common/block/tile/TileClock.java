package de.empty2k12.fancyclocks.common.block.tile;

import java.util.Calendar;

import net.minecraft.tileentity.TileEntity;

public class TileClock extends TileEntity {
	
	int oldSeconds;

	public static int getRotationFromSeconds() {
		return Calendar.getInstance().get(Calendar.SECOND)*6;
	}
	
	public static int getRotationFromMinutes() {
		return Calendar.getInstance().get(Calendar.MINUTE)*6;
	}
	
	public static int getRotationFromHours() {
		return Calendar.getInstance().get(Calendar.HOUR)*15;
	}
	
	/*
	 * Once around = 360°
	 * one minute = 60 secs
	 * 360/60
	 * dangit that was eZZZZ :)
	 * */
}

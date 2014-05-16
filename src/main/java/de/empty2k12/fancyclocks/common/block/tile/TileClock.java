package de.empty2k12.fancyclocks.common.block.tile;

import java.util.Calendar;

import net.minecraft.tileentity.TileEntity;

public class TileClock extends TileEntity {

	public static int getRotationFromSeconds() {
		return (int)(90*Math.cos(Math.toRadians(Calendar.getInstance().get(Calendar.SECOND)*6-90)));
	}
	
}

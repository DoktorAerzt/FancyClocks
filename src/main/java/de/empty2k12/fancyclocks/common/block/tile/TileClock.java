package de.empty2k12.fancyclocks.common.block.tile;

import java.util.Calendar;

import net.minecraft.tileentity.TileEntity;

public class TileClock extends TileEntity {
	
	int secondsRotation;
	
	Calendar calendar;
	
	public TileClock() {
		calendar = Calendar.getInstance();
	}
	
	@Override
	public void updateEntity() {
		secondsRotation = getRotationFromSeconds();
	}
	
	public int getRotationFromSeconds() {
		return (int) (calendar.get(Calendar.SECOND) * Math.PI);
	}

}

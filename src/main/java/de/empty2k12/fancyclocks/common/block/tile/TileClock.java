package de.empty2k12.fancyclocks.common.block.tile;

import net.minecraft.tileentity.TileEntity;

public class TileClock extends TileEntity {
	
	int secondsRotation;
	
	@Override
	public void updateEntity() {
		secondsRotation = getRotationFromSeconds();
	}
	
	public int getRotationFromSeconds() {
		
	}

}

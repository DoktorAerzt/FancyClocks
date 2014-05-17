package de.empty2k12.fancyclocks.common.block.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileDoubleClockTop extends TileEntity {
	
	public int direction;
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		this.direction = compound.getInteger("direction");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		compound.setInteger("direction", direction);
	}

}

package de.empty2k12.fancyclocks.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public interface IScrewdriveable {

	public void onScrewDriveTurn(EntityPlayer player, World world, int x, int y, int z);
	
}

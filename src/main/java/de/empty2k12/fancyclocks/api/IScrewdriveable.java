package de.empty2k12.fancyclocks.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Used to identify a block that is capable of handling a whack with the Screwdriver
 *
 */
public interface IScrewdriveable {
	
	/**
	 * 
	 * @param player The player, that uses the item
	 * @param world The world the player is in
	 * @param x x-Coordinate
	 * @param y y-Coordinate
	 * @param z z-Coordinate
	 */

	public void onScrewDriveTurn(EntityPlayer player, World world, int x, int y, int z);
	
}

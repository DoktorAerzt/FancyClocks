package de.empty2k12.fancyclocks.client.misc;

import de.empty2k12.fancyclocks.common.misc.ModInfo;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class SoundHandler {
	
	public static void playAtClock(String filename, World world, int x, int y, int z, float vol, float pitch) {
		world.playSound(x, y, z, ModInfo.MOD_ID + ":" + filename, vol, pitch, true);
	}

}

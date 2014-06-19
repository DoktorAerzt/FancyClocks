package de.empty2k12.fancyclocks.common.misc;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import de.empty2k12.fancyclocks.common.block.ClockBlocks;
import de.empty2k12.fancyclocks.common.item.ClockItems;

public class Recipes {

	public static void registerRecipes() {

		//TODO: Recipes using oreDict
		GameRegistry.addRecipe(new ItemStack(ClockBlocks.modern_clock, 1), "sss", "sos", "sss", 'o', new ItemStack(Items.clock, 1), 's', new ItemStack(Blocks.stone));
		GameRegistry.addRecipe(new ItemStack(ClockItems.screwdriver, 1), "l", "l", "x", 'x', new ItemStack(Items.iron_ingot, 1), 'l', new ItemStack(Items.stick));

		for(int i = 0; i < 6; i++) {
			GameRegistry.addRecipe(new ItemStack(ClockBlocks.clock, 1, i),
					"xox",
					"xlx",
					"xix",
					'x', new ItemStack(Blocks.planks, 1, i),
					'o', new ItemStack(Items.clock, 1),
					'l', new ItemStack(Items.stick),
					'i', new ItemStack(Items.iron_ingot, 1));
		}

		for(int i = 0; i < 6; i++) {
			GameRegistry.addRecipe(new ItemStack(ClockBlocks.clock_bottom, 1, i),
					"x",
					"x",
					'x', new ItemStack(ClockBlocks.clock, 1, i));
		}

	}

}

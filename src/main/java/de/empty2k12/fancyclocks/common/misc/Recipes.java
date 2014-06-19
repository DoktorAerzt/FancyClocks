package de.empty2k12.fancyclocks.common.misc;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import de.empty2k12.fancyclocks.common.block.ClockBlocks;
import de.empty2k12.fancyclocks.common.item.ClockItems;

public class Recipes {

	public static void registerRecipes() {

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ClockBlocks.modern_clock, 1), "sss", "sos", "sss", 'o', new ItemStack(Items.clock, 1), 's', new ItemStack(Blocks.stone)));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ClockItems.screwdriver, 1), "l", "l", "x", 'x', new ItemStack(Items.iron_ingot, 1), 'l', "stickWood"));


		//Wooden Clock
		for(int i = 0; i < 6; i++) {
			GameRegistry.addRecipe(
					new ShapedOreRecipe(
							new ItemStack(ClockBlocks.clock, 1, i),
							"xox",
							"xlx",
							"xix",
							'x', new ItemStack(Blocks.planks, 1, i),
							'o', new ItemStack(Items.clock, 1),
							'l', new ItemStack(Items.stick),
							'i', new ItemStack(Items.iron_ingot, 1)));
		}

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ClockBlocks.clock, 1),
						"xox",
						"xlx",
						"xix",
						'x', "plankWood",
						'o', new ItemStack(Items.clock, 1),
						'l', "stickWood",
						'i', new ItemStack(Items.iron_ingot, 1)));


		//DoubleClock
		for(int i = 0; i < 6; i++) {
			GameRegistry.addRecipe(
					new ShapedOreRecipe(
							new ItemStack(ClockBlocks.clock_bottom, 1, i),
							"x",
							"x",
							'x', new ItemStack(ClockBlocks.clock, 1, i)));
		}

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ClockBlocks.clock_bottom, 1),
						"x",
						"x",
						'x', new ItemStack(ClockBlocks.clock, 1, OreDictionary.WILDCARD_VALUE)));

	}

}

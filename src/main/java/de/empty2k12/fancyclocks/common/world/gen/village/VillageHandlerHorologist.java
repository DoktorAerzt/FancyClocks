package de.empty2k12.fancyclocks.common.world.gen.village;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.StructureVillagePieces.PieceWeight;
import net.minecraft.world.gen.structure.StructureVillagePieces.Start;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageCreationHandler;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class VillageHandlerHorologist implements IVillageCreationHandler, IVillageTradeHandler {

	public static final int HOROLOGIST_ID = 11;

	@Override
	public PieceWeight getVillagePieceWeight(Random random, int i) {
		return new StructureVillagePieces.PieceWeight(ComponentHorologistsShop.class, 4, 2);
	}

	@Override
	public Class<?> getComponentClass() {
		return ComponentHorologistsShop.class;
	}

	@Override
	public Object buildComponent(PieceWeight villagePiece, Start startPiece, List pieces, Random random, int p1, int p2, int p3, int p4, int p5) {
		return ComponentHorologistsShop.buildComponent(startPiece, pieces, random, p1, p2, p3, p4, p5);
	}

	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
		if(villager.getProfession() == 1) { /*FIXME*/
			recipeList.add(new MerchantRecipe(
					new ItemStack(Items.potionitem, 3, 16), // Awkward potion 
					new ItemStack(Items.emerald, 2)));
			recipeList.add(new MerchantRecipe(
					new ItemStack(Items.emerald, 1),
					new ItemStack(Items.potionitem, 2, 33))); // night vision
			recipeList.add(new MerchantRecipe(
					new ItemStack(Items.emerald, 1),
					new ItemStack(Items.baked_potato, 32)));
			recipeList.add(new MerchantRecipe(
					new ItemStack(Items.emerald, 1),
					new ItemStack(Items.magma_cream, 6)));
			recipeList.add(new MerchantRecipe(
					new ItemStack(Items.bone, 12),
					new ItemStack(Items.emerald,1)));
			recipeList.add(new MerchantRecipe(
					new ItemStack(Items.redstone, 12),
					new ItemStack(Items.emerald,1)));
			recipeList.add(new MerchantRecipe(
					new ItemStack(Items.blaze_powder, 12),
					new ItemStack(Items.emerald, 1)));
		}

	}

}

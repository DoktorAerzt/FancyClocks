package de.empty2k12.fancyclocks.common.world.gen.village;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.StructureVillagePieces.PieceWeight;
import net.minecraft.world.gen.structure.StructureVillagePieces.Start;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageCreationHandler;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;
import de.empty2k12.fancyclocks.FancyClocks;
import de.empty2k12.fancyclocks.common.item.ClockItems;
import de.empty2k12.fancyclocks.common.misc.Config;
import de.empty2k12.fancyclocks.common.misc.ModInfo;

public class VillageHandlerHorologist implements IVillageCreationHandler, IVillageTradeHandler {

	public static final int HOROLOGIST_ID = 11;

	@Override
	public PieceWeight getVillagePieceWeight(Random random, int i) {
		return new StructureVillagePieces.PieceWeight(ComponentHorologistsShop.class, 1, 2);
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
		if(villager.getProfession() == VillageHandlerHorologist.HOROLOGIST_ID) {
			recipeList.add(new MerchantRecipe(
					new ItemStack(Items.emerald, 3),
					new ItemStack(Items.clock, 1)));
			recipeList.add(new MerchantRecipe(
					new ItemStack(Items.emerald, 1),
					new ItemStack(ClockItems.screwdriver, 1)));

			//TODO: More Trades!
		}
	}

	public static final void init() {
		if(Config.ENABLE_HOROLOGIST) {
			MapGenStructureIO.func_143031_a(ComponentHorologistsShop.class, "horologistsShop");
			VillagerRegistry.instance().registerVillageCreationHandler(new VillageHandlerHorologist());

			VillageHandlerHorologist horologist = new VillageHandlerHorologist();
			VillagerRegistry.instance().registerVillageTradeHandler(VillageHandlerHorologist.HOROLOGIST_ID, horologist);
			
			FancyClocks.proxy.setupVillagers();
		}
	}
}

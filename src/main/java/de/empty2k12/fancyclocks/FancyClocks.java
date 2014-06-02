package de.empty2k12.fancyclocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import de.empty2k12.fancyclocks.common.block.ClockBlocks;
import de.empty2k12.fancyclocks.common.item.ClockItems;
import de.empty2k12.fancyclocks.common.misc.ModInfo;
import de.empty2k12.fancyclocks.common.misc.TabFancyClocks;
import de.empty2k12.fancyclocks.common.proxy.CommonProxy;
import de.empty2k12.fancyclocks.common.world.gen.village.ComponentClockShop;
import de.empty2k12.fancyclocks.common.world.gen.village.VillageCreationHandler;

@Mod(modid = ModInfo.MOD_ID, version = ModInfo.MOD_NAME)
public class FancyClocks {

	@Instance(ModInfo.MOD_ID)
	public static FancyClocks instance;

	@SidedProxy(clientSide = ModInfo.CLIENT_PROXY, serverSide = ModInfo.COMMON_PROXY)
	public static CommonProxy proxy;

//	public static Achievement timeMaster;
//	public static Achievement advancedTimeMaster;

	public static CreativeTabs tabFancyClocks = new TabFancyClocks("FancyClocks");

	//TODO: everything from my todo list!

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ClockBlocks.init();
		ClockItems.init();
		proxy.registerRenderers();
		addRecipes();
//		addAchievements();

		MapGenStructureIO.func_143031_a(ComponentClockShop.class, "clockShop");
		VillagerRegistry.instance().registerVillageCreationHandler(new VillageCreationHandler());
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
//		FMLCommonHandler.instance().bus().register(this); 
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}

	public static void addRecipes() {
		GameRegistry.addRecipe(new ItemStack(ClockBlocks.clock_bottom, 1), "x", "x", 'x', new ItemStack(ClockBlocks.clock, 1));
		GameRegistry.addRecipe(new ItemStack(ClockBlocks.clock, 1), "xox", "xlx", "xix", 'x', new ItemStack(Blocks.planks, 1), 'o', new ItemStack(Items.clock, 1), 'l', new ItemStack(Items.stick), 'i', new ItemStack(Items.iron_ingot, 1));
		GameRegistry.addRecipe(new ItemStack(ClockBlocks.clock, 1), "sss", "sos", "sss", 'o', new ItemStack(Items.clock, 1), 's', new ItemStack(Blocks.stone));
		GameRegistry.addRecipe(new ItemStack(ClockItems.screwdriver, 1), "l", "l", "x", 'x', new ItemStack(Items.iron_ingot, 1), 'l', new ItemStack(Items.stick));
	}

//	public static void addAchievements() {
//		timeMaster = new Achievement("timeMaster", "timeMaster", 1, 1, ClockBlocks.clock, null);
//	}
//
//	@SubscribeEvent
//	public void onCrafting(PlayerEvent.ItemCraftedEvent event) {
//		if(event.crafting == new ItemStack(ClockBlocks.clock)) {
//			event.player.addStat(timeMaster, 50);
//		}
//	}
}

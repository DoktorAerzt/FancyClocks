package de.empty2k12.fancyclocks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import de.empty2k12.fancyclocks.common.block.ClockBlocks;
import de.empty2k12.fancyclocks.common.item.ClockItems;
import de.empty2k12.fancyclocks.common.misc.Config;
import de.empty2k12.fancyclocks.common.misc.ModInfo;
import de.empty2k12.fancyclocks.common.misc.Recipes;
import de.empty2k12.fancyclocks.common.misc.TabFancyClocks;
import de.empty2k12.fancyclocks.common.proxy.CommonProxy;
import de.empty2k12.fancyclocks.common.world.gen.village.VillageHandlerHorologist;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

@Mod(modid = ModInfo.MOD_ID, version = ModInfo.MOD_VERSION, name = ModInfo.MOD_NAME)
public class FancyClocks {

	@Instance(ModInfo.MOD_ID)
	public static FancyClocks instance;

	@SidedProxy(clientSide = ModInfo.CLIENT_PROXY, serverSide = ModInfo.COMMON_PROXY)
	public static CommonProxy proxy;

	public static CreativeTabs tabFancyClocks = new TabFancyClocks("FancyClocks");

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Config.init(event.getSuggestedConfigurationFile());
		ClockBlocks.init();
		ClockItems.init();
		VillageHandlerHorologist.init();
		FancyClocks.init();
	}

	public static void init() {
		proxy.registerRenderers();
		Recipes.registerRecipes();
	}
}

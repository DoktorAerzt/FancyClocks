package de.empty2k12.fancyclocks;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import de.empty2k12.fancyclocks.common.block.ClockBlocks;
import de.empty2k12.fancyclocks.common.item.ClockItems;
import de.empty2k12.fancyclocks.common.misc.ModInfo;
import de.empty2k12.fancyclocks.common.proxy.CommonProxy;

@Mod(modid = ModInfo.MOD_ID, version = ModInfo.MOD_NAME)
public class FancyClocks {
	
	@Instance(ModInfo.MOD_ID)
	public static FancyClocks instance;
	
	@SidedProxy(clientSide = ModInfo.CLIENT_PROXY, serverSide = ModInfo.COMMON_PROXY)
	public static CommonProxy proxy;
	
	//TODO: Config
	//TODO: everything from my todo list!
	//TODO: creative tab
	//TODO: Archievements after addng recipes!
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ClockBlocks.init();
		ClockItems.init();
		proxy.registerRenderers();
		addRecipes();
	}
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
		
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }
    
    public static void addRecipes() {
    	GameRegistry.addRecipe(new ItemStack(ClockBlocks.clock_bottom, 1), "x", "x", 'x', new ItemStack(ClockBlocks.clock, 1));
    	GameRegistry.addRecipe(new ItemStack(ClockBlocks.clock, 1), "xox", "xlx", "xix", 'x', new ItemStack(Blocks.planks, 1), 'o', new ItemStack(Items.clock, 1), 'l', new ItemStack(Items.stick), 'i', new ItemStack(Items.iron_ingot, 1));
    }
    
}

package de.empty2k12.fancyclocks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import de.empty2k12.fancyclocks.common.block.Blocks;
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
	
	//nothing to show i am modeling!
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.registerRenderers();
		Blocks.init();
	}
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
		
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }
    
}

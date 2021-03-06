package de.empty2k12.fancyclocks.common.item.items;

import de.empty2k12.fancyclocks.FancyClocks;
import de.empty2k12.fancyclocks.api.IClockScrewdriver;
import de.empty2k12.fancyclocks.api.IScrewdriveable;
import de.empty2k12.fancyclocks.common.misc.ModInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemScrewdriver extends Item implements IClockScrewdriver {
	
	public ItemScrewdriver() {
		setCreativeTab(FancyClocks.tabFancyClocks);
		setFull3D();
		setMaxDamage(-1);
		setMaxStackSize(1);
		setTextureName(ModInfo.MOD_ID + ":" + "screwdriver");
		setUnlocalizedName("screwdriver");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if(world.getBlock(x, y, z) instanceof IScrewdriveable) {
			((IScrewdriveable)world.getBlock(x, y, z)).onScrewDriveTurn(player, world, x, y, z);
			return true;
		}
		return false;
	}
}

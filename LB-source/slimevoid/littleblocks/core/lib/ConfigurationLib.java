package slimevoid.littleblocks.core.lib;

import net.minecraftforge.common.Configuration;
import slimevoid.littleblocks.core.LBCore;
import slimevoid.littleblocks.core.LoggerLittleBlocks;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ConfigurationLib {
	
	@SideOnly(Side.CLIENT)
	public static void ClientConfig() {
		
	}
	
	public static void CommonConfig() {
		LBCore.configuration.load();
		LBCore.littleChunkID = LBCore.configuration.get(
				Configuration.CATEGORY_BLOCK,
				"littleChunkID",
				1150).getInt();
		LBCore.littleBlocksWandID = LBCore.configuration.get(
				Configuration.CATEGORY_ITEM,
				"littleBlocksWandID",
				29999).getInt();
		LBCore.littleBlocksCollectionID = LBCore.configuration.get(
				Configuration.CATEGORY_GENERAL,
				"littleBlocksCollectionID",
				EntityRegistry.findGlobalUniqueEntityId()).getInt();
		LBCore.littleBlocksClip = LBCore.configuration.get(
				Configuration.CATEGORY_GENERAL,
				"littleBlocksClip",
				true).getBoolean(true);
		LBCore.littleBlocksForceUpdate = LBCore.configuration.get(
				Configuration.CATEGORY_GENERAL,
				"littleBlocksForceUpdate",
				false).getBoolean(false);
		LBCore.renderingMethod = LBCore.configuration.get(
				Configuration.CATEGORY_GENERAL,
				"renderingMethod",
				0).getInt();
		LBCore.renderType = RenderingRegistry.getNextAvailableRenderId();
		LBCore.loggerLevel = LBCore.configuration.get(
				Configuration.CATEGORY_GENERAL,
				"loggerLevel",
				"INFO").getString();
		LBCore.configuration.save();
		LoggerLittleBlocks.getInstance("LittleBlocksConfig").setFilterLevel(LBCore.loggerLevel);
	}

}

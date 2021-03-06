package com.jtrent238.hammermod;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.jtrent238.hammermod.command.CommandAbilities;
import com.jtrent238.hammermod.command.CommandChangelog;
import com.jtrent238.hammermod.common.CommonProxy;
import com.jtrent238.hammermod.items.hammers.ItemBaseHammer;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid=HammerMod.MODID, name=HammerMod.MODNAME, version=(HammerMod.MODVERSION))
public class HammerMod
{

	
	@SidedProxy(clientSide="com.jtrent238.hammermod.client.ClientProxy", serverSide="com.jtrent238.hammermod.common.CommonProxy")
	public static CommonProxy proxy;
	
	
	public static final String MODID = "hammermod";

	@Instance(MODID)
    public static HammerMod instance;
	public static final String MODVERSION = "1.1.3.10";
	public static final String MODNAME = "jtrent238's Hammer Mod";
	public static final String MODAUTHOR = "jtrent238";
	public static final String MC = "1.7.10";

	public static final int numHammers = 119;
	
	private PlayerLoggedInEvent username;


	public static boolean CUSTOM_HAMMER_1_ENCHANT_GLINT;
	public static boolean CUSTOM_HAMMER_1;
	public static Property CUSTOM_HAMMER_1_NAME;
	public static Object CUSTOM_HAMMER_1_TOOLMATERIAL;
	public static Property CUSTOM_HAMMER_1_TEXTURE;
	public static Property CUSTOM_HAMMER_DESC_1;
	public static Property CUSTOM_HAMMER_1_LANG_NAME;
	public static Property CUSTOM_HAMMER_1_MATERIALMODIFIER;
	public static Property CUSTOM_HAMMER_1_CRAFT;
	
	public static boolean SMASH_BREAK_SOUND;
	public static boolean TOASTER_BREAK_SOUND;
	public static boolean RANDOM_TOAST;
	public static boolean SHARP_TOAST;
	public static boolean DEBUG_MODE;
	public static boolean RAINBOWCRAFT;
	public static boolean DISABLE_ALL_HAMMER;
	
	public static boolean WOOD_HAMMER_ENABLE;
	public static boolean STONE_HAMMER_ENABLE;
	public static boolean IRON_HAMMER_ENABLE;
	public static boolean GOLD_HAMMER_ENABLE;
	public static boolean DIAMOND_HAMMER_ENABLE;
	public static boolean DIRT_HAMMER_ENABLE;
	public static boolean GLASS_HAMMER_ENABLE;
	public static boolean SAND_HAMMER_ENABLE;
	public static boolean CACTUS_HAMMER_ENABLE;
	public static boolean GRAVEL_HAMMER_ENABLE;
	public static boolean WOOL_WHITE_HAMMER_ENABLE;
	public static boolean EMERALD_HAMMER_ENABLE;
	public static boolean GRASS_HAMMER_ENABLE;
	public static boolean OBISIDIAN_HAMMER_ENABLE;
	public static boolean GLOWSTONE_HAMMER_ENABLE;
	public static boolean REDSTONE_HAMMER_ENABLE;
	public static boolean LAPIZ_HAMMER_ENABLE;
	public static boolean NETHERRACK_HAMMER_ENABLE;
	public static boolean SOULSAND_HAMMER_ENABLE;
	public static boolean COAL_HAMMER_ENABLE;
	public static boolean CHARCOAL_HAMMER_ENABLE;
	public static boolean ENDSTONE_HAMMER_ENABLE;
	public static boolean BONE_HAMMER_ENABLE;
	public static boolean SPONGE_HAMMER_ENABLE;
	public static boolean BRICK_HAMMER_ENABLE;
	public static boolean SUGAR_HAMMER_ENABLE;
	public static boolean PUMPKIN_HAMMER_ENABLE;
	public static boolean POTATO_HAMMER_ENABLE;
	public static boolean CARROT_HAMMER_ENABLE;
	public static boolean APPLE_HAMMER_ENABLE;
	public static boolean ICE_HAMMER_ENABLE;
	public static boolean PACKEDICE_HAMMER_ENABLE;
	public static boolean CAKE_HAMMER_ENABLE;
	public static boolean DRAGONEGG_HAMMER_ENABLE;
	public static boolean TNT_HAMMER_ENABLE;
	public static boolean BEDROCK_HAMMER_ENABLE;
	public static boolean PIG_HAMMER_ENABLE;
	public static boolean COW_HAMMER_ENABLE;
	public static boolean CREEPER_HAMMER_ENABLE;
	public static boolean COPPER_HAMMER_ENABLE;
	public static boolean BRONZE_HAMMER_ENABLE;
	public static boolean SILVER_HAMMER_ENABLE;
	public static boolean TUNGSTEN_HAMMER_ENABLE;
	public static boolean RUBY_HAMMER_ENABLE;
	public static boolean TIN_HAMMER_ENABLE;
	public static boolean JADE_HAMMER_ENABLE;
	public static boolean AMETHEYST_HAMMER_ENABLE;
	public static boolean GRAPHITE_HAMMER_ENABLE;
	public static boolean CITRINE_HAMMER_ENABLE;
	public static boolean PIERRE_HAMMER_ENABLE;
	public static boolean ONYX_HAMMER_ENABLE;
	public static boolean NIKOLITE_HAMMER_ENABLE;
	public static boolean SILICA_HAMMER_ENABLE;
	public static boolean CINNABAR_HAMMER_ENABLE;
	public static boolean AMBER_HAMMER_ENABLE;
	public static boolean FERROUS_HAMMER_ENABLE;
	public static boolean ADAMITE_HAMMER_ENABLE;
	public static boolean SHINY_HAMMER_ENABLE;
	public static boolean XYCHORINUM_HAMMER_ENABLE;
	public static boolean URANIUM_HAMMER_ENABLE;
	public static boolean TITANIUM_HAMMER_ENABLE;
	public static boolean BLOODSTONE_HAMMER_ENABLE;
	public static boolean RUSTED_HAMMER_ENABLE;
	public static boolean ROSITE_HAMMER_ENABLE;
	public static boolean LIMONITE_HAMMER_ENABLE;
	public static boolean MITHRIL_HAMMER_ENABLE;
	public static boolean PROMETHEUM_HAMMER_ENABLE;
	public static boolean HEPATIZON_HAMMER_ENABLE;
	public static boolean POOP_HAMMER_ENABLE;
	public static boolean ANGMALLEN_HAMMER_ENABLE;
	public static boolean MAGANESE_HAMMER_ENABLE;
	public static boolean SEAREDBRICK_HAMMER_ENABLE;
	public static boolean ELECTRUM_HAMMER_ENABLE;
	public static boolean PIGIRON_HAMMER_ENABLE;
	public static boolean ARDITE_HAMMER_ENABLE;
	public static boolean ALUMITE_HAMMER_ENABLE;
	public static boolean COBALT_HAMMER_ENABLE;
	public static boolean OURCLASE_HAMMER_ENABLE;
	public static boolean HADEROTH_HAMMER_ENABLE;
	public static boolean INFUSCOILUM_HAMMER_ENABLE;
	public static boolean RUBBER_HAMMER_ENABLE;
	public static boolean DESICHALKOS_HAMMER_ENABLE;
	public static boolean MEUTOITE_HAMMER_ENABLE;
	public static boolean EXIMITE_HAMMER_ENABLE;
	public static boolean MIDASUM_HAMMER_ENABLE;
	public static boolean SANGUINITE_HAMMER_ENABLE;
	public static boolean INOLASHITE_HAMMER_ENABLE;
	public static boolean VULCANITE_HAMMER_ENABLE;
	public static boolean LEMURITE_HAMMER_ENABLE;
	public static boolean AMARDRINE_HAMMER_ENABLE;
	public static boolean CERUCLASE_HAMMER_ENABLE;
	public static boolean KALENDRIDE_HAMMER_ENABLE;
	public static boolean VYROXERS_HAMMER_ENABLE;
	public static boolean CARMOT_HAMMER_ENABLE;
	public static boolean TARTARITE_HAMMER_ENABLE;
	public static boolean ATLARUS_HAMMER_ENABLE;
	public static boolean ASTRAL_HAMMER_ENABLE;
	public static boolean CELENEGIL_HAMMER_ENABLE;
	public static boolean AREDRITE_HAMMER_ENABLE;
	public static boolean ORICALCUM_HAMMER_ENABLE;
	public static boolean TOASTER_HAMMER_ENABLE;
	public static boolean CRYOBBY_HAMMER_ENABLE;
	public static boolean TDM_HAMMER_ENABLE;
	public static boolean PAT_HAMMER_ENABLE;
	public static boolean JEN_HAMMER_ENABLE;
	public static boolean JSQ_HAMMER_ENABLE;
	public static boolean SKYRS_HAMMER_ENABLE;
	public static boolean MRGREGOR_HAMMER_ENABLE;
	public static boolean THACKATTACK_HAMMER_ENABLE;
	public static boolean DEEJAYAXEL_HAMMER_ENABLE;
	public static boolean INCAPABLEGAMER_HAMMER_ENABLE;
	public static boolean SLIME_HAMMER_ENABLE;
	public static boolean MELON_HAMMER_ENABLE;
	public static boolean SAPPHIRE_HAMMER_ENABLE;
	public static boolean MANYULLYN_HAMMER_ENABLE;
	public static boolean RAINBOW_HAMMER_ENABLE;
	public static boolean MISSING_TEXTURE_HAMMER_ENABLE;
	
	public static final String CATEGORY_CUSTOM_HAMMERS = "Custom Hammers";
	public static final String CATEGORY_SETTINGS = "Settings";
	public static final String CATEGORY_HAMMERS = "Hammers";

	//public static ToolMaterial MATERIAL_NAME = EnumHelper.addToolMaterial("MATERIAL_NAME", harvestLevel, durability, miningSpeed, damageVsEntities, enchantability);
	//public static ToolMaterial DIRT = EnumHelper.addToolMaterial("DIRT", 0, 10, 2, 1, 4);
	//public static ToolMaterial GLASS = EnumHelper.addToolMaterial("GLASS", 0, 6, 50, 1, 1);
	
	@ForgeSubscribe(priority = EventPriority.NORMAL)
    public void eventHandler(RenderGameOverlayEvent event) {

	}
	
	
@Mod.EventHandler
public void preInit(FMLPreInitializationEvent event)
{
	
	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	event.getModConfigurationDirectory();
	event.getModConfigurationDirectory();
	event.getModLog();
	event.getModMetadata();
	event.getModState();
	event.getSide();
	event.getVersionProperties();
	
	
	config.load();
	config.getLoadedConfigVersion();
	
	
	//========================================CUSTOM HAMMERS=============================================
		CUSTOM_HAMMER_1 = config.get(CATEGORY_CUSTOM_HAMMERS, "Enable Custom Hammer 1", false).getBoolean(false);
		CUSTOM_HAMMER_1_NAME = config.get(CATEGORY_CUSTOM_HAMMERS, "Custom Hammer 1 Internal Name", "CustomHammer1");
		CUSTOM_HAMMER_1_LANG_NAME = config.get(CATEGORY_CUSTOM_HAMMERS, "Custom Hammer 1 Name", "Custom Hammer 1");
		CUSTOM_HAMMER_1_TOOLMATERIAL = config.get(CATEGORY_CUSTOM_HAMMERS, "Custom Hammer 1 Tool Material", "IRON");
		CUSTOM_HAMMER_1_MATERIALMODIFIER = config.get(CATEGORY_CUSTOM_HAMMERS, "Custom Hammer 1 Material Modifier", 16);
		CUSTOM_HAMMER_1_TEXTURE = config.get(CATEGORY_CUSTOM_HAMMERS, "Custom Hammer 1 Texture", "hammermod:\\custom\\custom_1");
		CUSTOM_HAMMER_DESC_1 = config.get(CATEGORY_CUSTOM_HAMMERS, "Custom Hammer 1 Description", "I'm A Custom Hammer");
		CUSTOM_HAMMER_1_CRAFT = config.get(CATEGORY_CUSTOM_HAMMERS, "Custom Hammer 1 Crafting Recipe", "XXX, NSN, NSN, 'X', Items.ingotIron, 'S', Items.stick");
		CUSTOM_HAMMER_1_ENCHANT_GLINT = config.get(CATEGORY_CUSTOM_HAMMERS, "Custom Hammer 1 Enchantment Effect", false).getBoolean(false);
		//===================================================================================================
		
		//=======================================SETTINGS====================================================
		SMASH_BREAK_SOUND = config.get(CATEGORY_SETTINGS, "HammerCustomBreakSound", false).getBoolean(false);
		TOASTER_BREAK_SOUND = config.get(CATEGORY_SETTINGS, "ToasterCustomBreakSound", true).getBoolean(true);
		RANDOM_TOAST = config.get(CATEGORY_SETTINGS, "RandomToast", false).getBoolean(false);
		SHARP_TOAST = config.get(CATEGORY_SETTINGS, "SharpToast", false).getBoolean(false);
		DEBUG_MODE  = config.get(CATEGORY_SETTINGS, "DebugMode", false).getBoolean(false);
		RAINBOWCRAFT  = config.get(CATEGORY_SETTINGS, "RainbowHammerRecipe", false).getBoolean(false);
		DISABLE_ALL_HAMMER  = config.get(CATEGORY_SETTINGS, "AllHammersDisabled", false).getBoolean(false);
		//====================================================================================================
		
		//==========================VANNILA HAMMERS===========================================================
		WOOD_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Wood Hammer", true).getBoolean(true);
		STONE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Stone Hammer", true).getBoolean(true);
		IRON_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Iron Hammer", true).getBoolean(true);
		GOLD_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Gold Hammer", true).getBoolean(true);
		DIAMOND_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Diamond Hammer", true).getBoolean(true);
		DIRT_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Dirt Hammer", true).getBoolean(true);
		GLASS_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Glass Hammer", true).getBoolean(true);
		SAND_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Sand Hammer", true).getBoolean(true);
		CACTUS_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Cactus Hammer", true).getBoolean(true);
		GRAVEL_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Gravel Hammer", true).getBoolean(true);
		WOOL_WHITE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Wool Hammer", true).getBoolean(true);
		EMERALD_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Emerald Hammer", true).getBoolean(true);
		GRASS_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Grass Hammer", true).getBoolean(true);
		OBISIDIAN_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Obisidan Hammer", true).getBoolean(true);
		GLOWSTONE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Glowstone Hammer", true).getBoolean(true);
		REDSTONE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Redstone Hammer", true).getBoolean(true);
		LAPIZ_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Lapiz Hammer", true).getBoolean(true);
		NETHERRACK_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Nethherack Hammer", true).getBoolean(true);
		SOULSAND_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable SoulSand Hammer", true).getBoolean(true);
		COAL_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Coal Hammer", true).getBoolean(true);
		CHARCOAL_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Charcoal Hammer", true).getBoolean(true);
		ENDSTONE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable End Hammer", true).getBoolean(true);
		BONE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Bone Hammer", true).getBoolean(true);
		SPONGE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Sponge Hammer", true).getBoolean(true);
		BRICK_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Brick Hammer", true).getBoolean(true);
		SUGAR_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Sugar Hammer", true).getBoolean(true);
		PUMPKIN_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Pumpkin Hammer", true).getBoolean(true);
		POTATO_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Potato Hammer", true).getBoolean(true);
		CARROT_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Carrot Hammer", true).getBoolean(true);
		APPLE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Apple Hammer", true).getBoolean(true);
		ICE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Ice Hammer", true).getBoolean(true);
		PACKEDICE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Packed Ice Hammer", true).getBoolean(true);
		CAKE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Cake Hammer", true).getBoolean(true);
		DRAGONEGG_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Dragon Egg Hammer", true).getBoolean(true);
		TNT_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable TNT Hammer", true).getBoolean(true);
		BEDROCK_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Bedrock Hammer", true).getBoolean(true);
		SLIME_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Slime Hammer", true).getBoolean(true);
		MELON_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Melon Hammer", true).getBoolean(true);
		//=======================================================================================================
		
		//========================================MOB HAMMERS====================================================
		PIG_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Pig Hammer", true).getBoolean(true);
		COW_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Cow Hammer", true).getBoolean(true);
		CREEPER_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Creeper Hammer", true).getBoolean(true);
		//=======================================================================================================
		
		//======================================MODDED HAMMERS===================================================
		COPPER_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Copper Hammer", true).getBoolean(true);
		BRONZE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Bronze Hammer", true).getBoolean(true);
		SILVER_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Silver Hammer", true).getBoolean(true);
		TUNGSTEN_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Tungsten Hammer", true).getBoolean(true);
		RUBY_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Ruby Hammer", true).getBoolean(true);
		TIN_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Tin Hammer", true).getBoolean(true);
		JADE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Jade Hammer", true).getBoolean(true);
		AMETHEYST_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Ametheyst Hammer", true).getBoolean(true);
		GRAPHITE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Graphite Hammer", true).getBoolean(true);
		CITRINE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Citrine Hammer", true).getBoolean(true);
		PIERRE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Pierre Hammer", true).getBoolean(true);
		ONYX_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Onyx Hammer", true).getBoolean(true);
		NIKOLITE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Nikolite Hammer", true).getBoolean(true);
		SILICA_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Silica Hammer", true).getBoolean(true);
		CINNABAR_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Cinnabar Hammer", true).getBoolean(true);
		AMBER_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Amber Hammer", true).getBoolean(true);
		FERROUS_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Ferrous Hammer", true).getBoolean(true);
		ADAMITE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Adamite Hammer", true).getBoolean(true);
		SHINY_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Shiny Hammer", true).getBoolean(true);
		XYCHORINUM_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Xychorinum Hammer", true).getBoolean(true);
		URANIUM_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Uranium Hammer", true).getBoolean(true);
		TITANIUM_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Titanium Hammer", true).getBoolean(true);
		BLOODSTONE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Bloodstone Hammer", true).getBoolean(true);
		RUSTED_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Rusted Hammer", true).getBoolean(true);
		ROSITE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Rosite Hammer", true).getBoolean(true);
		LIMONITE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Limonite Hammer", true).getBoolean(true);
		MITHRIL_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Mithril Hammer", true).getBoolean(true);
		PROMETHEUM_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Prometheum Hammer", true).getBoolean(true);
		HEPATIZON_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Hepatizon Hammer", true).getBoolean(true);
		POOP_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Poop Hammer", true).getBoolean(true);
		ANGMALLEN_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Angmallen Hammer", true).getBoolean(true);
		MAGANESE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Maganese Hammer", true).getBoolean(true);
		SEAREDBRICK_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable SearedBrick Hammer", true).getBoolean(true);
		ELECTRUM_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Electrum Hammer", true).getBoolean(true);
		PIGIRON_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Pig Iron Hammer", true).getBoolean(true);
		ARDITE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Ardite Hammer", true).getBoolean(true);
		ALUMITE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Alumite Hammer", true).getBoolean(true);
		COBALT_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Cobalt Hammer", true).getBoolean(true);
		OURCLASE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Ourclase Hammer", true).getBoolean(true);
		HADEROTH_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Haderoth Hammer", true).getBoolean(true);
		INFUSCOILUM_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Infuscoilum Hammer", true).getBoolean(true);
		RUBBER_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Rubber Hammer", true).getBoolean(true);
		DESICHALKOS_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Desichaloks Hammer", true).getBoolean(true);
		MEUTOITE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Meutoite Hammer", true).getBoolean(true);
		EXIMITE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Eximite Hammer", true).getBoolean(true);
		MIDASUM_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Midasum Hammer", true).getBoolean(true);
		SANGUINITE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Sanguinite Hammer", true).getBoolean(true);
		INOLASHITE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Inolashite Hammer", true).getBoolean(true);
		VULCANITE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Vulcanite Hammer", true).getBoolean(true);
		LEMURITE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Lemurite Hammer", true).getBoolean(true);
		AMARDRINE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Amardine Hammer", true).getBoolean(true);
		CERUCLASE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Ceruclase Hammer", true).getBoolean(true);
		KALENDRIDE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Kalendride Hammer", true).getBoolean(true);
		VYROXERS_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Vyroxers Hammer", true).getBoolean(true);
		CARMOT_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Carmot Hammer", true).getBoolean(true);
		TARTARITE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Tartarite Hammer", true).getBoolean(true);
		ATLARUS_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Atlarus Hammer", true).getBoolean(true);
		ASTRAL_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Astral Hammer", true).getBoolean(true);
		CELENEGIL_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Celenegil Hammer", true).getBoolean(true);
		AREDRITE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Arederite Hammer", true).getBoolean(true);
		ORICALCUM_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Oricalcum Hammer", true).getBoolean(true);
		SAPPHIRE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Saphirre Hammer", true).getBoolean(true);
		MANYULLYN_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Manyullyn Hammer", true).getBoolean(true);
		//=======================================================================================================
		
		//=====================================COMMUNITY HAMMERS=================================================
		TOASTER_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Toaster Hammer", true).getBoolean(true);
		CRYOBBY_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Crying Obisidan Hammer", true).getBoolean(true);
		//=======================================================================================================
		
		//======================================YOUTUBE HAMMERS==================================================
		TDM_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable DanTDM Hammer", true).getBoolean(true);
		PAT_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable FuriousDestroyer Hammer", true).getBoolean(true);
		JEN_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable SuperGirlyGamer Hammer", true).getBoolean(true);
		JSQ_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable xJSQ Hammer", true).getBoolean(true);
		SKYRS_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable SkyTheKidRS Hammer", true).getBoolean(true);
		MRGREGOR_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable _MrGregor_ Hammer", true).getBoolean(true);
		THACKATTACK_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable ThackAttack_MC Hammer", true).getBoolean(true);
		//========================================================================================================
		
		//===================================TWITCH HAMMERS=======================================================
		DEEJAYAXEL_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable DeeAxelJay Hammer", true).getBoolean(true);
		//========================================================================================================
		
		//==================================SPECIAL HAMMERS=======================================================
		RAINBOW_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Rainbow Hammer", true).getBoolean(true);
		MISSING_TEXTURE_HAMMER_ENABLE = config.get(CATEGORY_HAMMERS, "Enable Missing Texture Hammer", true).getBoolean(true);
		//========================================================================================================
		
		//config.addCustomCategoryComment(CATEGORY_INFO, "This Configfile is still [WIP] and may not work properly. ***Some things won't work!");
		config.addCustomCategoryComment(CATEGORY_CUSTOM_HAMMERS, "Custom Hammer Settings");
		config.addCustomCategoryComment(CATEGORY_SETTINGS, "Settings");
		//config.getCategoryNames();
			
		config.save();
		
		event.getModLog();
		event.getModState();
		//Configuration configFile = new Configuration(event.getSuggestedConfigurationFile());
		
		//loadConfiguration(configFile);
		
		System.out.println(MODID + " >>> Configuration File Loaded");
		
		
		ModRegistry.registerMods();
		PlayerChecker.checkPlayer(username);
	
}



@Mod.EventHandler
public void init(FMLInitializationEvent event)
{
	proxy.init(event);
	
	
	ItemLoader.LoadItems();
	//BlockLoader.loadBlocks();
	Recipes.registerRecpies();
	//EntityLoader.LoadEntitys();
	//OreDict.addores();
	Achievements.loadAchievements();
	Stats.RegisterStats();

	PlayerChecker.checkPlayer(username);
	LootRegistry.registerLoot();
	
}


public static CreativeTabs HammerMod = new CreativeTabs("HammerMod")

{
	public Item getTabIconItem() {

		return new ItemStack(ItemLoader.ItemDiamondHammer).getItem();
	}
	public boolean hasSearchBar(){
		return false;
	}
	/*
	@SideOnly(Side.CLIENT)
	public String getBackgroundImageName() 
	{
		return "EpicProportionsMod_Halloween.png";
	}
	
	@SideOnly(Side.CLIENT)
	public boolean drawInForegroundOfTab() 
	{
		return false;
	}
	*/
	};
/**
public static CreativeTabs CommunityHammers = new CreativeTabs("CommunityHammers")

{
	public Item getTabIconItem() {

		return new ItemStack(ItemLoader.ItemCryingObsidainHammer).getItem();
	}
	public boolean hasSearchBar(){
		return false;
	}
	/*
	@SideOnly(Side.CLIENT)
	public String getBackgroundImageName() 
	{
		return "EpicProportionsMod_Halloween.png";
	}
	
	@SideOnly(Side.CLIENT)
	public boolean drawInForegroundOfTab() 
	{
		return false;
	}
	
	}*/
	
;









@Mod.EventHandler
public void postInit(FMLPostInitializationEvent event) {
	{
		
	    Recipes.registerRecpies();

	    
	}
	
	
}


@EventHandler
public void serverStart(FMLServerStartingEvent event)
{
     MinecraftServer server = MinecraftServer.getServer();
     // Get's the current server instance
     
     ICommandManager command = server.getCommandManager();
     ServerCommandManager manager = (ServerCommandManager) command;
     
     //manager.registerCommand(new CommandModInfo());
     manager.registerCommand(new CommandChangelog());
     manager.registerCommand(new CommandAbilities());
}

					
}

package net.miningz.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.miningz.MiningMain;
import net.miningz.item.ProspectorPick;

public class ItemInit {

    public static final RegistryKey<ItemGroup> MININGZ_ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, MiningMain.identifierOf("item_group"));

    public static final Item COPPER_PROSPECTOR_PICK = Registry.register(Registries.ITEM, MiningMain.identifierOf("copper_prospector_pick"), new ProspectorPick(10, new Item.Settings().maxDamage(190)));
    public static final Item GOLDEN_PROSPECTOR_PICK = Registry.register(Registries.ITEM, MiningMain.identifierOf("golden_prospector_pick"), new ProspectorPick(15, new Item.Settings().maxDamage(32)));
    public static final Item IRON_PROSPECTOR_PICK = Registry.register(Registries.ITEM, MiningMain.identifierOf("iron_prospector_pick"), new ProspectorPick(20, new Item.Settings().maxDamage(250)));
    public static final Item DIAMOND_PROSPECTOR_PICK = Registry.register(Registries.ITEM, MiningMain.identifierOf("diamond_prospector_pick"), new ProspectorPick(25, new Item.Settings().maxDamage(1561)));
    public static final Item NETHERITE_PROSPECTOR_PICK = Registry.register(Registries.ITEM, MiningMain.identifierOf("netherite_prospector_pick"), new ProspectorPick(30, new Item.Settings().maxDamage(2031)));

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, MININGZ_ITEM_GROUP,
                FabricItemGroup.builder().icon(() -> new ItemStack(ItemInit.NETHERITE_PROSPECTOR_PICK)).displayName(Text.translatable("item.miningz.item_group")).build());

        ItemGroupEvents.modifyEntriesEvent(MININGZ_ITEM_GROUP).register(entries -> {
            entries.add(COPPER_PROSPECTOR_PICK);
            entries.add(GOLDEN_PROSPECTOR_PICK);
            entries.add(IRON_PROSPECTOR_PICK);
            entries.add(DIAMOND_PROSPECTOR_PICK);
            entries.add(NETHERITE_PROSPECTOR_PICK);
        });
    }
}
package leonillo.stuff.item;

import leonillo.stuff.FirstMod;
import leonillo.stuff.item.custom.SuperBenItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item BEN = registerItem("ben", new Item(
            new FabricItemSettings().food( new FoodComponent.Builder().hunger( 20 ).saturationModifier( 20.0f ).build()
        )
    ));

    public static final Item SUPER_BEN = registerItem("super_ben", new SuperBenItem(
            new FabricItemSettings()
        )
    );

    private static Item registerItem( String name, Item item ) {
        return Registry.register( Registries.ITEM, new Identifier( FirstMod.MOD_ID, name ), item );
    }

    public static void addItemsToItemGroup() {
        addToItemGroup( ItemGroups.FOOD_AND_DRINK, BEN );
        addToItemGroup( ItemGroups.FUNCTIONAL, SUPER_BEN);
    }

    private static void addToItemGroup( ItemGroup group, Item item ) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        FirstMod.LOGGER.info( "YEEEES (registrando items pa tu mod)" );

        addItemsToItemGroup();
    }

}

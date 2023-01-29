package leonillo.stuff.block;


import leonillo.stuff.FirstMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block BEN_ORE = registerBlock("ben_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(10.0f),
                UniformIntProvider.create(1, 1000000)));
    public static final Block BEN_BLOCK = registerBlock("ben_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(10.0f)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(FirstMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(FirstMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        FirstMod.LOGGER.debug("YEPAAA ahora van los bloques");
    }

}

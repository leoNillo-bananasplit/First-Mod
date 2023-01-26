package leonillo.stuff.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SuperBenItem extends Item {
    public SuperBenItem (Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use( World world, PlayerEntity user, Hand hand ) {
        if(!world.isClient() && hand == Hand.MAIN_HAND) {
            user.getItemCooldownManager().set(this, 20);
            // give user a stack of diamonds
            user.giveItemStack(new ItemStack(Items.DIAMOND, 64));
        }

        return super.use( world, user, hand );
    }
}

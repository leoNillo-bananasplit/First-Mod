package leonillo.stuff.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ColacaoTest extends Item {
    public ColacaoTest(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand ) {
        if(!world.isClient() && hand == Hand.MAIN_HAND) {

            user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 1));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100, 1));
            //remove 1 item from the stack
            user.getStackInHand(hand).decrement(1);

        }

        return super.use( world, user, hand );
    }


}

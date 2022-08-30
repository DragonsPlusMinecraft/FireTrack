package plus.dragons.firetrack.mixin;

import plus.dragons.firetrack.capability.TrackTypeData;
import plus.dragons.firetrack.track.TrackType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Wearable;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ArmorItem.class)
public abstract class MixinArmorItem extends Item implements Wearable {
    public MixinArmorItem(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public CompoundTag getShareTag(ItemStack stack) {
        var ret = super.getShareTag(stack);
        if (stack.getItem() instanceof ArmorItem armorItem) {
            if (armorItem.getSlot() == EquipmentSlot.FEET) {
                if (ret == null) ret = new CompoundTag();
                var data = stack.getCapability(TrackTypeData.CAPABILITY);
                if (data.isPresent()) {
                    CompoundTag finalRet = ret.copy();
                    data.ifPresent(cap -> {
                        finalRet.putString("track_type", cap.get().id);
                    });
                    return finalRet;
                }

            }
        }
        return ret;
    }

    @Override
    public void readShareTag(ItemStack stack, @Nullable CompoundTag compoundTag) {
        super.readShareTag(stack, compoundTag);
        if (compoundTag != null && stack.getItem() instanceof ArmorItem armorItem) {
            if (armorItem.getSlot() == EquipmentSlot.FEET) {
                var data = stack.getCapability(TrackTypeData.CAPABILITY);
                if (data.isPresent()) {
                    data.ifPresent(cap -> cap.set(TrackType.fromId(compoundTag.getString("track_type"))));
                }
            }
        }
    }
}

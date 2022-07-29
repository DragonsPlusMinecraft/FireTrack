package love.marblegate.firetrack.mixin;

import love.marblegate.firetrack.capability.TrackTypeData;
import love.marblegate.firetrack.track.TrackType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Wearable;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

//@Mixin(ItemStack.class)
@Mixin(ArmorItem.class)
public abstract class MixinArmorItem extends Item implements Wearable
        /*extends net.minecraftforge.common.capabilities.CapabilityProvider<ItemStack> implements net.minecraftforge.common.extensions.IForgeItemStack**/ {
    public MixinArmorItem(Properties properties) {
        super(properties);
    }

    /*protected MixinArmorItem(Class<ItemStack> baseClass) {
        super(baseClass);
    }

    protected MixinArmorItem(Class<ItemStack> baseClass, boolean isLazy) {
        super(baseClass, isLazy);
    }*/

    @Nullable
    @Override
    public CompoundTag getShareTag(ItemStack stack) {
        var ret = super.getShareTag(stack);
        if(stack.getItem() instanceof ArmorItem armorItem){
            if(armorItem.getSlot() == EquipmentSlot.FEET){
                if(ret==null) ret = new CompoundTag();
                var data = stack.getCapability(TrackTypeData.CAPABILITY);
                System.out.println("get type from cap.");
                if(data.isPresent()){
                    CompoundTag finalRet = ret.copy();
                    data.ifPresent(cap-> {
                        finalRet.putString("track_type",cap.get().id);
                        System.out.println("put type to tag: " + cap.get().id);
                    });
                    return finalRet;
                }

            }
        }
        return ret;
    }

    @Override
    public void readShareTag(ItemStack stack, @Nullable CompoundTag compoundTag) {
        super.readShareTag(stack,compoundTag);
        if(compoundTag != null && stack.getItem() instanceof ArmorItem armorItem){
            if(armorItem.getSlot() == EquipmentSlot.FEET){
                var data = stack.getCapability(TrackTypeData.CAPABILITY);
                if(data.isPresent()){
                    System.out.println("get type from tag: " + compoundTag.getString("track_type"));
                    data.ifPresent(cap-> cap.set(TrackType.fromId(compoundTag.getString("track_type"))));
                }
            }
        }
    }

    /*@Inject(method = "getTag", at = @At("RETURN"), cancellable = true)
    public void injectedGetTag(CallbackInfoReturnable<CompoundTag> cir) {
        var stack = ((ItemStack) (Object) this);
        if(stack.getItem() instanceof ArmorItem armorItem){
            if(armorItem.getSlot() == EquipmentSlot.FEET){
                var compoundTag = cir.getReturnValue();
                var data = stack.getCapability(TrackTypeData.CAPABILITY, null);
                if(data.isPresent()){
                    data.ifPresent(cap->{
                        compoundTag.putString("track_type",cap.get().id);
                    });
                    cir.setReturnValue(compoundTag);
                }
            }
        }
    }

    @Inject(method = "setTag", at = @At("RETURN"))
    public void injectedSetTag(CompoundTag compoundTag, CallbackInfo ci) {
        var stack = ((ItemStack) (Object) this);
        if(stack.getItem() instanceof ArmorItem armorItem){
            if(armorItem.getSlot() == EquipmentSlot.FEET){
                var data = stack.getCapability(TrackTypeData.CAPABILITY, null);
                if(data.isPresent()){
                    data.ifPresent(cap->{
                        cap.set(TrackType.fromId(compoundTag.getString("track_type")));
                    });
                }
            }
        }
    }*/
}

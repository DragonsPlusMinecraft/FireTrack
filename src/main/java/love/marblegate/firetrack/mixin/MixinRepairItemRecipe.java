package love.marblegate.firetrack.mixin;

import love.marblegate.firetrack.capability.TrackTypeData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RepairItemRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RepairItemRecipe.class)
public abstract class MixinRepairItemRecipe extends CustomRecipe {
    public MixinRepairItemRecipe(ResourceLocation resourceLocation) {
        super(resourceLocation);
    }

    @Inject(method = "assemble*", at = @At("RETURN"))
    public void injected(CraftingContainer craftingContainer, CallbackInfoReturnable<ItemStack> cir) {
        var resultStack = cir.getReturnValue();
        if (resultStack.getItem() instanceof ArmorItem armorItem) {
            if (armorItem.getSlot() == EquipmentSlot.FEET) {
                for(int i = 0; i < craftingContainer.getContainerSize(); ++i) {
                    ItemStack itemstack = craftingContainer.getItem(i);
                    if (!itemstack.isEmpty()) {
                        var oldData = itemstack.getCapability(TrackTypeData.CAPABILITY);
                        var newData = resultStack.getCapability(TrackTypeData.CAPABILITY);
                        oldData.ifPresent(oldCap -> newData.ifPresent(newCap-> newCap.set(oldCap.get())));
                    }
                }
            }
        }
    }
}

package love.marblegate.firetrack.capability;

import love.marblegate.firetrack.FireTrack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CapabilityAttach {
    @SubscribeEvent
    public static void attachCap(AttachCapabilitiesEvent<ItemStack> event) {
        if(event.getObject().getItem() instanceof ArmorItem armorItem){
            if(armorItem.getSlot() == EquipmentSlot.FEET){
                TrackTypeItemStackProvider provider = new TrackTypeItemStackProvider();
                event.addCapability(new ResourceLocation(FireTrack.MOD_ID, "track_type_capability"), provider);
            }
        }
    }
}

package love.marblegate.firetrack.capability;

import com.mojang.datafixers.util.Either;
import love.marblegate.firetrack.FireTrack;
import love.marblegate.firetrack.track.TrackType;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.sound.midi.Track;

@Mod.EventBusSubscriber()
public class CapabilityEvent {
    private static TextColor TOOLTIP_COLOR = TextColor.parseColor("#FBB741");
    @SubscribeEvent
    public static void attachCap(AttachCapabilitiesEvent<ItemStack> event) {
        if(event.getObject().getItem() instanceof ArmorItem armorItem){
            if(armorItem.getSlot() == EquipmentSlot.FEET){
                TrackTypeItemStackProvider provider = new TrackTypeItemStackProvider();
                event.addCapability(new ResourceLocation(FireTrack.MOD_ID, "track_type_capability"), provider);
            }
        }
    }

    @SubscribeEvent
    public static void AppendTooltip(RenderTooltipEvent.GatherComponents event) {
        if(event.getItemStack().getItem() instanceof ArmorItem armorItem){
            if(armorItem.getSlot() == EquipmentSlot.FEET){
                var data = event.getItemStack().getCapability(TrackTypeData.CAPABILITY);
                data.ifPresent(cap -> {
                    var type = cap.get();
                    if(type!=TrackType.NONE){
                        event.getTooltipElements().add(Either.left(new TranslatableComponent("tooltip.fire_track." + type.id.toLowerCase() +".name").setStyle(Style.EMPTY.withColor(TOOLTIP_COLOR).withBold(false))));
                    }
                });
            }
        }
    }
}

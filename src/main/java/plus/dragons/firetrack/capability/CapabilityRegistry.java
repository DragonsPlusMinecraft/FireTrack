package plus.dragons.firetrack.capability;

import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CapabilityRegistry {
    @SubscribeEvent
    public static void registerCap(RegisterCapabilitiesEvent event) {
        event.register(TrackTypeData.class);
    }
}

package love.marblegate.firetrack.easteregg;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.FlameParticle;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ParticleFactoryRegistry {

    @SubscribeEvent
    public static void onParticleFactoryRegistration(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ParticleTypeRegistry.TEACON_MODERN.get(), FlameParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleTypeRegistry.TEACON_GOOD_NEWS.get(), FlameParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleTypeRegistry.TEACON_WAITING_FOR_SERVER.get(), FlameParticle.Provider::new);
    }
}

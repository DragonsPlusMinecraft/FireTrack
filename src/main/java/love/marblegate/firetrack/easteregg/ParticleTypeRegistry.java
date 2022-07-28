package love.marblegate.firetrack.easteregg;

import love.marblegate.firetrack.FireTrack;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ParticleTypeRegistry {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, FireTrack.MOD_ID);
    public static final RegistryObject<SimpleParticleType> TEACON_MODERN = PARTICLE_TYPES.register("teacon_modern", ()->new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> TEACON_GOOD_NEWS = PARTICLE_TYPES.register("teacon_good_news", ()->new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> TEACON_WAITING_FOR_SERVER = PARTICLE_TYPES.register("teacon_waiting_for_server", ()->new SimpleParticleType(false));
}

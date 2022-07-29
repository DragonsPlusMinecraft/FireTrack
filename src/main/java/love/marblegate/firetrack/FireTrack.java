package love.marblegate.firetrack;

import com.mojang.logging.LogUtils;
import love.marblegate.firetrack.easteregg.ItemRegistry;
import love.marblegate.firetrack.easteregg.ParticleTypeRegistry;
import love.marblegate.firetrack.recipe.RecipeRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod("fire_track")
public class FireTrack {
    public static final Logger LOGGER = LogUtils.getLogger();
    public final static String MOD_ID = "fire_track";

    public FireTrack(){
        ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        RecipeRegistry.RECIPE_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        RecipeRegistry.RECIPE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ParticleTypeRegistry.PARTICLE_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}

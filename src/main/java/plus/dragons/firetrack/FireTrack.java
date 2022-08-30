package plus.dragons.firetrack;

import com.mojang.logging.LogUtils;
import plus.dragons.firetrack.recipe.RecipeRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod("fire_track")
public class FireTrack {
    public static final Logger LOGGER = LogUtils.getLogger();
    public final static String MOD_ID = "fire_track";

    public FireTrack(){
        RecipeRegistry.RECIPE_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        RecipeRegistry.RECIPE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}

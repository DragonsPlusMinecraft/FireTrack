package love.marblegate.firetrack;

import love.marblegate.firetrack.recipe.RecipeRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("fire_track")
public class FireTrack {
    public final static String MOD_ID = "fire_track";

    public FireTrack(){
        RecipeRegistry.RECIPE_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        RecipeRegistry.RECIPE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //TODO mixin into ItemDescription
}

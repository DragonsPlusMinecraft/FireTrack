package love.marblegate.firetrack;

import love.marblegate.firetrack.registry.ItemRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("fire_track")
public class FireTrack {
    public static String MOD_ID = "fire_track";

    public FireTrack(){
        ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}

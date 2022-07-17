package love.marblegate.firetrack.registry;

import love.marblegate.firetrack.FireTrack;
import love.marblegate.firetrack.item.Experimental;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FireTrack.MOD_ID);
    public static final RegistryObject<Item> EXPERIMENTAL = ITEMS.register("experimental", Experimental::new);
}

package love.marblegate.firetrack.easteregg;

import love.marblegate.firetrack.FireTrack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FireTrack.MOD_ID);
    public static final RegistryObject<Item> LAVA_TRACK_FLAME = ITEMS.register("lava_track_flame", ()->new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> SMOKE_TRACK_FLAME = ITEMS.register("smoke_track_flame", ()->new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> FIRE_TRACK_FLAME = ITEMS.register("fire_track_flame", ()->new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
}

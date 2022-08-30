package plus.dragons.firetrack.capability;

import plus.dragons.firetrack.track.TrackType;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TrackTypeItemStackProvider implements ICapabilitySerializable<CompoundTag> {
    private final TrackTypeData imp = new TrackTypeData();
    private final LazyOptional<TrackTypeData> impOptional = LazyOptional.of(() -> imp);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == TrackTypeData.CAPABILITY) {
            return impOptional.cast();
        } else return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundNBT = new CompoundTag();
        if (TrackTypeData.CAPABILITY != null) {
            compoundNBT.putString("track_type", imp.get().id);
        }
        return compoundNBT;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        if (TrackTypeData.CAPABILITY != null) {
            imp.set(TrackType.fromId(compoundTag.getString("track_type")));
        }
    }
}

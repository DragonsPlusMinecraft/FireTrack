package plus.dragons.firetrack.capability;

import plus.dragons.firetrack.track.TrackType;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class TrackTypeData {
    public static final Capability<TrackTypeData> CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    private TrackType type;

    public TrackTypeData() {
        type = TrackType.NONE;
    }

    public TrackType get() {
        return type;
    }

    public void set(TrackType type) {
        this.type = type;
    }
}

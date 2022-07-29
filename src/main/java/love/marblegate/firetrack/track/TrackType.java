package love.marblegate.firetrack.track;

import love.marblegate.firetrack.FireTrack;

public enum TrackType {
    NONE("NONE"),
    FIRE("FIRE"),
    SMOKE("SMOKE"),
    LAVA("LAVA"),
    MODERN("MODERN"),
    GOOD_NEWS("GOOD_NEWS"),
    WAITING_FOR_SERVER("WAITING_FOR_SERVER");

    public final String id;

    TrackType(String id) {
        this.id = id;
    }

    public static TrackType fromId(String id){
        try{
            return TrackType.valueOf(id);
        } catch(IllegalArgumentException e){
            FireTrack.LOGGER.error("Read TrackType from string id error, so result falls to NONE. String id is:" + id);
        }
        return TrackType.NONE;
    }
}

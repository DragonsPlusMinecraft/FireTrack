package love.marblegate.firetrack.track;

public enum TrackType {
    NONE("none"),
    FIRE("fire"),
    SMOKE("smoke"),
    LAVA("lava");

    public final String id;

    TrackType(String id) {
        this.id = id;
    }

    public static TrackType fromId(String id){
        return TrackType.valueOf(id.toUpperCase());
    }
}

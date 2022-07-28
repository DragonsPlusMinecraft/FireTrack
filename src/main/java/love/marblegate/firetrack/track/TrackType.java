package love.marblegate.firetrack.track;

public enum TrackType {
    NONE("none"),
    FIRE("fire"),
    SMOKE("smoke"),
    LAVA("lava"),
    MODERN("modern"),
    GOOD_NEWS("good_news"),
    WAITING_FOR_SERVER("waiting_for_server");

    public final String id;

    TrackType(String id) {
        this.id = id;
    }

    public static TrackType fromId(String id){
        return TrackType.valueOf(id.toUpperCase());
    }
}

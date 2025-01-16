package sotsuken.api.model;

public enum AttendanceState {
    ATTENDANCE("ATTENDANCE"),
    ABSENCE("ABSENCE"),
    OFFICIAL_ABSENCE("OFFICIAL_ABSENCE");

    private final String name;

    private AttendanceState(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

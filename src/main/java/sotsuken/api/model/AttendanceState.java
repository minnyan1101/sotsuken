package sotsuken.api.model;

public enum AttendanceState {
    ATTENDANCE("attendance"),
    ABSENCE("absence"),
    OFFICIAL_ABSENCE("official_absence");

    private final String name;

    private AttendanceState(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

package sotsuken.api.teacher.controller;

import jakarta.validation.constraints.NotNull;
import sotsuken.api.model.AttendanceState;

public class EditAttendanceRequest {
    @NotNull
    public AttendanceState state;
    @NotNull
    public Boolean isLateness;
    @NotNull
    public Boolean isLeaveEarly;
    
    public EditAttendanceRequest(AttendanceState state, Boolean isLateness, Boolean isLeaveEarly) {
        this.state = state;
        this.isLateness = isLateness;
        this.isLeaveEarly = isLeaveEarly;
    }
}

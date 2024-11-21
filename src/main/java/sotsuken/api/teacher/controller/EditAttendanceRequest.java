package sotsuken.api.teacher.controller;

import sotsuken.api.model.AttendanceState;

public class EditAttendanceRequest {
    public AttendanceState state;
    public boolean isLateness;
    public boolean isLeaveEarly;
    
    public EditAttendanceRequest(AttendanceState state, boolean isLateness, boolean isLeaveEarly) {
        this.state = state;
        this.isLateness = isLateness;
        this.isLeaveEarly = isLeaveEarly;
    }
}

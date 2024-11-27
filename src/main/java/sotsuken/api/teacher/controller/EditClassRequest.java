package sotsuken.api.teacher.controller;

import jakarta.validation.constraints.NotNull;

public class EditClassRequest {
    @NotNull
    public String className;//クラス名

    public EditClassRequest(String className) {
        this.className = className;
    }
}

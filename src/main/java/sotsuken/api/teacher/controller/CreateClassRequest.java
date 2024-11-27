package sotsuken.api.teacher.controller;

import jakarta.validation.constraints.NotNull;

public class CreateClassRequest {
    @NotNull
    public String className;//クラス名

    public CreateClassRequest(String className) {
        this.className = className;
    }
}

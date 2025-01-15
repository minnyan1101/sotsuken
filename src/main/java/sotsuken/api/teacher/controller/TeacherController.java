package sotsuken.api.teacher.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import sotsuken.api.teacher.service.FetchAllTeachersUseCase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/teacher/teachers")
@Tag(name = "Teacher API")
public class TeacherController {

    @Autowired
    FetchAllTeachersUseCase fetchAllTeachersUseCase;

    @GetMapping("")
    @Operation(summary = "先生一覧の取得")
    public List<TeacherResponse> fetchAllTeachers() {
        return fetchAllTeachersUseCase.handle();
    }
    
    
}

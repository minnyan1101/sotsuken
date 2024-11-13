package sotsuken.api.teacher.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/teacher/students")
public class StudentController {
    @GetMapping("")
    public List<StudentStatusResponse> fetchAllStudents(@RequestParam("classId") Long classId) {
        return List.of(new StudentStatusResponse(
            0L, "xxx", 0L, "Class"
        ));
    }

    @GetMapping("/{studentId}")
    public StudentStatusResponse fetchStudent(
        @PathVariable("studentId") Long studentId
    ){
        return new StudentStatusResponse(
            0L, "xxx", 0L, "Class"
        );
    }



    @PostMapping("/{studentId}")
    public StudentStatusResponse changeStudentStatus(
        @PathVariable("studentId") Long studentId,
        @RequestBody StudentRequest reqeust
    ){            


        return new StudentStatusResponse(0, "xxx", 0, "xxx");
    }
    
}
    

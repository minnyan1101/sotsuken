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
    @GetMapping("")//学生一覧の表示(学生一覧)
    public List<StudentStatusResponse> fetchAllStudents(@RequestParam("classId") Long classId) {
        return List.of(new StudentStatusResponse(
            0L, "xxx", 0L, "Class"
        ));
    }

    @GetMapping("/{studentId}")//学生１人の情報を表示（学生詳細）
    public StudentStatusResponse fetchStudent(
        @PathVariable("studentId") Long studentId
    ){
        return new StudentStatusResponse(
            0, "xxx", 0L, "Class"
        );
    }



    @PostMapping("/{studentId}")//学生情報の更新処理（学生詳細）
    public StudentStatusResponse changeStudentStatus(
        @PathVariable("studentId") Long studentId,
        @RequestBody StudentRequest reqeust
    ){            
        return new StudentStatusResponse(0, "xxx", 0, "xxx");
    }
    
}
    

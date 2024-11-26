package sotsuken.api.teacher.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import sotsuken.api.teacher.service.ChangeStudentStatusUseCase;
import sotsuken.api.teacher.service.FetchAllStudentUseCase;
import sotsuken.api.teacher.service.FetchStudentUseCase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/teacher/students")
@Tag(name = "Teacher API")
public class StudentController {

    @Autowired
    FetchStudentUseCase fetchStudentUseCase;
    
    @Autowired
    FetchAllStudentUseCase fetchAllStudentUseCase;

    @Autowired
    ChangeStudentStatusUseCase changeStudentStatusUseCase;

    @GetMapping("")//学生一覧の表示(学生一覧)
    @Operation(summary = "すべての学生の一覧")
    public List<StudentStatusResponse> fetchAllStudents(
        @AuthenticationPrincipal UserDetails userDetails,
        @RequestParam("classId") Long classId) {
        return fetchAllStudentUseCase.handle(userDetails.getUsername(), classId);
    }

    @GetMapping("/{studentId}")//学生１人の情報を表示（学生詳細）
    @Operation(summary = "指定した学生の情報")
    public StudentStatusResponse fetchStudent(@AuthenticationPrincipal UserDetails userDetails, @PathVariable("studentId") String studentId) {
        return fetchStudentUseCase.handle(userDetails.getUsername(), studentId);
    }


    @PostMapping("/{studentId}")//学生情報の更新処理（学生詳細）
    @Operation(summary = "指定した学生の情報の編集")
    public StudentStatusResponse changeStudentStatus(
        @AuthenticationPrincipal UserDetails userDetails,
        @PathVariable("studentId") String studentId,
        @RequestBody StudentRequest request
    ){            
        return changeStudentStatusUseCase.handle(userDetails.getUsername(), studentId, request.studentName, request.classId);
    }
}
    

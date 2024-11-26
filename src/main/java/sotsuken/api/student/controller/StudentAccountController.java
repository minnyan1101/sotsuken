package sotsuken.api.student.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import sotsuken.api.student.service.FetchAllClassesForRegistrationUseCase;
import sotsuken.api.student.service.RegisterStudentAccountUseCase;
import sotsuken.api.teacher.controller.StudentClassResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/student")
@Tag(name = "Student API")
public class StudentAccountController {

    @Autowired
    FetchAllClassesForRegistrationUseCase fetchAllClassesForRegistrationUseCase;

    @Autowired
    RegisterStudentAccountUseCase registerStudentAccountUseCase;

    @PostMapping("register")
    @Operation(summary = "学生登録", description = "学生が新規登録画面からIDとパスワード、名前、クラスを選択して登録")
    public StudentAccountResponse registerStudentAccount(@RequestBody RegisterStudentAccountRequest request) {
        return registerStudentAccountUseCase.handle(request.studentId, request.studentName, request.password, request.classId);
    }

    @GetMapping("classes")
    @Operation(summary = "クラス一覧", description = "学生登録時に必要なクラス一覧を無権限で取得")
    public List<StudentClassResponse> fetchAllStudentClasses(
    ) {
        return fetchAllClassesForRegistrationUseCase.handle();
    }
    
    
}

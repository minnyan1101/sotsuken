package sotsuken.api.student.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sotsuken.api.student.service.RegisterStudentAccountUseCase;
import sotsuken.api.teacher.controller.StudentClassResponse;
import sotsuken.api.teacher.service.FetchAllClassesUseCase;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/student")
public class StudentAccountController {

    @Autowired
    FetchAllClassesUseCase fetchAllClassesUseCase;

    @Autowired
    RegisterStudentAccountUseCase registerStudentAccountUseCase;

    @PostMapping("register")
    public StudentAccountResponse registerStudentAccount(@RequestBody RegisterStudentAccountRequest request) {
        return registerStudentAccountUseCase.handle(request.studentId, request.studentName, request.password, request.classId);
    }

    @GetMapping("classes")
    public List<StudentClassResponse> fetchAllStudentClasses(
        @AuthenticationPrincipal UserDetails userDetails
    ) {
        return fetchAllClassesUseCase.handle(userDetails.getUsername());
    }
    
    
}

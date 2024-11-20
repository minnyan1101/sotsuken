package sotsuken.api.teacher.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import sotsuken.api.teacher.service.CreateClassesUseCase;
import sotsuken.api.teacher.service.EditClassesUseCase;
import sotsuken.api.teacher.service.FetchAllClassesUseCase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/teacher/classes")
public class ClassesController {

    @Autowired
    FetchAllClassesUseCase fetchAllClassesUseCase;
    CreateClassesUseCase createClassesUseCase;
    EditClassesUseCase editClassesUseCase;

    @GetMapping("")//クラス一覧表示
    public List<StudentClassResponse> fetchAllClass(@AuthenticationPrincipal UserDetails userDetails) {
        return fetchAllClassesUseCase.handle(userDetails.getUsername());
    }
    
    @PostMapping("")
    public StudentClassResponse createClass(@AuthenticationPrincipal UserDetails userDetails, @RequestBody CreateClassRequest createclass) {
        return createClassesUseCase.handle(userDetails.getUsername(), createclass.className);
    }

    @PostMapping("/{classId}")
    public StudentClassResponse editClass(
        @AuthenticationPrincipal UserDetails userDetails,
        @PathVariable("classId") Long classId,
        @RequestBody EditClassRequest editclass
    ) {
        return editClassesUseCase.handle(userDetails.getUsername(), classId, editclass.className);
    }
}

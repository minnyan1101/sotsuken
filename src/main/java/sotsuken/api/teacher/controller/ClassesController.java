package sotsuken.api.teacher.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Teacher API")
public class ClassesController {

    @Autowired
    FetchAllClassesUseCase fetchAllClassesUseCase;
    
    @Autowired
    CreateClassesUseCase createClassesUseCase;
    
    @Autowired
    EditClassesUseCase editClassesUseCase;

    @GetMapping("")//クラス一覧表示
    @Operation(summary = "すべてのクラスの一覧")
    public List<StudentClassResponse> fetchAllClass(@AuthenticationPrincipal UserDetails userDetails) {
        return fetchAllClassesUseCase.handle(userDetails.getUsername());
    }
    
    @PostMapping("")
    @Operation(summary = "新しいクラスの作成")
    public StudentClassResponse createClass(@AuthenticationPrincipal UserDetails userDetails, @RequestBody CreateClassRequest createclass) {
        return createClassesUseCase.handle(userDetails.getUsername(), createclass.className);
    }

    @PostMapping("/{classId}")
    @Operation(summary = "既存のクラスの編集")
    public StudentClassResponse editClass(
        @AuthenticationPrincipal UserDetails userDetails,
        @PathVariable("classId") Long classId,
        @RequestBody EditClassRequest editclass
    ) {
        return editClassesUseCase.handle(userDetails.getUsername(), classId, editclass.className);
    }
}

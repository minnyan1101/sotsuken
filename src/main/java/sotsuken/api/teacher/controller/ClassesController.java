package sotsuken.api.teacher.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import sotsuken.api.teacher.service.CreateClassesUseCase;

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
    CreateClassesUseCase createClassesUseCase;

    @GetMapping("")//クラス一覧表示
    public List<ClassResponse> fetchAllClass() {
        return List.of(new ClassResponse(
            0L,
            "xxx"
        ));
    }
    
    @PostMapping("")
    public ClassResponse createClass(@AuthenticationPrincipal UserDetails userDetails, @RequestBody CreateClassRequest createclass) {
        return createClassesUseCase.handle(userDetails.getUsername(), createclass.className);
    }

    @PostMapping("/{classId}")
    public ClassResponse editClass(
        @PathVariable("className") String className,
        @RequestBody EditClassRequest editclass
    ) {
        return new ClassResponse(
            0L,
            "xxx"
        );
    }
}

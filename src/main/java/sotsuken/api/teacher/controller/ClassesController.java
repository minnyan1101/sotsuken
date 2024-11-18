package sotsuken.api.teacher.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/teacher/classes")
public class ClassesController {

    @GetMapping("")//クラス一覧表示
    public List<ClassResponse> fetchAllClass() {
        return List.of(new ClassResponse(
            0L,
            "xxx"
        ));
    }
    
    @PostMapping("")
    public ClassResponse createClass(@RequestBody CreateClassRequest createclass) {
        return new ClassResponse(
        0L,    
        "xxx"
        );
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

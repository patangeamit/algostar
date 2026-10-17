package com.patangeamit.algostar.controller;

import com.patangeamit.algostar.dto.CreateProblemRequest;
import com.patangeamit.algostar.model.Problem;
import com.patangeamit.algostar.service.ProblemService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/problems")
public class ProblemController {

    private final ProblemService service;

    public ProblemController(ProblemService service) {
        this.service = service;
    }

    @GetMapping
    public List<Problem> getAllProblems() {
        return service.getAllProblems();
    }

    @GetMapping("/{id}")
    public Problem getProblemById(@PathVariable Long id) {
        return service.getProblemById(id);
    }

    @PostMapping
    public Problem createProblem(@Valid @RequestBody CreateProblemRequest request) {

        Problem problem = new Problem();
        problem.setTitle(request.title());
        problem.setDescription(request.description());
        problem.setDifficulty(request.difficulty());

        return service.createProblem(problem);
    }
}
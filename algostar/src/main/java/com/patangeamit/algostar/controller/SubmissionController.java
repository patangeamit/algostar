package com.patangeamit.algostar.controller;

import com.patangeamit.algostar.dto.CreateSubmissionRequest;
import com.patangeamit.algostar.dto.SubmissionResponse;
import com.patangeamit.algostar.model.Submission;
import com.patangeamit.algostar.service.SubmissionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubmissionController {

    private final SubmissionService service;

    public SubmissionController(SubmissionService service) {
        this.service = service;
    }

    @PostMapping("/submissions")
    @ResponseStatus(HttpStatus.CREATED)
    public SubmissionResponse createSubmission(
            @Valid @RequestBody CreateSubmissionRequest request) {
        Submission submission = service.createSubmission(request);
        return SubmissionResponse.from(submission);
    }

    @GetMapping("/submissions/{id}")
    public SubmissionResponse getSubmission(@PathVariable Long id) {
        Submission submission = service.getSubmission(id);
        return SubmissionResponse.from(submission);
    }

    @GetMapping("/problems/{problemId}/submissions")
    public List<SubmissionResponse> getSubmissionsForProblem(
            @PathVariable Long problemId) {
        return service.getSubmissionsForProblem(problemId)
                .stream()
                .map(SubmissionResponse::from)
                .toList();
    }
}

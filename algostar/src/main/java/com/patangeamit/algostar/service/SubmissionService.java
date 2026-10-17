package com.patangeamit.algostar.service;

import com.patangeamit.algostar.dto.CreateSubmissionRequest;
import com.patangeamit.algostar.model.Problem;
import com.patangeamit.algostar.model.Submission;
import com.patangeamit.algostar.repository.ProblemRepository;
import com.patangeamit.algostar.repository.SubmissionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final ProblemRepository problemRepository;

    public SubmissionService(
            SubmissionRepository submissionRepository,
            ProblemRepository problemRepository) {
        this.submissionRepository = submissionRepository;
        this.problemRepository = problemRepository;
    }

    @Transactional
    public Submission createSubmission(CreateSubmissionRequest request) {

        Problem problem = problemRepository.findById(request.problemId())
                .orElseThrow(() ->
                        new ResponseStatusException(
                                NOT_FOUND,
                                "Problem not found"
                        ));

        Submission submission = new Submission();
        submission.setProblem(problem);
        submission.setSourceCode(request.sourceCode());
        submission.setLanguage(request.language());

        return submissionRepository.save(submission);
    }

    @Transactional(readOnly = true)
    public Submission getSubmission(Long id) {
        return submissionRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                NOT_FOUND,
                                "Submission not found"
                        ));
    }

    @Transactional(readOnly = true)
    public List<Submission> getSubmissionsForProblem(Long problemId) {

        if (!problemRepository.existsById(problemId)) {
            throw new ResponseStatusException(
                    NOT_FOUND,
                    "Problem not found"
            );
        }

        return submissionRepository
                .findByProblem_IdOrderByCreatedAtDesc(problemId);
    }
}
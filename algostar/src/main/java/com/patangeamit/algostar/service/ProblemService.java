package com.patangeamit.algostar.service;

import com.patangeamit.algostar.model.Problem;
import com.patangeamit.algostar.repository.ProblemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemService {

    private final ProblemRepository repository;

    public ProblemService(ProblemRepository repository) {
        this.repository = repository;
    }

    public List<Problem> getAllProblems() {
        return repository.findAll();
    }

    public Problem getProblemById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Problem not found: " + id));
    }

    public Problem createProblem(Problem problem) {
        return repository.save(problem);
    }
}
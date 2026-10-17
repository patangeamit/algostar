package com.patangeamit.algostar.repository;

import com.patangeamit.algostar.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    List<Submission> findByProblem_IdOrderByCreatedAtDesc(
            Long problemId
    );

    List<Submission> findByProblem_IdOrderByCreatedAtAsc(
            Long problemId
    );
}
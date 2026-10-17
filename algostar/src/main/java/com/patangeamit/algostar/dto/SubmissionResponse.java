package com.patangeamit.algostar.dto;

import com.patangeamit.algostar.model.Submission;
import com.patangeamit.algostar.model.ProgrammingLanguage;
import com.patangeamit.algostar.model.SubmissionStatus;

import java.time.Instant;

public record SubmissionResponse(
        Long id,
        Long problemId,
        String sourceCode,
        ProgrammingLanguage language,
        SubmissionStatus status,
        Instant createdAt
) {
    public static SubmissionResponse from(Submission submission) {
        return new SubmissionResponse(
                submission.getId(),
                submission.getProblem().getId(),
                submission.getSourceCode(),
                submission.getLanguage(),
                submission.getStatus(),
                submission.getCreatedAt()
        );
    }
}
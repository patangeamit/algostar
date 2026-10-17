package com.patangeamit.algostar.dto;

import com.patangeamit.algostar.model.ProgrammingLanguage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateSubmissionRequest(

        @NotNull
        @Positive
        Long problemId,

        @NotBlank
        String sourceCode,

        @NotNull
        ProgrammingLanguage language

) {
}
package com.patangeamit.algostar.dto;

import com.patangeamit.algostar.model.Difficulty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateProblemRequest(
        @NotBlank
        @Size(max = 200)
        String title,

        @NotBlank
        String description,

        @NotNull
        Difficulty difficulty
) {
}
package com.patangeamit.algostar.repository;

import com.patangeamit.algostar.model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Problem, Long> {

}
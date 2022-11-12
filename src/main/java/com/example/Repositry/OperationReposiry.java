package com.example.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.query.Entity.Operation;

public interface OperationReposiry extends JpaRepository<Operation, Long> {

}

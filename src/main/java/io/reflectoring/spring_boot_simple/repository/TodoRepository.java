package io.reflectoring.spring_boot_simple.repository;

import io.reflectoring.spring_boot_simple.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, String> {
    public Todo findByTitle(String title);
}

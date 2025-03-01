package dev.nkh.todo.repository;

import dev.nkh.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepositoryJpa extends JpaRepository<Task, Long> {
}

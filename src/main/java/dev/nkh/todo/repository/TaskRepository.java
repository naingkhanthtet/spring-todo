package dev.nkh.todo.repository;

import dev.nkh.todo.model.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository {
    private final JdbcTemplate jdbcTemplate;

    public TaskRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Map ResultSet to Task object
    private final RowMapper<Task> taskRowMapper = (rs, rowNum) -> {
        Task task = new Task();
        task.setId(rs.getLong("id"));
        task.setTitle(rs.getString("title"));
        task.setCompleted(rs.getBoolean("completed"));
        return task;
    };

    // Retrieve all tasks
    public List<Task> findAll() {
        String sql = "SELECT * FROM tasks";
        return jdbcTemplate.query(sql, taskRowMapper);
    }

    // Add a new task
    public void save(Task task) {
        String sql = "INSERT INTO tasks (title, completed) VALUES (?, ?)";
        jdbcTemplate.update(sql, task.getTitle(), task.isCompleted());
    }

    // Update task completion status
    public void updateCompletion(long id, boolean completed) {
        String sql = "UPDATE tasks SET completed = ? WHERE id = ?";
        jdbcTemplate.update(sql, completed, id);
    }

    // Delete a task
    public void delete(long id) {
        String sql = "DELETE FROM tasks WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}

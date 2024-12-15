package dev.nkh.todo.service;

import dev.nkh.todo.model.Task;
import dev.nkh.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void addTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void toggleTaskCompletion(long id) {
        Task task = taskRepository.findAll().stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Task not found!"));
        taskRepository.updateCompletion(id, !task.isCompleted());
    }

    public void deleteTask(long id) {
        taskRepository.delete(id);
    }

}

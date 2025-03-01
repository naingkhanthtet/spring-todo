package dev.nkh.todo.controller;

import dev.nkh.todo.model.Task;
import dev.nkh.todo.repository.TaskRepositoryJpa;
import dev.nkh.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class TaskControllerJpa {
    @Autowired
    private TaskRepositoryJpa taskRepositoryJpa;

    public TaskControllerJpa(TaskService taskService) {
        this.taskRepositoryJpa = taskRepositoryJpa;
    }

    @GetMapping("/")
    public String getTasks() {
        taskRepositoryJpa.findAll();
        return "tasks/list";
    }

    @PostMapping("/tasks/jpa")
    public String addTask(@RequestParam("title") String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepositoryJpa.save(task);
        return "redirect:/";
    }

    @PostMapping("/tasks/jpa/toggle")
    public String toggleTaskCompletion(@RequestParam("id") long id) {
        Optional<Task> optionalTask = taskRepositoryJpa.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setCompleted(!task.isCompleted());
            taskRepositoryJpa.save(task);
        }
        return "redirect:/";
    }

    @PostMapping("/tasks/jpa/delete")
    public String deleteTask(@RequestParam("id") long id) {
        taskRepositoryJpa.deleteById(id);
        return "redirect:/";
    }
}

package dev.nkh.todo.controller;

import dev.nkh.todo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks/list";
    }

    @PostMapping("/tasks")
    public String addTask(@RequestParam("title") String title) {
        taskService.addTask(title);
        return "redirect:/";
    }

    @PostMapping("/tasks/toggle")
    public String toggleTaskCompletion(@RequestParam("id") long id) {
        taskService.toggleTaskCompletion(id);
        return "redirect:/";
    }

    @PostMapping("/tasks/delete")
    public String deleteTask(@RequestParam("id") long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }
}


package com.taskmanager.taskmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TaskController {

    private List<String> tasks = new ArrayList<>();

    // Show all tasks
    @GetMapping("/task")
    public String taskManagement(Model model) {
        model.addAttribute("tasks", tasks);
        return "task";
    }

    // Add a new task
    @PostMapping("/process_task")
    public String addTask(@RequestParam("taskName") String taskName) {
        if(taskName != null && !taskName.trim().isEmpty()) {
            tasks.add(taskName.trim());
            System.out.println("Task added: " + taskName);
        }
        return "redirect:/task";
    }

    // Delete a task by number
    @PostMapping("/delete_task")
    public String deleteTask(@RequestParam("taskNumber") int taskNumber,
                             RedirectAttributes redirectAttributes) {

        if(taskNumber > 0 && taskNumber <= tasks.size()) {
            String removedTask = tasks.remove(taskNumber - 1);
            System.out.println("Task deleted: " + removedTask);
        } else {
            redirectAttributes.addFlashAttribute("wrongIndex", true);
        }

        return "redirect:/task";
    }
}

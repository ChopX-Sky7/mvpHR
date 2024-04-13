package com.example.mvphr.Controllers;



import com.example.mvphr.Entities.Employee;
import com.example.mvphr.Repos.EmployeeRepository;
import com.example.mvphr.Services.Impl.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/employers")
@Slf4j
public class EmployeeController {

    // private final String UPLOAD_DIR = "src/main/resources/static/TaskFiles/";


    private final EmployeeRepository repo;
    private final EmployeeServiceImpl service;

    @Autowired
    public EmployeeController(
            EmployeeRepository repo,
            EmployeeServiceImpl service) {
        this.repo = repo;
        this.service = service;
    }

    @ModelAttribute
    private Employee employee() {
        return new Employee();
    }


    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("employee", employee());
        return "AddEmployee";
    }

    @PostMapping
    public String uploadFile(/*@RequestParam("file") MultipartFile file,*/
                             @ModelAttribute("employee") Employee e) {
    service.setInfo(e,
            e.getSurname(),
            e.getName(),
            e.getSecname(),
            e.getTg(),
            e.getRole(),
            String.valueOf(e.getStartOfWork()));
    repo.save(e);
    log.info("saved: {}", e);
        //String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        // Сохранение файла
    /*    try {
            Path path = Paths.get(UPLOAD_DIR + task.getTaskUploadTime() + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            service.setInfoTask(task, String.valueOf(path),
                    task.getTaskTitle(),
                    task.getTaskDescription(),
                    task.getTaskCategory());
            repository.save(task);

            log.info("Saved: {} in path :{}", file,path);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        return "redirect:/";
    }

}

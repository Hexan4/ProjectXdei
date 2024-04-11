package pl.SpringProject.ProjectX.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class MainPageController {
    @GetMapping
    public String getGreeting(){
        return new String("Hello there! - https://www.youtube.com/watch?v=dQw4w9WgXcQ");
    }
}

package homework.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerNew {
    @GetMapping("/")
    public String showpublicInfo() {
    return "publicInfo";
    }
    @GetMapping("/employee")
    public String showEmployeeInfo() {
        return "employeeInfo";
    }

    @GetMapping("/it")
    public String showItInfo() {
        return "itInfo";
    }

    @GetMapping("/security")
    public String showSecurityInfo() {
        return "securityInfo";
    }

    @GetMapping("/director")
    public String showDirectorInfo() {
        return "directorInfo";
    }

}

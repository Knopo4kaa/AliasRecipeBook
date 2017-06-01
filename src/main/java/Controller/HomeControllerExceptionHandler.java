package Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = {HomeController.class})
public class HomeControllerExceptionHandler {

    @ExceptionHandler(value = {NullPointerException.class})
    public String handleNullPointerException(){
        System.out.println("Handling NullPointerException!");
        return "redirect:/login";
    }
}

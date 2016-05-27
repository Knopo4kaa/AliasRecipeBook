package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by drowerik on 27.05.16.
 */

@ControllerAdvice
public class ExceptionController {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e){

        ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        return mav;
    }
}

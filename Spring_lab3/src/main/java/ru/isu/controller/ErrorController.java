package ru.isu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {
    @GetMapping("/errors")
    public ModelAndView errorPage(HttpServletRequest httpRequest) {
        ModelAndView errorPage = new ModelAndView("pages_error");
        int errorCode = (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
        String errorMsg;
        switch (errorCode) {
            case 400:
                errorMsg = "Error 400: Bad Request";
                break;
            case 404:
                errorMsg = "Error 404: Not Found";
                break;
            case 500:
                errorMsg = "Error 500: Internal Server Error";
                break;
            case 502:
                errorMsg = "Error 502: Bad Gateway";
                break;
            default:
                errorMsg = "Error " + errorCode;
                break;
        }
        errorPage.addObject("errorMsg", errorMsg);
        return errorPage;
    }
}

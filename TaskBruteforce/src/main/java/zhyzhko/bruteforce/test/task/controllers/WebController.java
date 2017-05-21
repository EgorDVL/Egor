package zhyzhko.bruteforce.test.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zhyzhko.bruteforce.test.task.bean.Password;
import zhyzhko.bruteforce.test.task.service.WebServiceBrute;

import javax.servlet.http.HttpSession;

/**
 * Created by Egor on 27.02.2017.
 */
@Controller
public class WebController {

    @Autowired
    private WebServiceBrute webServiceBrute;

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public String writePassword(Password password) {
        int result = webServiceBrute.getPassword(password.getPassword(), 7);// parameter maxlen - amount of numbers!!!!
        System.out.println("Result : " + result);
        return "show-password-result";
    }
}

package org.springboot.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by goldendba@gmail.com on 2017/3/3.
 */
@Controller
public class SysController {
    @RequestMapping("/")
    public String home(Model model) {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}

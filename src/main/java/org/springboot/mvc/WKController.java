package org.springboot.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by goldendba@gmail.com on 2017/3/3.
 */
@Controller
@RequestMapping("/wk")
public class WKController {

    @RequestMapping("/list")
    public String list(){ return "wk/list";}
}

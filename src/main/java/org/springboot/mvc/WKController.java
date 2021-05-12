package org.springboot.mvc;

import org.springboot.dao.WkRepository;
import org.springboot.jdo.WorkingHours;
import org.springboot.service.WkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by goldendba@gmail.com on 2017/3/3.
 */
@Controller
@RequestMapping("/wk")
public class WkController {
    @Autowired
    private WkService wkService;
    @Autowired
    private WkRepository wkRepository;

    @RequestMapping("/list")
    public String list(Model model) {
        WorkingHours wk = new WorkingHours();
        wk.setSeq(1);
        wk.setAcceptCount(1);
        wk.setRejectCount(1);
        wk.setCompromiseCount(5);
        wk.setStandbyCount(10);
        wkRepository.saveAndFlush(wk);

        List<WorkingHours> list = wkService.list();

        model.addAttribute("wks", list);
        return "wk/list";
    }
}

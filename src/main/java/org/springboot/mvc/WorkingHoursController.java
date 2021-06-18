package org.springboot.mvc;

import org.springboot.jdo.WorkingHours;
import org.springboot.service.WorkingHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 计件工时管理.
 * <p>
 * Created by goldendba@gmail.com on 2017/3/3.
 */
@Controller
@RequestMapping("/wk")
public class WorkingHoursController {
    @Autowired
    private WorkingHoursService workingHoursService;

    @RequestMapping("/edit_view")
    public String editView() {
        return "wk/edit";
    }

    @RequestMapping("/edit")
    public String edit(Model model) {
        WorkingHours workingHours = null;
        workingHoursService.save(workingHours);
        return "wk/list";
    }

    @RequestMapping("/list_view")
    public String listView() {
        return "wk/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<WorkingHours> list() {
        return workingHoursService.list();
    }
}

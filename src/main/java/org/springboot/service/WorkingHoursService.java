package org.springboot.service;

import org.hibernate.jdbc.Work;
import org.springboot.dao.WorkingHoursRepository;
import org.springboot.jdo.WorkingHours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by goldendba@gmail.com on 2017/3/3.
 */
@Component
public class WorkingHoursService {
    @Autowired
    WorkingHoursRepository workingHoursRepository;

    public List<WorkingHours> list() {
        return workingHoursRepository.findAll();
    }

    public void save(WorkingHours workingHours){
        workingHoursRepository.save(workingHours);
    }
}

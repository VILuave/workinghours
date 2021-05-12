package org.springboot.service;

import org.springboot.dao.WkRepository;
import org.springboot.jdo.WorkingHours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by goldendba@gmail.com on 2017/3/3.
 */
@Component
public class WkService {
    @Autowired
    WkRepository wkRepository;

    public List<WorkingHours> list() {
        return wkRepository.findAll();
    }
}

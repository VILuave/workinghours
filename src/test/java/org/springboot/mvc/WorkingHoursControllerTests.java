package org.springboot.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springboot.WorkinghoursApplication;
import org.springboot.dao.WorkingHoursRepository;
import org.springboot.jdo.Part;
import org.springboot.jdo.Product;
import org.springboot.jdo.WorkingHours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 计件工时Mvc Mock类.
 * <p>
 * Created by goldendba@gmail.com on 2017/3/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WorkinghoursApplication.class)
@WebAppConfiguration
public class WorkingHoursControllerTests {
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private WorkingHoursRepository workingHoursRepository;

    String expectedJson;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        WorkingHours workingHours = new WorkingHours();
        Product product = new Product();
        product.setProductNum("顺田");
        product.setProductName("40缸");
        Part part = new Part();
        part.setPartImgNum("HSG40/25");
        part.setPartName("缸桶");

        workingHours.setCreateTime(new Date());
        workingHours.setCreateBy("goldendba@gmail.com");
        workingHours.setRemark("测试数据");
        //workingHours.setProduct(product);
        workingHours.setSeq(1);
        //workingHours.setPart(part);
        workingHours.setAcceptCount(2); //接收数量
        workingHours.setBasicWk(1.6); //基本工时
        workingHours.setAssistWk(3.5); //辅助工时
        workingHours.setQualifiedCount(2); //合格数
        workingHours.setCompromiseCount(0); //让步接受数
        workingHours.setStandbyCount(0); //待用数
        workingHours.setRejectCount(0); //报废数
        workingHoursRepository.save(workingHours);

        List<WorkingHours> workingHourses = workingHoursRepository.findAll();
        expectedJson = new ObjectMapper().writeValueAsString(workingHourses);
    }

    @Test
    public void testWorkingHoursController() throws Exception {
        RequestBuilder request = get("/wk/list");

        MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }
}

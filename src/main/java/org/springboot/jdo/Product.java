package org.springboot.jdo;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * 产品JDO
 * <p>
 * Created by goldendba@gmail.com on 2017/3/3.
 */
@Entity
@Table(name = "product")
public class Product extends IdEntity {

    private Set<WorkingHours> workingHoursList;
    /**
     * 产品编号.
     */
    private String productNum;
    /**
     * 产品名称.
     */
    private String productName;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    public Set<WorkingHours> getWorkingHoursList() {
        return workingHoursList;
    }

    public void setWorkingHoursList(Set<WorkingHours> workingHoursList) {
        this.workingHoursList = workingHoursList;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}

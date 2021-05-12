package org.springboot.jdo;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 产品JDO
 *
 * Created by goldendba@gmail.com on 2017/3/3.
 */
@Entity
@Table(name = "product")
public class Product extends IdEntity{
    /**
     * 产品编号.
     */
    private String productNum;
    /**
     * 产品名称.
     */
    private String productName;

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

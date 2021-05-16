package org.springboot.jdo;

import javax.persistence.*;

/**
 * 记件工时.
 * <p>
 * Created by goldendba@gmail.com on 2017/3/3.
 */
@Entity
@Table(name = "wk")
public class WorkingHours extends AuditableEntity {
    /**
     * 工序号.
     */
    private int seq;

    /**
     * 接收数量.
     */
    private int acceptCount;

    /**
     * 让步接受数量.
     */
    private int compromiseCount;

    /**
     * 待用数量.
     */
    private int standbyCount;

    /**
     * 报废数量.
     */
    private int rejectCount;
    /**
     * 合格数量.
     */
    private int qualifiedCount;

    /**
     * 基本工时.
     */
    private double basicWk;

    /**
     * 辅助工时.
     */
    private double assistWk;

    /**
     * 备注.
     */
    private String remark;

    /**
     * 对应产品.
     */
    private Product product;

    /**
     * 对应零件.
     */
    private Part part;


    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getAcceptCount() {
        return acceptCount;
    }

    public void setAcceptCount(int acceptCount) {
        this.acceptCount = acceptCount;
    }

    public int getCompromiseCount() {
        return compromiseCount;
    }

    public void setCompromiseCount(int compromiseCount) {
        this.compromiseCount = compromiseCount;
    }

    public int getStandbyCount() {
        return standbyCount;
    }

    public void setStandbyCount(int standbyCount) {
        this.standbyCount = standbyCount;
    }

    public int getRejectCount() {
        return rejectCount;
    }

    public void setRejectCount(int rejectCount) {
        this.rejectCount = rejectCount;
    }

    public int getQualifiedCount() {
        return qualifiedCount;
    }

    public void setQualifiedCount(int qualifiedCount) {
        this.qualifiedCount = qualifiedCount;
    }

    public double getBasicWk() {
        return basicWk;
    }

    public void setBasicWk(double basicWk) {
        this.basicWk = basicWk;
    }

    public double getAssistWk() {
        return assistWk;
    }

    public void setAssistWk(double assistWk) {
        this.assistWk = assistWk;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "part_id")
    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }
}

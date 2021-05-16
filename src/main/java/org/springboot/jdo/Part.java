package org.springboot.jdo;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * 零件JDO
 * <p>
 * Created by goldendba@gmail.com on 2017/3/3.
 */
@Entity
@Table(name = "part")
public class Part extends IdEntity {

    private Set<WorkingHours> workingHoursList;
    /**
     * 零件图号.
     */
    private String partImgNum;
    /**
     * 零件名称.
     */
    private String partName;

    @OneToMany(mappedBy = "workingHours")
    public Set<WorkingHours> getWorkingHoursList() {
        return workingHoursList;
    }

    public void setWorkingHoursList(Set<WorkingHours> workingHoursList) {
        this.workingHoursList = workingHoursList;
    }

    public String getPartImgNum() {
        return partImgNum;
    }

    public void setPartImgNum(String partImgNum) {
        this.partImgNum = partImgNum;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }
}

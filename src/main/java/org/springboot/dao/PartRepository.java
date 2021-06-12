package org.springboot.dao;

import org.springboot.jdo.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by goldendba@gmail.com on 2017/3/3.
 */
@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
    Part findByPartName(String partName);
}

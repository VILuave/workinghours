package org.springboot.dao;

import org.springboot.jdo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by goldendba@gmail.com on 2017/3/3.
 */
@Repository
public interface ProRepository extends JpaRepository<Product, Long> {
}

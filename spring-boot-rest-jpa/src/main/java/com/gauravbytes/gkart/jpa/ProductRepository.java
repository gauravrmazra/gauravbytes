package com.gauravbytes.gkart.jpa;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gauravbytes.gkart.entity.Product;

/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="http://www.gauravbytes.com">Catch me</a>
 */
@Transactional
public interface ProductRepository extends JpaRepository<Product, String> {

}

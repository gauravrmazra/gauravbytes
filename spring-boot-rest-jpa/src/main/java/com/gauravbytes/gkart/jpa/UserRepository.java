package com.gauravbytes.gkart.jpa;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gauravbytes.gkart.entity.User;

/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="http://www.gauravbytes.com">Catch me</a>
 */
@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, String> {

}

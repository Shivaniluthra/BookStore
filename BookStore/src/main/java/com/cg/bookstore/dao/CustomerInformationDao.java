package com.cg.bookstore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entities.CustomerInformation;

@Repository
public interface CustomerInformationDao extends CrudRepository<CustomerInformation, Integer>{

}

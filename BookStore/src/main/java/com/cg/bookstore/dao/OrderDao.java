package com.cg.bookstore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entities.OrderInformation;

@Repository
public interface OrderDao extends CrudRepository<OrderInformation, Integer>{

}

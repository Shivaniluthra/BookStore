package com.cg.bookStore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookStore.entities.OrderInformation;

@Repository
public interface OrderDao extends CrudRepository<OrderInformation, Integer>{

}

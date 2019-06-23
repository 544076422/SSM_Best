package cn.rbc.service;

import cn.rbc.domain.Orders;

import java.util.List;

public interface OrderService {

    List<Orders> findAll(int pageNum,int pageSize);

    Orders findById(String id);
}

package cn.rbc.service.impl;

import cn.rbc.dao.OrderDao;
import cn.rbc.domain.Orders;
import cn.rbc.service.OrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public List<Orders> findAll(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return orderDao.findAll();
    }

    @Override
    public Orders findById(String id) {
        return orderDao.findById(id);
    }
}

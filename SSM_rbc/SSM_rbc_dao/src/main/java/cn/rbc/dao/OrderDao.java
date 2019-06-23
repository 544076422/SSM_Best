package cn.rbc.dao;

import cn.rbc.domain.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderDao {
    @Select("select * from orders")
    @Results({
            @Result(id =true ,property = "id" , column = "id" ),
            @Result(property = "orderNum" , column = "orderNum"),
            @Result(property = "orderTime" , column = "orderTime"),
            @Result(property = "orderStatus" , column = "orderStatus"),
            @Result(property = "peopleCount" , column = "peopleCount"),
            @Result(property = "product" , column = "productId" , one = @One(select = "cn.rbc.dao.ProductDao.findById"))
    })
    List<Orders> findAll();
    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id =true ,property = "id" , column = "id" ),
            @Result(property = "orderNum" , column = "orderNum"),
            @Result(property = "orderTime" , column = "orderTime"),
            @Result(property = "orderStatus" , column = "orderStatus"),
            @Result(property = "peopleCount" , column = "peopleCount"),
            @Result(property = "product" , column = "productId" , one = @One(select = "cn.rbc.dao.ProductDao.findById")),
            @Result(property = "member" , column = "memberId" , one = @One(select = "cn.rbc.dao.MemberDao.findById")),
            @Result(property = "travellers", column = "id" ,many = @Many(select = "cn.rbc.dao.TravellerDao.findByOrdersId"))
    })
    Orders findById(String id);
}

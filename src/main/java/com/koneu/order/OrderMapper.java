package com.koneu.order;

import com.koneu.order.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by aaron on 16-7-17.
 */
@Mapper
public interface OrderMapper {

    @Select("select * from t_order where id = #{id}")
    @Results(value = {
            @Result(property = "orderDate", column = "ORDER_DATE"),
            @Result(property = "orderBy", column = "ORDER_BY"),
            @Result(property = "orderStatus", column = "STATUS")
    })
    public Order get(@Param("id") Long id);

    @Select("select * from t_order")
    @Results(value = {
            @Result(property = "orderDate", column = "ORDER_DATE"),
            @Result(property = "orderBy", column = "ORDER_BY"),
            @Result(property = "orderStatus", column = "STATUS")
    })
    public List<Order> getAll();

    @Insert("insert into t_order(order_date, order_by, subtotal, status) values(#{orderDate}, #{orderBy}, #{subtotal}, #{orderStatus})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    public void insert(Order order);

    @Update("update t_order set order_date=#{order.orderDate}, order_by=#{order.orderBy}, subtotal=#{order.subtotal}, status=#{order.orderStatus} where id=#{id}")
    public Integer update(@Param("id") Long id, @Param("order") Order order);

    @Delete("delete from t_order where id=#{id}")
    public void delete(@Param("id") Long id);
}

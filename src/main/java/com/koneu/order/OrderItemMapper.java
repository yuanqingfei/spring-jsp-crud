package com.koneu.order;

import com.koneu.order.OrderItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by aaron on 16-7-17.
 */
@Mapper
public interface OrderItemMapper {

    @Select("select * from t_order_item where id = #{id}")
    @Results(value = {
            @Result(property = "orderId", column = "ORDER_ID"),
            @Result(property = "courseId", column = "COURSE_ID"),
            @Result(property = "unitPrice", column = "UNIT_PRICE")
    })
    public OrderItem get(@Param("id") Long id);

    @Select("select * from t_order_item")
    @Results(value = {
            @Result(property = "orderId", column = "ORDER_ID"),
            @Result(property = "courseId", column = "COURSE_ID"),
            @Result(property = "unitPrice", column = "UNIT_PRICE")
    })
    public List<OrderItem> getAll();

    @Select("select * from t_order_item where order_id = #{orderId}")
    @Results(value = {
            @Result(property = "orderId", column = "ORDER_ID"),
            @Result(property = "courseId", column = "COURSE_ID"),
            @Result(property = "unitPrice", column = "UNIT_PRICE")
    })
    public List<OrderItem> getByOrderId(@Param("orderId") Long orderId);

    @Select("select * from t_order_item where course_id = #{courseId}")
    @Results(value = {
            @Result(property = "orderId", column = "ORDER_ID"),
            @Result(property = "courseId", column = "COURSE_ID"),
            @Result(property = "unitPrice", column = "UNIT_PRICE")
    })
    public List<OrderItem> getByCourseId(@Param("courseId") Long courseId);

    @Insert("insert into t_order_item(order_id, course_id, quantity, unit_price) values(#{orderId}, #{courseId}, #{quantity}, #{unitPrice})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    public void insert(OrderItem orderItem);

    @Update("update t_order_item set order_id=#{orderItem.orderId}, course_id=#{orderItem.courseId}, quantity=#{orderItem.quantity}, " +
            "unit_price=#{orderItem.unitPrice} where id=#{id}")
    public Integer update(@Param("id") Long id, @Param("orderItem") OrderItem orderItem);

    @Delete("delete from t_order_item where id=#{id}")
    public void delete(@Param("id") Long id);
}

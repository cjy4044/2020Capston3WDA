package com.vote.vote.repository;

import java.util.List;

import com.vote.vote.db.customSelect.CustomOrderState;
import com.vote.vote.db.customSelect.OrderInterface;
import com.vote.vote.db.dto.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// @SqlResultSetMapping(
//         name="orderStateMapping",
//         classes = @ConstructorResult(
//             targetClass = CustomOrderState.class,
//             columns ={
//                 @ColumnResult(name="product_id", type = Integer.class),
//                 @ColumnResult(name="name", type = String.class),
//                 @ColumnResult(name="sum", type = Integer.class),
//                 @ColumnResult(name="one", type = Integer.class),
//                 @ColumnResult(name="two", type = Integer.class),
//                 @ColumnResult(name="three", type = Integer.class),
//                 @ColumnResult(name="four", type = Integer.class),
//                 @ColumnResult(name="five", type = Integer.class)
//             }
//         )
//     )
    
public interface OrderJpaRepository extends JpaRepository<Order, Integer> {
    public Order findByOrderId(int orderId);
    
    
    @Query(value =
        "select l.product_id ,p.p_name name, count(*)  sum, "+
        "count ( case when o.orderdate between add_months(sysdate,-1) and sysdate then 1 end) one, "+
        "count ( case when o.orderdate between add_months(sysdate,-2) and add_months(sysdate,-1) then 1 end) two, "+
        "count ( case when o.orderdate between add_months(sysdate,-3) and add_months(sysdate,-2) then 1 end) three, "+
        "count ( case when o.orderdate between add_months(sysdate,-4) and add_months(sysdate,-3) then 1 end) four, "+
        "count ( case when o.orderdate between add_months(sysdate,-5) and add_months(sysdate,-4) then 1 end) five "+
        "from r_order o , orderlist l, product p "+
        "where o.order_id = l.order_id "+
        "and l.product_id = p.product_id "+
        "and  l.product_id in (select product_id from product where p_manager = :managerId) "+
        "group by l.product_id, p.p_name "
    , nativeQuery = true)
    List<Object> getOrderState(@Param("managerId") int managerId);
}

// @Query(value = "select * from vote where voteid in (select voteid from voter where r_id = :userid)", nativeQuery = true)
    //  "count ( case when o.orderdate between add_months(sysdate,-1) and sysdate then 1 end) one,"+
    //  "count ( case when o.orderdate between add_months(sysdate,-2) and add_months(sysdate,-1) then 1 end) two,"+
    //  "count ( case when o.orderdate between add_months(sysdate,-3) and add_months(sysdate,-2) then 1 end) three,"+
    //  "count ( case when o.orderdate between add_months(sysdate,-4) and add_months(sysdate,-3) then 1 end) four,"+
    //  "count ( case when o.orderdate between add_months(sysdate,-5) and add_months(sysdate,-4) then 1 end) five"+
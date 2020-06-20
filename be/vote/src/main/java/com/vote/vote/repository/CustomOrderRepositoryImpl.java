package com.vote.vote.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.vote.vote.db.customSelect.CustomOrderState;
import com.vote.vote.db.dto.QOrder;
import com.vote.vote.db.dto.QOrderList;
import com.vote.vote.db.dto.QPrd;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomOrderRepositoryImpl implements CustomOrderReopsitoy {

    @PersistenceContext
    private EntityManager em;

    private QOrder order = QOrder.order;
    private QOrderList list = QOrderList.orderList;
    private QPrd prd = QPrd.prd;
    
    @Override
    public List<CustomOrderState> getOrderStateByManagerId(int managerId) {
        CaseBuilder a = new CaseBuilder();
        
        JPAQueryFactory query = new JPAQueryFactory(em); // 실제로 쿼리 되는 문장?

        BooleanBuilder booleanBuilder = new BooleanBuilder(); //여기다가 조건절을 단다.

        // booleanBuilder.and(order.rId.eq(managerId));
        String sql = 
        "select l.product_id ,p.p_name name, count(*)  sum, "+
        "count ( case when o.orderdate between add_months(sysdate,-1) and sysdate then 1 end) one, "+
        "count ( case when o.orderdate between add_months(sysdate,-2) and add_months(sysdate,-1) then 1 end) two, "+
        "count ( case when o.orderdate between add_months(sysdate,-3) and add_months(sysdate,-2) then 1 end) three, "+
        "count ( case when o.orderdate between add_months(sysdate,-4) and add_months(sysdate,-3) then 1 end) four, "+
        "count ( case when o.orderdate between add_months(sysdate,-5) and add_months(sysdate,-4) then 1 end) five "+
        "from r_order o , orderlist l, product p "+
        "where o.order_id = l.order_id "+
        "and l.product_id = p.product_id "+
        "and  l.product_id in (select product_id from product where p_manager = "+managerId+") "+
        "group by l.product_id, p.p_name ";

        Query nativeQuery  = em.createNativeQuery(sql);
        // .setParameter("mId", managerId);
        // .getResultList();
        JpaResultMapper jpaResultMapper = new JpaResultMapper();
        List<CustomOrderState>  result = jpaResultMapper.list(nativeQuery, CustomOrderState.class);

        return result;
    }
    
        
// select l.product_id ,p.p_name,count(*) 전체 , 
// count ( case when o.orderdate between add_months(sysdate,-1) and sysdate then 1 end) 한달,
// count ( case when o.orderdate between add_months(sysdate,-2) and add_months(sysdate,-1) then 1 end) 두달,
// count ( case when o.orderdate between add_months(sysdate,-3) and add_months(sysdate,-2) then 1 end) 세달,
// count ( case when o.orderdate between add_months(sysdate,-4) and add_months(sysdate,-3) then 1 end) 네달,
// count ( case when o.orderdate between add_months(sysdate,-5) and add_months(sysdate,-4) then 1 end) 다섯달
// from r_order o , orderlist l, product p
// where o.order_id = l.order_id
// and l.product_id = p.product_id
// and  l.product_id in (select product_id from product where p_manager = '261')
// group by l.product_id, p.p_name
}
package com.vote.vote.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.vote.vote.db.customSelect.CustomOrderList;
import com.vote.vote.db.customSelect.CustomOrderListSelect;
import com.vote.vote.db.dto.QMember;
import com.vote.vote.db.dto.QOrder;
import com.vote.vote.db.dto.QOrderList;
import com.vote.vote.db.dto.QPrd;
import com.vote.vote.db.dto.QPrdOption;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class CustomOrderListRepositoryImpl implements CustomOrderListRepository {

    @PersistenceContext
    private EntityManager em;

    private QOrder order = QOrder.order;
    private QOrderList list = QOrderList.orderList;
    private QPrd prd = QPrd.prd;
    private QPrdOption option = QPrdOption.prdOption;
    private QMember member = QMember.member;



    @Override
    public CustomOrderListSelect getOrderListbyUserId(int r_id, Pageable page) {
        JPAQueryFactory query = new JPAQueryFactory(em); // 실제로 쿼리 되는 문장?

        BooleanBuilder booleanBuilder = new BooleanBuilder(); //여기다가 조건절을 단다.

        booleanBuilder.and(order.rId.eq(r_id));

        List<CustomOrderList> items =

        query.select(Projections.bean(CustomOrderList.class, 
           order.orderId,
           order.addr,
           order.addr2,
           order.phone,
           order.invoice,
           order.orderDate,
           order.price.as("sumPrice"),
           list.orderListId,
           list.optionId,
           list.price.as("itemPrice"),
           list.count,
           prd.name,
           prd.img,
           option.oTitle
        ))
        .from(order)
        .join(list).on(order.orderId.eq(list.orderId))
        .join(prd).on(list.productId.eq(prd.productId))
        .join(option).on(list.optionId.eq(option.optionId))
        .where(booleanBuilder)
        .offset(page.getOffset()).limit(page.getPageSize())
        .orderBy(order.orderId.desc()) // 최신순 내림차순
        .fetch();

        Long count = 
        query.select(Projections.bean(CustomOrderList.class, 
           order.orderId,
           order.addr,
           order.addr2,
           order.phone,
           order.invoice,
           order.orderDate,
           order.price.as("sumPrice"),
           list.orderListId,
           list.optionId,
           list.price.as("itemPrice"),
           list.count,
           prd.name,
           prd.img,
           option.oTitle
        ))
        .from(order)
        .join(list).on(order.orderId.eq(list.orderId))
        .join(prd).on(list.productId.eq(prd.productId))
        .join(option).on(list.optionId.eq(option.optionId))
        .where(booleanBuilder)
        .fetchCount();

        CustomOrderListSelect result = new CustomOrderListSelect();
        result.setOrderList(items);
        result.setCount(count.intValue());

        return result;
    }
        

    @Override
    public CustomOrderListSelect getOrderListbyOrderListId(int orderListId) {
        JPAQueryFactory query = new JPAQueryFactory(em); // 실제로 쿼리 되는 문장?

        BooleanBuilder booleanBuilder = new BooleanBuilder(); //여기다가 조건절을 단다.

        booleanBuilder.and(list.orderListId.eq(orderListId));

        List<CustomOrderList> items =

        query.select(Projections.bean(CustomOrderList.class, 
           order.orderId,
           order.addr,
           order.addr2,
           order.phone,
           order.invoice,
           order.orderDate,
           order.receiver,
           order.state,
           order.price.as("sumPrice"),
           list.orderListId,
           list.optionId,
           list.price.as("itemPrice"),
           list.count,
           prd.productId,
           prd.name,
           prd.img,
           option.oTitle
        ))
        .from(order)
        .join(list).on(order.orderId.eq(list.orderId))
        .join(prd).on(list.productId.eq(prd.productId))
        .join(option).on(list.optionId.eq(option.optionId))
        .where(booleanBuilder)
        .orderBy(order.orderId.desc()) // 최신순 내림차순
        .fetch();

         // 주문 상세이기 때문에, count 는 필요없음 

        // Long count = 
        // query.select(Projections.bean(CustomOrderList.class, 
        //    order.orderId,
        //    order.addr,
        //    order.addr2,
        //    order.phone,
        //    order.invoice,
        //    order.orderDate,
        //    order.price.as("sumPrice"),
        //    list.optionId,
        //    list.price.as("itemPrice"),
        //    list.count,
        //    prd.name,
        //    prd.img,
        //    option.oTitle
        // ))
        // .from(order)
        // .join(list).on(order.orderId.eq(list.orderId))
        // .join(prd).on(list.productId.eq(prd.productId))
        // .join(option).on(list.optionId.eq(option.optionId))
        // .where(booleanBuilder)
        // .fetchCount();

        CustomOrderListSelect result = new CustomOrderListSelect();
        result.setOrderList(items);
        

        return result;

    }


	@Override
	public CustomOrderListSelect getOrderListByManagerId(int managerId, Pageable page) {
        
        
        JPAQueryFactory query = new JPAQueryFactory(em); // 실제로 쿼리 되는 문장?

        BooleanBuilder booleanBuilder = new BooleanBuilder(); //여기다가 조건절을 단다.

        booleanBuilder.and(prd.manager.eq(managerId));

        List<CustomOrderList> items =

        query.select(Projections.bean(CustomOrderList.class, 
            order.orderId,
            order.addr,
            order.addr2,
            order.phone,
            order.invoice,
            order.orderDate,
            order.receiver,
            order.state,
            order.rId,
            order.price.as("sumPrice"),
            list.orderListId,
            list.optionId,
            list.price.as("itemPrice"),
            list.count,
            prd.manager,
            prd.productId,
            prd.name,
            prd.img,
            option.oTitle,
            member.name.as("clientName"),
            member.phone.as("clientPhone")
        ))
        .from(order)
        .join(list).on(order.orderId.eq(list.orderId))
        .join(prd).on(list.productId.eq(prd.productId))
        .join(option).on(list.optionId.eq(option.optionId))
        .join(member).on(order.rId.eq(member.no))
        .offset(page.getOffset()).limit(page.getPageSize())
        .where(booleanBuilder)
        .orderBy(order.orderId.desc()) // 최신순 내림차순
        .fetch();
        Long count =

        query.select(Projections.bean(CustomOrderList.class, 
            order.orderId,
            order.addr,
            order.addr2,
            order.phone,
            order.invoice,
            order.orderDate,
            order.receiver,
            order.state,
            order.rId,
            order.price.as("sumPrice"),
            list.orderListId,
            list.optionId,
            list.price.as("itemPrice"),
            list.count,
            prd.manager,
            prd.productId,
            prd.name,
            prd.img,
            option.oTitle,
            member.name.as("clientName"),
            member.phone.as("clientPhone")
        ))
        .from(order)
        .join(list).on(order.orderId.eq(list.orderId))
        .join(prd).on(list.productId.eq(prd.productId))
        .join(option).on(list.optionId.eq(option.optionId))
        .join(member).on(order.rId.eq(member.no))
        .offset(page.getOffset()).limit(page.getPageSize())
        .where(booleanBuilder)
        .orderBy(order.orderId.desc()) // 최신순 내림차순
        .fetchCount();

        CustomOrderListSelect result = new CustomOrderListSelect();
        result.setOrderList(items);
        result.setCount(count.intValue());

		return result;
	}

   
// select o.order_id, o.addr, o.addr2, o.phone, o.invoice, o.orderDate,
// o.price, l.option_id, l.price,l.count, p.p_name, p.image, po.o_title    -- 컬럼 몇개 더 추가..
// from R_order o, orderlist l, product p, product_option po
// where o.order_Id = l.order_Id
// and l.product_id = p.product_id
// and l.option_id = po.option_id
// --and o.r_id = '281'   -- 유저명으로 검색  -> 주문 리스트 
// --and o.order_id = 17  -- 주문 아이디로 검색  -> 주문 상세

    
}
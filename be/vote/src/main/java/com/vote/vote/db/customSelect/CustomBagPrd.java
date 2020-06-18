package com.vote.vote.db.customSelect;

public class CustomBagPrd {
 
// select * 
// from mybag b, 
//     (select p.product_id, p.p_name, p.image, o.option_id ,o.o_title, o.o_price, o.p_stock
//     from product p , product_option o
//     where p.product_id = o.product_id) g
// where b.product_id = g.product_id
// and b.option_id = g.option_id
// and b.r_id = '261'
// order by b.id desc
}
package com.vote.vote.goodsshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopController {

	@RequestMapping("/shop")
	public String index() {
		return "shop/shop_main";
	}
}
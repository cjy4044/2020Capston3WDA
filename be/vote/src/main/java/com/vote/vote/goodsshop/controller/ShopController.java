package com.vote.vote.goodsshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopController {

	@RequestMapping("/shop/index")
	public String index() {
		return "shop/index";
	}

	@RequestMapping("/shop/cart")
	public String cart() {
		return "shop/cart";
	}
}
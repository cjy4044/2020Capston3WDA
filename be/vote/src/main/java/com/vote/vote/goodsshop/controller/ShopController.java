package com.vote.vote.goodsshop.controller;

import com.vote.vote.repository.PrdJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopController {

	@Autowired
	PrdJpaRepository prdRepository;
	@RequestMapping("/shop/index")
	public String index(Model model) {

		// model.addAttribute("prdList", prdRepository.findAll());
		return "shop/index";

	}

	@RequestMapping("/shop/cart")
	public String cart() {
		return "shop/cart";
	}
}
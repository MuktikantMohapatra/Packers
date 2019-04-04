package com.packers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.packers.util.OnlinePayment;

@Controller
public class UDashBoardController {
	/*@RequestMapping(value = "userDashBoard", method = RequestMethod.GET)
	public String handler(@RequestParam("id") String id, Model model) {
		model.addAttribute("id", id);
		return "";
	}

	@RequestMapping(name = "payOnline", method = RequestMethod.GET)
	public String payOnline(Model model) {
		System.out.println("before ");
		OnlinePayment op = new OnlinePayment();
		System.out.println("After ");
		try {
			op.handler(model);
			System.out.println(model.containsAttribute("paytmCheckSum"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "onlinePay";
	}
*/
}

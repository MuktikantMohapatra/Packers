package com.packers.controller;

import java.util.Map.Entry;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.packers.bo.UserDetailsBO;
import com.packers.repo.UserDetailsRepository;
import com.paytm.pg.merchant.CheckSumServiceHelper;

@Controller
public class UserController {
	
	private final String merchantKey = "gKpu7IKaLSbkchFS";
	private String paytmChecksum = null;
	
	@Autowired
	private UserDetailsRepository userRepository;

	@GetMapping("/showRegister")
	public String showRegistrationPage() {

		return "registration1";
	}

	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute UserDetailsBO userDetails) {
		System.out.println(userDetails);
		userRepository.save(userDetails);
		System.out.println(userDetails);
		return "login1";
	}
	@PostMapping("/page")
	public String Page() {
		
		// Create a tree map from the form post param
		TreeMap<String, String> paytmParams = new TreeMap<String, String>();
		// Request is HttpServletRequest
		for (Entry<String, String[]> requestParamsEntry : request.getParameterMap().entrySet()) {
		    if ("CHECKSUMHASH".equalsIgnoreCase(requestParamsEntry.getKey())){
		        paytmChecksum = requestParamsEntry.getValue()[0];
		    } else {
		        paytmParams.put(requestParamsEntry.getKey(), requestParamsEntry.getValue()[0]);
		    }
		}
		// Call the method for verification
		boolean isValidChecksum = CheckSumServiceHelper.getCheckSumServiceHelper().verifycheckSum(merchantKey, paytmParams, paytmChecksum);
		// If isValidChecksum is false, then checksum is not valid
		if(isValidChecksum){
			System.out.append("Checksum Matched");
		}else{
			System.out.append("Checksum MisMatch");
		}
		return "page";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login1";
	}

	@PostMapping("/login")
	public String validateLogin(@RequestParam("email") String email, @RequestParam("password") String password,
			Model model) {

		UserDetailsBO userDetails = userRepository.findByEmail(email);
		if (userDetails != null && userDetails.getPassword().equals(password)) {
			model.addAttribute("name", userDetails.getName());
			model.addAttribute("id", userDetails.getId());
//			model.addAttribute("email", userDetails.getEmail());
//			model.addAttribute("phone", userDetails.getNumber());
			return "userDashBoard";
		} else {
			model.addAttribute("msg", "Incorrect email or password");
			return "login1";
		}
	}

}
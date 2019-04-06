package com.packers.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.packers.bo.BookingBO;
import com.packers.bo.UserDetailsBO;
import com.packers.repo.BookingRepository;
import com.packers.repo.UserDetailsRepository;
import com.packers.util.EmailUtil;
import com.packers.util.PDFGenerator;

@Controller
@RequestMapping("booking")
public class BookingController {
	@Value("com.packers.PDF.dir")
	private String PDF_FILE_PATH;

	@Autowired
	private EmailUtil email;

	@Autowired
	private PDFGenerator generatePDF;

	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private UserDetailsRepository userRepository;

	@GetMapping
	public String showBookingPage(@RequestParam("id") String id ,Model model) {
		
		model.addAttribute("name", id);
		model.addAttribute("id", id);
		
		return "booking";
	}

	@PostMapping
	public String confirmBooking(@ModelAttribute BookingBO bo) {
		Optional<UserDetailsBO> optBO = userRepository.findById(bo.getCustId());
		System.out.println(optBO);
		UserDetailsBO bo1 = optBO.get();
		System.out.println(bo);
		bookingRepository.save(bo);
		generatePDF.generatePDF(bo, PDF_FILE_PATH + bo.getBookingId() + ".pdf");
		email.sendBookingDetails(bo1.getEmail(), PDF_FILE_PATH + bo.getBookingId() + ".pdf");
		System.out.println("DD");
		return "ConfirmBooking";
	}
//	@RequestMapping(name="getAQuotation",method=RequestMethod.GET)
//	public String quotationHandler(@ModelAttribute ) {
//		return"";
//	}

}

package com.webproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	
	@Autowired
	CustomerRepository repo; 
 	@RequestMapping("/")
 	public String online() {
 		return "online";
 	}
     
 	@RequestMapping("/details")
 	public String details(Customers customers) {
 		repo.save(customers);
 		return "online";
 	}
	@RequestMapping("/getdetails")
 	public String getdetails() {
 		
 		return "ViewCustomers";
 	}
     
	@PostMapping("/getdetails")
	public ModelAndView getdetails(@RequestParam int cid) {
		ModelAndView mv=new ModelAndView("Retrieve");
	    Customers customers=repo.findById(cid).orElse(null);
	    mv.addObject(customers);
	    return mv;
	}
	
}

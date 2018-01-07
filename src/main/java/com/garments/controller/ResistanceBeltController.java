package com.garments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.garments.constants.ProductConstants;
import com.garments.entities.ProductsCdtb;

@Controller
public class ResistanceBeltController {
	
	@RequestMapping(value="/resistanceBelt", method=RequestMethod.GET)
	public String updateProduct(@PathVariable String productCd, Model model) {
		return "resistanceBelt";
	}

}

package com.garments.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.garments.constants.ProductConstants;
import com.garments.entities.ProductsCdtb;
import com.garments.entities.ProductsColorCdtb;
import com.garments.service.ProductService;


@Controller
public class InventoryController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/inventory", method=RequestMethod.GET)
	public String showInventory(Model model) {
		
		return "inventory";
	}

	@RequestMapping(value="/getProductColor/{msg}", method=RequestMethod.GET)
	public String getProductsColor(@PathVariable String msg, Model model) {
		List<ProductsColorCdtb> productsColorList = productService.findAllProductColors();
		
		if(productsColorList != null) 
			model.addAttribute("productsColorList", productsColorList);
		
		if(msg.equals(ProductConstants.SUCCESS_MESSAGE))
			model.addAttribute("success", ProductConstants.COLOR_SUCCESS_MSG);
		
		if(msg.equals(ProductConstants.FAILURE_MESSAGE))
			model.addAttribute("failure", ProductConstants.COLOR_FAILURE_MESSAGE);
		
		if(msg.equals(ProductConstants.WARNING_MESSAGE))
			model.addAttribute("warning", ProductConstants.COLOR_WARNING_MESSAGE);
					
		model.addAttribute("productColor", new ProductsColorCdtb());
		return "productColor";
	}
	
	@RequestMapping(value="/addProductColor", method=RequestMethod.POST)
	public String addProductColor(@Valid @ModelAttribute("productColor") ProductsColorCdtb productColor, BindingResult bindingResult, Model model) {
		
			
		if (bindingResult.hasErrors()) { // if there are errors in color form
			model.addAttribute("productsColorList", productService.findAllProductColors()); //this list does not included the one user tried to enter
	        return "productColor";
	    }
		String msg = null;
		if(productService.findByColorCd(productColor.getColorCd().toUpperCase()) == null) { //add only if the color is not available
			productColor.setColorCd(productColor.getColorCd().toUpperCase());
			productColor = productService.saveColorCd(productColor);
			if(productColor != null) 
				msg = ProductConstants.SUCCESS_MESSAGE;
			else
				msg = ProductConstants.FAILURE_MESSAGE;			
		}else
			msg = ProductConstants.WARNING_MESSAGE;
	
		
		return "redirect:/getProductColor/" + msg;
	}
	
	@RequestMapping(value="/getProduct/{msg}", method=RequestMethod.GET)
	public String getProduct(@PathVariable String msg, Model model) {
		List<ProductsCdtb> productsList = productService.findAllProducts();
		
		if(productsList != null) 
			model.addAttribute("productsList", productsList);
		
		if(msg.equals(ProductConstants.SUCCESS_MESSAGE))
			model.addAttribute("success", ProductConstants.PRODUCT_SUCCESS_MSG);
		
		if(msg.equals(ProductConstants.FAILURE_MESSAGE))
			model.addAttribute("failure", ProductConstants.PRODUCT_FAILURE_MESSAGE);
		
		if(msg.equals(ProductConstants.WARNING_MESSAGE))
			model.addAttribute("alreadyExisting", ProductConstants.PRODUCT_EXISTING_MESSAGE);
					
		model.addAttribute("product", new ProductsCdtb());
		return "product";
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") ProductsCdtb product, BindingResult bindingResult, Model model) {
		
			
		if (bindingResult.hasErrors()) { // if there are errors in product form
			model.addAttribute("productsList", productService.findAllProducts()); //this list does not included the one user tried to enter
	        return "product";
	    }
		String msg = null;
		if(productService.findByProductCd(product.getProductCd().toUpperCase()) == null) { //add only if the product is not available
			product.setProductCd(product.getProductCd().toUpperCase());
			product = productService.saveProduct(product);
			if(product != null) 
				msg = ProductConstants.SUCCESS_MESSAGE;
			else
				msg = ProductConstants.FAILURE_MESSAGE;				
		}else
			msg = ProductConstants.WARNING_MESSAGE;
		
		return "redirect:/getProduct/" + msg;
	}
	
	@RequestMapping(value="/updateProduct/{productCd}", method=RequestMethod.GET)
	public String updateProduct(@PathVariable String productCd, Model model) {
		
		ProductsCdtb product = productService.findByProductCd(productCd);
		model.addAttribute("product", product);
		if(!productCd.equals(ProductConstants.RESISTANCE_BELT_CD)) 
			return "undevelopedProduct";
		
		return "resistanceBelt";
	}
	
}
package com.catalog.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.models.Products;
import com.catalog.repository.ProductRepository;

import io.swagger.annotations.Api;


@RestController
@CrossOrigin(origins = "https://frontopenl.herokuapp.com")
@RequestMapping("/product")
public class ProductController {

	
	  @Autowired
	  private ProductRepository prodRepo;
	  
	  
	  
	  @RequestMapping(path = "/AddItems", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  public Products createProduct(@RequestBody Products newProduct) {
		  
		  Products newProd = new Products();
		  newProd.setName(newProduct.getName());
		  newProd.setItemNo(newProduct.getItemNo());
		  newProd.setAmount(newProduct.getAmount());
		  newProd.setInventoryCode(newProduct.getInventoryCode());
		
		  this.prodRepo.save(new Products("1", "Milk","3","121"));
		  this.prodRepo.save(new Products("2", "Water","3","122"));
		  this.prodRepo.save(new Products("3", "Bread","3","123"));
		  this.prodRepo.save(new Products("4", "Apple","3","124"));
		  this.prodRepo.save(new Products("5", "TV","3","125"));
		  this.prodRepo.save(new Products("6", "Fridge","3","126"));
		  
		  return this.prodRepo.save(newProd);
		  
		  
	  }
	  
	  
	  @RequestMapping(value = "/List", method = RequestMethod.GET)
	    public List<Products> prodList() {
		  
		
		  
	        return this.prodRepo.findAll();
	    }
	  
	  
	  @RequestMapping(value = "/ReadItemDetails/{itemNo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public Optional<Products> getOneItem(@PathVariable("itemNo") String itemNo) {
	        
		  return this.prodRepo.findById(itemNo);
		  
	    }
	  
	  
	  @RequestMapping(value = "/DeleteItem/{itemNo}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	    public void deleteOneItem(@PathVariable("itemNo") String itemNo) {
	        
		 this.prodRepo.deleteById(itemNo);
		  
	    }
	  
	  
	  @RequestMapping(value = "/Withdrawal/{itemNo}", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    public Products WithdrawalQuantityFromStock(@PathVariable("itemNo") String itemNo, @RequestBody Products newProduct) {
	     
		  
		 
		  Products prod = this.prodRepo.findById(itemNo).get();
		 
		  prod.setAmount(String.valueOf(Integer.parseInt(prod.getAmount()) - Integer.parseInt(newProduct.getAmount())));
			
		 return this.prodRepo.save(prod);
	   
	  }
	  
	  
	  @RequestMapping(value = "/Deposit/{itemNo}", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    public Products DepositQuantityToStock(@PathVariable("itemNo") String itemNo, @RequestBody Products newProduct) {
	     
		  
		 
		  Products prod = this.prodRepo.findById(itemNo).get();
		 
		  prod.setAmount(String.valueOf(Integer.parseInt(prod.getAmount()) + Integer.parseInt(newProduct.getAmount())));
			
		 return this.prodRepo.save(prod);
	   
	  }
	  
	  
	  
}

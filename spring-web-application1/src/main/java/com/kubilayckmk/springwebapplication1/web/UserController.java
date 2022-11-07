/*
 * @author kubilaycakmak
 * @date Nov 07, 2022
 * @version 1.0
 */
 
package com.kubilayckmk.springwebapplication1.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kubilayckmk.springwebapplication1.domain.Product;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String displayUser(@PathVariable String id){
        return "<h1> User id " + id + "</h1>";
    }

    @RequestMapping(value = "/{id}/order", method = RequestMethod.GET)
    public String displayUserOrder(@PathVariable String id,
        // ?date=2022/3/3
        @RequestParam(value = "date", required = false) Date date){
        return "<h1> User id: " + id + " on the date: " + date + "</h1>";
    }

    @RequestMapping(value = "/{id}/orders", method = RequestMethod.GET)
    public List<String> displayUserJson(){
        return Arrays.asList("Joe", "John", "Jane");
    }

    @RequestMapping(value = "/{id}/products")
    public List<Product> displayProducts(){
        return Arrays.asList(
            new Product(1, "Product1", "ProductDescription1", 10.0),
            new Product(2, "Product2", "ProductDescription2", 20.0),
            new Product(3, "Product3", "ProductDescription3", 30.0),
            new Product(4, "Product4", "ProductDescription4", 40.0)
        );
    }

    @RequestMapping(value = "/{id}/product/{product_id}")
    public Product displayProduct(@PathVariable String id, @PathVariable String product_id){
        return new Product(Integer.parseInt(product_id), "Product1", "ProductDescription1", 10.0);
    }
}

package com.springData.Jpa.SpringJpa.Controller;

import com.springData.Jpa.SpringJpa.Repositries.ProductRepositories;
import com.springData.Jpa.SpringJpa.entites.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private  final ProductRepositories productRepositories;


    public ProductController(ProductRepositories productRepositories) {
        this.productRepositories = productRepositories;
    }

    @GetMapping("/product")
    public List<Products> getAllProducts(){
        return  productRepositories.findByTitleOrderByPrice("Pepsi");
    }

    @GetMapping("/prod")
    public List<Products> getProducts(){
        return  productRepositories.findByOrderByPrice();
    }

    // another way of sorting the iteam

    @GetMapping("/pro")
    public List<Products> getProduct(@RequestParam (defaultValue = "id")String srtBy){
        return  productRepositories.findBy(Sort.by(srtBy));
    }



}

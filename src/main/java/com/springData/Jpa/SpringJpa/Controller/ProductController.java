package com.springData.Jpa.SpringJpa.Controller;

import com.springData.Jpa.SpringJpa.Repositries.ProductRepositories;
import com.springData.Jpa.SpringJpa.entites.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private  final ProductRepositories productRepositories;
    private  final  int pageSize=5;

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

    // pagimation



    @GetMapping("/pr")
    public List<Products> get(@RequestParam (defaultValue = "id")String srtBy
            ,@RequestParam (defaultValue = "0")Integer pageNo){

        Pageable pageable= PageRequest.of(pageNo,pageSize);
      return   productRepositories.findAll(pageable).getContent();


    }

    // combination


    @GetMapping("/p")
    public List<Products> get(@RequestParam (defaultValue = "id")String srtBy
            ,@RequestParam (defaultValue = "0")Integer pageNo,
            @RequestParam (defaultValue = "null")String title
                              ){


        return  productRepositories.findByTitleContainingIgnoreCase(title,
                PageRequest.of(pageNo,pageSize,
                Sort.by(srtBy)));


    }




}

package com.springData.Jpa.SpringJpa.Repositries;

import com.springData.Jpa.SpringJpa.entites.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositories extends JpaRepository<Products,Long> {

}

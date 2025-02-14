package com.springData.Jpa.SpringJpa.Repositries;

import com.springData.Jpa.SpringJpa.entites.Products;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepositories extends JpaRepository<Products,Long> {


    List<Products>findByOrderByPrice();
    List<Products>findByTitleOrderByPrice(String title);

    List<Products> findByQuantityGreaterThanOrPriceLessThan(int quantity, BigDecimal price);

    @Query("select e from Products  e where e.title=?1 and e.price=?2")
    Optional<Products>findByTitleAndPrice(String title ,BigDecimal price);


    // another way of sort

    List<Products>findBy(Sort sort);

    // all comibnation

    List<Products> findByTitleContainingIgnoreCase(String title,  Pageable pageable);

}

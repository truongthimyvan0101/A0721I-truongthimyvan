package com.codegym.shoppingcart.Repository;

import com.codegym.shoppingcart.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends PagingAndSortingRepository <Product, Long> {
}

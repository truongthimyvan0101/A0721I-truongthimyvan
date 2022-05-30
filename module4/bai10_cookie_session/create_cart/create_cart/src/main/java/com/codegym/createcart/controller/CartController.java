package com.codegym.createcart.controller;

import com.codegym.createcart.model.Cart;
import com.codegym.createcart.model.Product;
import com.codegym.createcart.service.CartService;
import com.codegym.createcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductService productService;

    @GetMapping("buy/{id}")
    public String addProductToCart(@PathVariable Long id,
                                   @SessionAttribute("carts") HashMap<Long, Cart> hashMap,
                                   Model model) {
        Product product = productService.findById(id);
        if (product != null) {
//        TH 1: Sản phẩm chưa có trong giỏ hàng.
            if ( !hashMap.containsKey( id ) ){
                Cart cart = new Cart();
                cart.setProduct(product);
                cart.setQuantity(1);
                hashMap.put(id, cart);
            } else {
//        TH 2: Sản phẩm đã có trong giỏ hàng.
                Cart cart = hashMap.get(id);
                cart.setQuantity( cart.getQuantity() + 1 );
                hashMap.put(id, cart);
            }
        }
        model.addAttribute("cartNum", hashMap.size());
        model.addAttribute("carts", hashMap);
        model.addAttribute("cartMoney", totalPrice(hashMap));
        return "cart";

    }


    public double totalPrice(HashMap<Long, Cart> cartHashMap) {
        int count = 0;
        for (Map.Entry<Long, Cart> list : cartHashMap.entrySet()) {
            count += Double.parseDouble(list.getValue().getProduct().getNewPrice()) * list.getValue().getQuantity();
        }
        return count;
    }
}

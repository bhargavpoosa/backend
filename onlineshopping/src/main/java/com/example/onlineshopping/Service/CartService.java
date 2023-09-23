package com.example.onlineshopping.Service;

import com.example.onlineshopping.Entity.Cart;
import com.example.onlineshopping.Entity.Order;
import com.example.onlineshopping.Entity.Product;
import com.example.onlineshopping.Repository.CartRepo;
import com.example.onlineshopping.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
public class CartService {

    static int index = 100;

    @Autowired
    CartRepo cartRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ProductService productService;


    @Transactional
    public void addtoCart(String productId){
        List<Cart> productsInCart = cartRepo.findAll();
        for(Cart cart: productsInCart){
            if(cart.getProd_id().equals(productId)){
                int quantity = cart.getQuantity();
                cart.setQuantity(quantity + 1);
                cartRepo.save(cart);
                return;
            }
        }
        Product p = productService.getProduct(productId);
        Cart cart = new Cart(productId, 1, p.getPrice(), p.getProductName(), p.getImageUrl());
        cartRepo.save(cart);
    }

    @Transactional
    public void removeFromCart(String productId){
        List<Cart> productsInCart = cartRepo.findAll();
        for(Cart cart: productsInCart){
            if(cart.getProd_id().equals(productId)){
                int quantity = cart.getQuantity();
                if(quantity == 0) return;
                cart.setQuantity(quantity - 1);
                cartRepo.save(cart);
            }
        }
    }

    public void deleteFromCart(String productId){
        cartRepo.deleteById(productId);
    }

    @Transactional
    public void bookProducts(double totalPrice, String productList){
        Order order = new Order("O" + index, totalPrice, new Date().toString(), productList );
        index+=1;
        orderRepo.save(order);
    }

    @Transactional(readOnly = true)
    public List<Cart> getProductList(){
        return cartRepo.findAll();
    }
}

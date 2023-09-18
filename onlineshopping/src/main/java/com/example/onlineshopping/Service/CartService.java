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


    @Transactional
    public void addtoCart(Product product){
        List<Cart> productsInCart = cartRepo.findAll();
        for(Cart cart: productsInCart){
            if(cart.getProd_id().equals(product.getProductId())){
                int quantity = cart.getQuantity();
                double price = cart.getPrice();
                cart.setQuantity(quantity + 1);
                cart.setPrice(price + product.getPrice());
                cartRepo.save(cart);
                return;
            }
        }
        Cart cart = new Cart(product.getProductId(), 1, product.getPrice());
        cartRepo.save(cart);
    }

    @Transactional
    public void removeFromCart(Product product){
        List<Cart> productsInCart = cartRepo.findAll();
        for(Cart cart: productsInCart){
            if(cart.getProd_id().equals(product.getProductId())){
                int quantity = cart.getQuantity();
                double price = cart.getPrice();
                cart.setQuantity(quantity - 1);
                cart.setPrice(price - product.getPrice());
                cartRepo.save(cart);
            }
        }
    }

    @Transactional
    public void bookProducts(double totalPrice){
        Order order = new Order("O" + index, totalPrice, new Date().toString());
        index+=1;
        orderRepo.save(order);
    }
}

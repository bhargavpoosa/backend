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
    @Autowired
    CartRepo cartRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ProductService productService;


    @Transactional
    public void addtoCart(String username, int productId){
        List<Cart> productsInCart = cartRepo.findByUsername(username);
        for(Cart cart: productsInCart){
            if(cart.getProd_id() == productId){
                int quantity = cart.getQuantity();
                cart.setQuantity(quantity + 1);
                cartRepo.save(cart);
                return;
            }
        }
        Product p = productService.getProduct(productId);
        Cart cart = new Cart(username, productId, 1, p.getPrice(), p.getProductName(), p.getImageUrl());
        cartRepo.save(cart);
    }

    @Transactional
    public void removeFromCart(String username, int productId){
        List<Cart> productsInCart = cartRepo.findByUsername(username);
        for(Cart cart: productsInCart){
            if(cart.getProd_id() == productId){
                int quantity = cart.getQuantity();
                if(quantity == 0) return;
                if(quantity == 1){
                    deleteFromCart(username, productId);
                    return;
                }
                cart.setQuantity(quantity - 1);
                cartRepo.save(cart);
            }
        }
    }

    public void deleteFromCart(String username, int productId){
        List<Cart> productsInCart = cartRepo.findByUsername(username);
        for(Cart cart: productsInCart) {
            if (cart.getProd_id() == productId) {
                cartRepo.delete(cart);
            }
        }
    }

    @Transactional
    public void bookProducts(Order o){
        Order order = new Order(o.getTotalAmount(), new Date().toString(), o.getProductList(), o.getUsername());
        orderRepo.save(order);
        List<Cart> cartList = cartRepo.findByUsername(o.getUsername());
        for(Cart cart: cartList){
            cartRepo.delete(cart);
        }
    }

    @Transactional(readOnly = true)
    public List<Cart> getProductList(String username){
        return cartRepo.findByUsername(username);
    }
}

package com.webshop.webportal.controller;

import com.webshop.webportal.model.product.Product;
import com.webshop.webportal.model.product.ProductRegistry;
import com.webshop.webportal.model.shopping.ShoppingCart;
import com.webshop.webportal.model.shopping.ShoppingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("ShoppingCart")
public class ShoppingCartController {

    @Autowired
    private RestTemplate restTemplate;

    @ModelAttribute("ShoppingCart")
    public ShoppingCart getShoppingCart() {
        return new ShoppingCart();
    }

    @RequestMapping("/cart")
    public String shoppingCartPage(@ModelAttribute("ShoppingCart") ShoppingCart cart, Model model) {
        if (!cart.getItems().isEmpty()) {
            List<ShoppingItem> items = new ArrayList<>();
            double total = 0;
            for (Map.Entry<Long, Integer> item : cart.getItems().entrySet()) {
                int quantity = item.getValue();
                Product prod = ProductRegistry.lookupProduct(item.getKey());
                double totalPriceForProduct = prod.getPrice() * quantity;
                items.add(new ShoppingItem(prod.getName(), quantity, totalPriceForProduct));
                total += totalPriceForProduct;
            }
            model.addAttribute("shoppingList", items);
            model.addAttribute("totalPrice", total);
        }
        return "shoppingCart";
    }

    @RequestMapping(value = "/addToCart/{prodID}", method = RequestMethod.POST)
    public String addItem(@ModelAttribute("ShoppingCart") ShoppingCart cart, @PathVariable("prodID") Long productID) {
        cart.addItem(productID, 1);
        return "redirect:/";
    }

    @RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
    public String placeOrder(@ModelAttribute("ShoppingCart") ShoppingCart cart, SessionStatus sessionStatus) {
        //TODO: invoke order service

        sessionStatus.setComplete();
        return "redirect:/orderPlaced";
    }
}
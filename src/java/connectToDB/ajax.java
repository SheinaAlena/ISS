/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectToDB;

import javax.annotation.PostConstruct;


/**
 *
 * @author Алена
 */

public class ajax {
    private String cart;
    
    @PostConstruct
    public void init() {
        this.cart = "http://www.openstreetmap.org/export/embed.html?bbox=54.12689208984376%2C53.075877572693564%2C57.19207763671876%2C54.06583577161281&amp;layer=mapnik";
        
        
    }
    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    
}


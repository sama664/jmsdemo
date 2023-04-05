package org.soumitra.poc.jmsdemo.model;

import lombok.Data;

@Data
public class Prodcut {
     String productname;
     String id;
     public Prodcut() {

     }

     public Prodcut(String myproduct, String i) {
          this.productname=myproduct;
          this.id=i;
     }

     @Override
     public String toString() {
          return String.format("Product{name=%s, id=%s}", getProductname(),getId());
     }

}

package com.mike.jaxrs;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
   
   List<Product> products = new ArrayList<Product>();
   private int productId=123;
   
   public ProductServiceImpl() {
      // TODO Auto-generated constructor stub
      Product product =  new Product();
      product.setId(++productId);
      product.setDescription("JWS");
      products.add(product);
   }

   @Override
   public List<Product> getProducts() {
      return products;
   }

   @Override
   public int addProduct(Product product) {
      product.setId(++productId);
      products.add(product);
      return productId;
   }

}

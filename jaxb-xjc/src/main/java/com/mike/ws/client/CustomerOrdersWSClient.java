package com.mike.ws.client;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.mike.ws.wsdl.CustomerOrdersPortType;
import com.mike.ws.wsdl.CustomerOrdersService;
import com.mike.ws.wsdl.GetOrdersRequest;
import com.mike.ws.wsdl.GetOrdersResponse;
import com.mike.ws.wsdl.Order;
import com.mike.ws.wsdl.Product;

public class CustomerOrdersWSClient {
    
    public static void main(String[] args) {
        try {
            CustomerOrdersService service = new CustomerOrdersService(new URL("http://localhost:8080/jaxb-xjc/services/customerOrders?wsdl"));
            CustomerOrdersPortType port = service.getCustomerOrdersPort();
            GetOrdersRequest request = new GetOrdersRequest();
            request.setCustomerId(BigInteger.valueOf(1L));
            
            GetOrdersResponse response = port.getOrders(request);
            List<Order> orders = response.getOrder();
            for (Order order : orders) {
                List<Product> products = order.getProduct();
                for (Product product : products) {
                    System.out.println("Product Description: "+product.getDescription());
                    System.out.println("Product Quantity: "+product.getQuantity());
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        
    }

}

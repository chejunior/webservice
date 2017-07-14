package com.mike.ws.wsdl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CustomersOrdersWSImpl implements CustomerOrdersPortType {
    
    Map<BigInteger, List<Order>> customerOrders = new HashMap<BigInteger, List<Order>>(); 
    int currentCustomerId;
    
    public CustomersOrdersWSImpl() {
        init();
    }
    
    public void init(){
        List<Order> orders = new ArrayList<Order>();
        Order order = new Order();
        order.setId(BigInteger.valueOf(1L));
        
        Product product = new Product();
        product.setDescription("Castlevania");
        product.setId("1");
        product.setQuantity(BigInteger.valueOf(3L));
        
        order.getProduct().add(product);
        orders.add(order);
        customerOrders.put(BigInteger.valueOf(++currentCustomerId), orders);
    }

    @Override
    public GetOrdersResponse getOrders(GetOrdersRequest request) {
        BigInteger customerId = request.getCustomerId();
        List<Order> orders = customerOrders.get(customerId);
        GetOrdersResponse response = new GetOrdersResponse();
        List<Order> responseOrders = response.getOrder();
        
        for (Order order:orders){
            responseOrders.add(order);
        }
        
        return response;
    }

    @Override
    public CreateOrdersResponse createOrders(CreateOrdersRequest request) {
        Order order = request.getOrder();
        List<Order> currentOrders = customerOrders.get(request.getCustomerId());
        currentOrders.add(order);
        
        CreateOrdersResponse createOrdersResponse = new CreateOrdersResponse();
        createOrdersResponse.setResult(true);
        
        return createOrdersResponse;
    }

    @Override
    public DeleteOrdersResponse deleteOrders(DeleteOrdersRequest request) {
        List<Order> currentOrders = customerOrders.get(request.getCustomerId());
        Order orderDel = null;
        for (Order order : currentOrders) {
            if (order.getId().intValue()==request.getOrderId().intValue()){
                orderDel = order;
            }
        }
        
        DeleteOrdersResponse deleteOrdersResponse = new DeleteOrdersResponse();
        deleteOrdersResponse.setResult(false);
        if(orderDel!=null){
            currentOrders.remove(orderDel);
            deleteOrdersResponse.setResult(true);
        }
        return deleteOrdersResponse;
    }

}

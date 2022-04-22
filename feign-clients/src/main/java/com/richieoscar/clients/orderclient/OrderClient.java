package com.richieoscar.clients.orderclient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "order-service", path = "api/v1/order")
public interface OrderClient {

}

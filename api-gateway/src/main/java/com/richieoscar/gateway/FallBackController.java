package com.richieoscar.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

    @RequestMapping("/payment-fallback")
    public Mono<String> paymentServiceFallback(){
        return Mono.just("Payment Service is taking to long to respond, Please Try again later");
    }

    @RequestMapping("/order-fallback")
    public Mono<String> ordererviceFallback(){
        return Mono.just("Order Service is taking to long to respond, Please Try again later");
    }
}

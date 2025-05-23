package com.example.demo.controller;

import com.example.demo.dto.ConfirmOrderRespondeDTO;
import com.example.demo.dto.CreateOrderRequestDTO;
import com.example.demo.dto.CreateOrderResponseDTO;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    @PostMapping(value = "/create")
    public CreateOrderResponseDTO createOrder(
            @RequestBody CreateOrderRequestDTO request,
            @RequestHeader(value = "partner_code", required = false) String partnerCode
    ) {
        log.info("OrderController.createOrder - request: {}, partnerCode: {}", request, partnerCode);
        return new CreateOrderResponseDTO(request.customerId(), UUID.randomUUID().toString(), partnerCode);
    }

    @PostMapping(value = "/confirm/{orderId}")
    public ConfirmOrderRespondeDTO confirmOrder(@PathParam("orderId") String orderId) {
        log.info("OrderController.confirmOrder - orderId: {}", orderId);
        return new ConfirmOrderRespondeDTO(orderId);
    }
}

package com.userauth.filter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.userauth.entity.Response;
 

@FeignClient(value = "dispatch79879", url = "http://localhost:8004")
public interface APIClient {
    @GetMapping(value = "/dispatch/getInvoiceData")
    ResponseEntity<Response> getDepartmentById();
}
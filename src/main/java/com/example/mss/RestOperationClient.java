package com.example.mss;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;

import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.core.Context;
import java.util.Collection;

@FeignClient(name = "COMPTES-SERVICE")
public interface RestOperationClient {
    @GetMapping(path = "/operations/")
    PagedModel<Operation> getAllOperations();
}

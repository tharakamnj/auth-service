package com.booking.authservice.proxyClient;

import com.booking.authservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "localhost:8082/api/v2",name = "user-service")
public interface CoreServiceClient {

    @GetMapping("/user/{userName}")
    UserDTO getUserByUserName(@PathVariable("userName") String userName);

}

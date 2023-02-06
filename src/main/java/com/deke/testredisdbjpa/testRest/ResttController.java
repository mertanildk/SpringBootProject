package com.deke.testredisdbjpa.testRest;


import com.deke.testredisdbjpa.utils.ExternalApiUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class ResttController {

    private final ExternalApiUtil externalApiService;
    @GetMapping("/current-usd")
    public ResponseEntity<USD> getRecentUSD() {
        return ResponseEntity.ok(externalApiService.getRecentUSD());
    }
    @PostMapping("/test2")//attığın istekten geriye dönüşte url değiştirme
    public ResponseEntity<USD> test() {
        USD usd = new USD("USD", "asd", "asdasd", "asdsad", "asdsd");
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{satis}")
                .buildAndExpand(usd.getSatis())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    @GetMapping("/test2/{satis}")
    public String test2(@PathVariable String satis) {
        return "buraya geldin " + satis;
    }

}

package com.deke.testredisdbjpa.testRest;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/test")
public class RestController {

    private final TestRestTemplateService testRestTemplateService;

    public RestController(TestRestTemplateService testRestTemplateService) {
        this.testRestTemplateService = testRestTemplateService;
    }


    @GetMapping("/test")
    public ResponseEntity<USD> getRecentUSD() {
        return ResponseEntity.ok(testRestTemplateService.getRecentUSD());
    }

    @GetMapping("/testttt")
    public BigDecimal testooo() {
        return BigDecimal.valueOf(934.88).divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(5));
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

/*
    @RequestMapping(value = "/template/products", method = RequestMethod.POST)
   public String createProducts(@RequestBody Product product) {


      HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);

      return restTemplate.exchange(
         "http://localhost:8080/products", HttpMethod.POST, entity, String.class).getBody();
   }
     */
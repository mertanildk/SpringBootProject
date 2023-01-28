package com.deke.testredisdbjpa.exceptions;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class TestController {

    @GetMapping(path = "/test")
    public ResponseEntity<String> test() {
        throw new RestRuntimeException("testo", "1testV.2");
    }

    @GetMapping(path = "/test2")
    public ResponseEntity<String> test2() {
        throw new NullInputException("00.V2N.I");
    }

    @GetMapping(path = "/test6")
    public ResponseEntity<String> test24() {
        return null;
    }

    @GetMapping(path = "/test61")
    public MethodArgumentNotValidException test242() {
        return new MethodArgumentNotValidException(null,null);
    }
}

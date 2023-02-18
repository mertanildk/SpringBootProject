package com.deke.testredisdbjpa.mongoTest;


import com.deke.testredisdbjpa.utils.responseApi.RestResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.Cacheable;

import java.util.List;

@RestController
@RequestMapping("/mongo")
@RequiredArgsConstructor
public class MongoController {


    private final UserRepository userRepository;
    private final PhoneRepository phoneRepository;

    @PostMapping("/save")
    public ResponseEntity<RestResponseEntity<User>> save(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok(RestResponseEntity.response(user));
    }

    @PostMapping("/save-phone")
    public ResponseEntity<RestResponseEntity<User>> savePhone(@RequestBody Phone phone) {
        phoneRepository.save(phone);
        return ResponseEntity.ok(RestResponseEntity.response(phone));
    }

    @GetMapping("/getAll")
    public ResponseEntity<RestResponseEntity<User>> getAll() {
        return ResponseEntity.ok(RestResponseEntity.response(userRepository.findAll()));
    }

    @GetMapping("/getAllPhone")
    @ResponseBody
    public ResponseEntity<List<Phone>> getAllPhone() {
        return ResponseEntity.ok(getAllPhone1());
    }

    private List<Phone> getAllPhone1() {
        return phoneRepository.findAll();
    }
}

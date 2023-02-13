package com.deke.testredisdbjpa.utils.exceptions;


import com.deke.testredisdbjpa.entity.dto.request.MailDto;
import com.deke.testredisdbjpa.entity.Hotel;
import com.deke.testredisdbjpa.testRabbitMq.Runner;
import com.deke.testredisdbjpa.utils.mernis.EURKPSPublicSoap;
import com.deke.testredisdbjpa.utils.mailSender.EmailServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class TestController {

    private final EmailServiceImp emailServiceImp;
    private final Runner runner;

    @GetMapping(path = "/test")
    public ResponseEntity<String> test() {
        throw new RestRuntimeException("testo", "1testV.2");
    }

    @PostMapping(path = "/test2")
    public ResponseEntity<String> test2() throws Exception {
        runner.run();
        return ResponseEntity.ok("sent");
    }

    @GetMapping(path = "/test6")
    public ResponseEntity<String> test24() {
        return null;
    }


    @PostMapping(path = "/test3")
    public TestEntity test3(@Valid @RequestBody TestEntity testEntity) {

        return new TestEntity(testEntity.getId(), testEntity.getName(), testEntity.getAge());
    }

    @GetMapping("/testMail")
    public boolean testMail(@RequestBody MailDto mailDto) {
        emailServiceImp.sendEmail(mailDto);
        return true;
    }

    @PostMapping("/testMernis")
    public ResponseEntity<String> testMernis(@RequestParam String identityNo) throws Exception {
        EURKPSPublicSoap client = new EURKPSPublicSoap();
        boolean isRealPerson = client.TCKimlikNoDogrula(Long.parseLong(identityNo), "Mert Anıl", "Deke", 1998);
        if (!isRealPerson) {
            throw new RuntimeException("Girilen bilgilere ait kişi bulunamadı");
        }
        return ResponseEntity.ok("Girilen bilgilere ait kişi bulundu.");
    }

    @GetMapping(path = "/testMernis2", params = "version=2")
    public ResponseEntity<String> testMernis2(@RequestParam String identityNo) throws Exception {
        EURKPSPublicSoap client = new EURKPSPublicSoap();
        boolean isRealPerson = client.TCKimlikNoDogrula(Long.parseLong(identityNo), "Şevval", "Kesen", 1998);
        if (!isRealPerson) {
            throw new RuntimeException("Girilen bilgilere ait kişi bulunamadı");
        }
        return ResponseEntity.ok("Girilen bilgilere ait kişi bulundu.");
    }

    @GetMapping(path = "/testMernis3", headers = "X-API-HEADER=3")
    public ResponseEntity<String> testHeader() {
        return ResponseEntity.ok("Header testi başarılı");
    }

    @GetMapping(path = "/testMernis4", produces = "application/vnd.company.app-v1+json")
//accept header alanına yazılan değer
    public ResponseEntity<String> testHeader2() {
        return ResponseEntity.ok("Produces testi başarılı");
    }

    @GetMapping(path = "/hateoasTest")//hateoas testi
    public EntityModel<Hotel> testLink() {
        EntityModel entityModel = EntityModel.of(new Hotel());
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).test24());
        entityModel.add(linkTo.withRel("all-hotels"));
        return entityModel;

    }




}

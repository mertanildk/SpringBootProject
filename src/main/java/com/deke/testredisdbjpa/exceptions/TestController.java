package com.deke.testredisdbjpa.exceptions;


import com.deke.testredisdbjpa.dto.request.MailDto;
import com.deke.testredisdbjpa.mernis.EURKPSPublicSoap;
import com.deke.testredisdbjpa.test.EmailServiceImp;
import jakarta.validation.Valid;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class TestController {

    private EmailServiceImp emailServiceImp;

    public TestController(EmailServiceImp emailServiceImp) {
        this.emailServiceImp = emailServiceImp;
    }

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



    @PostMapping(path = "/test3")
    public TestEntity test3(@Valid @RequestBody TestEntity testEntity) {

        return new TestEntity(testEntity.getId(), testEntity.getName(),testEntity.getAge());
    }

    @GetMapping("/testMail")
    public boolean testMail(@RequestBody MailDto mailDto){
        emailServiceImp.sendEmail(mailDto);
        return true;
    }
    @PostMapping("/testMernis")
    public ResponseEntity<String> testMernis(@RequestParam String identityNo) throws Exception {
        EURKPSPublicSoap client = new EURKPSPublicSoap();
        boolean isRealPerson = client.TCKimlikNoDogrula(Long.parseLong(identityNo),"Mert Anıl","Deke",1998);
        if (!isRealPerson){
            throw new RuntimeException("Girilen bilgilere ait kişi bulunamadı");
        }
        return ResponseEntity.ok("Girilen bilgilere ait kişi bulundu.");
    }

}

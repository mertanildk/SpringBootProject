package com.deke.testredisdbjpa.upload;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping(path = "/file")

public class FileUploadController {

    @PostMapping("/upload")
    public ResponseEntity<FileUpload> uploadFile(

            @RequestParam(value = "file") MultipartFile multipartFile)
            throws IOException {

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        long size = multipartFile.getSize();

        String filecode = FileUploadUtil.saveFile(fileName, multipartFile);

        FileUpload response = new FileUpload();
        response.setFileName(fileName);
        response.setSize(size);
        response.setDownloadUrl("/Users/mertanil/Desktop/testPackage/" + filecode);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

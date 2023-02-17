package com.deke.testredisdbjpa.entity.uploadFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileUpload {

    private String fileName;

    private String downloadUrl;

    private long size;
}

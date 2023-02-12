package com.deke.testredisdbjpa.entity.dto.response.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseDto implements Serializable {
    @JsonProperty(value = "id")
    private String id;
    @JsonProperty(value = "created")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @JsonProperty(value = "lastupdated")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date lastupdated;
    @JsonProperty(value = "deleted")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date deleted;
}

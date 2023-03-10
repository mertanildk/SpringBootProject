package com.deke.testredisdbjpa.utils.responseApi;

import org.assertj.core.util.Lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RestResponseEntity<T> implements Serializable {

    private boolean success;
    private List<T> data;

    private RestResponseEntity(List data) {
        this.success = true;
        this.data = data;
    }

    public static RestResponseEntity response(Object data) {
        if(data == null) return new RestResponseEntity(new ArrayList());
        if (!(data instanceof Collection)) data = Lists.newArrayList(data);
        return new RestResponseEntity((List) data);
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }
}
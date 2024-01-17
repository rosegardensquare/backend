package com.zs.backend.user.model;

import lombok.Data;

import java.util.List;
@Data
public class PageVO<T> {

    private List<T> records;
    private Long total;

    public PageVO(List<T> records, Long total){
        this.records = records;
        this.total = total;
    }
}

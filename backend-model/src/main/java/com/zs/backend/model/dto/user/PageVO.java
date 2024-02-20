package com.zs.backend.model.dto.user;

import java.util.List;
import lombok.Data;

@Data
public class PageVO<T> {

    private List<T> records;
    private Long total;

    public PageVO(List<T> records, Long total){
        this.records = records;
        this.total = total;
    }
}

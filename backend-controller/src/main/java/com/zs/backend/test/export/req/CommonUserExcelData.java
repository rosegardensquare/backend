package com.zs.backend.test.export.req;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class CommonUserExcelData {

    @ExcelProperty("姓名")
    private String name;

    /**
     * 手机号
     */
    @ExcelProperty("手机号")
    private String tel;

}

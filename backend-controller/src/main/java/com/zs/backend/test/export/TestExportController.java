package com.zs.backend.test.export;


import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.zs.backend.model.entity.user.CommonUser;
import com.zs.backend.service.ICommonUserService;
import com.zs.backend.test.export.req.CommonUserExcelData;
import com.zs.backend.test.export.req.RecordReq;
import com.zs.backend.utils.BeanUtil;
import com.zs.backend.utils.DateUtil;
import com.zs.backend.utils.ExportExcelUtil;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/export")
@Slf4j
public class TestExportController {

    @Autowired
    private ICommonUserService commonUserService;

    /**
     * 数据同步导出
     * @param response
     * @param req
     * @throws IOException
     */
    @GetMapping("/test")
    public void downLoad(HttpServletResponse response, RecordReq req) throws IOException {

        List<CommonUser> list = commonUserService.list();
        List<CommonUserExcelData> excelData = BeanUtil
            .beanCopyPropertiesForList(list, CommonUserExcelData.class);

        String fileName = Joiner.on("_").join("数据导出列表", DateUtil.getFormatDate(new Date(), DateUtil.YMDHMS));
        ExportExcelUtil.setHeader(response, fileName);
        EasyExcel.write(response.getOutputStream(), CommonUserExcelData.class).sheet()
            .doWrite(excelData);
    }


}

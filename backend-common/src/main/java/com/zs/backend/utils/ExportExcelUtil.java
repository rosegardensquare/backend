package com.zs.backend.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.converters.date.DateStringConverter;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.excel.util.DateUtils;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public class ExportExcelUtil {

    protected static void export(HttpServletResponse response, InputStream templateInputStream,
        List<?> list) throws IOException {

        ExcelWriterBuilder builder = EasyExcel.write(response.getOutputStream())
            .withTemplate(templateInputStream).registerConverter(new DateConverter());
        ExcelWriter excelWriter = builder.build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
        excelWriter.fill(list, fillConfig, writeSheet);
        excelWriter.finish();
    }

    public static void setHeader(HttpServletResponse response, String fileName) {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/x-download");
        response.setHeader("Content-Disposition", "attachment; filename="
            + URLEncoder.encode(fileName, StandardCharsets.UTF_8) + ".xlsx");
    }

    private static class DateConverter extends DateStringConverter {

        @Override
        public CellData convertToExcelData(Date value, ExcelContentProperty contentProperty,
            GlobalConfiguration globalConfiguration) {
            if (contentProperty == null || contentProperty.getDateTimeFormatProperty() == null) {
                return new CellData(DateUtils.format(value, DateUtils.DATE_FORMAT_10));
            } else {
                return new CellData(DateUtils.format(value,
                    contentProperty.getDateTimeFormatProperty().getFormat()));
            }
        }
    }

}

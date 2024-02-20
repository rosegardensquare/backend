package com.zs.backend.operate;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.google.common.base.Throwables;
import java.io.File;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 文件异步导出
 */
@Slf4j
@Component
public class ExportAsyncProcess {

   // @Autowired
   // private OssFileComponent ossFileComponent;



    /**
     * 构建临时文件对象
     *
     * @param fileName 文件名
     * @return 临时文件对象
     */
    public File buildTempFile(String fileName) {
        log.info("ExportProcess.buildTempFile.fileName=" + fileName);
        File tempFile;
        try {
            tempFile = File.createTempFile(fileName.split("\\.")[0], "." + fileName.split("\\.")[1]);
        } catch (IOException e) {
            log.error(Throwables.getStackTraceAsString(e));
            throw new RuntimeException(e.getMessage());
        }
        return tempFile;
    }

    /**
     * 创建文件并记录文件信息
     *
     * @param taskScene 导出文件场景枚举
     * @param fileName  文件名
     * @return 文件ID
     */
    public Long prepare(String taskScene, String fileName) {
//        FileCreateCmd cmd = new FileCreateCmd();
//        cmd.setFileName(fileName);
//        cmd.setFileType(fileName.split("\\.")[1]);
//        BaseUserDTO baseUserDTO = UserHolder.get();
//        if (baseUserDTO == null) {
//            cmd.setUserId(1L);
//        } else {
//            cmd.setUserId(baseUserDTO.getUserId());
//        }
//        cmd.setTaskScene(taskScene);
//        Long id = ResponseDTO.getResEntity(fileService.create(cmd), "创建文件失败");
//        log.info("创建文件成功id: {}", id);
        Long id = 1L;
        // 保存到数据库
        return id;
    }

    /**
     * 将文件上传至OSS
     *
     * @param tempFile 临时文件对象
     * @param filename 文件名
     * @return 文件的OSS地址
     */
    public String uploadFile(File tempFile, String filename) {
        // 将文件上传到 OSS
        // String url = ossFileComponent.upload(tempFile, "excel", filename);
        String url = "";
        log.debug("文件OSS地址:{}", url);
        return url;
    }

    /**
     * 完成文件导出，包括上传文件至OSS和更新文件信息
     *
     * @param fileId   文件ID
     * @param count    数据条数
     * @param file     导出的文件对象
     * @param filename 文件名
     */
    public void finish(Long fileId, int count, File file, String filename) {
        String url = uploadFile(file, filename);
//        FileFinishCmd cmd = new FileFinishCmd();
//        cmd.setFileUrl(url);
//        cmd.setId(fileId);
//        cmd.setDataCount(count);
//        Boolean b = ResponseDTO.getResEntity(fileService.finish(cmd), "完成失败");
        // TODO 更新数据库下载状态为完成

    }

    /**
     * 处理导出失败情况，更新失败记录
     *
     * @param fileId 文件ID
     * @param msg    失败信息
     */
    public void fail(Long fileId, String msg) {
//        FileFailCmd cmd = new FileFailCmd();
//        cmd.setId(fileId);
//        cmd.setFailReason("导出失败，请重新导出");
//        Boolean b = ResponseDTO.getResEntity(fileService.fail(cmd), "完成失败");
//        log.info("更新失败记录: {}", b);
    }


    /**
     * 异步导出文件
     *
     * @param clazz 数据类型对应的类对象
     * @param list  待导出的数据列表
     */
    @Async
    public void asyncExport(Class clazz, List list, String fileName, String taskScene) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        log.info("asyncExport， 待导出的数据列表：{}。", list.size());

        // 创建excel文件对象
        ExcelWriter excelWriter = null;
        Long fileId = null;
        try {
            // 创建临时文件
            File tempFile = buildTempFile(fileName);
            // 新增上传文件记录
            fileId = prepare(taskScene, fileName);
            excelWriter = EasyExcel.write(tempFile, clazz).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("sheet").build();
            log.info("本次查出{}条，excel写入{}条", list.size(), list.size());
            excelWriter.write(list, writeSheet);
            excelWriter.finish();
            finish(fileId, list.size(), tempFile, fileName);
        } catch (Exception e) {
            log.error(Throwables.getStackTraceAsString(e));
            fail(fileId, e.getMessage());
        } finally {
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }


}

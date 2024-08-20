package com.xyx.common.util.excel;

import com.alibaba.excel.EasyExcel;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Slf4j
public class easyUtils {
    public static <T> List<T> read(MultipartFile file, Class<T> head) throws IOException {

        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        return EasyExcel.read(file.getInputStream(), head, null)
                .autoCloseStream(false)//不要自动关闭，交给servlet自己处理
                .doReadAllSync();
    }
    public static <T> void write(HttpServletResponse response, String sheetName, String fileName, Class<T> head, List<T> data) throws IOException {
        //设置content—type
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");

        //Content-disposition是MIME协议的扩展，MIME协议指示MIME用户代理如何显示附加的文件
        // 这里需要设置不关闭流

        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), head)
                .sheet(sheetName)
                .doWrite(data);
    }

}

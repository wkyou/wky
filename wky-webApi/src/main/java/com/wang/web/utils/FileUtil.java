package com.wang.web.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author WangKanYou
 * @Date 2022/11/27 0:05
 * @描述:
 */
public class FileUtil {
    // 第二种方式
    public static MultipartFile getMultipartFile(File file) {

        FileItem item = new DiskFileItem("file"
                , MediaType.MULTIPART_FORM_DATA_VALUE
                , true
                , file.getName()
                , (int)file.length()
                , file.getParentFile());
        try {
            OutputStream os = item.getOutputStream();
            os.write(FileUtils.readFileToByteArray(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new CommonsMultipartFile(item);
    }


}

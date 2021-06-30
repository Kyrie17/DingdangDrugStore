package com.dingdang.DingdangDrugstore.common;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/2/28 23:08
 */
public class MultipartFileToFile {

    public static File multipartFileToFile(MultipartFile multipartFile) {
        // 获取文件名
        String fileName = multipartFile.getOriginalFilename();
        // 文件名，不含.jpg等
        String prefix = fileName.split("\\.")[0];
        // 获取文件后缀，如.jpg
        String suffix  = fileName.substring(fileName.lastIndexOf("."));
        // 根据时间戳创建新的文件名，不会将同名文件覆盖
        String picName = prefix + System.currentTimeMillis();

        File file = null;
        try {
            file = File.createTempFile(picName, suffix);
            multipartFile.transferTo(file);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }
}

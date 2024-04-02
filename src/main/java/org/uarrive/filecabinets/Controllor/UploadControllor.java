package org.uarrive.filecabinets.Controllor;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.uarrive.filecabinets.Entity.BFileStorage;
import org.uarrive.filecabinets.Repository.BFileStorageRepository;
import org.uarrive.filecabinets.Services.SysSettingService;
import org.uarrive.filecabinets.Util.Base64Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UploadControllor {

    @Autowired
    SysSettingService sysSettingService;
    @Autowired
    private BFileStorageRepository repository;
    @PostMapping ("/file")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") String base64,@RequestParam("fileName") String fileName) throws IOException {
        if(ObjectUtils.isEmpty(base64))return null;
        String cabinetsPath=sysSettingService.getCabinetsPath();
            Base64Util.Base64ToFile(base64, cabinetsPath,fileName);

        //TODO 写一个file service 封装file 的存储，数据库中增加上传人，上传应用的名称，上传业务子目录等字段
        // 原始文件路径
        Path originalFilePath = Paths.get(sysSettingService.getCabinetsPath()+fileName);

        // 获取原始文件的大小
        long originalFileSize = Files.size(originalFilePath);
        System.out.println("Original File Size: " + originalFileSize + " bytes");

        // 获取原始文件的类型（扩展名）
        String originalFileType = Files.probeContentType(originalFilePath);
        System.out.println("Original File Type: " + originalFileType);
        BFileStorage file = new BFileStorage();
        file.setId(UUID.randomUUID().toString().replace("-",""));
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0) {
            file.setFileType(fileName.substring(dotIndex + 1));
        }
        file.setOriginName(fileName);
        file.setFileSize(Double.valueOf(originalFileSize));
        file.setFileDirectory(cabinetsPath);
        file.setCreateTime(System.currentTimeMillis());
        file.setExpireDate(System.currentTimeMillis());
        repository.save(file);





        return  new ObjectMapper().writeValueAsString(file);
    }
}

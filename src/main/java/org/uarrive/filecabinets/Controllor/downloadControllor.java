package org.uarrive.filecabinets.Controllor;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.uarrive.filecabinets.Entity.BFileStorage;
import org.uarrive.filecabinets.Repository.BFileStorageRepository;
import org.uarrive.filecabinets.Services.FileService;
import org.uarrive.filecabinets.Services.SysSettingService;
import org.uarrive.filecabinets.Util.Base64Util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping("/download")
public class downloadControllor {

    @Autowired
    FileService fileService;

//    /**
//     * Cabinet生成URL提供给服务端
//     * @param id
//     * @return
//     */
//    @PostMapping ("/fileUrl")
//    @ResponseBody
//    public String fileUrl(@RequestParam("id") String id) {
//        BFileStorage fileStorage=fileService.getFileById(id);
//        File file = new File(fileStorage.getFileType()+fileStorage.getOriginName());
//
//
//
//
//
//
//        return  new ObjectMapper().writeValueAsString(file);
//    }
}

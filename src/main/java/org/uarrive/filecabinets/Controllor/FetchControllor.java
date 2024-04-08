package org.uarrive.filecabinets.Controllor;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uarrive.filecabinets.Entity.BFileStorage;
import org.uarrive.filecabinets.Services.FileService;

import java.io.File;

@RestController
@RequestMapping("/fetch")
public class FetchControllor {

    @Autowired
    FileService fileService;

    /**
     * Cabinet生成URL提供给服务端
     * @param id
     * @return
     */
    @GetMapping ("/fileUrl")
    @ResponseBody
    public String fileUrl(@RequestParam("id") String id) {
        return  fileService.restoreFile2Temp(id);
    }
}

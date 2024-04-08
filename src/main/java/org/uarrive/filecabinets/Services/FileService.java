package org.uarrive.filecabinets.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Service;
import org.uarrive.filecabinets.Entity.BFileStorage;
import org.uarrive.filecabinets.Repository.BFileStorageRepository;
import org.uarrive.filecabinets.Util.ApplicationProperties;

import java.io.File;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
public class FileService {

    @Autowired
    private BFileStorageRepository repository;

    @Autowired
    private ApplicationProperties applicationProperties;

    //获取文件柜路径
    public BFileStorage getFileById(String id){
        Optional<BFileStorage> filePath =repository.findById(id);
        return filePath.get();
    }

    /**
     * 将文件拷贝至临时文件夹，并提供URL供前端调取
     * @param id
     * @return
     */
    public String restoreFile2Temp(String id){
        try {
            Optional<BFileStorage> fileStorage =repository.findById(id);
            File file = new File(fileStorage.get().getFileDirectory()+fileStorage.get().getOriginName());

            Path uploadPath = Paths.get("static/").toAbsolutePath().normalize();
            // 确保上传目录存在
            Files.createDirectories(uploadPath);
            Path filePath = Paths.get(uploadPath.toFile().getAbsolutePath()+"\\"+fileStorage.get().getOriginName());

            // 如第一次获取需保存文件到服务器
            if(!Files.exists(filePath)){
                Files.copy(file.toPath(), uploadPath.resolve(fileStorage.get().getOriginName()), StandardCopyOption.COPY_ATTRIBUTES);
            }

            return "http://"+InetAddress.getLocalHost().getHostAddress()+":"+applicationProperties.getPort()+applicationProperties.getContextPath()+"/"+fileStorage.get().getOriginName();
        }catch (Exception e){
            e.printStackTrace();
        }


        return "";
    }
}

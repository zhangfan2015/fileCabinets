package org.uarrive.filecabinets.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uarrive.filecabinets.Entity.DSysSetting;
import org.uarrive.filecabinets.Repository.DSysSettingRepository;

import java.util.Optional;

@Service
public class SysSettingService {

    @Autowired
    private DSysSettingRepository repository;

    //获取文件柜路径
    public String getCabinetsPath(){
        Optional<DSysSetting> filePath =repository.findById(1);
        return filePath.get().getValue();
    }
}

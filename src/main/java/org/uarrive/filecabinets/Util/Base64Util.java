package org.uarrive.filecabinets.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.uarrive.filecabinets.Entity.BFileStorage;
import org.uarrive.filecabinets.Repository.BFileStorageRepository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Component
public class Base64Util {


    /**
     *
     * @param base64Str base64字符编码
     * @param targetFilePath 文件存在电脑中的哪个位置(比如传: "D://")
     */
    public static void  Base64ToFile(String base64Str, String targetFilePath,String originName) throws IOException {

        byte[] buffer = Base64.getDecoder().decode(base64Str.split("base64,")[1]); //将base64字符串转为字节
        FileOutputStream out = null; //创建一个FileOutputStream对象
        try{
            out = new FileOutputStream(targetFilePath+originName); //向文件中写入数据
            out.write(buffer); //将字节数据写入到文件中
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != out){
                try {
                    out.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

//        file.setFileType();
        }
    }
}

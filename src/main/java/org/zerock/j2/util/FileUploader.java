package org.zerock.j2.util;


import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Log4j2
public class FileUploader {

    public static class UploadException extends RuntimeException{

        public UploadException(String msg){
            super(msg);
        }
    }

    @Value("${org.zerock.upload.path}")
    private String path;

    public List<String> uploadFiles(List<MultipartFile> files, boolean makeThumbnail){

        if (files == null || files.size()==0){
            throw new UploadException("Can Not Find Files");
        }

        List<String> upLoadFileNames = new ArrayList<>();
        log.info("path : " + files);
        log.info(files);

        //loop
        for (MultipartFile mfile: files) {
            String originalFileName = mfile.getOriginalFilename();
            String uuid = UUID.randomUUID().toString();

            String fileName = uuid+"_"+originalFileName;

            File saveFile = new File(path,fileName);

            try (InputStream in = mfile.getInputStream();
                 OutputStream out = new FileOutputStream(saveFile)
                 ) {

                FileCopyUtils.copy(in,out);

                if (makeThumbnail) {
                    File thumbOutFile = new File(path, "S_" + fileName);
                    Thumbnailator.createThumbnail(saveFile, thumbOutFile, 200, 200);
                }

                upLoadFileNames.add(fileName);



            } catch (Exception e) {
                throw new UploadException("UpLoad Fail : " + e.getMessage());
            }
        }

        return upLoadFileNames;
    }



}

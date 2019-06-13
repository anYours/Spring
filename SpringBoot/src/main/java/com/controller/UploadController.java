package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class UploadController {

    @GetMapping("/index")
    public String idnex(){
        return "/uploadIndex";
    }

    @PostMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            return "请选择一个文件上传";
        }
        String filename = file.getOriginalFilename();
        long fileSize = file.getSize();
        System.out.println("文件名称" + filename + "-------文件大小" + fileSize+"B");
        String path = "D:/test";
        File dest = new File(path + "/" + filename);
        if (!dest.getParentFile().exists()) {
            //父目录不存在就创建一个
            dest.getParentFile().mkdir();
        }
        //保存文件
        try {
            file.transferTo(dest);
            return "文件上传成功";
        } catch (IOException e) {
            e.printStackTrace();
            return "文件上传失败";
        }
    }

    @RequestMapping("/fileDownload")
    @ResponseBody
    public String fileDownload(HttpServletResponse response){
        String fileName = "HiSuite_9.0.3.300.zip";
        String filePath = "D:\\test";
        File file = new File(filePath +File.separator+fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try{
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        }catch (Exception e){
            e.printStackTrace();
            return "文件下载失败";
        }finally {

                try {
                    if(null != bis){
                    bis.close();
                    }
                    if(null != os){
                        os.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
        return "文件下载成功";
    }
}

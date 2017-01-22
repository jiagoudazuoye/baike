//package com.baike.controller;
//
//import com.baidu.ueditor.ActionEnter;
//import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.UnsupportedEncodingException;
//import java.util.HashMap;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/ueditor")
//public class UEditorController {
//
//    @RequestMapping(value="/config")
//    public void config(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            request.setCharacterEncoding("utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        response.setContentType("application/json");
//        String rootPath = request.getSession()
//                .getServletContext().getRealPath("/");
//
//        try {
//            String exec = new ActionEnter(request, rootPath).exec();
//            PrintWriter writer = response.getWriter();
//            writer.write(exec);
//            writer.flush();
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @RequestMapping("uploadImg")
//    @ResponseBody
//    public Object upload(HttpServletRequest request, HttpServletResponse response,
//                         @RequestParam("upfile") MultipartFile multipartFile){
//        System.out.println("image iploading");
//        String path = request.getSession().getServletContext().getRealPath("upload")+"/";
//        String fileName = multipartFile.getOriginalFilename();
//        String state = "";
//        File targetFile = new File(path,fileName);
//        if (!targetFile.exists()){
//            targetFile.mkdirs();
//        }
//        try {
//            multipartFile.transferTo(targetFile);
//            state = "success";
//        } catch (IOException e) {
//            e.printStackTrace();
//            state = "fail";
//        }
//        StringBuffer url = request.getRequestURL();
//        String tmpcontextUrl = url.delete(url.length() - request.getRequestURL().length(),url.length()).append(request.getContextPath()).append("/").toString();
//        String imaUrl = tmpcontextUrl + "upload/" + fileName;
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("original",fileName);
//        map.put("imgUrl",imaUrl);
//        map.put("title","");
//        map.put("state",state);
//        return map;
//
//
//
//    }
//}
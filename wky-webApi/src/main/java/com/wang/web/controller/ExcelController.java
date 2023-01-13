package com.wang.web.controller;

import com.wang.web.service.ExcelService;
import com.wang.web.utils.FileUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

/**
 * @Author WangKanYou
 * @Date 2022/11/26 23:43
 * @描述:
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {
    @Resource
    private ExcelService excelService;
    @GetMapping("testExcel")
    public String testExcel(){
        File file=new File("D:/softwareData/feishu/HIS-交易明细记录汇总表-7月-10月.xlsx");
        MultipartFile multipartFile = FileUtil.getMultipartFile(file);
        excelService.testExcel(multipartFile);
        return null;
    }

}

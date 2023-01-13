package com.wang.web.service;

import com.wang.dao.entity.TUser;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author WangKanYou
 * @Date 2022/11/26 23:47
 * @描述:
 */
public interface ExcelService {
    List<TUser> testExcel(MultipartFile multipartFile);
}

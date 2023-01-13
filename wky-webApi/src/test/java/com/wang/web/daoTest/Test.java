package com.wang.web.daoTest;
import com.wang.dao.mapper.TWxFwhXcxPatientMapper;
import com.wang.dao.model.TWxFwhXcxPatient;
import com.wang.dao.model.TWxFwhXcxPatientExample;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author WangKanYou
 * @Date 2022/7/25 16:54
 * @描述:
 */
@SpringBootTest
public class Test {
    @Resource
    private TWxFwhXcxPatientMapper tWxFwhXcxPatientMapper;
    @Transactional
    @org.junit.jupiter.api.Test
    public void Test(){
        TWxFwhXcxPatientExample tWxFwhXcxPatientExample = new TWxFwhXcxPatientExample();
        TWxFwhXcxPatientExample.Criteria criteria = tWxFwhXcxPatientExample.createCriteria();
        criteria.andIdEqualTo(1);
            TWxFwhXcxPatient tWxFwhXcxPatient = new TWxFwhXcxPatient();
                tWxFwhXcxPatient.setXcxOpenid("fdfd");
        int i = tWxFwhXcxPatientMapper.updateByExampleSelective(tWxFwhXcxPatient, tWxFwhXcxPatientExample);
        System.out.println("更新结果："+i);
//
//            TWxFwhXcxPatient tWxFwhXcxPatient = new TWxFwhXcxPatient();
//                tWxFwhXcxPatient.setXcxOpenid("fdfd");
//
//            int insert = tWxFwhXcxPatientMapper.insert(tWxFwhXcxPatient);
//            System.out.println(insert);


//        List<TWxFwhXcxPatient> tWxFwhXcxPatients = tWxFwhXcxPatientMapper.selectByExample(tWxFwhXcxPatientExample);

    }
}

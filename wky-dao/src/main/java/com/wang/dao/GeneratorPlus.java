package com.wang.dao;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author WangKanYou
 * @Date 2022/10/17 15:11
 * @描述:
 */
public class GeneratorPlus {
    public static void main(String[] args) {
        // 全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(false) // AR模式
                .setAuthor("mybatis-plus自动生成")    // 作者
                .setOutputDir(System.getProperty("user.dir") + "/wky-dao/src/main/java") // 生成路径
                .setFileOverride(false) // 文件覆盖、使用自定义的覆盖策略
                .setIdType(IdType.AUTO) // 主键策略
                .setOpen(false)    //生成时不打开文件夹
                .setServiceName("%sService"); // 设置生成的service接口的名字，默认为I%sSerice
        // 数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)     // 设置数据库类型
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://127.0.0.1:3306/wky?serverTimezone=Asia/Shanghai&useSSL=false&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL")
                .setUsername("root")
                .setPassword("123456");

        // 策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) // 全局大写命名
                .setNaming(NamingStrategy.underline_to_camel); // 数据库表映射到实体的命名策略 实体类名驼峰
        //默认全表生成
        stConfig.setInclude(new String[] {"stock"}); // 需要生成的表
//        stConfig.setExclude(new String[]{""}); // 排除生成的表


        // 包名配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.wang.dao");
        //对账库用以下代码
        pkConfig.setEntity("entity");
        pkConfig.setMapper("mapper");

         //TODO银医库用以下代码
//        pkConfig.setEntity("domain.oldchspentity");
//        pkConfig.setMapper("dao.oldchspmapper");
//        config.setEntityName("OldR%s");
//        config.setMapperName("OldR%sMapper");

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
         //如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return System.getProperty("user.dir") + "/wky-dao/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                //TODO银医系统的库用一下代码
//                return System.getProperty("user.dir") + "/chsp-reconciliation/src/main/resources/reconciliation/oldchspmapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;

            }
        });
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        //不生成 controller
        templateConfig.setController("");
        //不生成 Service
        templateConfig.setService("").setServiceImpl("");
        templateConfig.setXml(null);

        cfg.setFileOutConfigList(focList);

        //配置只有实体类覆盖策略，mapper和mapper.xml文件没有情况下才生成
        cfg.setFileCreate((configBuilder, fileType, filePath) -> {
            //如果是Entity则直接返回true表示写文件
            if (fileType == FileType.ENTITY) {
                return true;
            }
            //否则先判断文件是否存在
            File file = new File(filePath);
            boolean exist = file.exists();
            if (!exist) {
                file.getParentFile().mkdirs();
            }
            //文件不存在或者全局配置的fileOverride为true才写文件
            return !exist || configBuilder.getGlobalConfig().isFileOverride();
        });


        //  整合
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config).setDataSource(dsConfig).setStrategy(stConfig).setPackageInfo(pkConfig).setCfg(cfg).setTemplate(templateConfig);
        // 生成
        ag.execute();

    }
}

package com.spring.demo.util;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisPlusGenerator {
    private static MybatisPlusGenerator single = null;

    private MybatisPlusGenerator() {
        super();
    }

    private static MybatisPlusGenerator getSingle() {
        if(single == null) {
            single =new MybatisPlusGenerator();
        }
        return single;
    }

    public void autoGeneration() {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://localhost:3306/student?characterEncoding=utf8&useSSL=false";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        AutoGenerator generator = new AutoGenerator();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("123456")
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel);
        config.setActiveRecord(false)
                .setEnableCache(false)
                .setAuthor("tangxiaoping")
                //指定输出文件夹位置
                .setOutputDir("D:\\cczj\\demo\\src\\main\\java")
                .setFileOverride(true)
                .setServiceName("%sService");

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-rb");
                this.setMap(map);
            }
        };

        // 调整 xml 生成目录演示
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "D://cczj//demo//src//main//resources//mapper//" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        cfg.setFileOutConfigList(focList);
        generator.setCfg(cfg);

        // 自定义entity支持swagger2
        focList.add(new FileOutConfig("/templates/entity2.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "D://cczj//demo//src//main//java//com//spring//demo//entity//" + tableInfo.getEntityName() + ".java";
            }
        });
        cfg.setFileOutConfigList(focList);
        generator.setCfg(cfg);

        // 关闭默认 xml 生成，调整生成 至 配置目录
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        tc.setEntity(null);
        generator.setTemplate(tc);

        generator.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent("com.spring.demo")
                                .setController("controller")
                                .setEntity("entity")
                ).execute();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MybatisPlusGenerator generator = MybatisPlusGenerator.getSingle();
        generator.autoGeneration();
    }

}

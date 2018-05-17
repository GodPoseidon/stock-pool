package com.huanxian.core.mybatis;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class GeneratorServiceEntity {

	public static void main(String[] args) {
		GeneratorServiceEntity entity = new GeneratorServiceEntity();
        String packageName = "com.huanxian";
        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
        entity.generateByTables(serviceNameStartWithI, packageName, "pl_thirdparty_account_t");
	}

    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://stock.aikline.cn:3306/stockprodb";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("stockpro")
                .setPassword("StPoolDB2018hnj")
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames)//修改替换成你需要的表名，多个表名传数组
                .setEntityBooleanColumnRemoveIsPrefix(true)
                .entityTableFieldAnnotationEnable(true);
        config.setActiveRecord(false)
                .setAuthor("zhuzhen")
                .setOutputDir("d:\\codeGen")
                .setFileOverride(true)
                .setEnableCache(false)
                .setBaseResultMap(true)
                .setBaseColumnList(true);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("controller")
                                .setEntity("entity")
                ).execute();
    }

    public void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }
    
  
}


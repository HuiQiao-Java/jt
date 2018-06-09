package com.jt.config;

import java.io.IOException;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;


@PropertySource("classpath:mysql_configs.properties")//类目录下的文件
public class AppRootConfig {
	
	@Bean(value="dataSource",initMethod="init",destroyMethod="close")
	public DruidDataSource druid(
			@Value("${jdbcDriver}")String jdbcDriver,
			@Value("${jdbcUrl}")String url,
			@Value("${jdbcUser}")String user,
			@Value("${jdbcPassword}")String password
			) {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(jdbcDriver);
		druidDataSource.setUrl(url);
		druidDataSource.setUsername(user);
		druidDataSource.setPassword(password);
		return druidDataSource;
	}
	
	@Bean("sqlSessionFactory")
	public SqlSessionFactoryBean newSqlSessionFactory(
			@Autowired DruidDataSource dataSource) throws IOException {
		SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
		sfb.setDataSource(dataSource);
		Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*.xml");
		sfb.setMapperLocations(resources);
		sfb.setTypeAliasesPackage("com.jt.sys.entity");
		return sfb;
	}
	@Bean
	public MapperScannerConfigurer newMapperScannerConfigurer() {
		 MapperScannerConfigurer msc =  new MapperScannerConfigurer();
		 msc.setBasePackage("com.jt.**.dao");
		 return msc;
	}
}

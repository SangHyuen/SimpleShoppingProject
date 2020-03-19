package com.shopping01;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "com.shopping01.domain.**")
public class Shopping01Config {
	
	   @Bean
	    public SqlSessionFactory sqlSessionFactory (DataSource dataSource) throws Exception {
	        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
	        sqlSessionFactory.setDataSource(dataSource);
	        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mappers/*.xml"));;
	        sqlSessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mybatis-config.xml"));
	        return sqlSessionFactory.getObject();
	    }
	    
	    @Bean
	    public SqlSessionTemplate sqlSession (SqlSessionFactory sqlSessionFactory) {
	        
	        return new SqlSessionTemplate(sqlSessionFactory);
	    }
}

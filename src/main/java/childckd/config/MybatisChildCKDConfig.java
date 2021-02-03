package childckd.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@Configuration
@MapperScan(basePackages = "childckd.dao",sqlSessionFactoryRef = "childckdSqlSessionFactory")
public class MybatisChildCKDConfig {
	@Primary
	@Bean(name = "childckdDataSource")
	@ConfigurationProperties("spring.datasource.childckd")
	public DataSource masterDataSource(){
		return DruidDataSourceBuilder.create().build();
	}

	@Bean(name = "childckdSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("childckdDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
				.getResources("classpath:childckd/mapper/*.xml"));
		return sessionFactoryBean.getObject();
	}

	@Bean
	public PlatformTransactionManager childckdTransactionManager(@Qualifier("childckdDataSource")DataSource sitDataSource) {
		return new DataSourceTransactionManager(sitDataSource);
	}
}

/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.koneu;

import com.alibaba.druid.pool.DruidDataSource;
import com.koneu.common.MyFilter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.servlet.Filter;

@SpringBootApplication
@PropertySource({"classpath:jdbc.properties"})
public class WebApplication extends SpringBootServletInitializer {

	private static Logger logger = Logger.getLogger(WebApplication.class);

	@Value("${jdbc.url}")
	public String jdbcUrl;

	@Value("${jdbc.username}")
	public String jdbcUserName;

	@Value("${jdbc.password}")
	public String jdbcPassword;

	@Bean
	public DruidDataSource druidDataSource() {
		DruidDataSource ds = new DruidDataSource();
		ds.setUrl(jdbcUrl);
		ds.setPassword(jdbcPassword);
		ds.setUsername(jdbcUserName);
		return ds;
	}

	@Bean
	public Filter myFilter() {
		MyFilter filter = new MyFilter();
		return filter;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(WebApplication.class, args);
	}

}

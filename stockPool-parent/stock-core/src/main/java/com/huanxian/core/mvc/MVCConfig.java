package com.huanxian.core.mvc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;


@Configuration
public class MVCConfig {

	/**
	 * 设置返回数据的格式
	 * @return
	 */
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		objectMapper.setDateFormat(smt); 
        List<MediaType> list = new ArrayList<MediaType>();  
        list.add(MediaType.APPLICATION_JSON_UTF8);  
        converter.setSupportedMediaTypes(list);
		converter.setObjectMapper(objectMapper);
		return converter;
	}
}

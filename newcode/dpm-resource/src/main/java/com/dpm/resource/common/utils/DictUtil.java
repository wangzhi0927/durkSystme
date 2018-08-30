package com.dpm.resource.common.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.dpm.resource.freamwork.YamlPropertySourceFactory;

import lombok.Data;

@Component
@ConfigurationProperties(prefix ="resource")
@PropertySource(value = "classpath:config/dict.yml",factory=YamlPropertySourceFactory.class)
@Data
public class DictUtil {
	public Map<String, String> systeminfo = new HashMap<String, String>();
	
}

package com.huanxian.core.redisson;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@ConditionalOnProperty(name = "redisson.enabled", havingValue = "true")
@EnableConfigurationProperties(RedissonProperties.class)
public class RedissonConfiguration {

	private final static Logger logger = LogManager.getLogger();
	
	@Bean(destroyMethod = "shutdown")
	@ConditionalOnMissingBean(name = "redissonClient")
	RedissonClient redissonClient(RedissonProperties properties) throws IOException {
		Config config = new Config();
		if(properties.getFileConfig()) {
			if(!StringUtils.isEmpty(properties.getYamlPath()) && !StringUtils.isEmpty(properties.getJsonPath())) {
				logger.warn("yaml和json配置路径同时存在，默认优先使用yaml路径！！");
			}
			if(!StringUtils.isEmpty(properties.getYamlPath())) {			
				Config.fromYAML(properties.getYamlPath());
			}else if(!StringUtils.isEmpty(properties.getJsonPath())){
				Config.fromJSON(properties.getJsonPath());
			}		
		}
		if (properties.getSingleServer()) {
			config.useSingleServer().setAddress(properties.getAddress());
			
			config.useSingleServer().setPassword(properties.getPassword());
			config.useSingleServer().setClientName(properties.getClientName());
			config.useSingleServer().setConnectTimeout(properties.getConnectTimeout());
			config.useSingleServer().setKeepAlive(properties.getKeepAlive());		
			config.useSingleServer().setDatabase(properties.getDatabase());
		} else if (properties.getClusterServers()) {
			config.useClusterServers().addNodeAddress(properties.getNodeAddress());
			
			config.useClusterServers().setPassword(properties.getPassword());
			config.useClusterServers().setClientName(properties.getClientName());
			config.useClusterServers().setConnectTimeout(properties.getConnectTimeout());
			config.useClusterServers().setKeepAlive(properties.getKeepAlive());
		} else if (properties.getMasterSlaveServers()) {
			config.useMasterSlaveServers().setMasterAddress(properties.getMasterAddress());
			config.useMasterSlaveServers().addSlaveAddress(properties.getSlaveAddress());
			
			config.useMasterSlaveServers().setPassword(properties.getPassword());
			config.useMasterSlaveServers().setClientName(properties.getClientName());
			config.useMasterSlaveServers().setConnectTimeout(properties.getConnectTimeout());
			config.useMasterSlaveServers().setKeepAlive(properties.getKeepAlive());
			config.useMasterSlaveServers().setDatabase(properties.getDatabase());
		} else if (properties.getSentinelServers()) {
			config.useSentinelServers().addSentinelAddress(properties.getSentinelAddress());
			
			config.useSentinelServers().setPassword(properties.getPassword());
			config.useSentinelServers().setClientName(properties.getClientName());
			config.useSentinelServers().setConnectTimeout(properties.getConnectTimeout());
			config.useSentinelServers().setKeepAlive(properties.getKeepAlive());
			config.useSentinelServers().setDatabase(properties.getDatabase());
		} else if (properties.getReplicatedServers()) {
			config.useReplicatedServers().addNodeAddress(properties.getReplicatedAddress());
			config.useReplicatedServers().setScanInterval(properties.getReplicatedScanInterval());
			config.useReplicatedServers().setDatabase(properties.getDatabase());
			
			config.useReplicatedServers().setPassword(properties.getPassword());
			config.useReplicatedServers().setClientName(properties.getClientName());
			config.useReplicatedServers().setConnectTimeout(properties.getConnectTimeout());
			config.useReplicatedServers().setKeepAlive(properties.getKeepAlive());
			config.useReplicatedServers().setDatabase(properties.getDatabase());
		} else {
			throw new IllegalArgumentException("请指定一种模式开启redisson！！！！！");
		}
		config.setTransportMode(properties.getTransportMode());
		config.setNettyThreads(properties.getNettyThreads());
		config.setThreads(properties.getThreads());
		config.setCodec(properties.getCodec());
		return Redisson.create(config);
	}
}

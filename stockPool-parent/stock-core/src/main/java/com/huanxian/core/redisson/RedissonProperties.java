package com.huanxian.core.redisson;

import java.net.URI;

import org.redisson.client.codec.Codec;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.SslProvider;
import org.redisson.config.TransportMode;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = RedissonProperties.Redisson_PREFIX)
public class RedissonProperties {

	public static final String Redisson_PREFIX = "redisson";
	
	private Boolean enabled = false;
	
	/**
	 * 是否采用文件形式配置
	 */
	private Boolean fileConfig = false;
	
	/**
	 * 开启单服务器模式
	 */
	private Boolean singleServer = true;
	
	/**
	 * 开启集群模式
	 */
	private Boolean clusterServers = false;
	
	/**
	 * 开启主从模式
	 */
	private Boolean masterSlaveServers = false;
	
	
	private Boolean replicatedServers = false;
	
	
	/**
	 * 开启哨兵模式
	 */
	private Boolean sentinelServers = false;
	
	private String address = "127.0.0.1:6379";
	
	private String password;
	
	private String clientName;
	/**
	 * 节点地址集合
	 */
	private String[] nodeAddress;
	
	/**
	 * 主节点
	 */
	private String masterAddress;
	
	/**
	 * 从节点
	 */
	private String[] slaveAddress;

	/**
	 * 哨兵模式节点地址
	 */
	private String[] sentinelAddress;
	
	private String[] replicatedAddress;
	
	/**
	 * 序列化
	 */
	private Codec codec = new JsonJacksonCodec();
	
	
    /**
     * Threads amount shared between all redis node clients
     */
    private int threads = 0; // 0 = current_processors_amount * 2
    
    private int nettyThreads = 0; // 0 = current_processors_amount * 2


    private TransportMode transportMode = TransportMode.NIO;
    
    
    
    /**
     * If pooled connection not used for a <code>timeout</code> time
     * and current connections amount bigger than minimum idle connections pool size,
     * then it will closed and removed from pool.
     * Value in milliseconds.
     *
     */
    private int idleConnectionTimeout = 10000;

    /**
     * Ping timeout used in <code>Node.ping</code> and <code>Node.pingAll<code> operation.
     * Value in milliseconds.
     *
     */
    private int pingTimeout = 1000;

    /**
     * Timeout during connecting to any Redis server.
     * Value in milliseconds.
     *
     */
    private int connectTimeout = 10000;

    /**
     * Redis server response timeout. Starts to countdown when Redis command was succesfully sent.
     * Value in milliseconds.
     *
     */
    private int timeout = 3000;

    private int retryAttempts = 3;

    private int retryInterval = 1500;

    /**
     * Subscriptions per Redis connection limit
     */
    private int subscriptionsPerConnection = 5;


    private boolean sslEnableEndpointIdentification = true;
    
    private SslProvider sslProvider = SslProvider.JDK;
    
    private URI sslTruststore;
    
    private String sslTruststorePassword;
    
    private URI sslKeystore;
    
    private String sslKeystorePassword;

    private int pingConnectionInterval;

    private boolean keepAlive;
    
    private boolean tcpNoDelay;
    
    /**
     * Replication group scan interval in milliseconds
     */
    private int replicatedScanInterval = 1000;

    /**
     * Database index used for Redis connection
     */
    private int database = 0;
    
    /**
     * 采用yaml配置
     */
    private String yamlPath;
    
    /**
     * 采用json配置
     */
    private String jsonPath;
    
       
	public int getReplicatedScanInterval() {
		return replicatedScanInterval;
	}

	public void setReplicatedScanInterval(int replicatedScanInterval) {
		this.replicatedScanInterval = replicatedScanInterval;
	}


	public int getIdleConnectionTimeout() {
		return idleConnectionTimeout;
	}

	public void setIdleConnectionTimeout(int idleConnectionTimeout) {
		this.idleConnectionTimeout = idleConnectionTimeout;
	}

	public int getPingTimeout() {
		return pingTimeout;
	}

	public void setPingTimeout(int pingTimeout) {
		this.pingTimeout = pingTimeout;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getRetryAttempts() {
		return retryAttempts;
	}

	public void setRetryAttempts(int retryAttempts) {
		this.retryAttempts = retryAttempts;
	}

	public int getRetryInterval() {
		return retryInterval;
	}

	public void setRetryInterval(int retryInterval) {
		this.retryInterval = retryInterval;
	}

	public int getSubscriptionsPerConnection() {
		return subscriptionsPerConnection;
	}

	public void setSubscriptionsPerConnection(int subscriptionsPerConnection) {
		this.subscriptionsPerConnection = subscriptionsPerConnection;
	}

	public boolean isSslEnableEndpointIdentification() {
		return sslEnableEndpointIdentification;
	}

	public void setSslEnableEndpointIdentification(boolean sslEnableEndpointIdentification) {
		this.sslEnableEndpointIdentification = sslEnableEndpointIdentification;
	}

	public SslProvider getSslProvider() {
		return sslProvider;
	}

	public void setSslProvider(SslProvider sslProvider) {
		this.sslProvider = sslProvider;
	}

	public URI getSslTruststore() {
		return sslTruststore;
	}

	public void setSslTruststore(URI sslTruststore) {
		this.sslTruststore = sslTruststore;
	}

	public String getSslTruststorePassword() {
		return sslTruststorePassword;
	}

	public void setSslTruststorePassword(String sslTruststorePassword) {
		this.sslTruststorePassword = sslTruststorePassword;
	}

	public URI getSslKeystore() {
		return sslKeystore;
	}

	public void setSslKeystore(URI sslKeystore) {
		this.sslKeystore = sslKeystore;
	}

	public String getSslKeystorePassword() {
		return sslKeystorePassword;
	}

	public void setSslKeystorePassword(String sslKeystorePassword) {
		this.sslKeystorePassword = sslKeystorePassword;
	}

	public int getPingConnectionInterval() {
		return pingConnectionInterval;
	}

	public void setPingConnectionInterval(int pingConnectionInterval) {
		this.pingConnectionInterval = pingConnectionInterval;
	}

	public boolean getKeepAlive() {
		return keepAlive;
	}

	public void setKeepAlive(boolean keepAlive) {
		this.keepAlive = keepAlive;
	}

	public boolean getTcpNoDelay() {
		return tcpNoDelay;
	}

	public void setTcpNoDelay(boolean tcpNoDelay) {
		this.tcpNoDelay = tcpNoDelay;
	}

	public Boolean getReplicatedServers() {
		return replicatedServers;
	}

	public void setReplicatedServers(Boolean replicatedServers) {
		this.replicatedServers = replicatedServers;
	}

	public String[] getReplicatedAddress() {
		return replicatedAddress;
	}

	public void setReplicatedAddress(String[] replicatedAddress) {
		this.replicatedAddress = replicatedAddress;
	}

	public Boolean getSingleServer() {
		return singleServer;
	}

	public void setSingleServer(Boolean singleServer) {
		this.singleServer = singleServer;
	}

	public Boolean getClusterServers() {
		return clusterServers;
	}

	public void setClusterServers(Boolean clusterServers) {
		this.clusterServers = clusterServers;
	}

	public String getMasterAddress() {
		return masterAddress;
	}

	public void setMasterAddress(String masterAddress) {
		this.masterAddress = masterAddress;
	}

	public String[] getSlaveAddress() {
		return slaveAddress;
	}

	public void setSlaveAddress(String[] slaveAddress) {
		this.slaveAddress = slaveAddress;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String[] getNodeAddress() {
		return nodeAddress;
	}

	public void setNodeAddress(String[] nodeAddress) {
		this.nodeAddress = nodeAddress;
	}

	public Boolean getMasterSlaveServers() {
		return masterSlaveServers;
	}

	public void setMasterSlaveServers(Boolean masterSlaveServers) {
		this.masterSlaveServers = masterSlaveServers;
	}

	public String[] getSentinelAddress() {
		return sentinelAddress;
	}

	public void setSentinelAddress(String[] sentinelAddress) {
		this.sentinelAddress = sentinelAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getSentinelServers() {
		return sentinelServers;
	}

	public void setSentinelServers(Boolean sentinelServers) {
		this.sentinelServers = sentinelServers;
	}

	public Codec getCodec() {
		return codec;
	}

	public void setCodec(Codec codec) {
		this.codec = codec;
	}

	public int getThreads() {
		return threads;
	}

	public void setThreads(int threads) {
		this.threads = threads;
	}

	public int getNettyThreads() {
		return nettyThreads;
	}

	public void setNettyThreads(int nettyThreads) {
		this.nettyThreads = nettyThreads;
	}

	public TransportMode getTransportMode() {
		return transportMode;
	}

	public void setTransportMode(TransportMode transportMode) {
		this.transportMode = transportMode;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getDatabase() {
		return database;
	}

	public void setDatabase(int database) {
		this.database = database;
	}

	public String getJsonPath() {
		return jsonPath;
	}

	public void setJsonPath(String jsonPath) {
		this.jsonPath = jsonPath;
	}

	public String getYamlPath() {
		return yamlPath;
	}

	public void setYamlPath(String yamlPath) {
		this.yamlPath = yamlPath;
	}

	public Boolean getFileConfig() {
		return fileConfig;
	}

	public void setFileConfig(Boolean fileConfig) {
		this.fileConfig = fileConfig;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
		
	
}

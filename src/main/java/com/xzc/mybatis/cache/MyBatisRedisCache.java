package com.xzc.mybatis.cache;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;

/**
 * 使用Redis作为MyBatis二级缓存
 * @author 徐志超
 *
 */
public class MyBatisRedisCache implements Cache {
	private static final Logger logger = Logger.getLogger(MyBatisRedisCache.class);
	
	// 获取读写锁（MyBatis的缓存机制需要用到读写锁）
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	// 创建Jedis， 生产过程中需要用JedisPool
	private Jedis redisClient = new Jedis("192.168.14.168", 6379);
	
	private String id;
	
	public MyBatisRedisCache(final String id) {
		if( id == null){
			 throw new IllegalArgumentException("缓存实例需要传入id");  
		}
		logger.debug("****MyBatisRedisCache:id = " + id);
		this.id = id;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public void putObject(Object key, Object value) {

		logger.debug("****putObject:"+key+"="+value);  
		// 生成放入Redis二级缓缓存数据库的key（需要序列化，可自定义，但是必须保持唯一）
		redisClient.set(SerializeUtil.serialize(key.toString()), SerializeUtil.serialize(value));  

	}

	@Override
	public Object getObject(Object key) {
		// 反序列化获取key，利用key从Redis中获取数据
		Object value = SerializeUtil.unserialize(redisClient.get(SerializeUtil.serialize(key.toString())));  
		logger.debug("****getObject:"+key+"="+value);  
		return value;  

	}

	@Override
	public Object removeObject(Object key) {
		return redisClient.expire(SerializeUtil.serialize(key.toString()),0);
	}

	@Override
	public void clear() {
		redisClient.flushDB(); 
	}

	@Override
	public int getSize() {
		return Integer.valueOf(redisClient.dbSize().toString());  
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}
}

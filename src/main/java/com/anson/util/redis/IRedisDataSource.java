package com.anson.util.redis;

import redis.clients.jedis.ShardedJedis;

public interface IRedisDataSource {
	//��ȡ�ͻ���
	public ShardedJedis getResource();
	//����Դ������pool
	public void close();
}

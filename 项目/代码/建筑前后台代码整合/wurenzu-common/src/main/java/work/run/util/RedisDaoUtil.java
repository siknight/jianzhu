package work.run.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisDaoUtil {

	@Autowired
	@Qualifier("redisTemplate") // 指定泛型后可省略
	private RedisTemplate<Object, Object> template;

	public void saveObject(String key, Object value) {
		template.opsForValue().set(key, value);
	}

	public Object getObject(String key) {
		Object value = template.opsForValue().get(key);
		return value;
	}
}

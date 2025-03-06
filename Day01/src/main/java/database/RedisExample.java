package database;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

public class RedisExample {

    public static void main(String[] args) {
        try {
            Jedis jedis = new Jedis("localhost", 6379);
            SetParams params = new SetParams().ex(30);
            jedis.set("cachedUser", "{id:1, email:'keeper@ninydev.com'}", params);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

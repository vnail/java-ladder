package cache;

import com.zhipin.cache.service.impl.CacheServiceRedisImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.Charset;

@Component("lexiconSubjectCache")
public class LexiconSubjectCache {

    @Autowired
    private CacheServiceRedisImpl cacheServiceRedis;

    private LexiconSubjectCacheData bitSetRedis;

    private String key="common:lexicon:subject";

    private HashProvider.HashFunction hashFunction = HashProvider.HashMethod.Murmur3KirschMitzenmacher.getHashFunction();

    private int size=100000;

    private int k=5;

    @PostConstruct
    private void init(){
        bitSetRedis=new LexiconSubjectCacheData();
        bitSetRedis.setClient(cacheServiceRedis.client);
        bitSetRedis.setKey(key);
    }

    public void add(String value){
         bitSetRedis.setAll(hash(value));
    }

    public boolean contains(String value){
       return bitSetRedis.isAllSet(hash(value));
    }



    public int[] hash(byte[] bytes){
        return hashFunction.hash(bytes,size,k);

    }

    public int[] hash(String value){
       return hash(value.getBytes(Charset.forName("UTF-8")));
    }


}

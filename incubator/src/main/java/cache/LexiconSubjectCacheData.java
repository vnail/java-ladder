package cache;


import redis.clients.jedis.JedisCommands;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;


public class LexiconSubjectCacheData extends BitSet {


    private JedisCommands client;

    private String key;

    public JedisCommands getClient() {
        return client;
    }

    public void setClient(JedisCommands client) {
        this.client = client;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean get(int bitIndex){
        return client.getbit(key,bitIndex);
    }

    public void set(int bitIndex,boolean value){
        client.setbit(key,bitIndex,value);
    }

    public void setAll(int... positions){
        for(int position:positions){
            client.setbit(key,position,true);
        }
    }

    public Boolean[] getBulk(int... indexes){
        List<Boolean> result=new LinkedList<>();
        for(int index:indexes){
            result.add(get(index));
        }

        return result.toArray(new Boolean[indexes.length]);
    }
    public boolean isAllSet(int... positions){
        Boolean[] results=getBulk(positions);
        return Stream.of(results).allMatch(b -> b);
    }
}

package com.atguigu.common.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lfy
 * @Description
 * @create 2023-08-19 10:05
 */
@Slf4j
public class JSONs {
    private static final ObjectMapper mapper = new ObjectMapper();



    /**
     * 复杂类型转换
     * @param json
     * @param ref
     * @return
     * @param <T>
     */
    public static<T> T jsonStrToObj(String json,TypeReference<T> ref){
        T t = null;
        try {
            t = mapper.readValue(json, ref);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return t;
    }

    public static<T> T jsonStrToObj(String json, Class<T> valueType){
        T t = null;
        try {
            t = mapper.readValue(json, valueType);
        } catch (JsonProcessingException e) {
            log.error("json转换失败：{}",e);
        }
        return t;
    }
    public static String toJSONStr(Object obj){
        String string = null;
        try {
            string = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("json转化错误：{}",e);
        }
        return string;
    }
}

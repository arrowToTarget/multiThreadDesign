package com.lewis.protostuff;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

/**
 * Created by zhangminghua on 2016/6/13.
 */
public final class ProtoStuffSerializerUtil {

    private ProtoStuffSerializerUtil(){}

    public  static <T> byte[] serialize(T t){
        Schema<T> schema = RuntimeSchema.getSchema((Class<T>)t.getClass());
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        byte[] bytes = ProtostuffIOUtil.toByteArray(t, schema, buffer);
        return bytes;
    }

    public static <T> T deserializer(byte[] bytes, Class<T> clazz) {
        Schema<T> schema = RuntimeSchema.getSchema(clazz);
        T t = null;
        try {
            t = clazz.newInstance();
            ProtostuffIOUtil.mergeFrom(bytes, t, schema);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }

}

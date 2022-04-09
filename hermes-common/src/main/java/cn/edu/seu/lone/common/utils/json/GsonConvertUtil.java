package cn.edu.seu.lone.common.utils.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Gson 封装工具
 */
public class GsonConvertUtil {

    /**
     * 采用单例模式，保证线程安全
     */

    private volatile static GsonConvertUtil singleton = null;

    /**
     * Gson解析对象
     */
    private Gson gson;

    /**
     * Gson封装工具初始化，主要处理JSON的解析配置
     */
    private GsonConvertUtil() {
        // 1.对日期格式化处理
        // 2.开启对Map的解析转化支持，{key1: value1, key2: value2}
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").enableComplexMapKeySerialization().create();
    }

    /**
     * 单例模式（线程安全处理）
     */
    public static GsonConvertUtil getInstance() {
        if (singleton == null) {
            synchronized (GsonConvertUtil.class) {
                if (singleton == null) {
                    singleton = new GsonConvertUtil();
                }
            }
        }
        return singleton;
    }

    /**
     * 将JSON转化为指定的JAVA对象
     */
    public <T> T convertToObject(JsonObject jsonObject, Class<T> t) {
        return gson.fromJson(jsonObject, t);
    }

    /**
     * 将JSON转化为LIST对象
     */
    public <T> List<T> convertToList(String jsonObj, Class<T[]> clazz) {
        T[] arr = gson.fromJson(jsonObj, clazz);
        return Arrays.asList(arr);
    }

    /**
     * JSON转化为MAP对象
     */
    public Map<String, String> convertToMap(String jsonObj) {
        return gson.fromJson(jsonObj, new TypeToken<Map<String, String>>() {}.getType());
    }
}

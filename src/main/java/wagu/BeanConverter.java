package wagu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by xingxing.zhong on 2017/12/18
 *
 * @author xingxing.zhong
 */
public enum BeanConverter {
    CONVERTER;
    public static Gson GSON;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls(); //重点
        GSON = gsonBuilder.create();
    }

    public <T> T convert2Bean(String msg, Type typeOfT) {
        return GSON.fromJson(msg, typeOfT);
    }

    public List<List<String>> convert2TableLine(List<?> datas) {
        List<List<String>> out = new ArrayList<>();
        for (Object obj : datas) {
            List<String> objValues = new ArrayList<>();
            JsonElement json = GSON.toJsonTree(obj);
            if (json.isJsonObject()) {
                JsonObject jsonObj = json.getAsJsonObject();
                Iterator<Map.Entry<String, JsonElement>> it = jsonObj.entrySet().iterator();
                while (it.hasNext()) {
                    JsonElement v = it.next().getValue();
                    if (v.isJsonNull()) {
                        objValues.add("N/A");
                    } else {
                        objValues.add(v.getAsString());
                    }
                }
            }
            out.add(objValues);
        }
        return out;
    }
}

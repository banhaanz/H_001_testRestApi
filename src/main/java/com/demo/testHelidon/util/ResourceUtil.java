package com.demo.testHelidon.util;

import org.yaml.snakeyaml.Yaml;
import java.io.IOException;
import java.util.*;


public class ResourceUtil
{
    public static Properties getProperties(String propFileName) {
        Properties p = new Properties();
        try {
            p.load(ResourceUtil.class.getResourceAsStream("/" + propFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    public static Properties getYaml(String yamlFileName) {
        final Properties p = new Properties();
        final Yaml yaml = new Yaml();
        Map<String, Object> yamlMaps = yaml.load(ResourceUtil.class.getResourceAsStream("/" + yamlFileName));
        List<Map<String, Object>> keyList = checkIsHasValueAsMap(yamlMaps, null);
        keyList.forEach(p::putAll);
        return p;
    }

    private static List<Map<String, Object>> checkIsHasValueAsMap(Map<String, Object> maps, List<Map<String, Object>> keyList){
        keyList = keyList != null ? keyList : new ArrayList<>();
        if(null != maps) {
            try {
                for (Map.Entry entry : maps.entrySet()) {
                    if (entry.getValue() != null && entry.getValue() instanceof Map) {
                        Map<String, Object> tempMaps = new HashMap<>();
                        tempMaps.put(String.valueOf(entry.getKey()), entry.getValue());
                        keyList.add(tempMaps);
                    }
                }
                checkIsHasValueAsMap(null, keyList);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else {
            List<Map<String, Object>> toRemove = new ArrayList<>();
            List<Map<String, Object>> toUpdate = new ArrayList<>();
            List<Map<String, Object>> toRedo = new ArrayList<>();

            keyList.forEach(el -> el.forEach((k, v) -> {
                if (v instanceof Map){
                    toRemove.add(el);
                    Map<String, Object> tempMaps1 = (Map<String, Object>) v;
                    Map<String, Object> tempMaps2 = new HashMap<>();
                    if(tempMaps1.size() == 1){
                        tempMaps1.forEach((k1, v1) -> {
                            tempMaps2.put(k + "." + k1, v1);
                            toUpdate.add(tempMaps2);
                        });
                    }else {
                        tempMaps1.forEach((k2, v2) -> {
                            Map<String, Object> tempMaps3 = new HashMap<>();
                            tempMaps3.put(k + "." + k2, v2);
                            toUpdate.add(tempMaps3);
                        });
                    }
                }
            }));

            keyList.removeAll(toRemove);
            keyList.addAll(toUpdate);

            keyList.forEach(el -> {
                for(Map.Entry entry : el.entrySet()){
                    if (entry.getValue() != null && entry.getValue() instanceof Map){
                        toRedo.add(el);
                    }
                }
            });

            if(!toRedo.isEmpty()){
                checkIsHasValueAsMap(null, keyList);
            }
        }
        return keyList;
    }

}

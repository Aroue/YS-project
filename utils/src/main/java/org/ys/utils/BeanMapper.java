package org.ys.utils;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Component
public class BeanMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.create().build();

    public static Mapper getMapper() {
        return mapper;
    }

    /**
     * 基于Dozer转换对象的类型.
     */
    public static <T> T map(Object source, Class<T> destinationClass) {
        if (null == source)
            return null;
        return mapper.map(source, destinationClass);
    }

    /**
     * 基于Dozer转换Collection中对象的类型.
     */
    @SuppressWarnings("rawtypes")
    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
        if (null == sourceList)
            return null;
        List<T> destinationList = new ArrayList<>();
        for (Object sourceObject : sourceList) {
            T destinationObject = mapper.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

    /**
     * ????Dozer??????A?????????????B??.
     */
    public static void copy(Object source, Object destinationObject) {
        mapper.map(source, destinationObject);
    }
}
package org.ys.utils.dto;

import org.dozer.Mapper;
import org.ys.utils.BeanMapper;

public class BaseDTO {
    protected final static Mapper mapper = BeanMapper.getMapper();

//    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
//        return BeanMapper.mapList(sourceList, destinationClass);
//    }
}

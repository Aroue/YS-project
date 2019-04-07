package org.ys.utils;

public class Entity {
    public <T> T to(Class<T> destinationClass) {
        return BeanMapper.getMapper().map(this, destinationClass);
    }
}

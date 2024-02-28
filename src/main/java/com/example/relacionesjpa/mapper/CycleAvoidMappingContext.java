package com.example.relacionesjpa.mapper;

import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class CycleAvoidMappingContext {
    private Map<Object,Object> knownInstances = new IdentityHashMap<Object,Object>();
    @BeforeMapping
    public <T> T getMapping(Object source, @TargetType Class<T> targetType)
    {
        return (T) knownInstances.get(source);
    }

    @BeforeMapping
    public void storeMappedInstances(Object source, @MappingTarget Object target)
    {
        knownInstances.put(source,target);
    }
}

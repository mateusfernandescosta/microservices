package com.course.microservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import java.util.Set;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

/**
 *
 * @author MateusCosta
 */
@Service
public class FilterService {
    
    public MappingJacksonValue doFilter(Object T, Set<String> parameters){
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(parameters);
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(T);
        mapping.setFilters(filters);
        return mapping;
    }
}

package com.course.microservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mateus Costa
 */
@RestController
public class FilteringController {
    
    @Autowired
    FilterService service;

    //field1, field2
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSameBean(){
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        return service.doFilter(someBean, new HashSet(Arrays.asList("field1","field2")));
    }
    
    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveListOfSameBean(){
        List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value12", "value22", "value32"));
        return service.doFilter(list, new HashSet(Arrays.asList("field2","field3")));
    }
}

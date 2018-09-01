package com.course.microservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mateus Costa
 */
@RestController
public class VersioningController {
    
    @GetMapping("v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Mateus Costa");
    }
    
    @GetMapping("v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Mateus", "Costa"));
    }
    
    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 personV1Param() {
        return new PersonV1("Mateus Costa");
    }
    
    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 personV2Param() {
        return new PersonV2(new Name("Mateus", "Costa"));
    }
    
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 personV1Header() {
        return new PersonV1("Mateus Costa");
    }
    
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 personV2Header() {
        return new PersonV2(new Name("Mateus", "Costa"));
    }
    
    @GetMapping(value = "/person/produces", produces = "application/my.company.app-v1+json")
    public PersonV1 personV1Produces() {
        return new PersonV1("Mateus Costa");
    }
    
    @GetMapping(value = "/person/produces", produces = "application/my.company.app-v2+json")
    public PersonV2 personV2Produces() {
        return new PersonV2(new Name("Mateus", "Costa"));
    }
    
    
}

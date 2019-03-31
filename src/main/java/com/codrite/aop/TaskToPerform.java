package com.codrite.aop;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskToPerform {

    @RequestMapping("/area/{radius}")
    public float calculateAreaOfCircle(@PathVariable("radius") float radius) {
        return ((22 * (radius * radius)) / 7);
    }

}

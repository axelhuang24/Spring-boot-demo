package com.huangkai.girl.controller;

import com.huangkai.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {


    @Autowired
    private GirlProperties girlProperties;

    //@RequestMapping(value = {"/say"}, method = RequestMethod.GET)
    @GetMapping(value = {"/say"})
    public String say(@RequestParam(value = "id", required = false, defaultValue = "100") Integer myId){
    //public String say(@PathVariable("id") Integer myId){
        return "myId: " + myId;
        //return girlProperties.getCupSize() + girlProperties.getAge();
    }
}

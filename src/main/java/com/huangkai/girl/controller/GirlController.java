package com.huangkai.girl.controller;

import com.huangkai.girl.aspect.HttpAspect;
import com.huangkai.girl.domain.Result;
import com.huangkai.girl.domain.Girl;
import com.huangkai.girl.repository.GirlRepository;
import com.huangkai.girl.service.GirlService;
import com.huangkai.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * Find all girls
     * **/
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        logger.info("girlList");
        return girlRepository.findAll();
    }

    /**
     * Add a girl
     * **/
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //return null;
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        girl.setMoney(girl.getMoney());

        return ResultUtil.success(girlRepository.save(girl));

    }

    /**
     * Find a girl with id
     * **/
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findById(id).get();
    }

    /**
     * Update a girl with id
     * **/
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("age") Integer age,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer money){

        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl.setMoney(money);

        return girlRepository.save(girl);
    }

    /**
     * Delete a girl with id
     * **/
    @DeleteMapping(value = "/girls/{id}")
    public  void girlDelete(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    /**
     * Find girls with age
     * **/
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * Insert 2 girls
     * **/
    @PutMapping(value = "/girls/insertTwo")
    public void girlTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }
}

package com.huangkai.girl.service;

import com.huangkai.girl.domain.Girl;
import com.huangkai.girl.enums.ResultEnum;
import com.huangkai.girl.exception.GirlException;
import com.huangkai.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setId(4);
        girlA.setAge(19);
        girlA.setCupSize("C");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setId(5);
        girlB.setAge(21);
        girlB.setCupSize("D");
        girlRepository.save(girlB);

        return;
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findById(id).get();
        Integer age = girl.getAge();
        if(age < 22){
            throw new GirlException(ResultEnum.UNIVERSITY);
        }
        else if(age >= 22 && age < 24){
            throw new GirlException(ResultEnum.MASTER);
        }

    }

    // Find a girl with her id
    public Girl findOne(Integer id){
        return girlRepository.findById(id).get();
    }


}

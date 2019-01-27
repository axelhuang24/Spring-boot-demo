package com.huangkai.girl.repository;

import com.huangkai.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer> {

    // find girls by age
    public List<Girl> findByAge(Integer age);
}

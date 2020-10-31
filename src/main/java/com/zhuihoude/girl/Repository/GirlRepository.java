package com.zhuihoude.girl.Repository;

import com.zhuihoude.girl.dateobject.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer> {
    //通过年龄
    public List<Girl> findByAge(Integer age);
}

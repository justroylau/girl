package com.zhuihoude.girl.service;

import com.zhuihoude.girl.Repository.GirlRepository;
import com.zhuihoude.girl.dateobject.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    //@Transactional //事务
    public void insertTwo() {

        Girl girlA = new Girl();
        girlA.setCupSize("F");
        girlA.setAge(14);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("G");
        girlB.setAge(13);
        girlRepository.save(girlB);


    }
}

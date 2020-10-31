package com.zhuihoude.girl.controll;

import com.zhuihoude.girl.Repository.GirlRepository;
import com.zhuihoude.girl.dateobject.Girl;
import com.zhuihoude.girl.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlControll {

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    //查询所有女生
    @GetMapping("/girls")
    public List<Girl> girlList() {
        System.out.println("查询所有女生");
        return girlRepository.findAll();
    }

    //添加妹子
    //@PostMapping("girlAdd")
    @GetMapping("girlAdd")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize ,@RequestParam("age") Integer age){
        System.out.println("添加妹子");
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    //ID 查询妹子
    @GetMapping("girl")
    public Girl girlFindOne (@RequestParam("id") Integer id) {
        return girlRepository.findOne(id);
    }
    //年龄 查询妹子
    @GetMapping("girlAge")
    public List<Girl> girlListByAge (@RequestParam("age") Integer age) {
        return girlRepository.findByAge(age);
    }
    //更新
    @PutMapping("updateGirl")
    public Girl girlUpdate(@RequestParam("id") Integer id,@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){

        System.out.println("添加妹子");
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    //删除
    @DeleteMapping("delGirl")
    public void GirlDel(@RequestParam("id") Integer id){
       girlRepository.delete(id);
    }

    //测试事务
    //ID 查询妹子
    @GetMapping("girlTwo")
    public void girlTwo () {
        girlService.insertTwo();
    }
}

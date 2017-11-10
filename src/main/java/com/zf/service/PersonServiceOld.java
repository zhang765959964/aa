package com.zf.service;

import com.zf.entity.Person;
import com.zf.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Person 业务逻辑层
 * Created by Administrator on 2017/11/8.
 */
@Service
public class PersonServiceOld {

    @Autowired
    private PersonRepository personRepository;

/*    public Person findByPersonName(String name){
        Person person = null;
        try {
            person =  personRepository.findByPersonName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;

    }

    public Person findOne(Long id){
        return personRepository.findOne(id);
    }


    public List<Person> findAll(){

        return personRepository.findAll(new Sort(Sort.Direction.DESC,"id"));
    }

    //根据姓名和性别查询
    public List<Person> findByNameAndSex(String name,String sex){
        List<Person> list = new ArrayList<Person>();

        try {
            list =  personRepository.findByNameAndSex(name,sex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public int save(Person person){
        Person per   = personRepository.save(person);
        if(per!=null) {
            return 1;
        }
        return 0;
    }*/





}

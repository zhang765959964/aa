package com.zf.service;

import com.zf.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 人员service
 * Created by Administrator on 2017/11/9.
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;





}

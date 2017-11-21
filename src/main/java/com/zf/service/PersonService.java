package com.zf.service;

import com.zf.dto.PersonQuery;
import com.zf.entity.Person;
import com.zf.repository.PersonRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


/**
 * 人员service
 * Created by Administrator on 2017/11/9.
 */
@SuppressWarnings("ALL")
@Service
public class PersonService {

    @Resource
    private PersonRepository personRepository;


    /**
     * lay ui 分页模糊查询
     * @param page
     * @param size
     * @param personQuery 查询条件
     * @return
     */
    public Page<Person> findPersonAll(Integer page, Integer size, final PersonQuery personQuery) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        Page<Person> personPage = personRepository.findAll(new Specification<Person>(){
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                if(null!=personQuery.getName()&&!"".equals(personQuery.getName())){
                    list.add(criteriaBuilder.like(root.get("name").as(String.class),"%"+personQuery.getName()+"%"));
                }

                if(personQuery.getSchool()!="" && personQuery.getSchool()!=null){
                    list.add(criteriaBuilder.like(root.get("school").as(String.class),"%"+personQuery.getSchool()+"%"));
                }
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        },pageable);
        return personPage;
    }


    /**
     * 分页查询条件
     * @param page
     * @param size
     * @param personQuery 查询过滤条件
     * @return
     */
    public Page<Person> findAll(Integer page, Integer size, final PersonQuery personQuery) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        Page<Person> personPage = personRepository.findAll(new Specification<Person>(){
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                if(personQuery.getName()!="" && personQuery.getName()!=null){
                    Predicate p1  = cb.like(root.get("name").as(String.class),"%"+ personQuery.getName()+"%");
                    query.where(cb.and(p1));
                }
                if(personQuery.getSchool()!="" && personQuery.getSchool()!=null){
                    Predicate p2  = cb.like(root.get("school").as(String.class),"%"+ personQuery.getSchool()+"%");
                    query.where(cb.and(p2));
                }

                return query.getRestriction();
            }
        },pageable);
        return personPage;
    }








}

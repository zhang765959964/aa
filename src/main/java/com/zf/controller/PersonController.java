package com.zf.controller;

import com.zf.dto.PersonQuery;
import com.zf.entity.Person;
import com.zf.repository.PersonRepository;
import com.zf.service.PersonService;
import com.zf.util.Json;
import com.zf.util.LayuiDatagrid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


/**
 * 人员实现层
 * Created by Administrator on 2017/11/8.
 */
@SuppressWarnings("ALL")
@RequestMapping("/person")
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;


    /**
     * 进入表格页面
     * @return
     */
    @RequestMapping("/personList")
    public ModelAndView personList(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/person/personList");
        return mv;
    }


    /**
     * layUI 数据表格 json 数据
     * @param page 当前页
     * @param size 每页显示多少的条数
     * @return
     */
    @RequestMapping("/personListJson")
    @ResponseBody
    public LayuiDatagrid personListJson(@RequestParam(value = "page", defaultValue = "0")int page,
                                        @RequestParam(value = "size", defaultValue = "15")int size, final PersonQuery personQuery) {
        LayuiDatagrid datagrid = new LayuiDatagrid();
        if(page!=0){
            page-=1;
        }
        //findAll
//        Page<Person> pagePerson = personService.findAll(page,size,personQuery);
        Page<Person> pagePerson = personService.findPersonAll(page,size,personQuery);
        datagrid.setCount(pagePerson.getTotalElements());
        datagrid.setData(pagePerson.getContent());
        return datagrid;
    }


    @RequestMapping("/save")
    @ResponseBody
    public Json save(Person person){
        Json j = new Json();
        Person p = new Person();
        BeanUtils.copyProperties(person,p);
        Person p1 = personRepository.save(p);
        if(p1!=null){
            j.setSuccess(true);
            j.setMsg("新增成功");
        }
        return j;

    }

    @RequestMapping("/update")
    @ResponseBody
    public Json update(@Param("id")Long id,@Param("name")String name,@Param("school")String school,@Param("sex") Integer sex){
        Json j = new Json();
        int i =  personRepository.updatePerson(name,sex,school,id);
        if(i>0){
            j.setSuccess(true);
            j.setMsg("修改成功");
        }else{
            j.setSuccess(false);
            j.setMsg("修改失败");
        }

        return  j;
    }




    @RequestMapping("/delete")
    @ResponseBody
    public Json delete(@Param("id")Long id){
        Json j = new Json();
        personRepository.delete(id);
        j.setMsg("删除成功");
        j.setSuccess(true);
        return j;
    }



    /**
     * 新增页面
     * @return
     */
    @RequestMapping("/personAdd")
    public ModelAndView personAdd(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/person/personAdd");
        return mv;
    }


    /**
     * 编辑页面
     * @return
     */
    @RequestMapping("/personEdit")
    @ResponseBody
    public ModelAndView personEdit(@Param("id")Long id){
        Person person = personRepository.findOne(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/person/personEdit");
        mv.addObject("person",person);
        return mv;
    }


    /**
     * 详情页面
     * @return
     **/
    @RequestMapping("/personInfo")
    public ModelAndView personInfo(@Param("id")Long id){
        Person person = personRepository.findOne(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/person/personInfo");
        return mv.addObject("person",person);
    }

    /*
    @RequestMapping(value = "/pageable")
    @ResponseBody
    public Page<Person> getEntryByParams(@RequestParam(value = "name", defaultValue = "test") String name,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", defaultValue = "15") Integer size) {
        SortTools sortTools = new SortTools();
        Pageable pageable = new PageRequest(page, size, sortTools.basicSort());
        Page<Person> pages=personRepository.findByNameNot(name,pageable);
        return pages;
    }*/









}

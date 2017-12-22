package com.zf.repository;

import com.zf.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * 基于Jpa 实现dao接口
 * Created by Administrator on 2017/11/8.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person,Long>,JpaSpecificationExecutor<Person> {


/*
    @Query("select t from Person t where t.name =:name")
    Person findByPersonName(@Param("name") String name);
    @Query("select t from Person t where t.name = :name and t.sex = :sex")
    List<Person> findByNameAndSex(@Param("name") String name, @Param("sex") String sex);
    Page<Person> findByNameNot(String name, Pageable pageable);
*/




    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update t_person t set t.name =:name,t.sex =:sex,t.school =:school where t.id = :id",nativeQuery = true)
    int updatePerson(@Param("name") String name,@Param("sex") Integer sex,@Param("school") String school,@Param("id") Long id);


}

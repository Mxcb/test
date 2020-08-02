package com.dao;

import com.domain.Student;
import com.vo.ViewObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    List<Student> selectAll();
    Student selectById(@Param("id") Integer id);
    Student selectOne(String s);
    List<Student> selectObject(Student student);
    Student selectTwo(String s);
    List<Student> selectLike(String s);
    Student selectMap(Map<String,String> map);
    String selectName(Integer id);
    List<String> selectStrings();
    List<Map<String, Object>> selectMaps();
    List<Student> selectAlias();
    List<Student> selectStuMap();
    List<Student> selectWhere(Student student);
    List<Student> selectForEach(Integer[] ids);
    List<Map<Object, Object>> selectCascade();
    List<ViewObject> selectViewObject();
    List<ViewObject> selectViewObjectLike(String s);
}

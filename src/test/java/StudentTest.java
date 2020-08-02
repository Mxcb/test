import com.dao.StudentDao;
import com.domain.Student;
import com.vo.ViewObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentTest {
    @Test
    public void testAll() throws IOException {
        InputStream inputStream=Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=factory.openSession();
        StudentDao studentDao=sqlSession.getMapper(StudentDao.class);
        Integer[] ids=new Integer[]{1001,1002,1003};
        List<Student> students=studentDao.selectForEach(ids);

//        List<Student> students=studentDao.selectLike("c");
//        Student student=new Student();
//        student.setName("c");
//        List<Student> students=studentDao.selectWhere(student);

//        List<Student> students=studentDao.selectStuMap();
        //列名与实体类的属性不同,通过给列名起别名的方式
//        List<Student> students=studentDao.selectAlias();
//        students.forEach(student -> System.out.println(student));

        //一条数据封装为一个Map对象,多条数据保存到一个List集合中
        //key是字段名,value是真实数据
        //        key:name
//        value:赵鸣春
//        key:id
//        value:1069
//        key:email
//        value:2278@qq.com
//        key:age
//        value:17
        /**
         * SELECT name,count(*) FROM `student` group by name;
         * 这条语句查询结果不能使用domain对象封装,可以使用map集合封装
         */
//        List<Map<String,Object>> maps=studentDao.selectMaps();
//        for (Map<String,Object> map:maps){
//            Set<String> set=map.keySet();
//            for (String s:set){
//                System.out.println("key:"+s);
//                System.out.println("value:"+map.get(s));
//            }
//            System.out.println("-----------------");
//        }
        //返回值为List<String>
//        List<String> strings=studentDao.selectStrings();
//        strings.forEach(s -> System.out.println(s));
        //返回值为String
//        String name=studentDao.selectName(1006);
//        System.out.println(name);
//          用map查找
//        Map<String,String> map=new HashMap<>();
//        map.put("name","C++");
//        map.put("age","18");
//        Student student=studentDao.selectMap(map);
//        System.out.println(student);

//        List<Student> students=studentDao.selectLike("c");
//        students.forEach(student -> System.out.println(student));

//        Student student=studentDao.selectTwo("'java'");
//        System.out.println(student);

//        Student student=new Student();
//        student.setName("C++");
//        student.setAge(17);
//        List<Student> students=studentDao.selectObject(student);
//        students.forEach(stu -> System.out.println(stu));

//       Student student=studentDao.selectById(1003);
//        Student student=studentDao.selectOne("C++");
//        System.out.println(student);

        //List<Student> students=studentDao.selectAll();
        //students.forEach(student -> System.out.println(student));
    }


    @Test
    public void cascade() throws IOException {
        InputStream inputStream=Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=factory.openSession();
        StudentDao studentDao=sqlSession.getMapper(StudentDao.class);
        /**
         * 这里的key重名了(map中的key是无序不可重复的),导致只查到了student.name,没查到class.name;
         * 需要起别名
         */
//        List<Map<Object,Object>> maps=studentDao.selectCascade();
//        for (Map<Object,Object> m: maps){
//            Set<Object> set=m.keySet();
//            for (Object k:set){
//                System.out.println("k:"+k);
//                System.out.println("value:"+m.get(k));
//            }
//            System.out.println("---------------");
//        }
        /**
         * 查询得到的结果(多表联查)使用实体类不能进行封装,可以使用vo或者map保存查询信息,
         * vo(viewObject/viewValue)指的是创建出一个类,这个类的属性可以自定义。
         * 前端的需求的重复率高就使用vo,不高就使用map
         */
//        List<ViewObject> viewObjects=studentDao.selectViewObject();

        List<ViewObject> viewObjects=studentDao.selectViewObjectLike("c");
    }
}

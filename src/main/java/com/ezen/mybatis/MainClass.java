package com.ezen.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MainClass {
    public static void main(String[] args) {

        String resource = "mybatis-config.xml";

        InputStream inputStream = null;
        SqlSession session = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println("sqlSessionFactory : " + sqlSessionFactory);

            session = sqlSessionFactory.openSession();
            System.out.println("session : "+session);
//            BlogMapper mapper = session.getMapper(BlogMapper.class);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

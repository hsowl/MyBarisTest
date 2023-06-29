package com.ezen.prj;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        TestDAO tDao = TestDAO.getInstance();
        List<TestVO> list = tDao.selectAllTest();
//        tDao.insertTest("박종진", "010-5543-5819","인계동");

        for(TestVO vo : list){
            System.out.println(vo);
        }
    }
}

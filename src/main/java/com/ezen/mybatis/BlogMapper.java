package com.ezen.mybatis;

import java.util.List;

public interface BlogMapper {

    public TestVO selectOne(int id);

    public List<TestVO> selectAllList();

    public int insertTest(TestVO vo);

    public int updateTest(TestVO vo);
}

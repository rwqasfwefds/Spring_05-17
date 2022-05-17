package com.example.myservice.dao;

import com.example.myservice.model.Dept;
import com.example.myservice.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName : com.example.myservice.dao
 * fileName : MemberDao
 * author : ds
 * date : 2022-05-16
 * description : 회원 테이블에 접근해서 데이터를 처리 할 클래스(DAO)
 *               하는 일 : CRUD
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-12         ds          최초 생성
 */
// @Mapper : myBatis에서 사용하는 어노테이션
//    xml문에서 select문을 작성하게 만들어 줌
//    myBatis랑 DB랑 연동하게 해줌
//    이 새끼는 스프링에 자동으로 등록도 해줌
//    그래서 다른 곳에서 @Autowired를 쓸 수 있음
//    @Autowired는 스프링에 등록 된(컴퍼넌트 등록 된) 새끼만 가능
    
//    myBatis는 쿼리문을 xml로 다 빼서 인터페이스로 만듦(이 새끼는 껍대기고 실질적으론 xml문에서 구현 함)
@Mapper
public interface MemberDao {
//    select문 메소드
    List<Member> selectAll(); // 회원 정보를  select 하는 메소드

    Member selectById(String userId); // 부서 번호에 해당하는 데이터 조회 메소드

    void insert(Member member); // 회원 정보를 insert 하는 메소드

    void update(Member member); // 부서 번호에 해당하는 데이터 수정

    void delete(String userId); // 부서 번호에 해당하는 데이터 삭제
}

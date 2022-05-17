package com.example.myservice.service;

import com.example.myservice.dao.Dept2Dao;
import com.example.myservice.model.Dept;
import com.example.myservice.model.Dept2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.myservice.service
 * fileName : Dept2ServiceImpl
 * author : ds
 * date : 2022-05-13
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-13         ds          최초 생성
 */
@Service
public class Dept2ServiceImpl implements Dept2Service{

    @Autowired
    Dept2Dao dept2Dao;

    //    select 문을 실행하는 서비스
    @Override
    public List<Dept2> selectAll() {
        return dept2Dao.selectAll();
    }

    @Override
    public void insertMember(Dept2 dept2) {
//        DB에 insert문 실행하는 부분
        dept2Dao.insert(dept2);
    }

    @Override
    public void updateMember(int dno, Dept2 updateDept) {
//        dno : 부서 번호로 먼저 그 데이터가 테이블에 있는지 확인
        Dept2 dept2 = dept2Dao.selectById(dno);

//        데이터가 있을때만 update 함
        if(dept2 != null){
//            매개변수 updateDept : 수정 될 데이터
//            dept : 현재 db에 저장되어 있는 값
//            setter : 데이터 저장
//            getter : 데이터 조회, 검색
            dept2.setDname(updateDept.getDname());
            dept2.setLoc(updateDept.getLoc());
//            위에 setter로 인해 수정 된 dept를 매개변수로 전달
//            update문을 실행해서 db에 반영(수정 반영)
            dept2Dao.update(dept2);
        } else{
//            dept가 null이면 db에 데이터가 없음(부서번호에 해당하는 데이터가 없음)
            throw new IllegalStateException("부서가 존재하지 않습니다.");
        }
    }

    //    delete 구현
    @Override
    public void deleteMember(int dno) {
//        dno : 부서 번호로 먼저 그 데이터가 테이블에 있는지 확인
        Dept2 dept2 = dept2Dao.selectById(dno);

        if(dept2 != null){
//            부서 번호가 있으면 삭제 처리
            dept2Dao.delete(dno);
        } else {
//            부서 번호가 없으면 에러 처리
            throw new IllegalStateException("부서가 존재하지 않습니다.");
        }
    }
}

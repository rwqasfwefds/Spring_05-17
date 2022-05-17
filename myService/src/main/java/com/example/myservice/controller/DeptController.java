package com.example.myservice.controller;

import com.example.myservice.dao.*;
import com.example.myservice.model.*;
import com.example.myservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName : com.example.myservice.controller
 * fileName : DeptController
 * author : ds
 * date : 2022-05-12
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-12         ds          최초 생성
 */
// @RestController : 메뉴달기, 반환값 : JSON 파일 형태
// @Controller : jsp, html, 타임리프 파일 형태
//    Rest API : 웹에서 프로토콜로 던질때 CRUD를 밑 방식으로 씀
//    CRUD (Insert : Post, Select : Get, Update : Put, Delete : Delete)
@RestController
public class DeptController {

//    @Autowired : 객체를 자동으로 의존성 주입을 해줌(자동 DI)
    @Autowired
    DeptDao deptDao;

    @Autowired
    Dept2Dao dept2Dao;

    @Autowired
    Dept3Dao dept3Dao;

    @Autowired
    Dept4Dao dept4Dao;

    @Autowired
    EmpDao empDao;

    @Autowired
    MemberDao memberDao;

    @Autowired
    BoardDao boardDao;
    
//    @Autowired : 자동 의존성 주입(DI), 대상 : 스프링에 등록된 객체만 해줌
//    스프링에 객체를 등록 : 클래스 위에 @Component, @Service, @Repository
    @Autowired
    DeptServiceImpl deptService;

    @Autowired
    Dept2ServiceImpl dept2Service;

    @Autowired
    Dept3ServiceImpl dept3Service;

    @Autowired
    Dept4ServiceImpl dept4Service;

    @Autowired
    EmpServiceImpl empService;

    @Autowired
    BoardServiceImpl boardService;

//    @Servicd, @Component, @Bean 등등 스프링에 객체를 생성하는 어노테이션
//    @Autowired : 스프링에 생성된 객체를 전달받아 아래 맴버변수에 할당
    @Autowired
    MemberServiceImpl memberService; // 회원서비스 정의, 객체생성 필요없음(스프링에 만들어져 있으니깐ㅇㅇ)

//    @GetMapping : 메뉴달기 : /main, Select 실행
//    localhost:8000/main 접속 : 새메뉴
//    @GetMapping("/main")

    @GetMapping("/dept/all")
    public List<Dept> selectAll(){
//        List<Dept> list = deptDao.selectList();
        List<Dept> list = deptDao.selectAll();
        return list;
    }

//    @PostMapping : Insert 실행
//    HTML을 예로들어서 : 헤더(머리말)와 본문(BODY)이 있음
//    @RequestBody : 본문에 TEXT / JSON 형태로 데이터를 전송하겠다 라는 뜻
    @PostMapping("/dept/new")
    public List<Dept> insertMember(@RequestBody Dept dept){
//        웹 브라우저에서 Json 형태로 데이터를 넘겨 받아(dept 객체)
//        DB에 INSERT문을 실행하는 부분
        deptService.insertMember(dept);
//        데이터 추가되었는지 결과 확인(DB Select)
//        return deptDao.selectList();
        return deptDao.selectAll();
    }

//    @PutMapping : update 어노테이션
//    @PathVariable : 웹 브라우저에서 입력한 값인 {dno} 이 새끼를 받아서 매개변수로 넘기는 놈임
//    @PathVariable 추가설명 : URL 메뉴 /dept/{dno} 중에서 dno를 의미함
//    웹 브라우저 URL 매개변수{dno}를 메소드 updateMember의 매개변수 dno로 연결해주는 쉨히
//    형태 1(전통) : http://127.0.0.1/read?no=1 : html, JSP, 타임리프 개발
//    @GetMapping("read")
//    메소드의 매개변수 : @RequestParam("no") int no

//    형태 2(REST API) : http://127.0.0.1/read/1 : REST API, axios 이용, 데이터(json), Vue, react
//    @GetMapping("read/{no}")
//    메소드의 매개변수 : @PathVariable("no") int no (@PathVariable <- 이거 다음에 ("no")는 생략 가능 어차피 쟤를 의미하는 거기 때문에)

    @PutMapping("/dept/{dno}")
    public List<Dept> updateMember(@PathVariable int dno, @RequestBody Dept dept){
//        update 문이 실행
        deptService.updateMember(dno, dept);
//        데이터 수정이 잘 되었는지 확인하는 쉨히를 리턴해줌
        return deptService.selectAll();
    }
    
//    Delete sql문 실행
//    @DeleteMapping : 데이터 삭제에 해당하는 웹 브라우저 URL 어노테이션
    @DeleteMapping("/dept/{dno}")
    public List<Dept> deleteMember(@PathVariable int dno){
//        데이터 삭제 메소드 호출
        deptService.deleteMember(dno);
//        데이터 삭제가 잘 되었는지 조회
        return deptService.selectAll();
    }

    @PostMapping("/dept2/new")
    public List<Dept2> insertMember(@RequestBody Dept2 dept2){
        dept2Service.insertMember(dept2);
        return dept2Dao.selectAll();
    }

    @PutMapping("/dept2/{dno}")
    public List<Dept2> updateMember2(@PathVariable int dno, @RequestBody Dept2 dept2){
//        update 문이 실행
        dept2Service.updateMember(dno, dept2);
//        데이터 수정이 잘 되었는지 확인하는 쉨히를 리턴해줌
        return dept2Service.selectAll();
    }

    //    Delete sql문 실행
//    @DeleteMapping : 데이터 삭제에 해당하는 웹 브라우저 URL 어노테이션
    @DeleteMapping("/dept2/{dno}")
    public List<Dept2> deleteMember2(@PathVariable int dno){
//        데이터 삭제 메소드 호출
        dept2Service.deleteMember(dno);
//        데이터 삭제가 잘 되었는지 조회
        return dept2Service.selectAll();
    }

    @PostMapping("/dept3/new")
    public List<Dept3> insertMember(@RequestBody Dept3 dept3){
        dept3Service.insertMember(dept3);
        return dept3Dao.selectAll();
    }

    @GetMapping("/emp/all")
    public List<Emp> selectAll2(){
        List<Emp> list = empDao.selectAll();
        return list;
    }

    @PostMapping("/emp/new")
    public List<Emp> insertMember(@RequestBody Emp emp){
        empService.insertMember(emp);
        return null;
    }

    @GetMapping("/dept4/all")
    public List<Dept4> selectAll4(){
        List<Dept4> list = dept4Dao.selectAll();
        return list;
    }

    @PostMapping("/dept4/new")
    public List<Dept4> insertMember4(@RequestBody Dept4 dept4){
        dept4Service.insertMember(dept4);
        return dept4Dao.selectAll();
    }



    
//    @GetMapping : 아래 URL 메뉴를 Get 방식을 이용해서 만듦
//    URL Get 방식 : Select 쿼리에 해당하는 방법 ( 검색, 조회 )
    @GetMapping("/member/all")
    public List<Member> selectAll3(){
        List<Member> list = memberDao.selectAll();
        return list;
    }

//    @PostMapping : 아래 URL 메뉴를 Post 방식으로 Insert 실행
    @PostMapping("/member/new")
    public List<Member> insertMember2(@RequestBody Member member){
        memberService.insertMember(member);
        return memberService.selectAll();
    }

    @PutMapping("/member/{userId}")
    public List<Member> updateMember3(@PathVariable String userId, @RequestBody Member member){
//        update 문이 실행
        memberService.updateMember(userId, member);
//        데이터 수정이 잘 되었는지 확인하는 쉨히를 리턴해줌
        return memberService.selectAll();
    }

    //    Delete sql문 실행
//    @DeleteMapping : 데이터 삭제에 해당하는 웹 브라우저 URL 어노테이션
    @DeleteMapping("/member/{userId}")
    public List<Member> deleteMember3(@PathVariable String userId){
//        데이터 삭제 메소드 호출
        memberService.deleteMember(userId);
//        데이터 삭제가 잘 되었는지 조회
        return memberService.selectAll();
    }

    @GetMapping("/board/all")
    public List<Board> selectAll5(){
        List<Board> list = boardDao.selectAll();
        return list;
    }

    //    @PostMapping : 아래 URL 메뉴를 Post 방식으로 Insert 실행
    @PostMapping("/board/new")
    public List<Board> insertMember5(@RequestBody Board board){
        boardService.insertMember(board);
        return boardService.selectAll();
    }
}

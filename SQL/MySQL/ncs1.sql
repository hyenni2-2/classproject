-- 1. 대리키 IDX, 회원 아이디, 이름, 비밀번호, 사진이름, 가입일 을 저장할 수 있는 
--   이름이 MEMBER인 테이블을 생성하세요. 
--   회원 아이디에는 기본키 제약설정을 하고, 
--   이름과 비밀번호에는 not null, 
--   가입일은 기본 값으로 sysdate가 입력되도록 하시오.

create table `MEMBER` (
`IDX` int NOT NULL UNIQUE,
`ID` varchar(10) NOT NULL PRIMARY KEY,
`name` varchar(10) not null,
`pw` int not null,
`photoname` varchar(20) not null,
`joindate` datetime not null default current_timestamp
)
;

select * from member;

--   2. Member 테이블에서 이름 컬럼으로 인덱스 객체를 생성하시오.
create index idx_2 on member (name);

--   3. MEMBER 테이블에서 회원아이디, 이름, 사진 정보만을 출력하는 view 객체를 생성하시오.
--    view의 이름은 member_view 로 생성하시오.
create view member_view as select id,name,photoname from member;



-- 

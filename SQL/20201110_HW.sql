-- 전체 테이블 확인하기
select * 
from emp
;

--  덧셈연산자를 이용하여 모든 사원에 대해서 $300의 급여 인상을 계산한 후
-- 사원의 이름, 급여, 인상된 급여를 출력하시오.

select ename, sal, (sal+300) as upsal
from emp
;

-- 사원의 이름, 급여, 연간 총 수입을 총 수입이 많은 것부터 작은 순으로 출력
-- 연간 총수입은 월급에 12를 곱한 후 $100의 상여금을 더해서 계산하시오.

select ename, sal, (sal*12)+100 as "annual" 
from emp
order by (sal*12) desc
;

-- 급여가 2000을 넘는 사원의 이름과 급여를 표현, 
-- 급여가 많은 것부터 작은 순으로 출력하시오.

select ename, sal
from emp
where sal>2000
order by sal desc
;

-- 사원번호가 7788인 사원의 이름과 부서번호를 출력하시오.
select ename, deptno
from emp
where empno=7788
;

-- 급여가 2000에서 3000 사이에 포함되지 않는 사원의 이름과 급여를 출력하시오.
select ename, sal 
from emp
where not sal between 2000 and 3000
;

--1981년 2월 20일 부터 1981년 5월 1일 사이에 입사한 
-- 사원의 이름, 담당업무, 입사일을 출력하시오.
select ename, job, hiredate
from emp
where hiredate between '1981/2/20' and '1981/5/1'
;

-- 부서번호가 20 및 30에 속한 사원의 이름과 부서번호를 출력, 
-- 이름을 기준(내림차순)으로 영문자순으로 출력하시오.
select ename, deptno 
from emp
where deptno=20 or deptno=30
order by ename desc
;

-- 사원의 급여가 2000에서 3000사이에 포함되고 
-- 부서번호가 20 또는 30인 사원의 이름, 급여와 부서번호를 출력, 
-- 이름순(오름차순)으로 출력하시오.
select ename, deptno, sal 
from emp
where (sal between 2000 and 3000) and (deptno=20 or deptno=30)
order by ename
;

-- 1981년도에 입사한 사원의 이름과 입사일을 출력하시오. 
-- (like 연산자와 와일드카드 사용)
select ename, hiredate
from emp
where hiredate like '81%' 
;

-- 관리자가 없는 사원의 이름과 담당 업무를 출력하시오.
select ename, job
from emp
where mgr is null
;

-- 커미션을 받을 수 있는 자격이 되는 사원의 이름, 급여, 커미션을 출력하되 
-- 급여 및 커미션을 기준으로 내림차순 정렬하여 표시하시오.
select ename, sal, comm
from emp
where comm is not null 
order by sal, comm desc
;

-- 이름의 세번째 문자가 R인 사원의 이름을 표시하시오.
select ename
from emp
where ename like '__R%'
;

-- 이름에 A와 E를 모두 포함하고 있는 사원의 이름을 표시하시오.
select ename
from emp
where ename like '%A%E%'
;

​-- 담당업무가 CLERK, 또는 SALESMAN이면서 
-- 급여가 $1600, $950 또는 $1300이 아닌 
-- 사원의 이름, 담당업무, 급여를 출력하시오.
select ename, job, sal
from emp
where (job='CLERK' or job='SALESMAN') and (sal not IN(1600,950,1300))
;

-- 커미션이 $500 이상인 사원의 이름과 급여 및 커미션을 출력하시오.
select ename, sal, comm 
from emp
where comm >=500
;


-- select 추가 문제
-- 북테이블 출력
select *
from book
;

-- 주문 테이블 출력
select *
from orders
;

-- 고객 테이블 출력
select *
from customer
;

-- 도서번호가1인도서의이름
select bookid, bookname
from book
where bookid=1
;

-- 가격이20,000원이상인도서의이름
select bookname
from book
where price>=20000
;


-- 박지성의총구매액(박지성의고객번호는1번으로놓고작성)
select sum(saleprice) as "총구매액"
from orders
where custid=1
;

-- 박지성이구매한도서의수(박지성의고객번호는1번으로놓고작성)
select count(custid) as "구매한 도서 수"
from orders
where custid=1
;

-- 마당서점도서의총개수
select count(bookid) as "도서의 총 개수"
from book
;

-- 마당서점에도서를출고하는출판사의총개수
select count(DISTINCT publisher) as "출판사의 총 개수"
from book
;

-- 모든고객의이름, 주소
select name, address
from customer
;

--  2014년7월4일~7월7일사이에
-- 주문받은도서의주문번호
select orderid
from orders
where orderdate between '2014/07/04' and '2014/07/07'
;

-- 2014년7월4일~7월7일사이에주문받은도서를제외한
-- 도서의주문번호
select orderid
from orders
where not orderdate between '2014/07/04' and '2014/07/07'
;

-- 성이‘김’씨인고객의이름과주소
select name, address
from customer
where name like '김%'
;

-- 성이‘김’씨이고이름이‘아’로끝나는고객의이름과주소
select name, address
from customer
where name like '김%아'
;

-- 전체 테이블 확인하기
select * 
from emp
;

-- SUBSTR 함수를 사용하여 사원들의 입사한 년도와 입사한 달만 출력하시오.
select substr(hiredate, 1,5) as "입사년월" 
from emp
;

-- SUBSTR 함수를 사용하여 4월에 입사한 사원을 출력하시오.
select ename,hiredate
from emp
where substr(hiredate, 5, 1)=4
;

-- MOD 함수를 사용하여 사원번호가 짝수인 사람만 출력하시오.
select ename, empno
from emp
where mod(empno,2)=0
;

-- 입사일을 년도는 2자리(YY), 월은 숫자(MM)로 표시하고 
-- 요일은 약어 (DY)로 지정하여 출력하시오.
select ename, to_char(hiredate,'YY/MM/DD DY') as "입사연월"
from emp
;

-- 올해 몇 칠이 지났는지 출력하시오. 
-- 현재날짜에서 올해 1월 1일을 뺀 결과를 출력하고 
-- TO_DATE 함수를 사용하여 데이터 형을 일치 시키시오.
select trunc(sysdate -to_date('200101', 'YY/MM/DD'))
from dual
;

-- 사원들의 상관 사번을 출력하되 
-- 상관이 없는 사원에 대해서는 
-- NULL 값 대신 0으로 출력하시오.
select ename, empno, nvl(mgr,0)
from emp
;
-- DECODE 함수로 직급에 따라 급여를 인상하도록 하시오. 
-- 직급이 ‘ANALIST”인 사원은 200, ‘SALESMAN’인 사원은 180, ‘MANAGER’인 사원은 150, ‘CLERK”인 사원은 100을 인상하시오.
select ename, job, 
      decode(job, 'ANALYST', sal+200,
                  'SALESMAN', sal+180,
                  'MANAGER', sal+150,
                  'CLERK', sal+100,
                  'PRESIDENT', 0) 
                  as upsal
from emp
;

-- 모든 사원의 급여 최고액, 최저액, 총액 및 평균 급여를 출력하시오. 
-- 평균에 대해서는 정수로 반올림하시오.
select max(sal) as "최고액", min(sal) as "최저액", sum(sal) as "합계", round(avg(sal)) as "평균"
from emp
;

-- 각 담당 업무 유형별로 급여 최고액, 최저액, 총액 및 평균 액을 출력하시오. 
-- 평균에 대해서는 정수로 반올림 하시오.
select job, max(sal) as "최고액", min(sal) as "최저액", sum(sal) as "합계", round(avg(sal)) as "평균"
from emp
group by job
;

-- COUNT(*) 함수를 이용하여 담당업무가 동일한 사원 수를 출력하시오.
select job, count(*)
from emp
group by job
;
​
-- 관리자 수를 출력하시오.
select job, count(*) as "관리자 수"
from emp
where job='MANAGER'
group by job
;

-- 급여 최고액, 급여 최저액의 차액을 출력하시오.
select max(sal)-min(sal)
from emp
;

-- 직급별 사원의 최저 급여를 출력하시오. 
-- 관리자를 알 수 없는 사원과 최저 급여가 2000 미만인 그룹은 제외시키고 
-- 결과를 급여에 대한 내림차순으로 정렬하여 출력하시오.
select job, min(sal) 
from emp
group by job,sal,mgr
having (min(sal)>=2000) and (mgr is not null)
order by sal desc
;

-- 각 부서에 대해 부서번호, 사원 수, 부서 내의 모든 사원의 평균 급여를 출력하시오. 
-- 평균 급여는 소수점 둘째 자리로 반올림 하시오.
select deptno, count(*) as "사원 수",round(avg(sal),2) as "평균 급여"
from emp
group by deptno
;
​
select *
from dept
;

select *
from emp
;

-- 각 부서에 대해 부서번호 이름, 지역 명, 사원 수, 부서내의 모든 사원의 평균 급여를 출력하시오. 
-- 평균 급여는 정수로 반올림 하시오. DECODE 사용.
select decode(deptno, 10, 'ACCOUNTING',
                      20, 'RESEARCH',
                      30, 'SALES',
                      40, 'OPERATIONS') as "부서명",
      decode(deptno, 10, 'NEW YORK',
                     20, 'DALLAS',
                     30, 'CHICAGO',
                     40, 'BOSTON') as "지역",
      count(*) as "부서 인원",
      round(avg(sal)) as "평균 급여"                  
from emp
group by deptno
;
​

​-- 업무를 표시한 다음 해당 업무에 대해 부서 번호별 급여 및 부서 10, 20, 30의 급여 총액을 각각 출력하시오. 
-- 별칭은 각 job, dno, 부서 10, 부서 20, 부서 30, 총액으로 지정하시오. 
-- ( hint. Decode, group by )
select job, deptno, 
       decode(deptno, 10, is not null,
                      20, null,
                      30, null)  as "부서10"     
from emp
order by deptno, sal
;
​

-- 32. EQUI 조인을 사용하여 
-- SCOTT 사원의 부서번호와 부서 이름을 출력하시오.
select * from dept;
select * from emp;

select e.deptno, d.dname
from emp e,dept d
where e.deptno=d.deptno and e.ename='SCOTT';

select *
from emp e join dept d
-- on e.deptno=d.deptno
using(deptno)
;

select * 
from emp natural join dept;

-- 33. INNER JOIN과 ON 연산자를 사용하여 
-- 사원 이름과 함께 그 사원이 소속된 부서이름과 지역 명을 출력하시오.
select e.ename, d.dname, d.loc 
from emp e inner join dept d
on e.deptno=d.deptno
;

-- 36. 조인과 WildCARD를 사용하여 
-- 이름에 ‘A’가 포함된 모든 사원의 이름과 부서명을 출력하시오.
select e.ename, d.dname
from emp e cross j

oin dept d 
where e.deptno=d.deptno and ename like '%A%';

-- 37. JOIN을 이용하여 
-- NEW YORK에 근무하는 
-- 모든 사원의 이름, 업무, 부서번호 및 부서명을 출력하시오.
select e.ename, e.job, d.deptno, d.dname
from emp e, dept d
where e.deptno=d.deptno and loc='NEW YORK';

-- 38. SELF JOIN을 사용하여 
-- 사원의 이름 및 사원번호, 관리자 이름을 출력하시오.
select * from emp;
select e.ename, e.empno, m.ename
from emp e, emp m
where e.mgr=m.empno;

-- 39. OUTER JOIN, SELF JOIN을 사용하여 
-- 관리자가 없는 사원을 포함하여 사원번호를 기준으로 
-- 내림차순 정렬하여 출력하시오.

select e.empno,e.ename,m.ename
from emp e, emp m
where e.mgr=m.empno(+)
order by e.empno desc;

select e.ename, e.empno, m.ename
from emp e left outer join emp m
on e.mgr=m.empno
order by e.empno desc;


-- 40. SELF JOIN을 사용하여 지정한 사원의 이름, 
-- 부서번호, 지정한 사원과 동일한 부서에서 근무하는 사원을 출력하시오. ( SCOTT )
select * from emp where ename='SCOTT';
select ename from emp where deptno=20;
select * from emp;

select s.ename
from emp e, emp s 
where e.deptno = s.deptno and e.ename='SCOTT' and s.ename!='SCOTT';

select s.ename
from emp e join emp s
on e.deptno=s.deptno and e.ename='SCOTT';

-- 41. SELF JOIN을 사용하여 
-- WARD 사원보다 늦게 입사한 
-- 사원의 이름과 입사일을 출력하시오.
select hiredate from emp where ename='WARD';
select ename,hiredate from emp order by hiredate;

select e.ename, e.hiredate
from emp e, emp h
where e.hiredate>h.hiredate and h.ename='WARD';


-- 42. SELF JOIN 을 사용하여 
-- 관리자보다 먼저 입사한 
-- 모든 사원의 이름 및 입사일을 
-- 관리자의 이름 및 입사일과 함께 출력하시오.
select ename, hiredate from emp;

select e.ename, e.hiredate, m.ename, m.hiredate
from emp e, emp m
where e.mgr=m.empno;

select e.ename, e.hiredate,m.ename,m.hiredate
from emp e, emp m
where e.hiredate<m.hiredate and e.mgr=m.empno;

-- 43. 사원 번호가 7788인 사원과 담당 업무가 같은 사원을 표시(사원 이름과 담당업무)하시오.
select ename, job from emp where empno=7788;

select ename,job
from emp 
where job = (select job from emp where empno=7788);

-- 44. 사원번호가 7499인 사원보다 급여가 많은 사원을 표시하시오. 
-- 사원이름과 담당 업무
select ename, job from emp where empno=7499;

select ename, job
from emp
where sal>(select sal from emp where empno=7499);

-- 45. 최소급여를 받는 사원의 이름, 담당업무 및 급여를 표시하시오. (그룹함수 사용)
select ename, job, sal
from emp
where sal=(select min(sal) from emp);

select ename, job, sal
from emp
where sal<=all(select sal from emp);



-- 46. 평균급여가 가장 적은 직급의 -> 조건이니까 where절??  -> having 절이었음...그룹의 결과를 제한.
-- 직급 이름과 직급의 평균을 구하시오.
select job, avg(sal) from emp group by job;   -- 직급별 평균

select job, avg(sal)
from emp
group by job 
having avg(sal)=(select min(avg(sal)) from emp group by job);


-- 47. 각 부서의 최소 급여를 받는  -> 조건 
-- 사원의 이름, 급여, 부서번호를 표시하시오.  - 서브쿼리 안에는 order by가 안온다!!!
select min(sal) from emp group by deptno order by deptno;

select ename, sal, deptno
from emp
where sal in(select min(sal) from emp group by deptno)
order by deptno
;

-- 48. 담당업무가 ANALYST 인 사원보다 급여가 적으면서 
-- 업무가 ANALYST가 아닌 사원들을 표시(사원번호, 이름, 담당 업무, 급여)하시오.
select empno,ename,job, sal
from emp
where sal < all (select sal from emp where job='ANALYST')
order by empno;

-- 49. 부하직원이 없는 사원의 이름을 표시하시오.
select mgr from emp;

select ename
from emp
where empno not in(select nvl(mgr,0) from emp);

-- 50. 부하직원이 있는 사원의 이름을 표시하시오.
select mgr from emp;

select ename
from emp
where empno in(select nvl(mgr,0) from emp);


-- 51. BLAKE와 동일한 부서에 속한 
-- 사원의 이름과 입사일을 표시하는 질의를 작성하시오. ( 단 BLAKE는 제외 )
select deptno from emp where ename='BLAKE';

select ename, hiredate
from emp
where deptno=all(select deptno from emp where ename='BLAKE') and ename<>'BLAKE';

-- 52. 급여가 평균 급여보다 많은 
-- 사원들의 사원 번호와 이름을 표시하되 
-- 결과를 급여에 대해서 오름차순으로 정렬하시오.
select empno, ename
from emp
where sal > (select avg(sal) from emp)
order by sal;


-- 53. 이름에 K가 포함된 사원과 
-- 같은 부서에서 일하는 사원의 
-- 사원 번호와 이름을 표시하시오.
select deptno from emp where ename like '%K%';

select empno, ename
from emp
where deptno=any(select deptno from emp where ename like '%K%');

-- 54. 부서위치가 DALLAS인 
-- 사원의 이름과 부서번호 및 담당업무를 표시하시오.
select deptno from dept where loc='DALLAS';

select ename, deptno, job
from emp
where deptno=all(select deptno from dept where loc='DALLAS');

-- 55. KING에게 보고하는 -> king이 매니저인 
-- 사원의 이름과 급여를 표시하시오.
select ename,sal from emp where mgr in(select empno from emp where ename='KING');

-- 56. RESEARCH 부서의 
-- 사원에 대한 부서번호, 사원이름 및 담당 업무를 표시하시오.
select deptno from dept where dname='RESEARCH';

select deptno, ename, job
from emp
where deptno=all(select deptno from dept where dname='RESEARCH');


-- 57. 평균 월급보다 많은 급여를 받고 
-- 이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 
-- 사원 번호, 이름, 급여를 표시하시오.
select empno from emp where ename in(select ename from emp where ename like '%M%');

select empno, ename, sal
from emp
where sal>(select avg(sal) from emp) and deptno in(select deptno from emp where ename like '%M%');
;

-- 58. 평균급여가 가장 적은 
-- 업무를 찾으시오.
select job,avg(sal) from emp group by job;

select job,avg(sal)
from emp 
group by job
having avg(sal)=(select min(avg(sal)) from emp group by job);


-- 59. 담당업무가 MANAGER 인 사원이 
-- 소속된 부서와 동일한 부서의 사원을 표시하시오.
select deptno from emp where job='MANAGER';

select ename 
from emp
where deptno in(select deptno from emp where job='MANAGER');

-- (5) 박지성이구매한도서의
-- 출판사수
select * from customer;
select * from orders;
select * from book;

select * from orders o, book b where o.bookid=b.bookid;
select * from customer c, orders o where c.custid=o.custid;

select orderid from orders where custid=1; -- 박지성이 구매한 주문번호

select count(publisher)
from orders o, book b
where o.bookid = b.bookid and o.custid=1;

select count(*)
from orders
where custid=1; -- 구매한 도서 수

-- (6) 박지성이구매한도서의
-- 이름, 가격, 정가와판매가격의차이
select bookname, price, (price-saleprice) as "pricegap"
from orders o, book b
where o.bookid=b.bookid and custid=1;

-- (7) 박지성이구매하지않은도서의이름
select bookname
from orders o, book b
where o.orderid=b.bookid  and custid not in(select custid from orders where custid=1);

-- (8) 주문하지않은고객의이름(부속질의사용)
select o.custid from orders o, customer c where o.custid = c.custid;
-- 주문한 고객 아이디
select custid from orders;

select name
from customer c
where custid not in(select o.custid from orders o, customer c where o.custid = c.custid)
;

-- (9) 주문금액의총액과
-- 주문의평균금액
select sum(saleprice) as "TOTAL", avg(saleprice)
from orders
;

-- (10) 고객의이름과
-- 고객별구매액
select * from customer;
select * from orders;
select * from book;

select distinct c.name, sum(saleprice)
from orders o, customer c
where o.custid = c.custid
group by c.name;

-- (11) 고객의이름과
-- 고객이구매한도서목록
-- 구매한 고객 이름
select c.name,b.bookname  
from orders o, customer c, book b
where o.custid = c.custid and o.bookid=b.bookid
order by name;

-- 구매한 도서 목록
select b.bookname
from orders o, book b
where o.bookid=b.bookid;

select * 
from orders o, book b
where o.bookid=b.bookid;

select * 
from orders o, customer c
where o.custid=c.custid;

-- (12) 도서의가격(Book 테이블)과
-- 판매가격(Orders 테이블)의차이가가장많은주문
select * from customer;
select * from orders;
select * from book;

select o.orderid, o.custid, b.bookid,
o.saleprice,o.orderdate,b.bookid,b.bookname,b.publisher,b.price 
from orders o, book b 
where o.bookid=b.bookid 
and (b.price-o.saleprice)=(select max(b.price-o.saleprice) from orders o, book b where o.bookid=b.bookid);

select * 
      from orders o, book b 
      where o.bookid=b.bookid 
      order by price-saleprice desc;

-- (13) 도서의판매액평균보다
-- 자신의구매액평균이더높은고객의이름
select * from orders;
select * from customer;

select avg(saleprice)  -- 도서 판매액 평균
from orders;

select custid,avg(saleprice) -- 자신의 구매액 평균
from orders
group by custid;

select c.name
from orders o, customer c
where o.custid=c.custid
group by c.name
having avg(saleprice)>(select avg(saleprice) from orders)
;


-- (1) 박지성이 구매한 도서의 출판사와 
-- 같은 출판사에서 도서를 구매한 고객의 이름
select * from book;
select * from customer;
select * from orders;

-- 박지성이 구매한 도서의 출판사
select c.name  
from book b, orders o, customer c
where b.bookid=o.bookid and 
o.custid=c.custid and 
b.publisher in
(
select b. publisher 
from book b, orders o 
where b.bookid=o.bookid and o.custid=1) and o.custid!=1
;


-- (2) 두 개 이상의 서로 다른 출판사에서 
-- 도서를 구매한 고객의 이름
select * from book;
select * from customer;
select * from orders;

-- 구매한 고객 이름과 출판사 이름
select c.name
from orders o, customer c,book b
where o.custid=c.custid and b.bookid=o.bookid 
group by c.name


having count(distinct b.publisher)>=2
;

select c.name, b.bookname, b.publisher
from orders o, customer c,book b
where o.custid=c.custid and b.bookid=o.bookid ;


select o.custid,b.publisher
from orders o, book b
where o.bookid=b.bookid
order by o.custid
;





















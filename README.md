# 수업 내용 요약
<p align="center">
  <img src="https://github.com/yelo-o/JavaAcademy/assets/64743180/88704eaa-77ae-4558-ac7f-a1d3aacebbd5">
</p>


# 리다이렉션
'java.sun.com' 을 주소창에 입력해도 다른 주소(https://www.oracle.com/technetwork/java/index.html)로 바뀜 ← 리다이렉션

# 컴파일이란? 
	java.exe
	javac.exe
	javadoc.exe
	등등..
	- 정의 : 소스코드를 기계어로 변환화는 과정
	- 단계
		1. 소스코드를 분석하여 문법적 오류가 없는지 검사하고, 중간 단계의 코드(객체 코드)를 생성
		2. 중간단계 코드를 기계어로 번역
	- Java에서의 프로세스
		소스코드를 java 파일로 작성하고 javac 컴파일러를 사용하여 class 파일로 컴파일되며, class 파일은 JVM(Java Virtual Machine)에서 실행
	
# 인코딩이란?
	문자나 기호들을 컴퓨터에서 사용되는 이진 데이터로 변환하는 방식
	
# 기호
	~ : 틸트
	^ : 캐럿
	\ : 백슬래쉬
	| : 파이프
	[] : 대괄호(스퀘어브래킷)
	
# 컴파일
컴파일 및 실행을 하려면 컴파일러(javac)가 있는 디렉토리까지 이동해야 한다. 
cd [컴파일러 디렉토리]
	
	- [cp]
	  --class-path <path>, -classpath <path>, -cp <path>
			Specify where to find user class files and annotation processors(클래스 파일과 주석 프로세서의 위치를 상세화)
	  
	- [-d]
	  -d <directory> Specify where to place generated class files(클래스 파일을 생성할 위치를 상세화.)
	
	- 일반 컴파일
		javac -d [컴파일러 위치] [자바 파일 위치\자바 파일]
		
	- 참조 컴파일
		javac -d [컴파일러 위치] -cp [참조 폴더] [자바 파일 위치\자바 파일]


	- 예시 (명령프롬프트로 bin 폴더에 접근 후 javac.exe로 컴파일)
		<일반 컴파일>
			javac -d D:\Overview\myJAVA D:\Overview\myJAVA\Product.java

		<클래스 참조 1>
			javac -d D:\Overview\myJAVA -cp D:\Overview\myJAVA D:\Overview\myJAVA\ProductRepository.java

		<클래스 참조 2 : Product로 시작하는 자바 파일 모두 컴파일>
			javac -d D:\Overview\myJAVA -cp D:\Overview\myJAVA D:\Overview\myJAVA\Product*.java

# 실행
	- 실행 방법
		java -cp [실행파일 위치] [실행파일]

	- 예시
		→ Product 실행
		java -cp D:\Overview\myJAVA Product 
		→ ProductRepository 실행
		java -cp D:\Overview\myJAVA ProductRepository 
	
	
# 순서 
	- 컴파일 → 실행

# NullPointerException
	- 컴파일은 되지만 실행 시에 오류가 남
	
# 오류 
	non-static variable pArr cannot be referenced from a static context
	→ 논스태틱 변수는 스태틱 변수를 참조할 수 없다.

	error: prodNo has private access in Product
			pArr[0].prodNo = "G0001";
	→ private 변수는 다른 클래스에서 참조할 수 없다.

`23.05.10(수)
# 데이터 베이스(오라클)
- 데이터베이스의 종류는 매우 많지만 데이터베이스를 조작하는 언어는 하나(SQL) Structured Query Language

- 일반적인 프로그래밍 언어 절차
	변수선언 → 조건문 → 변수값 대입 → 반복문에서 변수 사용

- SQL 절차
	
	
# 네트워크 프로그래밍이란?
	- ip
	- port
	- socket
	
	
# SQL 프로그래밍(SQL Develpoer 사용)

	--테이블 생성
	CREATE TABLE product(
	prod_no VARCHAR2(10) PRIMARY KEY,
	prod_name VARCHAR2(50),
	prod_price NUMBER(5)
	);

	--추가
	INSERT INTO product(prod_no, prod_name, prod_price) VALUES ('R0001', '냉장고', 10000);
	INSERT INTO product(prod_no, prod_name, prod_price) VALUES ('R0002', '김치냉장고', 15000);
	INSERT INTO product(prod_no, prod_name, prod_price) VALUES ('R0003', '와인냉장고', 10000);

	--전체검색
	SELECT * FROM product;

	--상품번호로 검색
	SELECT * FROM product WHERE prod_no='R0001';

	--상품이름값을 변경(상품번호가 R0003인 상품의 이름을 '소주냉장고'로 변경
	UPDATE product SET prod_name='소주냉장고' WHERE prod_no='R0003';

	-상품삭제 : 상품번호가 R0002인 상품을 삭제하시오
	DELETE product WHERE prod_no='R0002';
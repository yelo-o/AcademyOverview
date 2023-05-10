# 리다이렉션
'java.sun.com'

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
	- [cp]
	  --class-path <path>, -classpath <path>, -cp <path>
			Specify where to find user class files and annotation processors(클래스 파일과 주석 프로세서의 위치를 상세화)
	  
	- [-d]
	  -d <directory> Specify where to place generated class files(클래스 파일을 생성할 위치를 상세화.)
	
	- 일반 실행
		javac -d [컴파일러 위치] [자바 파일 위치\자바 파일]
		
	- 참조 실행
		javac -d [컴파일러 위치] -cp [참조 폴더] [자바 파일 위치\자바 파일]


	- 예시 (명령프롬프트로 bin 폴더에 접근 후 javac.exe로 컴파일)
		<일반 컴파일>
			javac -d D:\Overview\myJAVA D:\Overview\myJAVA\Product.java

		<클래스 참조 1>
			javac -d D:\Overview\myJAVA -cp D:\Overview\myJAVA D:\Overview\myJAVA\ProductRepository.java

		<클래스 참조 2 : Product로 시작하는 자바 파일 모두 컴파일>
			javac -d D:\Overview\myJAVA -cp D:\Overview\myJAVA D:\Overview\myJAVA\Product*.java

# 실행
	java -cp D:\Overview\myJAVA Product → Product 실행
	java -cp D:\Overview\myJAVA ProductRepository → ProductRepository 실행
	
	
# 순서 
	- 컴파일 → 실행

# NullPointerException
	- 컴파일은 되지만 실행 시에 오류가 남
	- 
	
# 오류 
	non-static variable pArr cannot be referenced from a static context
	논스태틱 변수는 스태틱 변수를 참조할 수 없다.

	error: prodNo has private access in Product
			pArr[0].prodNo = "G0001";
	private 변수는 다른 클래스에서 참조할 수 없다.



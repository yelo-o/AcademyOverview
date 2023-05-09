# 리다이렉션
'java.sun.com'

# 컴파일이란? 
	java.exe
	javac.exe
	javadoc.exe
	등등..
	
# 인코딩이란?
	utf-8
	
# 기호
	~ : 틸트
	^ : 캐럿
	\ : 백슬래쉬
	| : 파이프
	[] : 대괄호(스퀘어브래킷)
	
# 컴파일
	명령프롬프트로 bin 폴더에 접근 후 javac.exe로 컴파일
		javac -d D:\Overview\myJAVA D:\Overview\myJAVA\Product.java
	
	<클래스 참조>
		javac -d D:\Overview\myJAVA -cp D:\Overview\myJAVA D:\Overview\myJAVA\ProductRepository.java
	
	<Product로 시작하는 자바 파일 모두 컴파일>
		javac -d D:\Overview\myJAVA -cp D:\Overview\myJAVA D:\Overview\myJAVA\Product*.java

# 실행
	java -cp D:\Overview\myJAVA Product
	
	
	
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
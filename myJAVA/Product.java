public class Product{
    String prodNo; // 상품번호(멤버 변수)
    private String prodName; // 상품이름
    private int prodPrice; // 상품가격

    public static void main(String []args){
        System.out.println("김민규입니다");
        System.out.print("KOSTA\t263기\n");
        System.out.println("반갑습니다");

		// 객체지향 개념
        Product p = new Product(); // Product 타입의 변수 p(지역 변수) 선언
        p.prodNo = "C0001"; // p 변수가 참조하고 있는 prodNo에 "C0001" 대입
        p.prodName = "아메리카노";
        p.prodPrice = 1000;

        Product p1 = new Product(); // Product 타입의 객체를 만들어서 대입
        
        System.out.println(p.prodNo + "," + p.prodName + "," + p.prodPrice);
        System.out.println(p1.prodNo + "," + p1.prodName + "," + p1.prodPrice);
		
		// 변수 : 변할 수 있는 데이터가 저장 될 메모리
		// 배열 : 동일자료형의 데이터 묶음
		
		// Product[] pArr; 이렇게도 선언 가능
		Product []pArr; // 배열 선언
		pArr = new Product[5]; // 배열 생성

		pArr[0] = new Product();
		pArr[0].prodNo = "F0001";
		pArr[0].prodName = "스콘";
		pArr[0].prodPrice = 10;
		
		pArr[1] = p;
		pArr[2] = p1;
		
		// System.out.println(pArr[0].prodNo);
		// System.out.println(pArr[1].prodNo);
		// System.out.println(pArr[2].prodNo);
		
		// System.out.println(pArr[3].prodNo);
		// System.out.println(pArr[4].prodNo);
		
		for(int i=0; i<3; i++){
			System.out.println(pArr[i].prodNo);
		}
		
		System.out.println("------------------");
		
		/*
		// 향상된 for문 : 모든 인덱스를 반복해야 할 때 (NullPointerException 조심!)
		for(Product prod: pArr){ // 향상된 for문 : for(int i=0; i<5; i++){ 
								// 						Product prod = pArr[i];
			System.out.println(prod.prodNo);
		}
		*/
	}
}
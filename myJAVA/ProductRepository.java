

public class ProductRepository{

    // Product[] pArr;
	
    static Product[] pArr = new Product[5]; // Product 타입의 배열 선언
	static int totalCnt = 0;
	
	public static void insert(Product p){
		pArr[totalCnt] = p;
		
		totalCnt++;
	}
	
	public static Product selectByProdNo(String no){
		// 상품번호에 해당하는 상품을 저장소에서 찾아 상품을 반환한다.
		
		for(int i=0; i<totalCnt; i++){
			Product p = pArr[i];
			if(p.prodNo.equals(no)){ // ==는 기본자료형(숫자,문자,논리)값 비교시 사용
									 // .equals()는 문자열(String)값 비교시 사용
				return p;
			}
		}
		return null; // 상품을 찾지 못한 경우 null을 반환한다
	}
	
	public static Product[] selectAll(){
		Product[] all = new Product[totalCnt];
		for(int i=0; i<totalCnt; i++){
			all[i] = pArr[i];
		}
		return all; // return pArr; NullPointerException 
		// return pArr; ← NullPointerException 발생
	}
	
	
	public static void main(String []args){
		
		System.out.println(">>상품 추가<<");
		// insert(물품 번호 추가) 함수 호출
		Product pArg = new Product();
		pArg.prodNo = "G0001";
		insert(pArg);
		
		System.out.println(">>상품 추가<<");
		Product pArg1 = new Product();
		pArg1.prodNo = "G0002";
		insert(pArg1);
		
		System.out.println(">>상품 검색<<");
		// selectByProdNo(번호 조회) 함수 호출
		String noArg1 = "G0002";
		// Product result1 = selectByProdNo(noArg1); // # 방식1 (2줄)
		// System.out.println(result1 == null? "상품이 없습니다":"상품이 있습니다"); // 삼항연산자 
		System.out.println("검색한 상품: " + noArg1);
		System.out.println(selectByProdNo(noArg1) == null? "상품이 없습니다":"상품이 있습니다"); // 삼항연산자 # 방식2 (1줄)
		
		System.out.println(">>상품 검색<<");
		String noArg2 = "X";
		// selectByProdNo(noArg2);
		System.out.println("검색한 상품: " + noArg2);
		System.out.println(selectByProdNo(noArg2) == null? "상품이 없습니다":"상품이 있습니다"); // 삼항연산자 # 방식2 (1줄)
		
		// 방식1 : 가독성 향상, 방식2 : 퍼포먼스 향상(변수가 적기 때문에)
		
		// selectAll(모두 선택) 함수 호출
		System.out.println(">>전체 상품 검색<<");
		Product[] resultArr =  selectAll();
		for(int i=0; i<resultArr.length; i++){
			System.out.println("상품번호: " + resultArr[i].prodNo);
		}
	}

	/*
    
	public static void main(String []args){
        // pArr = new Product[5];
        // pArr[0] = new Product();
        // pArr[0].prodNo = "G0001";
	
        for(int i=0; i<5;i++){
            pArr[i] = new Product();
            pArr[i].prodNo = "G000" + (i+1);
        }

       for(int i=0;i<5;i++){
            System.out.println(pArr[i].prodNo);
       }
    }
	
	*/
}
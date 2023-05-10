public class ProductUser{
	static java.util.Scanner sc = new java.util.Scanner(System.in);

	public static void main(String []args){
		String opt;
		do{
			System.out.println("작업을 선택하세요");
			System.out.print("1:상품전체검색, 2:상품번호로검색, 3:상품추가, 9:종료");
			opt = sc.nextLine(); // 키보드로 입력받기
			if(opt.equals("1")){
				System.out.println(">>전체 상품 리스트<<");
				Product[] resultArr =  ProductRepository.selectAll();
				for(int i=0; i<resultArr.length; i++){
					System.out.println("상품번호: " + resultArr[i].prodNo);
				}


			}else if(opt.equals("2")){
				System.out.println(">>상품 검색<<");
				System.out.println("상품번호를 입력하세요: ");
				String noArg1 = sc.nextLine(); // 키보드로 입력받기
				
				System.out.println("검색한 상품: " + noArg1);
				System.out.println(ProductRepository.selectByProdNo(noArg1) == null? "상품이 없습니다":"상품이 있습니다"); // 삼항연산자 # 방식2 (1줄)




			}else if(opt.equals("3")){
				System.out.println(">>상품 추가<<");
				System.out.print("상품번호를 입력하세요: ");
				Product pArg = new Product();
				// pArg.prodNo = "G0001";
				pArg.prodNo = sc.nextLine(); // 키보드로 입력받기
				ProductRepository.insert(pArg); // insert는 ProductRepository 클래스가 갖고 있는 메서드 이므로


			}else if(opt.equals("9")){
			}else{
				System.out.println("잘못입력하셨습니다");
			}
		}while(!opt.equals("9"));





/*		
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
*/

	}
}
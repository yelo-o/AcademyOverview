// 1. D:\Overview\myJAVA 폴더에 ProductRepository.java를 작성하시오
// 2. ProductRepository 클래스에
//    Product 타입의 5개 배열 저장소 형태의 멤버 변수를 만드시오
//    멤버변수 이름은 pArr입니다

// 3. ProductRepository클래스를 실행하면
//    pArr[0]에는 상품번호 "G0001"
//    pArr[1]에는 상품번호 "G0002"
//    pArr[2]에는 상품번호 "G0003"
//    pArr[3]에는 상품번호 "G0004"
//    pArr[4]에는 상품번호 "G0005"
//    가 저장되도록 합니다

// 3-2)
//   모든상품(pArr)의 상품번호(prodNo)를 출력하시오


public class ProductRepository{

    static Product[] pArr = new Product[5]; // Product 타입의 배열 선언
    // Product[] pArr;

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
}
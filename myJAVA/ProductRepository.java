// 1. D:\Overview\myJAVA ������ ProductRepository.java�� �ۼ��Ͻÿ�
// 2. ProductRepository Ŭ������
//    Product Ÿ���� 5�� �迭 ����� ������ ��� ������ ����ÿ�
//    ������� �̸��� pArr�Դϴ�

// 3. ProductRepositoryŬ������ �����ϸ�
//    pArr[0]���� ��ǰ��ȣ "G0001"
//    pArr[1]���� ��ǰ��ȣ "G0002"
//    pArr[2]���� ��ǰ��ȣ "G0003"
//    pArr[3]���� ��ǰ��ȣ "G0004"
//    pArr[4]���� ��ǰ��ȣ "G0005"
//    �� ����ǵ��� �մϴ�

// 3-2)
//   ����ǰ(pArr)�� ��ǰ��ȣ(prodNo)�� ����Ͻÿ�


public class ProductRepository{

    static Product[] pArr = new Product[5]; // Product Ÿ���� �迭 ����
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
public class Product{
    String prodNo; // ��ǰ��ȣ(��� ����)
    private String prodName; // ��ǰ�̸�
    private int prodPrice; // ��ǰ����

    public static void main(String []args){
        System.out.println("��α��Դϴ�");
        System.out.print("KOSTA\t263��\n");
        System.out.println("�ݰ����ϴ�");

		// ��ü���� ����
        Product p = new Product(); // Product Ÿ���� ���� p(���� ����) ����
        p.prodNo = "C0001"; // p ������ �����ϰ� �ִ� prodNo�� "C0001" ����
        p.prodName = "�Ƹ޸�ī��";
        p.prodPrice = 1000;

        Product p1 = new Product(); // Product Ÿ���� ��ü�� ���� ����
        
        System.out.println(p.prodNo + "," + p.prodName + "," + p.prodPrice);
        System.out.println(p1.prodNo + "," + p1.prodName + "," + p1.prodPrice);
		
		// ���� : ���� �� �ִ� �����Ͱ� ���� �� �޸�
		// �迭 : �����ڷ����� ������ ����
		
		// Product[] pArr; �̷��Ե� ���� ����
		Product []pArr; // �迭 ����
		pArr = new Product[5]; // �迭 ����

		pArr[0] = new Product();
		pArr[0].prodNo = "F0001";
		pArr[0].prodName = "����";
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
		// ���� for�� : ��� �ε����� �ݺ��ؾ� �� �� (NullPointerException ����!)
		for(Product prod: pArr){ // ���� for�� : for(int i=0; i<5; i++){ 
								// 						Product prod = pArr[i];
			System.out.println(prod.prodNo);
		}
		*/
	}
}
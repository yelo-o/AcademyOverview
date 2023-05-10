

public class ProductRepository{

    // Product[] pArr;
	
    static Product[] pArr = new Product[5]; // Product Ÿ���� �迭 ����
	static int totalCnt = 0;
	
	public static void insert(Product p){
		pArr[totalCnt] = p;
		
		totalCnt++;
	}
	
	public static Product selectByProdNo(String no){
		// ��ǰ��ȣ�� �ش��ϴ� ��ǰ�� ����ҿ��� ã�� ��ǰ�� ��ȯ�Ѵ�.
		
		for(int i=0; i<totalCnt; i++){
			Product p = pArr[i];
			if(p.prodNo.equals(no)){ // ==�� �⺻�ڷ���(����,����,��)�� �񱳽� ���
									 // .equals()�� ���ڿ�(String)�� �񱳽� ���
				return p;
			}
		}
		return null; // ��ǰ�� ã�� ���� ��� null�� ��ȯ�Ѵ�
	}
	
	public static Product[] selectAll(){
		Product[] all = new Product[totalCnt];
		for(int i=0; i<totalCnt; i++){
			all[i] = pArr[i];
		}
		return all; // return pArr; NullPointerException 
		// return pArr; �� NullPointerException �߻�
	}
	
	
	public static void main(String []args){
		
		System.out.println(">>��ǰ �߰�<<");
		// insert(��ǰ ��ȣ �߰�) �Լ� ȣ��
		Product pArg = new Product();
		pArg.prodNo = "G0001";
		insert(pArg);
		
		System.out.println(">>��ǰ �߰�<<");
		Product pArg1 = new Product();
		pArg1.prodNo = "G0002";
		insert(pArg1);
		
		System.out.println(">>��ǰ �˻�<<");
		// selectByProdNo(��ȣ ��ȸ) �Լ� ȣ��
		String noArg1 = "G0002";
		// Product result1 = selectByProdNo(noArg1); // # ���1 (2��)
		// System.out.println(result1 == null? "��ǰ�� �����ϴ�":"��ǰ�� �ֽ��ϴ�"); // ���׿����� 
		System.out.println("�˻��� ��ǰ: " + noArg1);
		System.out.println(selectByProdNo(noArg1) == null? "��ǰ�� �����ϴ�":"��ǰ�� �ֽ��ϴ�"); // ���׿����� # ���2 (1��)
		
		System.out.println(">>��ǰ �˻�<<");
		String noArg2 = "X";
		// selectByProdNo(noArg2);
		System.out.println("�˻��� ��ǰ: " + noArg2);
		System.out.println(selectByProdNo(noArg2) == null? "��ǰ�� �����ϴ�":"��ǰ�� �ֽ��ϴ�"); // ���׿����� # ���2 (1��)
		
		// ���1 : ������ ���, ���2 : �����ս� ���(������ ���� ������)
		
		// selectAll(��� ����) �Լ� ȣ��
		System.out.println(">>��ü ��ǰ �˻�<<");
		Product[] resultArr =  selectAll();
		for(int i=0; i<resultArr.length; i++){
			System.out.println("��ǰ��ȣ: " + resultArr[i].prodNo);
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
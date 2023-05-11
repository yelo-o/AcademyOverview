public class ProductRepository{

	public static void insert(Product p){
		// INSERT INTO product(prod_no, prod_name, prod_price) VALUES ('R0001', '�����', 10000);		
		// 1. JDBC ����̹� �ε�
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e){
			System.out.println("JDBC����̹��� �����ϴ�");
			return;
		}
		// 2. DB ����
		java.sql.Connection conn = null; // ���ᰪ ���� ���� ����
		try{
			String url = "jdbc:oracle:thin:@192.168.0.116:1521:xe"; // ������ DB ip, port, sid����
			String user= "kosta83"; // ������ ����
			String password = "kosta83"; // ���
			conn = java.sql.DriverManager.getConnection(url, user, password); // ������ ������ ������ ����
		}catch(Exception e){
			System.out.println("DB���� ������ ���еǾ����ϴ�");
			return;
		}
		// 3. SQL���� ����
		String insertSQL = "INSERT INTO product(prod_no, prod_name, prod_price) VALUES ('"+ p.prodNo +"', '�����', 10000)";
		java.sql.Statement stmt = null;
		try{
			stmt = conn.createStatement();
			// 4. ���۰�� ���ſ� ���� cnt
			int cnt = stmt.executeUpdate(insertSQL);
			// 5. ���ų��� Ȱ��
			System.out.println("�߰��Ǽ� " + cnt);
		}catch(Exception e){
			System.out.println("�߰� �����Ͽ����ϴ�");
			return;
		}
			

		// 6. DB���� �ݱ� -> close() �κ��� ������ �߻��ص� �����ڰ� ��¼�� �� ���� ��찡 ���� ������ ��¾��� ����
		try{
			stmt.close();
		}catch(Exception e){ // close() �κ��� ������ �߻��ص� �����ڰ� ��¼�� �� ���� ��찡 ���� ������ ��¾��� ����
		}
		try{
			conn.close();
		}catch(Exception e){
		}
	}
	
	public static Product selectByProdNo(String no){
		// ��ǰ��ȣ�� �ش��ϴ� ��ǰ�� ����ҿ��� ã�� ��ǰ�� ��ȯ�Ѵ�


		// SELECT * FROM product WHERE prod_no='R0001';

		// 1. JDBC ����̹� �ε�
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e){
			System.out.println("JDBC����̹��� �����ϴ�");
			return null;
		}
		// 2. DB ����
		java.sql.Connection conn = null; // ���ᰪ ���� ���� ����
		try{
			String url = "jdbc:oracle:thin:@192.168.0.116:1521:xe"; // ������ DB ip, port, sid����
			String user= "kosta83"; // ������ ����
			String password = "kosta83"; // ���
			conn = java.sql.DriverManager.getConnection(url, user, password); // ������ ������ ������ ����
		}catch(Exception e){
			System.out.println("DB���� ������ ���еǾ����ϴ�");
			return null;
		}
		// 3. SQL���� ����
		java.sql.Statement stmt = null;
		java.sql.ResultSet rs = null;
		try{
			stmt = conn.createStatement();
			String selectByNoSQL = "SELECT * FROM product WHERE prod_no='"+ no +"'";
			// 4. ���۰�� ���ſ� ���� rs
			rs = stmt.executeQuery(selectByNoSQL);
			// rs.next(); // ����� ���� �̵��Ѵ�. �̵��� ���� ���� ������ true ��ȯ�ϰ�, �̵��� ���� ���� ������ false�� ��ȯ
			boolean result = rs.next();
			// 5. ���ų��� Ȱ��
			if(result == true){
				String prodNo = rs.getString("prod_no");
				String prodName = rs.getString("prod_name");
				int prodPrice = rs.getInt("prod_price");
				Product p = new Product();
				p.prodNo = prodNo;
				// p.prodName = prodName; // Product Ŭ������ private�� ����Ǿ� ����
				// p.prodPrice = prodPrice;
				return p;
			}else{
				return null;
			}
		}catch(Exception e){
			System.out.println("�˻� �����߽��ϴ�");
			return null;
		}finally{
			// 6. DB���� �ݱ� -> close() �κ��� ������ �߻��ص� �����ڰ� ��¼�� �� ���� ��찡 ���� ������ ��¾��� ����
			try{
				stmt.close();
			}catch(Exception e){ // 
			}
			try{
				conn.close();
			}catch(Exception e){
			}
			}
	}
		
	public static Product[] selectAll(){
		// 1. JDBC ����̹� �ε�
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e){
			System.out.println("JDBC����̹��� �����ϴ�");
			return null;
		}
		// 2. DB ����
		java.sql.Connection conn = null; // ���ᰪ ���� ���� ����
		try{
			String url = "jdbc:oracle:thin:@192.168.0.116:1521:xe"; // ������ DB ip, port, sid����
			String user= "kosta83"; // ������ ����
			String password = "kosta83"; // ���
			conn = java.sql.DriverManager.getConnection(url, user, password); // ������ ������ ������ ����
		}catch(Exception e){
			System.out.println("DB���� ������ ���еǾ����ϴ�");
			return null;
		}
		// 3. SQL���� ����
		java.sql.Statement stmt = null;
		java.sql.ResultSet rs = null;
		Product[] pArr; // Product Ÿ���� �迭 ����

		try{
			// Row �� ���� Ȯ��
			String selectCountSQL = "SELECT count(*) FROM product"; // "row �� Ȯ��" SQL�� ������ ����
			stmt = conn.createStatement(); // 1�� ����
			rs = stmt.executeQuery(selectCountSQL); // 1�� ResultSet
			rs.next();
			int totalCnt = rs.getInt("count(*)");
			pArr = new Product[totalCnt]; // �迭 ����
			
			//��ǰ�� �ϳ��� ���� ���
			if(totalCnt == 0){
				return pArr;
			}
			
			// ��ǰ��
			String selectAllSQL = "SELECT * FROM product"; // "��ü �˻�" SQL�� ������ ����
			stmt = conn.createStatement(); // 2�� ����
			rs = stmt.executeQuery(selectAllSQL); // 2�� ResultSet
			int i = 0;
			while(rs.next()==true){
				String prodNo = rs.getString("prod_no");
				String prodName = rs.getString("prod_name");
				int prodPrice = rs.getInt("prod_price");
				Product p = new Product();
				p.prodNo = prodNo;
				pArr[i] = p;
				i++;
			}
			return pArr;
		}catch(Exception e){
			System.out.println("��ǰ��ü�˻� ����");
			return null;
		}finally{
			// 6. DB���� �ݱ� -> close() �κ��� ������ �߻��ص� �����ڰ� ��¼�� �� ���� ��찡 ���� ������ ��¾��� ����
			try{
				stmt.close();
			}catch(Exception e){ // 
			}
			try{
				conn.close();
			}catch(Exception e){
			}
			}
			
		}
	public static void main(String []args){
		
	
	}
}

public class ProductRepository{

	public static void insert(Product p){
		// INSERT INTO product(prod_no, prod_name, prod_price) VALUES ('R0001', '냉장고', 10000);		
		// 1. JDBC 드라이버 로드
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e){
			System.out.println("JDBC드라이버가 없습니다");
			return;
		}
		// 2. DB 연결
		java.sql.Connection conn = null; // 연결값 담을 변수 선언
		try{
			String url = "jdbc:oracle:thin:@192.168.0.116:1521:xe"; // 접속할 DB ip, port, sid정보
			String user= "kosta83"; // 접속할 계정
			String password = "kosta83"; // 비번
			conn = java.sql.DriverManager.getConnection(url, user, password); // 위에서 선언한 변수에 담음
		}catch(Exception e){
			System.out.println("DB와의 연결이 실패되었습니다");
			return;
		}
		// 3. SQL구문 전송
		String insertSQL = "INSERT INTO product(prod_no, prod_name, prod_price) VALUES ('"+ p.prodNo +"', '냉장고', 10000)";
		java.sql.Statement stmt = null;
		try{
			stmt = conn.createStatement();
			// 4. 전송결과 수신용 변수 cnt
			int cnt = stmt.executeUpdate(insertSQL);
			// 5. 수신내용 활용
			System.out.println("추가건수 " + cnt);
		}catch(Exception e){
			System.out.println("추가 실패하였습니다");
			return;
		}
			

		// 6. DB연결 닫기 -> close() 부분은 오류가 발생해도 개발자가 어쩌할 수 없는 경우가 많기 때문에 출력없이 끝냄
		try{
			stmt.close();
		}catch(Exception e){ // close() 부분은 오류가 발생해도 개발자가 어쩌할 수 없는 경우가 많기 때문에 출력없이 끝냄
		}
		try{
			conn.close();
		}catch(Exception e){
		}
	}
	
	public static Product selectByProdNo(String no){
		// 상품번호에 해당하는 상품을 저장소에서 찾아 상품을 반환한다


		// SELECT * FROM product WHERE prod_no='R0001';

		// 1. JDBC 드라이버 로드
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e){
			System.out.println("JDBC드라이버가 없습니다");
			return null;
		}
		// 2. DB 연결
		java.sql.Connection conn = null; // 연결값 담을 변수 선언
		try{
			String url = "jdbc:oracle:thin:@192.168.0.116:1521:xe"; // 접속할 DB ip, port, sid정보
			String user= "kosta83"; // 접속할 계정
			String password = "kosta83"; // 비번
			conn = java.sql.DriverManager.getConnection(url, user, password); // 위에서 선언한 변수에 담음
		}catch(Exception e){
			System.out.println("DB와의 연결이 실패되었습니다");
			return null;
		}
		// 3. SQL구문 전송
		java.sql.Statement stmt = null;
		java.sql.ResultSet rs = null;
		try{
			stmt = conn.createStatement();
			String selectByNoSQL = "SELECT * FROM product WHERE prod_no='"+ no +"'";
			// 4. 전송결과 수신용 변수 rs
			rs = stmt.executeQuery(selectByNoSQL);
			// rs.next(); // 결과의 행을 이동한다. 이동된 곳에 행이 있으면 true 반환하고, 이동된 곳에 행이 없으면 false를 반환
			boolean result = rs.next();
			// 5. 수신내용 활용
			if(result == true){
				String prodNo = rs.getString("prod_no");
				String prodName = rs.getString("prod_name");
				int prodPrice = rs.getInt("prod_price");
				Product p = new Product();
				p.prodNo = prodNo;
				// p.prodName = prodName; // Product 클래스에 private로 선언되어 있음
				// p.prodPrice = prodPrice;
				return p;
			}else{
				return null;
			}
		}catch(Exception e){
			System.out.println("검색 실패했습니다");
			return null;
		}finally{
			// 6. DB연결 닫기 -> close() 부분은 오류가 발생해도 개발자가 어쩌할 수 없는 경우가 많기 때문에 출력없이 끝냄
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
		// 1. JDBC 드라이버 로드
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e){
			System.out.println("JDBC드라이버가 없습니다");
			return null;
		}
		// 2. DB 연결
		java.sql.Connection conn = null; // 연결값 담을 변수 선언
		try{
			String url = "jdbc:oracle:thin:@192.168.0.116:1521:xe"; // 접속할 DB ip, port, sid정보
			String user= "kosta83"; // 접속할 계정
			String password = "kosta83"; // 비번
			conn = java.sql.DriverManager.getConnection(url, user, password); // 위에서 선언한 변수에 담음
		}catch(Exception e){
			System.out.println("DB와의 연결이 실패되었습니다");
			return null;
		}
		// 3. SQL구문 전송
		java.sql.Statement stmt = null;
		java.sql.ResultSet rs = null;
		Product[] pArr; // Product 타입의 배열 선언

		try{
			// Row 수 먼저 확인
			String selectCountSQL = "SELECT count(*) FROM product"; // "row 수 확인" SQL문 변수에 저장
			stmt = conn.createStatement(); // 1차 선언
			rs = stmt.executeQuery(selectCountSQL); // 1차 ResultSet
			rs.next();
			int totalCnt = rs.getInt("count(*)");
			pArr = new Product[totalCnt]; // 배열 생성
			
			//상품이 하나도 없는 경우
			if(totalCnt == 0){
				return pArr;
			}
			
			// 상품들
			String selectAllSQL = "SELECT * FROM product"; // "전체 검색" SQL문 변수에 저장
			stmt = conn.createStatement(); // 2차 선언
			rs = stmt.executeQuery(selectAllSQL); // 2차 ResultSet
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
			System.out.println("상품전체검색 실패");
			return null;
		}finally{
			// 6. DB연결 닫기 -> close() 부분은 오류가 발생해도 개발자가 어쩌할 수 없는 경우가 많기 때문에 출력없이 끝냄
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

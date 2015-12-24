package Utilx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 鏁版嵁搴撳伐鍏风被
* @Title: DBUtil.java 
* @Package cn.com.shxt.utils 
* @Description: TODO
* @author 鐜嬪畻瓒�
* @date 2015-11-16 涓婂崍10:26:56 
* @version V1.0
 */
public class DBUtil {
	
		//杩炴帴鏁版嵁搴撶殑URL
		private String url="jdbc:mysql://localhost:3306/wygl";

		//鏁版嵁搴撳悕
		private String username="root";
		//鏁版嵁搴撳瘑鐮�
		private String password="";
		//Connection杩炴帴瀵硅薄
		private Connection connection=null;
		//Statement璇彞瀵硅薄
		private Statement statement=null;
		//ResultSet鏌ヨ缁撴灉闆嗗璞�
		private  ResultSet resultSet=null;
		/**
		 * 閫氳繃闈欐�浠ｇ爜鍧楁墽琛屽姞杞介┍鍔紝鏈唬鐮佸潡鍙墽琛屼竴娆�
		 */
		static {
			//绗竴姝ワ細鍔犺浇椹卞姩
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/**
		 * 鑾峰彇杩炴帴鐨勬柟娉�涓撻棬璐熻矗鑾峰彇鏁版嵁搴撶殑杩炴帴瀵硅薄Connection
		 * @return
		 */
		public  Connection getConnection(){
			try {
				connection = DriverManager.getConnection(url, username, password);
				//System.out.println("connection="+connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("鑾峰彇杩炴帴寮傚父!");
				e.printStackTrace();
			}
			return connection;
		}
		
		/**
		 * 鍒涘缓statement瀵硅薄鐨勬柟娉�
		 * @return
		 */
		public  Statement getStatement(){
			try {
				//濡傛灉connection涓簄ull,鍒欒皟鐢╣etConnection()鏂规硶鍒涘缓connect瀵硅薄
				if(connection==null ){
					getConnection();
				}
				statement= connection.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return statement;
			
		}
		
		/**
		 * 鎵цupdate锛坕nsert銆乽pdate銆乨elete锛夌殑宸ュ叿鏂规硶
		 * @param sql
		 * @return
		 */
		public  int  update(String sql){
			int res =0;
			try {
				if(statement==null){
					getStatement();
				}
			   res =statement.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				close();
			}
			return res;
		}
		
		/**
		 * Sql鐨勬壒閲忔洿鏂�
		 * @param sqls
		 * @return
		 */
		public  int[]  upadateBatch(String sqls[] ){
			 if(statement==null){
				 getStatement();
			 }
			try {
				//灏唖ql璇彞鍔犲叆鍒癇atch瀹瑰櫒
				for(String sql : sqls){
					statement.addBatch(sql);
				}
				int[]   rowsAffects=statement.executeBatch();
				return rowsAffects;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				 close();
			}
			return null;
		}
		
		
		/**
		 * Sql鐨勬壒閲忔洿鏂�澧炲姞浜嗕簨鐗╂帶鍒�
		 * @param sqls
		 * @return
		 */
		public  int[]   upadateBatch_tx(String sqls[]){
			Connection conn =null;
			try {
				conn =getConnection();
				Statement stmt =conn.createStatement();
				/**璁剧疆浜嬬墿鎵嬪姩鎻愪氦**/
				conn.setAutoCommit(false);
				//灏唖ql璇彞鍔犲叆鍒癇atch瀹瑰櫒
				for(String sql : sqls){
					statement.addBatch(sql);
				}
				//鎵ц鎵归噺sql
				int[]   rowsAffects=statement.executeBatch();
				return rowsAffects;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				try {
					/**濡傛灉鎵归噺鎵ц鐨剆ql鏈変竴鍙ュ嚭鐜颁簡寮傚父锛屽垯鍥炴粴璇ヤ簨鐗�*/
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}finally{
				try {
					/**鎻愪氦浜嬬墿**/
					conn.commit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.close();
			}
			return null;
		}
		/**
		 * 鏌ヨ鐨勬柟娉曪紝鐩存帴杩斿洖ResultSet
		 * @param sql
		 * @return
		 */
		public ResultSet  query(String sql){
			try {
				if(statement==null){
					getStatement();
				}
				resultSet=statement.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resultSet;
		}
		
		/**
		 * 鏌ヨ鐨勫伐鍏锋柟娉曪紝鏃犻渶鎵嬪姩閲婃斁璧勬簮
		 * @param sql
		 * @return  List<Map<String,String>> 
		 */
		public  List<Map<String,String>> queryByList(String sql){
			List<Map<String,String>>  resultList =new ArrayList<Map<String,String>>();
			if(statement==null){
				getStatement();
			}
			try {
				resultSet=statement.executeQuery(sql);
				ResultSetMetaData  resultSetMetadata= resultSet.getMetaData();
				int  columnCount = resultSetMetadata.getColumnCount();
				//鐢ㄤ簬瀛樺偍鏁版嵁搴撳瓧娈靛悕鐨勬暟缁�
				String columnNames[] = new String[columnCount];
				//System.out.println("columnCount="+columnCount);
				for(int i=0; i<columnNames.length;i++){
					String  columnName=resultSetMetadata.getColumnName(i+1);
					columnNames[i]=columnName;
				}
				while(resultSet.next()){
					//map灏佽浜嗕竴琛岃褰�
					Map<String,String>  map= new  HashMap<String,String>();
					for(int i=0;i<columnNames.length;i++){
						//鑾峰彇姣忎竴琛岃褰曠殑姣忎竴涓瓧娈电殑key 鍜�value 
						String columnName = columnNames[i];
						String columnVal = resultSet.getString(columnName);
						map.put(columnName, columnVal);
					}
					//閫氳繃List瀛樺叆澶氳璁板綍
					resultList.add(map);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.close();
			}
			return resultList;
		}
		
		/**
		 * 鍒嗛〉鏌ヨ鐨勫伐鍏风被
		 * @param nowpage  褰撳墠椤垫暟
		 * @param iRows   姣忛〉璁板綍鏁�
		 * @param baseSql 鍩虹sql(瀵硅sql缁撴灉闆嗘墽琛屽垎椤�
		 * @return  List<Map<String, String>>
		 */
		public  List<Map<String, String>>  queryByPage(int nowpage , int iRows, String baseSql){
			int startIndex = iRows*(nowpage-1);
			String sql = "  SELECT b.* FROM  ("+baseSql+") as b  LIMIT  "+startIndex+" ,  "+iRows;
			List<Map<String, String>>  resList= this.queryByList(sql);
			return resList;
		}
		 
		/**
		 * 閲婃斁璧勬簮鐨勫伐鍏锋柟娉�
		 */
		 public  void   close(){
			 if(resultSet!=null){
				 try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			 if(statement!=null ){
				 try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			 if(connection!=null){
				 try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		 }
		 
		 
		
}

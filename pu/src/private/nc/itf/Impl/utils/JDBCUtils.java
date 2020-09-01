package nc.itf.Impl.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtils {
    //�û���
    private static String user = getValue("jdbc.username");
    //����
    private static String password = getValue("jdbc.password");
    //jdbcUrl---->> jdbc:oracle:thin:@��ַ:�˿ں�:ʵ����
    private static String url = getValue("jdbc.url");
    //oracle����
    private static String jdbc_driver = getValue("jdbc.driver");
    // ��̬�����oracle���ݿ������
    static {
        try {
            Class.forName(jdbc_driver);
        } catch (ClassNotFoundException e) {
            // TODO handle exception
            throw new ExceptionInInitializerError(e);
        }
    }
    
    /**
     * ��ȡ�����ļ��е���Ϣ
     *
     * @param key
     * @return
     */
    private static String getValue(String key) {
        // ��Դ����
    	String path = "nc"+File.separator+"itf"+File.separator+"Impl"+File.separator+"utils"+File.separator+"Oraclejdbc";
        ResourceBundle bundle = ResourceBundle.getBundle(path);
        return bundle.getString(key);
    }

    /**
     * ��������
     * 
     * @return
     * @throws SQLException �׳��쳣����Ҫ���õĵط�����
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * �ر�����(�ͷ�����)
     * 
     * @param conn
     *            ����
     * @param st
     *            ����ִ�о�̬ SQL ��䲢�����������ɽ���Ķ���PreparedStatement
     *            �̳���Statement��PreparedStatement��Ԥ����ĸ��ӵ���
     * @param res
     *            �����
     */
    public static void free(Connection conn, Statement st, ResultSet res) {
        try {
            if (res != null) {
                res.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    st.close();
            } catch (Exception e) {
                if (conn != null)
                    try {
                        conn.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
            }
        }

    }
    
    public static void main(String[] args) {
		Connection conn = null;
	    PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//������Ҫ��ȡʵ��,Ȼ���ȡ����
			conn = JDBCUtils.getConnection();
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			JDBCUtils.free(conn, pstmt, rs);
		}

	}
}

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
    //用户名
    private static String user = getValue("jdbc.username");
    //密码
    private static String password = getValue("jdbc.password");
    //jdbcUrl---->> jdbc:oracle:thin:@地址:端口号:实例名
    private static String url = getValue("jdbc.url");
    //oracle驱动
    private static String jdbc_driver = getValue("jdbc.driver");
    // 静态块加载oracle数据库的驱动
    static {
        try {
            Class.forName(jdbc_driver);
        } catch (ClassNotFoundException e) {
            // TODO handle exception
            throw new ExceptionInInitializerError(e);
        }
    }
    
    /**
     * 读取属性文件中的信息
     *
     * @param key
     * @return
     */
    private static String getValue(String key) {
        // 资源包绑定
    	String path = "nc"+File.separator+"itf"+File.separator+"Impl"+File.separator+"utils"+File.separator+"Oraclejdbc";
        ResourceBundle bundle = ResourceBundle.getBundle(path);
        return bundle.getString(key);
    }

    /**
     * 创建连接
     * 
     * @return
     * @throws SQLException 抛出异常，给要调用的地方处理
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * 关闭连接(释放连接)
     * 
     * @param conn
     *            连接
     * @param st
     *            用于执行静态 SQL 语句并返回它所生成结果的对象（PreparedStatement
     *            继承了Statement，PreparedStatement是预编译的更加的灵活）
     * @param res
     *            结果集
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
			//首先需要获取实例,然后获取连接
			conn = JDBCUtils.getConnection();
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			JDBCUtils.free(conn, pstmt, rs);
		}

	}
}

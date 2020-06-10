package train.jdbc.connect;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @ClassName: JdbcConnect
 * @Author: Swy
 * @Date: 2020-06-08 13:47
 **/
public class JdbcConnect {
    private String confPath = "jdbcconf";
    private String driver = null;
    private String url = null;
    private String user =null;
    private String pwd = null;

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    /**
     * 连接数据库
     * @Author xlu
     * @Date 14:11 2020-06-08
     * @Param null
     * @return null
    */
    public JdbcConnect() throws ClassNotFoundException, SQLException {
        ResourceBundle resourceBundle =ResourceBundle.getBundle(confPath);
        driver = resourceBundle.getString("driver");
        url = resourceBundle.getString("url");
        user = resourceBundle.getString("user");
        pwd = resourceBundle.getString("password");

        Class.forName(driver);
        conn = DriverManager.getConnection(url, user, pwd);
    }

    /**
     * 关闭所有数据库连接的资源
     * @Author xlu
     * @Date 14:09 2020-06-08
     * @Param null
     * @return null
    */
    public void closeAll() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 执行查询操作，用于数据库查询，这里的查询跟更新都用到了预编译防止sql注入
     * @Author xlu
     * @Date 14:06 2020-06-08
     * @Param sql语句，参数数组
     * @return
    */
    public ResultSet executeQuery(String preparedSql, String[] param) throws ClassNotFoundException {
        try {
            pstmt = conn.prepareStatement(preparedSql);
            //如果有参数就进行配置参数
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setString(i + 1, param[i]);
                }
            }

            rs = pstmt.executeQuery();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 更新修改数据库
     * @Author xlu
     * @Date 14:07 2020-06-08
     * @Param sql语句，参数数组
     * @return 更新了几行
    */
    public int executeUpdate(String preparedSql, String[] param) throws SQLException {
        int num = 0;

            pstmt = conn.prepareStatement(preparedSql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setString(i + 1, param[i]);
                }
            }
            num = pstmt.executeUpdate();

        return num;
    }
}

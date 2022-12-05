package access;

import java.sql.*;
import java.util.Scanner;

public class Query {
    private final String name = "jeongjunho";
    private final String passwd = "Icjh8954!";
    private Connection con;
    private Statement stmt;

    public Query() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.con = DriverManager.getConnection(
                "jdbc:mysql://192.168.56.101:4567/marine_transport",
                name, passwd);
        this.stmt = con.createStatement();
    }

    public void find() {
        ResultSet rs;
        Scanner scanner = new Scanner(System.in);
        String tName;
        String columns;
        String condition;

        try {
            System.out.print("검색 테이블 >> ");
            tName = scanner.nextLine();
            System.out.print("검색 열 >> ");
            columns = scanner.nextLine();
            System.out.print("조건 >> ");
            condition = scanner.nextLine();

            System.out.println("Finding...");

            if (columns.isEmpty()) columns = "*";

            if (condition.isEmpty())
                rs=stmt.executeQuery("SELECT " + columns + " FROM " + tName);
            else
                rs=stmt.executeQuery("SELECT " + columns + " FROM " + tName + " WHERE " + condition);

            // 결과 출력
            switch (tName) {
                case "EMPLOYEE":
                    while (rs.next()) {
                        System.out.println(rs.getString(1)
                                + " " + rs.getString(2)
                                + " " + rs.getInt(3)
                                + " " + rs.getString(4)
                                + " " + rs.getString(5)
                                + " " + rs.getString(6));
                    }
                    break;
                case "CARRIER":
                    while (rs.next()) {
                        System.out.println(rs.getString(1)
                                + " " + rs.getString(2)
                                + " " + rs.getInt(3)
                                + " " + rs.getString(4)
                                + " " + rs.getString(5)
                                + " " + rs.getString(6)
                                + " " + rs.getString(7));
                    }
                    break;
                case "CARRIER1":
                case "COURSE_PORTS_OF_CALL":
                    while (rs.next()) {
                        System.out.println(rs.getInt(1)
                                + " " + rs.getString(2)
                                + " " + rs.getString(3));
                    }
                    break;
                case "VOYAGE":
                    while (rs.next()) {
                        System.out.println(rs.getString(1)
                                + " " + rs.getString(2)
                                + " " + rs.getString(3)
                                + " " + rs.getInt(4)
                                + " " + rs.getString(5)
                                + " " + rs.getString(6)
                                + " " + rs.getString(7)
                                + " " + rs.getString(8)
                                + " " + rs.getString(9));
                    }
                    break;
                case "COURSE":
                    while (rs.next()) {
                        System.out.println(rs.getInt(1)
                                + " " + rs.getString(2)
                                + " " + rs.getString(3)
                                + " " + rs.getString(4)
                                + " " + rs.getString(5));
                    }
                    break;
                case "VOYAGE_CONSIGNOR":
                    while (rs.next()) {
                        System.out.println(rs.getInt(1)
                                + " " + rs.getString(2)
                                + " " + rs.getString(3));
                    }
                    break;
                case "VOYAGE_PORTS_OF_CALL":
                    while (rs.next()) {
                        System.out.println(rs.getInt(1)
                                + " " + rs.getString(2)
                                + " " + rs.getString(3));
                    }
                    break;
            }
        } catch (Exception e) { System.out.println("Error..."); }
    }

    public void desc() {
        ResultSet rs;
        String tName;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("desc를 볼 테이블 명 >> ");
            tName = scanner.nextLine();
            rs = stmt.executeQuery("SELECT * FROM " + tName);

            ResultSetMetaData metaData = rs.getMetaData();
            System.out.println("Table description...");
            for (int i = 1; i < metaData.getColumnCount(); i++) {
                System.out.println(metaData.getColumnName(i)+"\t"+metaData.getColumnTypeName(i));
            }
        } catch (Exception e) { System.out.println("Error..."); }
    }

    public void insert() {
        String tName = null;
        String values = null;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("테이블 입력>> ");
            tName = scanner.nextLine();
            System.out.print("값 입력(쉼표로 구분)>> ");
            values = scanner.nextLine();

            String[] values_arr = values.split(",");
            String SQL;
            PreparedStatement pstmt = null;

            System.out.print("Inserting...");
            switch (tName) {
                case "EMPLOYEE":
                    SQL = "INSERT INTO " + tName + " VALUE(?,?,?,?,?,?)";

                    pstmt = con.prepareStatement(SQL);
                    pstmt.setString(1, values_arr[0]);
                    pstmt.setString(2, values_arr[1]);
                    pstmt.setInt(3, Integer.parseInt(values_arr[2]));
                    pstmt.setString(4, values_arr[3]);
                    pstmt.setString(5, values_arr[4]);
                    pstmt.setString(6, values_arr[5]);
                    break;
                case "CARRIER":
                    SQL = "INSERT INTO " + tName + " VALUE(?,?,?,?,?,?,?)";

                    pstmt = con.prepareStatement(SQL);
                    pstmt.setString(1, values_arr[0]);
                    pstmt.setString(2, values_arr[1]);
                    pstmt.setInt(3, Integer.parseInt(values_arr[2]));
                    pstmt.setString(4, values_arr[3]);
                    pstmt.setString(5, values_arr[4]);
                    pstmt.setString(6, values_arr[5]);
                    pstmt.setString(7, values_arr[6]);
                    break;
                case "CARRIER1":
                    SQL = "INSERT INTO " + tName + " VALUE(?,?,?)";

                    pstmt = con.prepareStatement(SQL);
                    pstmt.setString(1, values_arr[0]);
                    pstmt.setString(2, values_arr[1]);
                    pstmt.setString(3, values_arr[2]);
                    break;
                case "COURSE_PORTS_OF_CALL":
                    SQL = "INSERT INTO " + tName + " VALUE(?,?,?)";

                    pstmt = con.prepareStatement(SQL);
                    pstmt.setString(1, values_arr[0]);
                    pstmt.setString(2, values_arr[1]);
                    pstmt.setString(3, values_arr[2]);
                    break;
                case "VOYAGE":
                    SQL = "INSERT INTO " + tName + " VALUE(?,?,?,?,?,?,?,?,?)";

                    pstmt = con.prepareStatement(SQL);
                    pstmt.setString(1, values_arr[0]);
                    pstmt.setString(2, values_arr[1]);
                    pstmt.setString(3, values_arr[2]);
                    pstmt.setInt(4, Integer.parseInt(values_arr[3]));
                    pstmt.setString(5, values_arr[4]);
                    pstmt.setString(6, values_arr[5]);
                    pstmt.setInt(7, Integer.parseInt(values_arr[6]));
                    pstmt.setString(8, values_arr[7]);
                    pstmt.setString(9, values_arr[8]);
                    break;
                case "COURSE":
                    SQL = "INSERT INTO " + tName + " VALUE(?,?,?,?,?)";

                    pstmt = con.prepareStatement(SQL);
                    pstmt.setString(1, values_arr[0]);
                    pstmt.setString(2, values_arr[1]);
                    pstmt.setString(3, values_arr[2]);
                    pstmt.setString(4, values_arr[3]);
                    pstmt.setString(5, values_arr[4]);
                    break;
                case "VOYAGE_CONSIGNOR":
                    SQL = "INSERT INTO " + tName + " VALUE(?,?,?)";

                    pstmt = con.prepareStatement(SQL);
                    pstmt.setString(1, values_arr[0]);
                    pstmt.setString(2, values_arr[1]);
                    pstmt.setString(3, values_arr[2]);
                    break;
                case "VOYAGE_PORTS_OF_CALL":
                    SQL = "INSERT INTO " + tName + " VALUE(?,?,?)";

                    pstmt = con.prepareStatement(SQL);
                    pstmt.setString(1, values_arr[0]);
                    pstmt.setString(2, values_arr[1]);
                    pstmt.setString(3, values_arr[2]);
                    break;
            }
            pstmt.executeUpdate();

        } catch (Exception e) { System.out.println(e); }
    }

    public void delete() {

    }
}

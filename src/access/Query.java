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
            rs=stmt.executeQuery("SELECT * FROM Book");
        } catch (Exception e) { System.out.println("Error..."); }
    }

    public void desc() {
        try {
            ResultSet rs;
            Scanner scanner = new Scanner(System.in);
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

            System.out.print("Inserting...");
            stmt.execute("INSERT INTO " + tName + "VALUE(" + values + ")");
        } catch (Exception e) { System.out.println(e); }
    }

    public void delete() {

    }

    public void update() {

    }

    public void custom() {

    }

    public void join() {

    }
}

package educationalGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Anas {
    	
        public String afficheQuestion(int x){
        	int i = 0;
            int a[]= new int[30];
            String b[]= new String[30];
            String c[]= new String[30];
        	
        	try{
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");

                Statement stmt=con.createStatement();

                ResultSet rs=stmt.executeQuery("select * from questions");

                while(rs.next()) {

                    a[i]=rs.getInt(1);

                    b[i]=rs.getString(2);

                    c[i]=rs.getString(3);


                    i++;
                }
                con.close();

            }catch(Exception e){
                System.out.println(e);
            }
        	return c[x];
        }
        
        public String afficheReponse1(int x){
        	int i = 0;
            String d[]= new String[30];
        	
        	try{
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");

                Statement stmt=con.createStatement();

                ResultSet rs=stmt.executeQuery("select * from questions");

                while(rs.next()) {
                    d[i]=rs.getString(4);
                    i++;
                }
                con.close();

            }catch(Exception e){
                System.out.println(e);
            }
        	return d[x];
        }
        
        public String afficheReponse2(int x){
        	int i = 0;
            String f[]= new String[30];
        	
        	try{
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");

                Statement stmt=con.createStatement();

                ResultSet rs=stmt.executeQuery("select * from questions");

                while(rs.next()) {
                    f[i]=rs.getString(5);
                    i++;
                }
                con.close();

            }catch(Exception e){
                System.out.println(e);
            }
        	return f[x];
        }
        
       
        
        public String afficheReponse3(int x){
        	int i = 0;
            String f[]= new String[30];
        	
        	try{
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");

                Statement stmt=con.createStatement();

                ResultSet rs=stmt.executeQuery("select * from questions");

                while(rs.next()) {
                    f[i]=rs.getString(6);
                    i++;
                }
                con.close();

            }catch(Exception e){
                System.out.println(e);
            }
        	return f[x];
        }
        
        
      
        
        public String afficheReponse4(int x){
        	int i = 0;
            String f[]= new String[30];
        	
        	try{
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");

                Statement stmt=con.createStatement();

                ResultSet rs=stmt.executeQuery("select * from questions");

                while(rs.next()) {
                    f[i]=rs.getString(7);
                    i++;
                }
                con.close();

            }catch(Exception e){
                System.out.println(e);
            }
        	return f[x];
        }
        
        public Anas() {
        }

        
    }
package playerDetails;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PlayerInfo {
	void addPlayer()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Details:");
		System.out.println("Enter the Name");
		String name = s.nextLine();
		System.out.println("Enter the age");
		int age = s.nextInt();
		System.out.println("Description of Player");
		String desc = s.nextLine();
		 desc = s.nextLine();
		System.out.println("Enter the average of Player");
		double avg = s.nextDouble();
		System.out.println("Enter the best Score");
		int best = s.nextInt();
		System.out.println("Enter the name of the Team for the player");
		String team = s.nextLine();
		team = s.nextLine();
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","1234");
		String qr = "insert into PlayerData values(?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(qr);
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, desc);
		ps.setDouble(4, avg);
		ps.setInt(5, best);
		ps.setString(6, team);
		int i = ps.executeUpdate();
		System.out.println(i+" Record Added");
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void delete()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the name of the player you want to delete:");
		String name = s.nextLine();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","1234");
			String qr = "delete from PlayerData where playerName=?";
			PreparedStatement ps = con.prepareStatement(qr);
			ps.setString(1, name);
			int i = ps.executeUpdate();
			System.out.println(i+" Record Deleted");
			
			}
			catch (ClassNotFoundException  | SQLException e) {
				e.printStackTrace();
			}
	}
	
	void updatePlayer()
	{
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the name of player you want to Update:");
		String nameo=s.nextLine();
		System.out.println("Enter the Name");
		String name = s.nextLine();
		System.out.println("Enter the age");
		int age = s.nextInt();
		System.out.println("Description of Player");
		String desc = s.nextLine();
		 desc = s.nextLine();
		System.out.println("Enter the average of Player");
		double avg = s.nextDouble();
		System.out.println("Enter the best Score");
		int best = s.nextInt();
		System.out.println("Enter the name of the Team for the player");
		String team = s.nextLine();
		team = s.nextLine();
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","1234");
		String qr = "Update PlayerData set playerName=? , age=? , description=? , average=? , best=? , team=? where playerName='"+nameo+"'";
		PreparedStatement ps = con.prepareStatement(qr);
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, desc);
		ps.setDouble(4, avg);
		ps.setInt(5, best);
		ps.setString(6, team);
		int i = ps.executeUpdate();
		System.out.println(i+" Record updated");
		System.out.println("Updated Successfully");
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	void showAll()
	{
	
		System.out.println("List of all Players is: \n");
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","1234");
		String qr = "Select * from PlayerData";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(qr);
		if(rs.next())
		{
			do{
				System.out.println(rs.getString("playerName")+" "+rs.getInt("age")+" "+rs.getString("description")+" "+rs.getDouble("average")+" "+rs.getInt("best")+" "+rs.getString("team"));
			}while(rs.next());
		}
		else
		{
			System.out.println("Empty set");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	void searchByName()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the name of the player you want to Search:");
		String name = s.nextLine();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","1234");
			String qr = "Select * from PlayerData where playerName='"+name+"'";
			Statement st = con.createStatement();
		
			ResultSet rs = st.executeQuery(qr);
			if(rs.next()){
				do{
					System.out.println("name: "+rs.getString("playerName")+"\n"+rs.getInt("age")+"   "+rs.getString("description")+" "+rs.getDouble("average")+" "+rs.getInt("best")+" "+rs.getString("team") );
				}while(rs.next());
			}
			}
			catch (ClassNotFoundException  | SQLException e) {
				e.printStackTrace();
			}
	}
	
	void searchByTeam()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the team to see players:");
		String team = s.nextLine();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","1234");
			String qr = "Select * from PlayerData where team='"+team+"'";
			Statement st = con.createStatement();
		
			ResultSet rs = st.executeQuery(qr);
			if(rs.next()){
				do{
					System.out.println("name: "+rs.getString("playerName")+"\n");
				}while(rs.next());
			}
			}
			catch (ClassNotFoundException  | SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		
		PlayerInfo pf = new PlayerInfo();
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("->Select your choice:\n press respective key to the options you want:\n");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("->1 - Add a Player:\n");
		System.out.println("->2 - Delete a Player:\n");
		System.out.println("->3 - Update a Player:\n");
		System.out.println("->4 - List of all Players:\n");
		System.out.println("->5 - Search Player by Name:\n");
		System.out.println("->6 - List of Players from a Single(Each) Team :\n");
		System.out.println("----------------------------------------------------------------------------");
		int n;
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		
		switch(n){
		
		case 1: pf.addPlayer() ;
		break;
		
		case 2: pf.delete();
		break;
		
		case 3: pf.updatePlayer();
		break;
		
		case 4:pf.showAll();
		break;
		
		case 5:pf.searchByName();
		break;
		
		case 6:pf.searchByTeam();
		break;
		
		default: System.out.println("Please choose from Given Options");
		}
		
	}

}

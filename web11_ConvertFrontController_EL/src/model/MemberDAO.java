package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtil.DBUtil;
public class MemberDAO {
	private static MemberDAO dao=new MemberDAO();	
	
	private MemberDAO(){	}
	public static MemberDAO getInstance(){
		return dao;
	}	
	
	
	
	public void updateMember(MemberVO vo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con = DBUtil.getConnection();
			String sql="update member set password=?,name=?,address=? where id=?";
			pstmt=con.prepareStatement(sql);			
			pstmt.setString(1,vo.getPassword());
			pstmt.setString(2,vo.getName());
			pstmt.setString(3,vo.getAddress());
			pstmt.setString(4,vo.getId());
			int result=pstmt.executeUpdate();
			System.out.println("update ok.."+result);
		}finally{
			 DBUtil.close(pstmt);
	         DBUtil.close(con);
		}
	}
	public void registerMember(MemberVO vo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con = DBUtil.getConnection();
			String sql="insert into member values(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,vo.getId());
			pstmt.setString(2,vo.getPassword());
			pstmt.setString(3,vo.getName());
			pstmt.setString(4,vo.getAddress());
			int result=pstmt.executeUpdate();
			System.out.println("insert ok.."+result);
		}finally{
			DBUtil.close(pstmt);
	         DBUtil.close(con);
		}
	}
	public MemberVO findMemberById(String id) throws SQLException{
		MemberVO vo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con = DBUtil.getConnection();
			String sql="select password,name,address from member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				vo=new MemberVO(id,rs.getString(1),rs.getString(2),rs.getString(3));
			}
		}finally{
			DBUtil.close(rs);
            DBUtil.close(pstmt);
            DBUtil.close(con);
		}
		return vo;
	}
	public ArrayList<MemberVO> findByAddress(String address) throws SQLException{
		ArrayList<MemberVO> list=new ArrayList<MemberVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con = DBUtil.getConnection();
			String sql="select id,name from member where address=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,address);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(new MemberVO(rs.getString(1),null,
						rs.getString(2),address));
			}
		}finally{
			DBUtil.close(rs);
            DBUtil.close(pstmt);
            DBUtil.close(con);
		}
		return list;
	}
	public MemberVO login(String id,String password) throws SQLException{
		MemberVO vo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con = DBUtil.getConnection();
			String sql=
		   "select name,address from member where id=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,password);
			rs=pstmt.executeQuery();
			if(rs.next()){
				vo=new MemberVO(id,password,rs.getString(1),rs.getString(2));
			}
		}finally{
			DBUtil.close(rs);
            DBUtil.close(pstmt);
            DBUtil.close(con);
		}
		return vo;
	}
	public ArrayList<MemberVO> getAllMember() throws SQLException{
		ArrayList<MemberVO> list=new ArrayList<MemberVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con = DBUtil.getConnection();
			String sql="select * from member";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(new MemberVO(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4)));
			}
		}finally{
			DBUtil.close(rs);
            DBUtil.close(pstmt);
            DBUtil.close(con);
		}
		return list;
	}
	//true가 리턴되면...해당 id값이 이미 디비에 저장되어 있음을 의미
	//true일때는 id 중복..그 아이디를 사용할수 없도록 유도...checkId() 자바스크립트에서
	public boolean isExist(String id) throws SQLException{
		boolean result=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con = DBUtil.getConnection();
			String sql="select count(*) from member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()){				
				if(rs.getInt(1)>0)
					result=true;
			}
		}finally{
			DBUtil.close(rs);
            DBUtil.close(pstmt);
            DBUtil.close(con);
		}
		return result;
	}
}


















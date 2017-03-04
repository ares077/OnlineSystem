package dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import util.DBUtil;
import dao.InNoteDAO;
import entity.admin.Note;

@Repository
public class NoteDAO implements InNoteDAO{
	//==============================查询总共有所少条成绩记录=======================================================================
	public int countPageBySize(int pageSize) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		int total=-1;
		int pages=-1;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select count(*) from note where states=1");
			//获得总的记录数
			rSet=pStatement.executeQuery();
			if (rSet.next())total=rSet.getInt(1);
			//计算总共需要多少页
			int mod=total%pageSize;
			if (mod==0) {
				pages=total/pageSize;
			} else {
				pages=total/pageSize+1;
			}
			return pages;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(connection);
		}
	}
	public int countPageBySize(int pageSize,String studentid) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		int total=-1;
		int pages=-1;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select count(*) from note where states=1 and studentid=?");
			pStatement.setString(1, studentid);
			//获得总的记录数
			rSet=pStatement.executeQuery();
			if (rSet.next())total=rSet.getInt(1);
			//计算总共需要多少页
			int mod=total%pageSize;
			if (mod==0) {
				pages=total/pageSize;
			} else {
				pages=total/pageSize+1;
			}
			return pages;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(connection);
		}
	}
	//=============================分页查询所有成绩==================================================================================
	public List<Note> findByPage(int page,int pageSize)throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		List<Note> notes=new ArrayList<Note>();
		int totalP=-1;
		int pages=-1;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select count(*) from note where states=1");
			//获得总的记录数
			rSet=pStatement.executeQuery();
			if (rSet.next())totalP=rSet.getInt(1);
			//计算总共需要多少页
			int mod=totalP%pageSize;
			if (mod==0) {
				pages=totalP/pageSize;
			} else {
				pages=totalP/pageSize+1;
			}
			//如果要查看的页数大于最大页，或者小于1，则取最后一页或第一页
			if (page>pages) {
				page=pages;
			}else if (page<1) {
				page=1;
			}
			int start=(page-1)*pageSize;
			pStatement=connection.prepareStatement("select noteid,studentid,courseid,singlecho,multicho,total,adddate,nandu from note where states=1 order by noteid limit ?,?");
			pStatement.setInt(1, start);
			pStatement.setInt(2, pageSize);
			rSet=pStatement.executeQuery();
			while(rSet.next()){
				String noteid=rSet.getString(1);
				String studentid=rSet.getString(2);
				String courseid=rSet.getString(3);
				String singlecho=rSet.getString(4);
				String multicho=rSet.getString(5);
				String total=rSet.getString(6);
				String adddate=rSet.getString(7);
				String nandu=rSet.getString(8);
				notes.add(new Note(noteid, studentid, courseid, singlecho, multicho, total, adddate,nandu));
			}
			return notes;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(connection);
		}
	}
	public List<Note> findByPage(int page,int pageSize,String studentid2,String a)throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		List<Note> notes=new ArrayList<Note>();
		int totalP=-1;
		int pages=-1;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select count(*) from note where states=1 and studentid=?");
			pStatement.setString(1,studentid2);
			//获得总的记录数
			rSet=pStatement.executeQuery();
			if (rSet.next())totalP=rSet.getInt(1);
			//计算总共需要多少页
			int mod=totalP%pageSize;
			if (mod==0) {
				pages=totalP/pageSize;
			} else {
				pages=totalP/pageSize+1;
			}
			//如果要查看的页数大于最大页，或者小于1，则取最后一页或第一页
			if (page>pages) {
				page=pages;
			}else if (page<1) {
				page=1;
			}
			int start=(page-1)*pageSize;
			pStatement=connection.prepareStatement("select noteid,studentid,courseid,singlecho,multicho,total,adddate,nandu from note where states=1 and studentid=? order by noteid limit ?,?");
			pStatement.setString(1, studentid2);
			pStatement.setInt(2, start);
			pStatement.setInt(3, pageSize);
			rSet=pStatement.executeQuery();
			while(rSet.next()){
				String noteid=rSet.getString(1);
				String studentid=rSet.getString(2);
				String courseid=rSet.getString(3);
				String singlecho=rSet.getString(4);
				String multicho=rSet.getString(5);
				String total=rSet.getString(6);
				String adddate=rSet.getString(7);
				String nandu=rSet.getString(8);
				notes.add(new Note(noteid, studentid, courseid, singlecho, multicho, total, adddate,nandu));
			}
			return notes;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(connection);
		}
	}
	//=============================修改现有成绩==================================================================================
	public boolean modify(Note note) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("update note set singlecho=?,multicho=?,total=? where noteid=?");
			pStatement.setString(1, note.getSinglecho());
			pStatement.setString(2, note.getMulticho());
			pStatement.setString(3, note.getTotal());
			pStatement.setString(4, note.getNoteid());
			if (1==pStatement.executeUpdate()) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(connection);
		}
	}
	//============================= 根据ID返回成绩信息==================================================================================
	public Note findByKey(String id) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		Note note=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select noteid,studentid,courseid,singlecho,multicho,total,adddate,nandu from note where states=1 and noteid=?");
			pStatement.setString(1, id);
			rSet=pStatement.executeQuery();
			if (rSet.next()){
				String noteid=rSet.getString(1);
				String studentid=rSet.getString(2);
				String courseid=rSet.getString(3);
				String singlecho=rSet.getString(4);
				String multicho=rSet.getString(5);
				String total=rSet.getString(6);
				String adddate=rSet.getString(7);
				String nandu=rSet.getString(8);
				note =new Note(noteid, studentid, courseid, singlecho, multicho, total, adddate,nandu);
			}
			return note;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(connection);
		}
	}
//	public static void main(String[] args) {
//		try {
//			NoteDAO dao=new NoteDAO();
//			List<Note> notes=dao.findAllByPage(1, 7);
//			for (Note note : notes) {
//				System.out.println(note);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	public boolean add(Note t) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean checkKey(String key) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean delete(String key) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	public List<Note> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

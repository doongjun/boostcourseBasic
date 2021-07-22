package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;

//delete
public class JDBCExam4 {

	public static void main(String[] args) {
		Integer roleId = 501;
		
		RoleDao dao = new RoleDao();
		int deleteCount = dao.deleteRole(roleId);
		
		System.out.println(deleteCount);
	}

}

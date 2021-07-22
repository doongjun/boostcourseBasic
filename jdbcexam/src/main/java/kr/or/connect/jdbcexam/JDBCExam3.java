package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

//update
public class JDBCExam3 {

	public static void main(String[] args) {
		String description = "CEO";
		Integer roleId = 200;
		
		Role role = new Role(roleId, description);
		
		RoleDao dao = new RoleDao();
		
		int updateCount = dao.updateRole(role);
		System.out.println(updateCount);
	}

}

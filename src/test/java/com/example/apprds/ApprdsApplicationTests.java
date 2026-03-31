package com.example.apprds;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SpringBootTest
class ApprdsApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Test
	void contextLoads() {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT NOW()");
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				System.out.println("\n--------------------------------------------------------");
				System.out.println("AWS RDS Database Current Time:	 " + rs.getTimestamp(1));
				System.out.println("--------------------------------------------------------\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

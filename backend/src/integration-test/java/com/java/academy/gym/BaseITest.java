package com.java.academy.gym;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(classes = GymBackendApplication.class)
@DataJpaTest
@Sql({"classpath:sql/test-user-data.sql"})
public class BaseITest {
}

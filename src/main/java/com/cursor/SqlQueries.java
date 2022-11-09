package com.cursor;

public final class SqlQueries {

    public static final String CREATE_TABLE = """
            CREATE TABLE IF NOT EXISTS user (
            id int PRIMARY KEY AUTO_INCREMENT,
            first_name varchar(50),
            last_name varchar(50),
            age int)
             """;

    public static final String INSERT_USERS = """
            INSERT INTO user (first_name, last_name,age) VALUES 
            ('john', 'snow',42),
            ('max', 'pax',18),
            ('tirion', 'lanister',30),
            ('ivan', 'merloy',25),
            ('dmytriy', 'ganster',58),
            ('alex', 'trudo',10)
            """;

    public static final String UPDATE_USER_AGE = """
            UPDATE user SET age=? WHERE id =?
            """;

    public static final String SELECT_USERS_LESS_18 = """
            SELECT * FROM user
            WHERE user.age <18
            """;

    public static final String SELECT_USERS_NAME_FINISH_O = """
            SELECT * FROM user
            WHERE user.first_name like "%o"
            """;

    public static final String SELECT_USERS_BETWEEN_18_AND_60 = """
            SELECT * FROM user 
            WHERE age BETWEEN 18 AND 60
                """;

    public static final String SELECT_USERS_NAME_HAVE_A = """
              SELECT * FROM user
            Where user.first_name like "%a%"
                """;

    private SqlQueries() {
    }

}

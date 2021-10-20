package com.briliantidea.restservices.dao;

import com.briliantidea.restservices.User;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.nio.charset.StandardCharsets;

@Repository
public class JDBCUserRepository implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addUser(User user) {
        String sql = "insert into test.users (username, password) values (?,?)";
        String encPass = Hashing.sha256().hashString(user.getPassword(), StandardCharsets.UTF_8).toString();

        jdbcTemplate.update(sql, user.getUsername(), encPass);
    }

    @Override
    public boolean authenticateUser(User user) {
        String sql = "select * from test.users where username = ?";
        String encPass = Hashing.sha256().hashString(user.getPassword(), StandardCharsets.UTF_8).toString();
        User fetchedUser = jdbcTemplate.queryForObject(
                sql, new Object[]{user.getUsername()},
                (rs, rowNum) -> {
                    return new User(
                            rs.getString("username"),
                            rs.getString("password")
                    );
                });

        if (encPass.equals(fetchedUser.getPassword()))
            return true;
        else
            return false;
    }
}

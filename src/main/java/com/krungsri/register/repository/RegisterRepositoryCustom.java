package com.krungsri.register.repository;

import com.krungsri.register.model.GetUserRequest;
import com.krungsri.register.model.GetUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class RegisterRepositoryCustom {
    @Autowired
    public JdbcTemplate jdbcTemplate;

    public List<GetUserResponse> getUser (GetUserRequest request) {
        List<Object> params = new ArrayList<Object>();
        List<GetUserResponse> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("  SELECT id,birth_date,citizen_id,created_by,created_date,first_name,gender,  \r\n");
        sql.append("  is_deleted,last_name,member_type,mobile,salary,title,updated_by,updated_date,reference_code   \r\n");
        sql.append("  from register  \r\n");
        sql.append("  where 1=1  \r\n");
        if(!request.getCid().isEmpty()){
            sql.append("  and citizen_id = ? \r\n");
            params.add(request.getCid());
        }
        if(!request.getFirstName().isEmpty()){
            sql.append("  and first_name = ? \r\n");
            params.add(request.getFirstName());
        }
        if(!request.getLastName().isEmpty()){
            sql.append("  and last_name = ? \r\n");
            params.add(request.getLastName());
        }
        if (log.isInfoEnabled()) {
            log.info("function : getUser");
            log.info("sql: {}", sql.toString());
        }

        result = jdbcTemplate.query(sql.toString(),  params.toArray(), new RowMapper() {
            @Override
            public GetUserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

                GetUserResponse item = new GetUserResponse();
                item.setId(rs.getInt("id"));
                item.setCid(rs.getString("citizen_id"));
                item.setTitle(rs.getString("title"));
                item.setFirstName(rs.getString("first_name"));
                item.setLastName(rs.getString("last_name"));
                item.setMobile(rs.getString("mobile"));
                item.setGender(rs.getString("gender"));
                item.setBirthDate(rs.getString("birth_date"));
                item.setSalary(rs.getInt("salary"));
                item.setMemberType(rs.getString("member_type"));
                item.setReferenceCode(rs.getString("reference_code"));
                item.setIsDeleted(rs.getString("is_deleted"));
                item.setCreatedDate(rs.getString("created_date"));
                item.setCreatedBy(rs.getString("created_by"));
                item.setUpdatedDate(rs.getString("updated_date"));
                item.setUpdatedBy(rs.getString("updated_by"));
                return item;
            }
        });
        return result;
    }

}

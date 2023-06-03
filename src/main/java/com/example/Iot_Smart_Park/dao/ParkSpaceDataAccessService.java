package com.example.Iot_Smart_Park.dao;

import com.example.Iot_Smart_Park.model.ParkSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("spacePostgres")
public class ParkSpaceDataAccessService implements ParkSpaceDao{
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public ParkSpaceDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public int insertParkSpace(UUID id, ParkSpace parkSpace) {
        final String sql = "INSERT INTO parkspace (id, status, locationlat, locationlng)" + "VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, id, parkSpace.getStatus(), parkSpace.getLocationLat(), parkSpace.getLocationLng());
        return 0;
    }

    @Override
    public Optional<ParkSpace> selectParkSpaceById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<ParkSpace> selectAllParkSpaces() {
        final  String sql = "SELECT id, status, locationlat, locationlng FROM parkspace";
        return jdbcTemplate.query(sql, new RowMapper<ParkSpace>() {
            @Override
            public ParkSpace mapRow(ResultSet rs, int rowNum) throws SQLException {
                var id = UUID.fromString(rs.getString("id"));
                var status = rs.getBoolean("status");
                var locationlat = rs.getDouble("locationlat");
                var locationlng = rs.getDouble("locationlng");
                return new ParkSpace(id,status, locationlat,locationlng);
            }
        });
    }

    @Override
    public int deleteParkSpaceById(UUID id) {
        final String sql = "DELETE FROM parkspace WHERE id=?";
        jdbcTemplate.update(sql, id);
        return 0;
    }

    @Override
    public int updateParkSpaceById(UUID id, ParkSpace parkSpace) {
        String sql = "Update parkspace SET status = ? WHERE id = ?";
        return jdbcTemplate.update(sql, parkSpace.getStatus(), id);
    }

}

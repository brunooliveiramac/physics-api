package com.physics.api.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.physics.api.commons.VideoSqlConstants;
import com.physics.api.connection.DataSourceFactory;
import com.physics.api.model.Video;

public class VideoDAO {

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource = new DataSourceFactory().getDataSource();
	
	public VideoDAO() {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Video> getVideosByContent(Long contentId) {
		List<Video> result = new ArrayList<>();
		result = jdbcTemplate.query(VideoSqlConstants.VIDEOS_BY_CONTENT, VIDEO_ROW_MAPPER, contentId);
		
		return result;
	}
	
	private RowMapper<Video> VIDEO_ROW_MAPPER = new RowMapper<Video>() {
		public Video mapRow(ResultSet rs, int numRow) throws SQLException {
			Video video = new Video();
			
			video.setId(rs.getLong("id"));
			video.setTitle(rs.getString("title"));
			video.setUri(rs.getString("uri"));
			
			return video;
		}
	};
}

package com.agenda_crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.agenda_crud.model.Agenda;

@Repository
public class AgendaDAOImpl implements AgendaDAO{
	
	NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) throws DataAccessException{
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Agenda> listarTodosAgenda() {
		String sql = "SELECT id, nome, telefone, email FROM agenda";

		List<Agenda> list = jdbcTemplate.query(sql, getSqlParameterByModel(null), new AgendaMapper());

		return list;
	}

	private SqlParameterSource getSqlParameterByModel(Agenda agenda) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (agenda != null) {
			parameterSource.addValue("id", agenda.getId());
			parameterSource.addValue("nome", agenda.getNome());
			parameterSource.addValue("telefone", agenda.getTelefone());
			parameterSource.addValue("email", agenda.getEmail());
		}
		return parameterSource;
	}
	
	private static final class AgendaMapper implements RowMapper<Agenda> {

		public Agenda mapRow(ResultSet rs, int rowNum) throws SQLException {
			Agenda agenda = new Agenda();
			agenda.setId(rs.getInt("id"));
			agenda.setNome(rs.getString("nome"));
			agenda.setTelefone(rs.getString("telefone"));
			agenda.setEmail(rs.getString("email"));

			return agenda;
		}
	}

	public void adicionarAgenda(Agenda agenda) {
		String sql = "INSERT INTO agenda(nome, telefone, email) VALUES(:nome, :telefone, :email)";
		jdbcTemplate.update(sql, getSqlParameterByModel(agenda));
	}

	public void atualizarAgenda(Agenda agenda) {
		String sql = "UPDATE agenda SET nome = :nome, telefone = :telefone, email = :email WHERE id = :id";
		jdbcTemplate.update(sql, getSqlParameterByModel(agenda));
	}

	public void deletar(int id) {
		String sql = "DELETE FROM agenda WHERE id = :id";
		jdbcTemplate.update(sql, getSqlParameterByModel(new Agenda(id)));
	}

	public Agenda procuraAgendaPorId(int id) {
		String sql = "SELECT * FROM agenda WHERE id = :id";
		return jdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Agenda(id)), new AgendaMapper());
	}
}

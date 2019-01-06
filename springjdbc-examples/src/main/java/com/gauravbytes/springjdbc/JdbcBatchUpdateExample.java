package com.gauravbytes.springjdbc;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;

import com.gauravbytes.springjdbc.ds.JdbcDataSourceUtils;
import com.gauravbytes.springjdbc.dto.Product;

/**
 * Examples of batch updates in JdbcTemplate
 * 
 * @author Gaurav Rai Mazra <a href="https://gauravbytes.com">My blog</a>
 *         <a href="https://lineofcode.in">Website</a>
 */
public class JdbcBatchUpdateExample {
	private static final Logger log = Logger.getGlobal();

	public static void main(String[] args) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcDataSourceUtils.getH2Database());

		int[] results = jdbcTemplate.batchUpdate("insert into product (name, category, description) values(?,?,?)",
				new ProductBatchPreparedStatementSetter(
						Arrays.asList(new Product("Lenovo Laptop", "laptop", "Thinkpad series laptop"),
								new Product("Acer Laptop", "laptop", "Predator series laptop"))));
		log.info(() -> String.format("Inserted rows: %s", Arrays.toString(results)));

		List<Product> products = IntStream.range(0, 10).mapToObj(i -> new Product("A " + i, "mobile", "New mobile"))
				.collect(Collectors.toList());

		ParameterizedPreparedStatementSetter<Product> pss = (ps, product) -> {
			ps.setString(1, product.getName());
			ps.setString(2, product.getCategory());
			ps.setString(3, product.getDescription());
		};

		int[][] result = jdbcTemplate.batchUpdate("insert into product (name, category, description) values(?,?,?)",
				products, 5, pss);
		
		log.info(Arrays.deepToString(result));
	}
}

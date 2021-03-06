package mhotel;

import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@ApplicationScoped
public class DatasourceUtils {
	private static final Logger __logger = Logger.getLogger("DatasourceUtils");
	
	@ApplicationScoped
	@Produces
	public DataSource getInjectedDataSourceH2() throws NamingException {
		__logger.info("Inside DataSource producer");
		Context ctx = new InitialContext();
		return (DataSource) ctx.lookup("java:/comp/env/jdbc/HotelDB");
	}
	
	public static DataSource getDataSource() throws NamingException {
		Context ctx = new InitialContext();
		return (DataSource) ctx.lookup("java:/comp/env/jdbc/HotelDB");
	}
}

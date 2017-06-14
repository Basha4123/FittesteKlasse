import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResultSetConverter {

	public String[] toStringArray(ResultSet rs, String columnLabel) {
		ArrayList<String> resultList = new ArrayList<String>();
		resultList.add("");
		String[] result=null;
		try {
			while (rs.next()) {
				String value = rs.getString(columnLabel);
				if(value != null && !value.equals("")){
					resultList.add(value);
				}
				
			}
			result = new String[resultList.size()];
			resultList.toArray(result);
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return result;
	}

}

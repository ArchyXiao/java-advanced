package config;

import utils.ParameterMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: Archy
 * @Date: 2020/12/6 22:53
 */
public class BoundSql {

    private String sqlText;

    private List<ParameterMapping> parameterMappings = new ArrayList<>();

    public BoundSql(String sqlText, List<ParameterMapping> parameterMappings) {
        this.sqlText = sqlText;
        this.parameterMappings = parameterMappings;
    }

    public String getSqlText() {
        return sqlText;
    }

    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
    }

    public List<ParameterMapping> getParameterMappings() {
        return parameterMappings;
    }

    public void setParameterMappings(List<ParameterMapping> parameterMappings) {
        this.parameterMappings = parameterMappings;
    }
}

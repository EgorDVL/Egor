package db;

import java.util.Arrays;

/**
 * Created by Egor on 31.10.2016.
 */
public class QueryBuilderSQL {

    private StringBuilder query = new StringBuilder();

    public QueryBuilderSQL select() {
        query.append("select ");
        return this;
    }

    public QueryBuilderSQL all() {
        query.append("* ");
        return this;
    }

    public QueryBuilderSQL from(String tableName) {
        query.append("from ")
                .append(tableName)
                .append(" ");
        return this;
    }

    public QueryBuilderSQL innerJoin(String tableFrom, String tableTo, String paramValue) {
        query.append("inner join ")
                .append(tableFrom)
                .append(" on ")
                .append(tableTo)
                .append(".")
                .append(paramValue)
                .append("=")
                .append(tableFrom)
                .append(".")
                .append(paramValue)
                .append(" ");
        return this;
    }

    public QueryBuilderSQL where() {
        query.append("where ");
        return this;
    }

    public QueryBuilderSQL param(String paramName) {
        query.append(paramName)
                .append(" ");
        return this;
    }

    public QueryBuilderSQL equals(String paramValue) {
        query.append("= ")
                .append(paramValue)
                .append(" ");
        return this;
    }

    public QueryBuilderSQL like(String paramValue) {
        query.append("like ")
                .append(paramValue)
                .append(" ");
        return this;
    }

    public QueryBuilderSQL groupBy(String paramValue) {
        query.append("group by ")
                .append(" ")
                .append(paramValue)
                .append(" ");
        return this;
    }

    public QueryBuilderSQL having(String agreatFunction, String columName, String operator, String value) {
        query.append("having ")
                .append(agreatFunction)
                .append("(")
                .append(columName)
                .append(")")
                .append(" ")
                .append(operator)
                .append(" ")
                .append(value)
                .append(" ");
        return this;
    }

    public QueryBuilderSQL orderBy(String columName) {
        query.append("order by ")
                .append(columName);
        return this;
    }


    public QueryBuilderSQL between(String columName, String paramFrom, String paramTo) {
        if (query.toString().contains("between ") || query.toString().contains("in ") || query.toString().contains("= ")) {
            query.append(" and ");
        }
        query.append(columName).append(" between ")
                .append(paramFrom)
                .append(" and ")
                .append(paramTo)
                .append(" ");
        return this;
    }

    public QueryBuilderSQL in(String columName, String... param) {
        String join = String.join(",", Arrays.asList(param));

        StringBuilder sb = new StringBuilder();

        if (join.isEmpty() || join == null || join == "") {
            query.append("");
        } else {
            if (query.toString().contains("in ") || query.toString().contains("between ") || query.toString().contains("= ")) {
                query.append(" and ");
            }
            query.append(columName)
                    .append(" in ")
                    .append("(")
                    .append("'")
                    .append(join)
                    .append("'")
                    .append(")");
        }
        return this;
    }


    public String build() {
        return query.append(";").toString();
    }

    public String buildWithOutEnd() {
        return query.toString();
    }
}


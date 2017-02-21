package xyz.gregoirejoncour.merdouille2.model;

/**
 * Created by gregoire on 21/02/2017.
 */

public class StreetModel {
    private String databaseid;
    private String recordid;
    private FieldStreetModel fields;

    public String getRecordid() {
        return recordid;
    }

    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }

    public String getDatabaseid() {
        return databaseid;
    }

    public void setDatabaseid(String databaseid) {
        this.databaseid = databaseid;
    }

    public FieldStreetModel getFields() {
        return fields;
    }

    public void setFields(FieldStreetModel fields) {
        this.fields = fields;
    }
}

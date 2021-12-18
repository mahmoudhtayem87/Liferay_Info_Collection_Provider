package com.liferay.info.model;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ClassedModel;

import java.io.Serializable;
/**
 * @author Mahmoud Hussein Tayem
 */
public class KPI implements ClassedModel {

    private long _id;
    private String _name;
    private String _value;

    public KPI(long kpiId,String kpiName,String kpiValue)
    {
        this._id =    kpiId;
        this._name = kpiName;
        this._value = kpiValue;
    }
    @Override
    public ExpandoBridge getExpandoBridge() {
        return null;
    }

    @Override
    public Class<?> getModelClass() {
        return KPI.class;
    }

    @Override
    public String getModelClassName() {
        return KPI.class.getName();
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }
    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
    }


    public long getId() {
        return _id;
    }

    public void setKpiId(long kpiId) {
        this._id = kpiId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String kpiName) {
        this._name = kpiName;
    }

    public String getValue() {
        return _value;
    }

    public void setValue(String kpiValue) {
        this._value = kpiValue;
    }
}

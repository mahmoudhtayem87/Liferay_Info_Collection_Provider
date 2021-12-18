package com.liferay.info.model;

import com.liferay.info.field.InfoField;
import com.liferay.info.field.type.TextInfoFieldType;
import com.liferay.info.localized.InfoLocalizedValue;
/**
 * @author Mahmoud Hussein Tayem
 */
public class KPIInfoFields {


    public static final InfoField<TextInfoFieldType> nameInfoField =
            InfoField.builder(
            ).infoFieldType(
                    TextInfoFieldType.INSTANCE
            ).name(
                    "name"
            ).labelInfoLocalizedValue(
                    InfoLocalizedValue.localize(KPI.class, "kpi-name")
            ).build();

    public static final InfoField<TextInfoFieldType> valueInfoField =
            InfoField.builder(
            ).infoFieldType(
                    TextInfoFieldType.INSTANCE
            ).name(
                    "value"
            ).labelInfoLocalizedValue(
                    InfoLocalizedValue.localize(KPI.class, "kpi-value")
            ).build();
}

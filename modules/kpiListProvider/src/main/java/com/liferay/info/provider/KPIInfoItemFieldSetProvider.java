package com.liferay.info.provider;

import com.liferay.info.field.InfoFieldSet;
import com.liferay.info.localized.InfoLocalizedValue;
import com.liferay.info.model.KPIInfoFields;
import org.osgi.service.component.annotations.Component;
/**
 * @author Mahmoud Hussein Tayem
 */
@Component(
        immediate = true,
        service = KPIInfoItemFieldSetProvider.class
)
public class KPIInfoItemFieldSetProvider {
    public InfoFieldSet getInfoFieldSet() {
        return InfoFieldSet.builder()
                .infoFieldSetEntry(KPIInfoFields.nameInfoField)
                .infoFieldSetEntry(KPIInfoFields.valueInfoField)
                .labelInfoLocalizedValue(InfoLocalizedValue.localize(getClass(), "kpi"))
                .name("kpi")
                .build();
    }
}

package com.liferay.info.provider;

import com.liferay.info.field.InfoFieldValue;
import com.liferay.info.item.InfoItemFieldValues;
import com.liferay.info.item.InfoItemReference;
import com.liferay.info.item.provider.InfoItemFieldValuesProvider;
import com.liferay.info.model.KPI;
import com.liferay.info.model.KPIInfoFields;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Mahmoud Hussein Tayem
 */
@Component(immediate = true, service = InfoItemFieldValuesProvider.class)
public class KPIInfoItemFieldValuesProvider implements InfoItemFieldValuesProvider<KPI>{




    @Override
    public InfoItemFieldValues getInfoItemFieldValues(KPI kpi) {
        return InfoItemFieldValues.builder(
        ).infoFieldValues(
                _getInfoFieldValues(kpi)
        ).infoItemReference(
                new InfoItemReference(KPI.class.getName(), kpi.getId())
        ).build();
    }


    private List<InfoFieldValue<Object>> _getInfoFieldValues(KPI kpi) {
        List<InfoFieldValue<Object>> infoFieldValues = new ArrayList<>();
        infoFieldValues.add(
                new InfoFieldValue<>(
                        KPIInfoFields.nameInfoField,
                        kpi.getName()));
        infoFieldValues.add(
                new InfoFieldValue<>(
                        KPIInfoFields.valueInfoField,
                        kpi.getValue()));

        return infoFieldValues;
    }



}

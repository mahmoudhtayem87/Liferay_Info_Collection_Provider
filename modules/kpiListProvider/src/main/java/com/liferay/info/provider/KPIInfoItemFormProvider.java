package com.liferay.info.provider;

import com.liferay.info.field.InfoFieldSet;
import com.liferay.info.form.InfoForm;
import com.liferay.info.item.provider.InfoItemFormProvider;
import com.liferay.info.localized.InfoLocalizedValue;
import com.liferay.info.model.KPI;
import com.liferay.info.model.KPIInfoFields;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;
import java.util.Set;
/**
 * @author Mahmoud Hussein Tayem
 */
@Component(immediate = true, service = InfoItemFormProvider.class)
public class KPIInfoItemFormProvider implements InfoItemFormProvider<KPI> {
    @Override
    public InfoForm getInfoForm() {
        Set<Locale> availableLocales = LanguageUtil.getAvailableLocales();

        InfoLocalizedValue.Builder infoLocalizedValueBuilder =
                InfoLocalizedValue.builder();

        for (Locale locale : availableLocales) {
            infoLocalizedValueBuilder.value(
                    locale,
                    ResourceActionsUtil.getModelResource(
                            locale, KPI.class.getName()));
        }

        return InfoForm.builder(
        ).infoFieldSetEntry(
                _kpiInfoItemFieldSetProvider.getInfoFieldSet()
        ).labelInfoLocalizedValue(
                infoLocalizedValueBuilder.build()
        ).name(
                KPI.class.getName()
        ).build();
    }
    @Reference
    private KPIInfoItemFieldSetProvider _kpiInfoItemFieldSetProvider;

}

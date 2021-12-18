package com.liferay.info.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.info.collection.provider.CollectionQuery;
import com.liferay.info.collection.provider.ConfigurableInfoCollectionProvider;
import com.liferay.info.collection.provider.InfoCollectionProvider;
import com.liferay.info.form.InfoForm;
import com.liferay.info.list.provider.InfoListProvider;
import com.liferay.info.list.provider.InfoListProviderContext;
import com.liferay.info.model.KPI;
import com.liferay.info.model.KPIInfoFields;
import com.liferay.info.model.dummyResponse;
import com.liferay.info.pagination.InfoPage;

import com.liferay.info.pagination.Pagination;
import com.liferay.info.sort.Sort;
import com.liferay.taglib.search.IconSearchEntry;
import org.osgi.service.component.annotations.Component;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Mahmoud Hussein Tayem
 */
@Component(immediate = true,service = InfoCollectionProvider.class)
public class kpiListProvider implements InfoCollectionProvider<KPI> {

	public  List<KPI> getData() throws Exception {
		String url = "https://upbeat-newton-e0c3a5.netlify.app/.netlify/functions/server";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		ObjectMapper mapper = new ObjectMapper();
		dummyResponse responseObj = mapper.readValue(response.toString(), dummyResponse.class);
		List<KPI> KPIS = new ArrayList<>();
		long fakeId = 1;
		for (Map.Entry<String,Object> entry : responseObj.details.entrySet()) {
			KPIS.add(new KPI(fakeId,entry.getKey(),entry.getValue().toString()));
			fakeId++;
		}
		return KPIS;
	}



	@Override
	public String getLabel(Locale locale) {
		return "KPIs";
	}

	@Override
	public String getKey() {
		return InfoCollectionProvider.super.getKey();
	}

	@Override
	public InfoPage<KPI> getCollectionInfoPage(CollectionQuery collectionQuery) {
		try {
			return InfoPage.of(getData());
		}
		catch (Exception exp)
		{
			System.out.println("Error: " + exp.getMessage());
		}
		return null;
	}
}
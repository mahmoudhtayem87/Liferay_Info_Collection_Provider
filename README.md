# Liferay Information Collection Provider

This is an example implementation of information collection provider where you can inject external data from a remote source into Liferay as a Collection which can be used with Collection Display Widget to render the content.

In order to implement the provider, you will need to implement the following:
- **InfoFields**: A class where you will be defining your provider data fields, this will help to tell liferay about what kind of data you are exposing.
- **KPIInfoItemFieldSetProvider**: Building the form fields which will be exposed to liferay based on the InfoFields attributes.
- **InfoItemFieldValuesProvider**: Mapping the external data source data attributes to the infoFields which will be exposed to liferay.
- **KPIInfoItemFormProvider**: Mapping the provider to the InfoFields.
- **InfoCollectionProvider**: This is where you pull the information from external data sources and map it to your infoFields.

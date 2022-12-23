package sirdarey.paramConverters;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import jakarta.ws.rs.ext.ParamConverter;
import jakarta.ws.rs.ext.ParamConverterProvider;
import jakarta.ws.rs.ext.Provider;
import sirdarey.Currency;

@Provider
public class CurrencyParamConverterProvider implements ParamConverterProvider{

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
		//return (ParamConverter<Currency>) new ParamConverterForCurrency();
		return new ParamConverter<T> () {

			@SuppressWarnings("unchecked")
			@Override
			public T fromString(String code) {
				Currency currency;
				
				switch(code.toUpperCase()) {
					case "EUR": currency = new Currency(code, "Euros"); break;
					case "USD": currency = new Currency(code, "US Dollars"); break;
					case "INR": currency = new Currency(code, "Indian Rupees"); break;
					default: currency = new Currency(code, "Naira"); break;
				}
				
				return (T) currency;
			}

			@Override
			public String toString(T currency) {
				return currency.toString();
			}
			
		};
	}

}

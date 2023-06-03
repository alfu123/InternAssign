select avg(averagerate) as 'Average exchange rate' 
from sales.CurrencyRate 
where FromCurrencyCode='USD' and ToCurrencyCode='GBP' and YEAR(currencyratedate)=2012;

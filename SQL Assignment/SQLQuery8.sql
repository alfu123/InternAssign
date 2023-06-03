select BusinessEntityID as 'Salespersonid',
CASE
when CommissionPct=0.0 then 'BAND 0'
when CommissionPct>0.0 and CommissionPct<=0.01 then 'BAND 1'
when CommissionPct>0.01 and CommissionPct<=0.015 then 'BAND 2'
when CommissionPct>0.015 then 'BAND 3'
END AS 'Commission Band'
from sales.SalesPerson;
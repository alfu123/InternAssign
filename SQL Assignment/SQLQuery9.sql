DECLARE @ID int;
select @ID =BusinessEntityID
from person.person
where firstname='RUTH'
and lastname='Ellerbrock'
and PersonType='EM';
EXEC dbo.uspGetEmployeeManagers @BusinessEntityID=@ID;
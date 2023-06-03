select firstname,lastname from 
HumanResources.Employee,person.Person 
where JobTitle in ( 'Design Engineer','Tool Designer','Marketing Assistant')
 and HumanResources.Employee.BusinessEntityID=person.Person.BusinessEntityID;
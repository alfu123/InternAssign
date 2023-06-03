select ROW_NUMBER() over(order by FirstName asc) 
as 'Sr.No.',firstname,lastname from Person.Person 
where firstname like '%ss%';
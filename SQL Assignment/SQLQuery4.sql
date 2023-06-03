select name ,color from Production.Product
where weight=(select max(weight) from Production.Product);
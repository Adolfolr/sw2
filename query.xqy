for $x in doc("book.xml")/Agenda/persona
where $x/telefono=1234
order by $x/nombre
return $x/nombre
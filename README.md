# Aula 8
## Externalizando Consulta

### Criar ```orm.xml``` arquivo na pasta META-INF:

![image](https://github.com/javajdk2023/j224082023/assets/130251409/ca425d35-67a8-4d77-9c85-23771901ee78)

### Conteúdo do Arquivo

```xml
<?xml version="1.0" encoding="UTF-8"?>
<entity-mappings version="2.0" xmlns="http://java.sun.com/xml/ns/persistence/orm"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="http://java.sun.com/xml/ns/persistence/orm
        http://java.sun.com/xml/ns/persistence/orm_2_0.xsd ">

    <!--find all books ordered by pages descending-->
    <named-query name="Alternativa.findAllXML">
        <query>SELECT a FROM Alternativa a</query>
    </named-query>

    <!--find books by title-->
    <named-query name="Questao.findAllXML">
        <query>SELECT q FROM Questao q</query>
    </named-query>

</entity-mappings>
````

## Ciclo de Vida da Entidade

![image](https://github.com/javajdk2023/j224082023/assets/130251409/e19ea87d-105d-4e55-9084-09f7235fe9fc)

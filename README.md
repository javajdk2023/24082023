# 24082023
## JDBC

* https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/package-summary.html

* https://download.oracle.com/otn-pub/jcp/jdbc-4_3-mrel3-spec/jdbc4.3-fr-spec.pdf?AuthParam=1694546163_72ad0c8226245091b567386b212bc7f4

## Maven

* https://mvnrepository.com/artifact/org.postgresql/postgresql/42.6.0

![image](https://github.com/javajdk2023/j224082023/assets/130251409/54da0142-11c8-42ef-a8de-6616e6f4eeb1)

* Adicionar a dependência (*dependency*) dentro da tag dependências (*dependencies*):

```xml
	<dependencies>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<version>42.6.0</version>
		</dependency>
	</dependencies>
```
![image](https://github.com/javajdk2023/j224082023/assets/130251409/d8c7c78e-a441-4c25-8d01-8e6470ae8302)

* Uma nova entrada no seu projeto será exibida: *Maven Dependencies*. Ao Expandir a entrada, será possível observar que o arquivo *postgresql-42.6.0.jar*
  
![image](https://github.com/javajdk2023/j224082023/assets/130251409/34b40ac2-fd96-4bf3-8980-5f3a70303c39)


## Classe Properties

A classe Properties é uma classe fundamental em Java que é frequentemente usada para gerenciar configurações e propriedades de um programa. 

Ela é usada para armazenar pares chave-valor, onde as chaves são strings que representam nomes de propriedades e os valores são strings associadas a essas chaves. 

As propriedades são frequentemente usadas para armazenar configurações de aplicativos, como configurações de banco de dados, preferências do usuário e outras informações de configuração.

A classe Properties faz parte do pacote **java.util**. Ela fornece métodos específicos para carregar e salvar propriedades de e para arquivos, o que a torna especialmente útil para a leitura e gravação de configurações de aplicativos.

## Como Utilizar no Projeto
* na pasta **resources** crie um arquivo chamado: **config.properties**

![image](https://github.com/javajdk2023/j224082023/assets/130251409/88aed9ca-8cfe-4bdc-91ba-3d254262fdb1)

* preencha o arquivo utilizando o par com a sintaxe: **chave=valor**
* observação, insira apenas 1 par por linha.

![image](https://github.com/javajdk2023/j224082023/assets/130251409/a829d2d1-7bd2-4681-bbae-0f6b092020dc)

* Na classe **Aplicacao** vamos efetuar a leitura do arquivo **config.properties**. Precisaremos de 1 recurso chamada *try-with-resources*

```java
package br.com.fuctura;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class Aplicacao {

	public static void main(String[] args) throws SQLException {

		try (InputStream arquivo = Aplicacao.class.getClassLoader().getResourceAsStream("config.properties")) {

			var prop = new Properties();
			prop.load(arquivo);

			var url = prop.get("url");
			var username = prop.get("username");
			var password = prop.get("password");

			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
			
		} catch (IOException io) {
			io.printStackTrace();
		}	
	}
}
```

* Os valores salvos no arquivo **config.properties** serão exibidos no console:

![image](https://github.com/javajdk2023/j224082023/assets/130251409/7c8f1244-c7a9-4fdb-95a1-343f02228384)


# Classe `Connection` no JDBC

O JDBC (Java Database Connectivity) é uma API Java que permite a conexão e interação com bancos de dados relacionais a partir de aplicativos Java. A classe Connection desempenha um papel central nessa API, representando uma conexão ativa com um banco de dados.
Principais Funções da Classe Connection

A classe Connection oferece várias funcionalidades essenciais ao trabalhar com bancos de dados por meio do JDBC:

1. **Estabelecimento de Conexão**: Antes de qualquer interação com um banco de dados, é necessário estabelecer uma conexão. A classe DriverManager é comumente usada para criar uma instância da classe Connection, que contém informações de conexão, como URL do banco de dados, nome de usuário e senha.

1. **Execução de Consultas SQL**: Através de um objeto Statement, que pode ser obtido a partir de uma instância de Connection, é possível executar consultas SQL para recuperar, inserir, atualizar ou excluir dados no banco de dados.

1. **Gerenciamento de Transações**: A classe Connection permite o controle de transações no banco de dados. Você pode iniciar, confirmar (commit) ou reverter (rollback) uma transação, dependendo dos resultados das operações no banco de dados.

1. **Controle de Conexão**: A classe Connection também é responsável por gerenciar o ciclo de vida da conexão. Isso inclui abrir e fechar conexões com o banco de dados de forma apropriada para evitar vazamentos de recursos.

## Exemplo de Uso

Aqui está um exemplo simplificado de como utilizar a classe Connection para se conectar a um banco de dados Postgres:

```java
package br.com.fuctura;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Aplicacao {

	public static void main(String[] args) throws SQLException {

		try (InputStream arquivo = Aplicacao.class.getClassLoader().getResourceAsStream("config.properties")) {

			var prop = new Properties();
			prop.load(arquivo);

			var url = prop.get("url");
				
			var conexao = DriverManager.getConnection(url.toString(), prop);

			System.out.println("Conectado com sucesso!!");
			
			conexao.close();
		} catch (IOException io) {
			io.printStackTrace();
		}	
	}
}
```

# Classe `PreparedStatement` no JDBC

A classe `PreparedStatement` é uma parte fundamental da API JDBC (Java Database Connectivity) que oferece uma maneira eficiente e segura de executar consultas SQL parametrizadas em bancos de dados a partir de aplicativos Java. Ela é uma extensão da classe `Statement` e é amplamente usada para evitar ataques de injeção de SQL e melhorar o desempenho das operações de banco de dados.

## Vantagens do `PreparedStatement`

Usar `PreparedStatement` em vez de `Statement` para executar consultas SQL tem várias vantagens:

1. **Prevenção de Injeção de SQL**: O `PreparedStatement` trata automaticamente caracteres especiais e evita a injeção de SQL. Os parâmetros são tratados como valores e não como parte do SQL, o que torna muito mais difícil que um invasor manipule a consulta.

2. **Melhor Desempenho**: `PreparedStatement` é compilado uma vez e pode ser reutilizado com diferentes valores de parâmetros. Isso é mais eficiente do que criar uma nova consulta SQL a cada vez.

3. **Legibilidade do Código**: O uso de placeholders para parâmetros torna o código mais legível e facilita a manutenção.

4. **Manuseio de Tipos de Dados**: `PreparedStatement` lida automaticamente com a conversão de tipos de dados Java para tipos de dados SQL, simplificando o código do aplicativo.

## Exemplo de Uso

Aqui está um exemplo de como usar `PreparedStatement` para inserir dados em uma tabela em um banco de dados MySQL:

```java
package br.com.fuctura;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Aplicacao {

	public static void main(String[] args) throws SQLException {

		try (InputStream arquivo = Aplicacao.class.getClassLoader().getResourceAsStream("config.properties")) {

			var prop = new Properties();
			prop.load(arquivo);

			var url = prop.get("url");
				
			var conexao = DriverManager.getConnection(url.toString(), prop);
			
			//preparar
			var comandoSQLINSERT = "INSERT INTO aluno VALUES (?, ?, ?, ?, ?)";
			var preparedStatement = conexao.prepareStatement(comandoSQLINSERT);

			var codigoAluno = 4;
			var nomeAluno = "joao";
			var idadeAluno = 20;
			var emailAluno = "j@gmail";
			var pesoAluno = 60;
			
			//atribuir valores
			preparedStatement.setInt(1, codigoAluno);
			preparedStatement.setString(2, nomeAluno);
			preparedStatement.setInt(3, idadeAluno);
			preparedStatement.setString(4, emailAluno);
			preparedStatement.setDouble(5, pesoAluno);
			
			//executar
			preparedStatement.execute();
			
			System.out.println("INSERT INTO aluno EXECUTADO COM SUCESSO!");
			
			System.out.println("Conectado com sucesso!!");
			
			conexao.close();
		} catch (IOException io) {
			io.printStackTrace();
		}	
	}
}
```

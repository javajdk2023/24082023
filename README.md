# Aula 5

# Introdução ao JPA (Java Persistence API) e Suas Aplicações

O Java Persistence API (JPA) é uma especificação da plataforma Java que simplifica o desenvolvimento de aplicativos Java que interagem com bancos de dados relacionais. Ele oferece uma camada de abstração sobre as operações de persistência de dados, permitindo que os desenvolvedores trabalhem com objetos Java em vez de lidar diretamente com consultas SQL e detalhes de mapeamento objeto-relacional.

A principal finalidade do JPA é fornecer um conjunto de interfaces e classes que tornam mais fácil o armazenamento e recuperação de objetos Java em bancos de dados relacionais. Isso simplifica o código, melhora a manutenção do aplicativo e aumenta a portabilidade, pois os aplicativos podem ser facilmente adaptados para diferentes sistemas de gerenciamento de bancos de dados (DBMS) compatíveis com JPA.

O JPA é amplamente utilizado em uma variedade de aplicações Java, desde sistemas de gerenciamento de conteúdo e aplicativos web até aplicativos corporativos complexos. Suas aplicações são diversas e incluem:

1. **Desenvolvimento Web:** Em aplicativos web, o JPA é usado para mapear objetos de domínio para tabelas de banco de dados, permitindo que os desenvolvedores realizem operações de CRUD (criar, ler, atualizar, excluir) de maneira eficiente.

2. **Aplicativos Empresariais:** Em sistemas corporativos, o JPA é usado para modelar e gerenciar dados de negócios, facilitando a integração com bancos de dados e a manutenção de dados consistentes.

3. **Aplicativos Móveis:** Em aplicativos móveis, o JPA pode ser usado para armazenar e recuperar dados de forma eficiente, melhorando o desempenho e a experiência do usuário.

4. **Aplicações de Análise de Dados:** Em aplicativos de análise de dados e business intelligence, o JPA pode ser usado para acessar dados de bancos de dados relacionais e transformá-los em informações valiosas.

5. **Aplicações de Jogos:** Até mesmo em jogos desenvolvidos em Java, o JPA pode ser usado para gerenciar e armazenar dados do jogo, como progresso do jogador e pontuações.

O JPA é uma ferramenta poderosa que simplifica o acesso a bancos de dados relacionais e aumenta a produtividade dos desenvolvedores Java. Sua flexibilidade e abstração o tornam uma escolha popular para uma variedade de aplicações, tornando o desenvolvimento de aplicativos que envolvem persistência de dados uma tarefa mais fácil e eficiente.

# O Arquivo `persistence.xml` na Java Persistence API (JPA)

O arquivo `persistence.xml` é um componente fundamental da Java Persistence API (JPA) que desempenha um papel crucial na configuração e na definição das unidades de persistência em um aplicativo Java que utiliza a JPA. Este arquivo é usado para configurar diversas informações relacionadas à persistência de dados, como conexões de banco de dados, mapeamento objeto-relacional (ORM), e nome da unidade de persistência.

## Conteúdo do `persistence.xml`

O arquivo `persistence.xml` é um arquivo de configuração XML que normalmente está localizado no diretório `META-INF` do seu projeto Java EE ou em outro local específico, dependendo do ambiente de desenvolvimento. Aqui estão algumas das configurações mais comuns que você pode encontrar no arquivo `persistence.xml`:

### Declaração de Unidade de Persistência

```xml
	<persistence-unit name="FUCTURA-PU"> <!-- COPIAR E COLAR NA CLASSE JAVA -->
		<properties>
			<!-- Propriedades JDBC -->
			<property name="javax.persistence.jdbc.driver"
				value="org.postgresql.Driver" />
			<property name="javax.persistence.jdbc.url"
				value="jdbc:postgresql://localhost:5432/postgres" /> <!-- ALTERE DE ACORDO COM A SUA CONFIGURACAO -->
			<property name="javax.persistence.jdbc.user" value="postgres" /> <!-- ALTERE DE ACORDO COM A SUA CONFIGURACAO -->
			<property name="javax.persistence.jdbc.password" value="123" /> <!-- ALTERE DE ACORDO COM A SUA CONFIGURACAO -->
			<!-- Configurações específicas do Hibernate -->
			<property name="hibernate.dialect"
				value="org.hibernate.dialect.PostgreSQLDialect" />
			<property name="hibernate.hbm2ddl.auto" value="update" />
			<property name="hibernate.show_sql" value="true" />
			<property name="hibernate.format_sql" value="true" />
		</properties>
	</persistence-unit>
```

# Introdução à Classe `Persistence` e sua Utilização

A classe `Persistence` é uma parte fundamental da Java Persistence API (JPA) que desempenha um papel crucial no início de uma unidade de persistência JPA em um aplicativo Java. A JPA é uma especificação que define um conjunto de interfaces e padrões para mapear objetos Java para um banco de dados relacional. A classe `Persistence` fornece métodos para inicializar uma unidade de persistência, que é essencial para a configuração e uso do JPA em um aplicativo.

## O que é uma Unidade de Persistência?

Uma unidade de persistência é uma instância da JPA que representa uma fonte de dados específica, geralmente um banco de dados. Através dela, é possível configurar como os objetos Java serão mapeados para as tabelas do banco de dados, definir as propriedades de conexão e gerenciar as entidades e transações.

## Utilização da Classe `Persistence`

A classe `Persistence` é geralmente usada para criar uma instância da unidade de persistência JPA por meio do método `createEntityManagerFactory`. Para isso, é necessário fornecer um nome de unidade de persistência e, opcionalmente, propriedades de configuração.

Aqui está um exemplo de como usar a classe `Persistence` para criar uma unidade de persistência JPA:

```java
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Aplicacao {
    public static void main(String[] args) {
        String unidadePersistencia = "FUCTURA-PU"; //DEVE SER IGUAL AO DO ARQUIVO **PERSISTENCE.XML**
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory(unidadePersistencia);
        
        // Agora, você pode usar a instância de EntityManagerFactory para criar EntityManagers e gerenciar entidades JPA.
        
        // Não se esqueça de fechar o EntityManagerFactory quando não for mais necessário.
        fabrica.close();
    }
}
```

# Introdução à Classe `EntityManagerFactory` e sua Utilização

A classe `EntityManagerFactory` desempenha um papel fundamental na Java Persistence API (JPA) ao criar instâncias de `EntityManager`. A JPA é uma especificação que define um conjunto de interfaces e padrões para mapear objetos Java para um banco de dados relacional. O `EntityManagerFactory` é responsável por configurar e gerenciar a conexão com o banco de dados, permitindo que você execute operações de persistência.

## O que é `EntityManagerFactory`?

A classe `EntityManagerFactory` é uma fábrica de gerenciadores de entidades (`EntityManager`) que representa uma unidade de persistência JPA. Ela é responsável por criar e configurar as instâncias de `EntityManager`, que são usadas para interagir com o banco de dados e gerenciar entidades JPA.

## Utilização da Classe `EntityManagerFactory`

Aqui está um exemplo de como usar a classe `EntityManagerFactory` para criar uma instância de `EntityManager` em um aplicativo Java:

```java
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Aplicacao {
    public static void main(String[] args) {
        String unidadePersistencia = "FUCTURA-PU";
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory(unidadePersistencia);
        
        // Criando uma instância de EntityManager a partir da EntityManagerFactory
        EntityManager em = fabrica.createEntityManager();
        
        // Agora, você pode usar o EntityManager para executar operações de persistência, como inserir, atualizar e consultar entidades JPA.
        
        // Não se esqueça de fechar o EntityManager e o EntityManagerFactory quando não forem mais necessários.
        em.close();
        fabrica.close();
    }
}
```

# O `EntityManager` na Java Persistence API (JPA)

O `EntityManager` é uma classe fundamental na Java Persistence API (JPA) que permite interagir com o banco de dados relacional usando objetos Java. Ele atua como uma interface entre o código da aplicação e a camada de persistência, facilitando a manipulação de entidades JPA e a execução de operações de persistência, como inserção, atualização, exclusão e consulta de dados no banco de dados.

## Principais Métodos do `EntityManager`

Aqui estão alguns dos principais métodos fornecidos pelo `EntityManager` para manipulação de entidades JPA:

### **Persistência de Entidades**

1. `persist(Object entity)`: Este método é usado para persistir uma nova entidade no banco de dados ou anexar uma entidade gerenciada pelo `EntityManager`. Se a entidade já existe, uma exceção será lançada.

2. `merge(Object entity)`: O método `merge` é usado para atualizar uma entidade existente ou anexar uma entidade não gerenciada ao contexto de persistência. Se a entidade não existir, ela será inserida; caso contrário, suas modificações serão sincronizadas com o banco de dados.

3. `remove(Object entity)`: Este método remove uma entidade do banco de dados. A entidade deve estar gerenciada pelo `EntityManager`.

### **Consultas**

4. `find(Class<T> entityClass, Object primaryKey)`: Utilizado para recuperar uma entidade específica com base na classe da entidade e na chave primária.

5. `createQuery(String qlString)`: Cria uma consulta JPA usando uma linguagem de consulta específica de banco de dados (JPQL - Java Persistence Query Language) e retorna um objeto `Query` que pode ser configurado e executado.

### **Controle de Transações**

6. `getTransaction()`: Retorna uma instância de `EntityTransaction` que permite iniciar, comprometer (commit) e reverter (rollback) transações.

### **Gerenciamento de Ciclo de Vida da Entidade**

7. `refresh(Object entity)`: Atualiza o estado da entidade com os valores do banco de dados.

### **Outros Métodos Úteis**

8. `clear()`: Remove todas as entidades gerenciadas pelo `EntityManager` do contexto de persistência, tornando-as não gerenciadas.

9. `close()`: Fecha o `EntityManager`, liberando os recursos associados a ele.

O `EntityManager` é uma parte essencial da JPA e permite que os desenvolvedores Java interajam com entidades JPA e realizem operações de persistência de forma eficaz. Esses métodos proporcionam um controle preciso sobre o ciclo de vida das entidades e a execução de consultas personalizadas em bancos de dados relacionais.

## Utilização da Classe `EntityManager`

```java
package br.com.fuctura;

import br.com.fuctura.entidade.Jogador;
import br.com.fuctura.entidade.Partida;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Aplicacao {

	public static void main(String[] args) {

    String unidadePersistencia = "FUCTURA-PU";
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory(unidadePersistencia);

		EntityManager em = fabrica.createEntityManager();

		Jogador j1 = new Jogador();
		j1.setNome("Joao");

		Partida p1 = new Partida();
		p1.setDuracao(123);
		p1.setPontuacao(0);

		em.getTransaction().begin();
		em.persist(j1);
		em.persist(p1);
		em.getTransaction().commit();

		var resultadoConsulta = em.find(Partida.class, 1);

		System.out.println("ID:" + resultadoConsulta);
	}
}
```

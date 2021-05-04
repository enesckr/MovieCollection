# Movie Collection System

**Movie Collection** film koleksiyon işlemleri için geliştirilmiştir. Sisteme kayıt olabilir ve giriş yapabilirsin.
Yetkilendirme mekanizması içermektedir. Sistemdeki rolünüze göre film ve aktör silebilir, güncelleyebilir,
ekleyebilirsiniz. Filmin adı, türü, oyuncularının ad ve soyadlarına göre arama yapılabilir.

### Not:

Kayıt ekranında normal yetkilere sahip kullanıcı oluştururken arka planda admin yetkisinde yeni bir kullanıcı
oluşturulmaktadır. email: ***admin@admin.com*** -> password: ***admin***

### Teknolojiler

Spring Boot  
Spring Security  
JPA, Hibernate, MySQL  
Maven  
HTML, CSS, Bootstrap  
Thymeleaf

### Veri Tabanı Ayarları

src/main/resources -> application.properties

MySQL de veritabani_ismi'nde db oluşturup localhost:/3306/veritabanı_ismi , username ve password özelliklerini
değiştirerek kendi veri tabanı bağlantınızı sağlayabilirsiniz.

    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
    spring.jpa.show-sql=true
    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.url=jdbc:mysql://localhost:3306/movieCollection?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false&allowPublicKeyRetrieval=true    
    spring.datasource.username=root
    spring.datasource.password=1234

## Kurulum

Terminalde aşağıdaki kodları çalıştırdıktan sonra web tarayıcı url kısmına localhost:8080 yazmalısınız.

    mvn clean install && mvn spring-boot:run

## Teknoloji Açıklamaları

**Spring Boot :** Spring tabanlı uygulama geliştirmenin en hızlı ve kolay yolu olması nedeniyle kullandım.

**Maven :** Bağımlılıkları kolay bir şekilde projeye dahil etmek, güncellemek ve yönetmek amacıyla kullandım.

**Spring Security :** Authentication ve authorization işlemlerini gerçekleştirmek yani kullanıcıları doğrulayıp sisteme
yönlendirmek ve yetkilerine göre kısıtlamak amacıyla kullandım.

**JPA - Hibernate :** JPA sayesinde veritabanı işlemlerini Java’da class’lar ile gerçekleştirebilmekteyiz ***(JPQL)***.
JPA, Hibernate gibi ORM'leri tek çatı altında kullanmayı amaçlamar. ORM ise nesneleri, ilişkisel veri tabanlarındaki
kayıtlarla ilişkilendirir. Veri tabanı ile ilgili iletişimde rahatlık sağladığı için kullandım.

**Thymeleaf :** Spring ile tam entegrasyon sağlamaktadır. Table yapılarında basitçe döngü oluşturabilmek, yönlendirmeler
yapabilmek, form üzerinde değerleri yerleştirebilmek amacıyla kullandım.

**Bootstrap :** Navbar, button, table gibi yapıları oluştururken kolaylık sağlaması amacıyla kullandım.

# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-developing-web-applications)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-spring-mvc-template-engines)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#using-boot-devtools)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)


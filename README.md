# Jakarta-Persistence-Testing

Simple application to test and learning Jakarta Persistence API.  
Clone the repo and run it from your IDE.  

Change your database settings in persistence.xml file. Create a database and run the application.  



JSON data model used to populate objects:
```
{
    "classification": {
        "localId": "valtio_1_20120101",
        "internationalRecommendation": true,
        "nationalRecommendation": true,
        "classificationName": [
            {
                "langName": "suomi",
                "lang": "fi",
                "name": "Valtiot ja maat"
            }
        ],
        "classificationDescription": [
            {
                "langName": "suomi",
                "lang": "fi",
                "description": "ISO 3166 -standardin mukaiset kolminumeroiset valtioiden tunnukset"
            }
        ]
    },
    "localId": "valtio_1_20120101/004",
    "level": 1,
    "code": "004",
    "order": 10,
    "modifiedDate": "1899-12-31T22:00:00Z",
    "parentItemLocalId": null,
    "parentCode": null,
    "classificationItemNames": [
        {
            "langName": "suomi",
            "lang": "fi",
            "name": "Afganistan"
        }
    ],
    "explanatoryNotes": [],
    "classificationIndexEntry": [
        {
            "text": []
        }
    ]
}
```
## Database model
![image](https://user-images.githubusercontent.com/64365116/214856794-ae90bc1e-be8a-4361-bd44-35b5f1f4e4a8.png)

## persistence.xml

```
<persistence xmlns="http://java.sun.com/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
             version="2.0">

    <persistence-unit name="hibernate-maakoodisto" transaction-type="RESOURCE_LOCAL">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>

        <class>org.jakarta.persistence.api.maakoodisto.test.models.Maakoodisto</class>
        <class>org.jakarta.persistence.api.maakoodisto.test.models.Classification</class>
        <class>org.jakarta.persistence.api.maakoodisto.test.models.ClassificationName</class>
        <class>org.jakarta.persistence.api.maakoodisto.test.models.ClassificationDescription</class>
        <class>org.jakarta.persistence.api.maakoodisto.test.models.ClassificationIndexEntry</class>
        <class>org.jakarta.persistence.api.maakoodisto.test.models.ClassificationItemNames</class>

        <exclude-unlisted-classes>true</exclude-unlisted-classes>

        <properties>
            <property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/jpa_test"/>
            <property name="jakarta.persistence.jdbc.user" value="root"/>
            <property name="jakarta.persistence.jdbc.password" value="root"/>

            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>

            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>

            <property name="hibernate.hbm2ddl.auto" value="create"/>
        </properties>

    </persistence-unit>

</persistence>
```

## Database
MySQL

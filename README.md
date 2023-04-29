<h2> Gestion des patients  </h2>
Gestion des patients est une application web JEE simple qui permet de gérer les patients d'une clinique médicale. Elle a été développée à l'aide du framework Spring MVC, Thymeleaf et Spring Data JPA.

<h3> Fonctionnalités </h3>
Les principales fonctionnalités de cette application incluent:

- Création, mise à jour et suppression de patients
- Affichage des informations des patients
- Recherche de patients par nom 

<h3> Installation </h3>

* `Pour installer l'application,vous devez d'abord cloner le dépôt Github sur votre machine locale`. Vous pouvez le faire en exécutant la commande suivante dans votre terminal:

```bash
git clone https://github.com/your-username/gestion-patients.git
```
</br>

* `Ensuite, vous devez créer une base de données MySQL` appelée * `gestion_patients` et mettre à jour le fichier * `application.properties` avec les informations de connexion à la base de données.

* `Enfin, vous pouvez exécuter l'application` en exécutant la commande suivante à la racine du projet:

```bash
mvn spring-boot:run
```
</br>

* `L'application sera ensuite accessible` à l'adresse suivante:


```bash
http://localhost:8082/index
```
</br>

<h3> Utilisation </h3>
Une fois que l'application est en cours d'exécution, vous pouvez l'utiliser pour ajouter, mettre à jour ou supprimer des patients, rechercher des patients par nom.


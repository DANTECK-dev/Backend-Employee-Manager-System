# Система управления сотрудниками (EMS)

Проект представляет собой систему управления сотрудниками, состоящую из двух модулей: бэкенда на **Spring Boot** и фронтенда на **Angular**. Данные хранятся в базе данных **MySQL**. Приложение позволяет выполнять основные CRUD-операции: просмотр, добавление, редактирование и удаление информации о сотрудниках.

**Ссылка на [Frontend](https://github.com/DANTECK-dev/Backend-Employee-Manager-System)** 


## Функциональные возможности

- Просмотр списка сотрудников.
- Добавление нового сотрудника.
- Редактирование данных сотрудника.
- Удаление сотрудника.
- Поиск сотрудников по имени или email.


## Технологии

- **Бэкенд**: 
  - Java 17
  - Spring Boot
  - Hibernate
  - MySQL
  - REST API

- **Фронтенд**:
  - Angular 15+
  - TypeScript
  - Bootstrap

- **Тестирование**:
  - JUnit, Mockito (для бэкенда)
  - Karma, Jasmine (для фронтенда)


## Установка и запуск

### 1. Системные требования
- **Java** 17+
- **Node.js** 16+ и npm
- **MySQL** 8.0+
- **Maven** 3.8+
- **Git**

### 2. Клонирование репозитория
Склонируйте проект:
```bash
git clone https://github.com/ваш-репозиторий/EMS.git
cd EMS
```

### 3. Настройка базы данных
1. Создайте базу данных MySQL:
   ```sql
   CREATE DATABASE ems_db;
   ```
2. Настройте подключение к базе данных в файле `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/ems_db
   spring.datasource.username=ваш_пользователь
   spring.datasource.password=ваш_пароль
   ```

### 4. Запуск бэкенда
1. Перейдите в директорию `Backend`:
   ```bash
   cd Backend
   ```
2. Соберите и запустите приложение:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

### 5. Запуск фронтенда
1. Перейдите в директорию `Frontend/angular_frontend`:
   ```bash
   cd Frontend/angular_frontend
   ```
2. Установите зависимости:
   ```bash
   npm install
   ```
3. Запустите приложение:
   ```bash
   ng start
   ```
4. Откройте приложение в браузере по адресу: [http://localhost:4200](http://localhost:4200)


## Тестирование

### 1. Тестирование бэкенда
Запустите unit-тесты с помощью Maven:
```bash
mvn test
```

### 2. Тестирование фронтенда
Запустите unit-тесты с помощью Karma:
```bash
ng test
```

## Штатный режим работы
После успешного запуска система будет доступна:
- **Фронтенд**: [http://localhost:4200](http://localhost:4200)
- **Бэкенд API**: [http://localhost:8080/api/employees](http://localhost:8080/api/employees)

Примеры маршрутов:
- Получение всех сотрудников: `GET /api/employees`
- Добавление сотрудника: `POST /api/employees`
- Редактирование сотрудника: `PUT /api/employees/{id}`
- Удаление сотрудника: `DELETE /api/employees/{id}`


## Разработка

1. **Фронтенд**:
   - Код находится в папке `Frontend/angular_frontend`.
   - Для сборки в production:
     ```bash
     ng build prod
     ```

2. **Бэкенд**:
   - Код находится в папке `Backend`.
   - Для сборки jar-файла:
     ```bash
     mvn package
     ```

## Дополнительная информация

### Ссылки
- [Документация Spring Boot](https://spring.io/projects/spring-boot)
- [Документация Angular](https://angular.io/docs)
- [MySQL Reference Manual](https://dev.mysql.com/doc/)

### Автор
- Cтудент **Александр Немеров**
- Вуз **ВСГУТУ**
- Группа **Б761-2**
- Связь **lol@kek-work.ru**

### Лицензия
Проект распространяется под лицензией [MIT LISENCE](LISENCE).

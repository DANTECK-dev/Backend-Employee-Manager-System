# Система управления сотрудниками (EMS) Backend (SpringBoot)
#### Для фронтенда на Angular 

## Описание проекта

Employee Manager System — это Fullstack-приложение для управления сотрудниками, созданное с использованием **Spring Boot**, **Angular** и **MySQL**. Система позволяет выполнять следующие операции:

- Просмотр списка сотрудников.
- Добавление новых сотрудников.
- Редактирование данных существующих сотрудников.
- Удаление сотрудников.

>Ссылка на [Frontend](https://github.com/DANTECK-dev/Frontend-Employee-Manager-System)

## Стек технологий

### Backend:
- **Spring Boot** 3.2.2: Основной фреймворк для разработки REST API.
- **Spring Data JPA**: Для взаимодействия с базой данных.
- **MySQL**: Реляционная база данных.
- **Hibernate**: ORM для работы с данными.
- **Maven**: Для управления зависимостями.

### Frontend:
- **Angular**: Для создания пользовательского интерфейса.

## Установка и запуск

### Backend

1. Убедитесь, что у вас установлены:
   - **Java 21** или выше.
   - **Maven**.

2. Склонируйте репозиторий:
   ```bash
   git clone <ссылка-на-репозиторий>
   ```

3. Настройте подключение к базе данных MySQL:
    - В файле `application.properties` укажите параметры подключения:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
      spring.datasource.username=ваш_пользователь
      spring.datasource.password=ваш_пароль
      spring.jpa.hibernate.ddl-auto=update
      ```

4. Запустите backend-приложение:
   ```bash
   mvn spring-boot:run
   ```

### Frontend

1. Убедитесь, что у вас установлены:
    - **Node.js** и **npm**.

2. Перейдите в папку с frontend-частью приложения:
   ```bash
   cd frontend
   ```

3. Установите зависимости:
   ```bash
   npm install
   ```

4. Запустите приложение:
   ```bash
   ng serve
   ```

5. Откройте браузер и перейдите по адресу:
   ```
   http://localhost:4200
   ```

## Основные API эндпоинты

- **GET /api/employees**: Получение списка сотрудников.
- **POST /api/employees**: Добавление нового сотрудника.
- **PUT /api/employees/{id}**: Редактирование данных сотрудника.
- **DELETE /api/employees/{id}**: Удаление сотрудника.

### Автор
- Cтудент **Александр Немеров**
- Вуз **ВСГУТУ**
- Группа **Б761-2**
- Связь **lol@kek-work.ru**

### Лицензия
Проект распространяется под лицензией [MIT LICENSE](LICENSE).

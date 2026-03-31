package com.example.springProj.repository;

import com.example.springProj.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// This is Spring Data JPA

public interface UserRepository extends JpaRepository<User, Long> {   // extends CrudRepository -> has implementations through Spring Data JPA
}

// Spring automatically creates class - implementation:
//  - Spring scanning interfaces, that extends JpaRepository
//  - Creates class that implements them, connecting EntityManager
//  - EntityManager though Hibernate generates SQL, opens connection, do PreparedStatement, ResultSet, commit, rollback

//REPOSITORY: CAN BE NULL -> USE OPTIONAL


// com.example.demo   ← базовий пакет
// ├── config        ← конфігурація (поки можна ігнорити)
// ├── controller    ← REST endpoints (API)
// ├── service       ← логіка
// ├── repository    ← доступ до БД
// ├── model         ← твої Entity (ТУТ буде User)
// └── DemoApplication ← головний клас
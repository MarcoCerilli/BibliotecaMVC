package biblioteca.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import biblioteca.Model.User;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUsername(String username);
}

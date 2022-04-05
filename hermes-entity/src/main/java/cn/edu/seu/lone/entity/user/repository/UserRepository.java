package cn.edu.seu.lone.entity.user.repository;

import cn.edu.seu.lone.entity.user.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {

    User findUserByName(String name);
}

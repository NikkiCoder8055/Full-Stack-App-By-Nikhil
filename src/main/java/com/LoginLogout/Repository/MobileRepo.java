package com.LoginLogout.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.LoginLogout.Model.Mobile;
@Repository
public interface MobileRepo extends JpaRepository<Mobile, Long> {

}

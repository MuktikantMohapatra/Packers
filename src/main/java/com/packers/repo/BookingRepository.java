package com.packers.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.packers.bo.BookingBO;
@Repository
public interface BookingRepository extends JpaRepository<BookingBO, String> {

}

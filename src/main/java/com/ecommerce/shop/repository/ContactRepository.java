package com.ecommerce.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shop.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}

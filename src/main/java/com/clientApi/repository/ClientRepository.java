package com.clientApi.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.clientApi.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
package com.bob_r.repository;

import com.bob_r.model.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
    List<License> findByOrganizationId(Long organizationId);
}

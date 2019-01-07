package com.mumSched.repository;

import org.springframework.data.repository.CrudRepository;

import com.mumSched.model.Entry;

public interface EntryRepository extends CrudRepository<Entry, Long> {

}

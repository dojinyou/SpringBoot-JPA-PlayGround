package com.dojinyou.manytomanty.store

import org.springframework.data.jpa.repository.JpaRepository

interface StoreDao : JpaRepository<Store, Long>

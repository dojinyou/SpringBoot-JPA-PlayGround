package com.dojinyou.manytomanty.store

import org.springframework.data.jpa.repository.JpaRepository

interface CategoryDao : JpaRepository<Category, Long>

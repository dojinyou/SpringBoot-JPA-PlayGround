package com.dojinyou.manytomanty.store

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
@Table(name = "store")
class Store(
    @Column(nullable = false, unique = true, updatable = false)
    val name: String = "",

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinTable(
        name = "store_category",
        joinColumns = [JoinColumn(name = "store_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")],
    )
    protected val mutableCategories: MutableSet<Category> = mutableSetOf(),
) : BaseEntity() {
    fun getCategories(): Set<Category> {
        return mutableCategories.toSet()
    }

    fun addCategory(category: Category) {
        mutableCategories.add(category)
    }
}

package com.dojinyou.manytomanty.store

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
@Table(name = "category")
class Category(
    @Column(nullable = false, unique = true, updatable = false)
    val name: String = "",
) : BaseEntity() {
    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinTable(
        name = "store_category",
        joinColumns = [JoinColumn(name = "category_id")],
        inverseJoinColumns = [JoinColumn(name = "store_id")],
    )
    protected val mutableStores: MutableSet<Store> = mutableSetOf()

    fun getStores(): Set<Store> {
        return mutableStores.toSet()
    }

    fun addStore(store: Store) {
        mutableStores.add(store)
    }
}

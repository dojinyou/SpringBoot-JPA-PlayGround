package com.dojinyou.manytomanty.store

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
@RequestMapping("/api/v1")
class Controller(
    val storeDao: StoreDao,
    val categoryDao: CategoryDao,
) {

    @PostMapping("/store")
    fun createStore(@RequestBody name: String): Store {
        val store = Store(name = name)
        return storeDao.save(store)
    }

    @GetMapping("/store/{id}")
    fun findStoreById(@PathVariable("id") id: Long): StoreDetailDTO {
        return StoreDetailDTO.from(storeDao.findById(id).orElseThrow())
    }

    @PostMapping("/category")
    fun createCategory(@RequestBody request: RequestName): Category {
        val category = Category(name = request.name)
        return categoryDao.save(category)
    }

    data class RequestName(val name:String)

    @GetMapping("/category/{id}")
    fun findCategoryById(@PathVariable("id") id: Long): CategoryDetailDTO {
        return CategoryDetailDTO.from(categoryDao.findById(id).orElseThrow())
    }

    @GetMapping("/store/{storeId}/category/{categoryId}")
    fun addStoreCategory(
        @PathVariable storeId: Long,
        @PathVariable categoryId: Long,
    ) {
        val store = storeDao.findById(storeId).orElseThrow()
        val category = categoryDao.findById(categoryId).orElseThrow()

        store.addCategory(category)
        storeDao.save(store)
    }

    @GetMapping("/category/{categoryId}/store/{storeId}")
    fun addCategoryStore(
        @PathVariable storeId: Long,
        @PathVariable categoryId: Long,
    ) {
        val store = storeDao.findById(storeId).orElseThrow()
        val category = categoryDao.findById(categoryId).orElseThrow()

        category.addStore(store)
        categoryDao.save(category)
    }

    @GetMapping("/category")
    fun findAllCategory(): List<CategoryDTO> {
        return categoryDao.findAll().map(CategoryDTO::from)
    }

    @GetMapping("/store")
    fun findAllStore(): List<StoreDTO> {
        return storeDao.findAll().map(StoreDTO::from)
    }

    data class StoreDTO(
        val id: Long,
        val name: String,
    ) {
        companion object {
            fun from(store: Store) : StoreDTO {
                return StoreDTO(store.id, store.name)
            }
        }
    }

    data class StoreDetailDTO(
        val id: Long,
        val name: String,
        val categories: List<CategoryDTO>,
    ) {
        companion object {
            fun from(store: Store) : StoreDetailDTO {
                return StoreDetailDTO(store.id, store.name, store.getCategories().map(CategoryDTO::from))
            }
        }
    }

    data class CategoryDTO(
        val id: Long,
        val name: String,
        val createdAt: Instant,
        val updatedAT: Instant,
    ) {
        companion object {
            fun from(category: Category) : CategoryDTO {
                return CategoryDTO(category.id, category.name, category.createdAt, category.updatedAt)
            }
        }
    }

    data class CategoryDetailDTO(
        val id: Long,
        val name: String,
        val stores: List<StoreDTO>,
    ) {
        companion object {
            fun from(category: Category) : CategoryDetailDTO {
                return CategoryDetailDTO(category.id, category.name, category.getStores().map(StoreDTO::from))
            }
        }
    }
}

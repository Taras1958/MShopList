package ru.stambul4you.mshoplist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.stambul4you.mshoplist.data.ShopListRepositoryImpl
import ru.stambul4you.mshoplist.domain.DeleteShopItemUseCase
import ru.stambul4you.mshoplist.domain.EditShopItemUseCase
import ru.stambul4you.mshoplist.domain.GetShopListUseCase
import ru.stambul4you.mshoplist.domain.ShopItem

class MainViewModel: ViewModel() {
    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()
    fun getShopList() {
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }
        fun deleteShopItem(shopItem: ShopItem) {
            deleteShopItemUseCase.deleteShopItem(shopItem)
            getShopList()
        }
        fun changeEnableState(shopItem: ShopItem){
            val newItem = shopItem.copy(enabled = !shopItem.enabled)
            editShopItemUseCase.editShopItem(newItem)
            getShopList()
        }

}
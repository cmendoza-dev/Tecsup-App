package com.tecsup.tecsupapp.noticias

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tecsup.tecsupapp.network.Article
import com.tecsup.tecsupapp.network.NoticiasResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class NoticasViewModel: ViewModel() {

    private val repository = NoticiasRepository()
    private  val disposable = CompositeDisposable()
    val listNoticiasResponse = MutableLiveData<List<Article>>()

    fun listNoticias(country: String, category: String){
        disposable.add(
            repository.listNoticias(country, category, "df7c3d67cd1f4066af61c2b9c522db30")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<NoticiasResponse>() {
                    override fun onSuccess(t: NoticiasResponse) {
                        listNoticiasResponse.value =  t.articles
                    }

                    override fun onError(e: Throwable) {

                    }

                })
        )
    }

}
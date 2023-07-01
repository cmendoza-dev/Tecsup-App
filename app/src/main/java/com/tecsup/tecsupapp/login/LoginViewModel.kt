package com.tecsup.tecsupapp.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tecsup.tecsupapp.network.LoginResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class LoginViewModel : ViewModel() {

    private val repository = LoginRepository()

    // MUtableLiveData
    val userLoginStringError = MutableLiveData<String>()
    val userLoginServiceResponse = MutableLiveData<Boolean>()

    private val disposable = CompositeDisposable()
    fun login(email: String, pass: String) {
        if (email.isEmpty() || pass.isEmpty()) {
            userLoginStringError.value = "Verifique sus credenciales"
        } else {
            loginService(email, pass)
        }

    }

    fun loginService(email: String, pass: String) {
        disposable.add(
            repository.login(email, pass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<LoginResponse>() {

                    override fun onSuccess(t: LoginResponse) {
                        userLoginServiceResponse.value = true
                    }

                    override fun onError(e: Throwable) {
                        userLoginServiceResponse.value = false
                    }

                })
        )
    }


}



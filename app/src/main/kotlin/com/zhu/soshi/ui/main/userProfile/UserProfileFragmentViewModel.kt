package com.zhu.soshi.ui.main.userProfile

import io.reactivex.Observable
import net.samystudio.beaver.R
import net.samystudio.beaver.di.scope.FragmentScope
import net.samystudio.beaver.ui.base.viewmodel.BaseFragmentViewModel
import net.samystudio.beaver.ui.common.navigation.NavigationRequest
import net.samystudio.beaver.ui.main.userProfile.UserProfileUserFlow
import javax.inject.Inject

@FragmentScope
class UserProfileFragmentViewModel @Inject constructor() : BaseFragmentViewModel() {

    fun <T : UserProfileUserFlow> addUserFlow(observable: Observable<T>) {
        disposables.add(observable.forEach { if (it is UserProfileUserFlow.Disconnect) userManager.disconnect() })
    }

    override fun handleUserDisconnected() {
        super.handleUserDisconnected()
        navigate(NavigationRequest.Push(R.id.action_global_authenticator))
    }
}
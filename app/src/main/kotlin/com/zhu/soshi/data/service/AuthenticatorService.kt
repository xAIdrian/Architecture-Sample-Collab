@file:Suppress("ProtectedInFinal")

package net.samystudio.beaver.data.service

import android.content.Intent
import android.os.IBinder
import dagger.android.DaggerService
import com.zhu.soshi.data.manager.AuthenticatorManager
import javax.inject.Inject

class AuthenticatorService : DaggerService() {
    @Inject
    protected lateinit var authenticatorManager: AuthenticatorManager

    override fun onBind(intent: Intent): IBinder = authenticatorManager.iBinder
}
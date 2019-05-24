@file:Suppress("ProtectedInFinal")

package com.zhu.soshi.ui.main.authenticator

import android.os.Bundle
import android.view.View
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import io.reactivex.disposables.CompositeDisposable
import net.samystudio.beaver.ext.getGenericErrorDialog
import net.samystudio.beaver.ext.getMethodTag
import net.samystudio.beaver.ui.base.fragment.BaseDataPushFragment


class AuthenticatorFragment : BaseDataPushFragment<AuthenticatorFragmentViewModel>() {
    override val layoutViewRes: Int = R.layout.fragment_authenticator
    override val viewModelClass: Class<AuthenticatorFragmentViewModel> =
        AuthenticatorFragmentViewModel::class.java
    override var title: String? = "Authenticator"
    private var disposables: CompositeDisposable? = null

    private val mGoogleSignInClient = GoogleSignInClient()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }

    override fun dataPushStart() {
        // TODO show loader
    }

    override fun dataPushSuccess() {
    }

    override fun dataPushError(throwable: Throwable) {
        fragmentManager?.let {
            getGenericErrorDialog(context!!).showNow(it, getMethodTag())
        }
    }

    override fun dataPushTerminate() {
        // TODO hide loader
    }

    override fun onDestroyView() {
        super.onDestroyView()

        disposables?.dispose()
    }
}
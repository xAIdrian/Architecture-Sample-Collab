package net.samystudio.beaver.ui.base.viewmodel

import android.os.Bundle
import com.zhu.soshi.ui.base.viewmodel.BaseViewControllerViewModel

abstract class BaseFragmentViewModel : BaseViewControllerViewModel() {
    open fun handleArguments(argument: Bundle) {}
}
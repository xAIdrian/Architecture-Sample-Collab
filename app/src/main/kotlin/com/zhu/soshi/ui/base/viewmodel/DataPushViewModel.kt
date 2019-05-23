package net.samystudio.beaver.ui.base.viewmodel

import androidx.lifecycle.LiveData
import com.zhu.soshi.data.AsyncState

interface DataPushViewModel {
    val dataPushCompletable: LiveData<AsyncState>
}
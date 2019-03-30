package com.multicinescc.app.view.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjected
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.lazy
import com.multicinescc.app.R
import com.multicinescc.app.presenter.Presenter
import com.multicinescc.app.view.activity.RootActivity


abstract class RootDialog<out T : Presenter.View> : DialogFragment(), KodeinInjected, Presenter.View {

    abstract val layoutResourceId: Int

    abstract val fragmentModule: Kodein.Module

    abstract val presenter: Presenter<T>

    override val injector: KodeinInjector = KodeinInjector()

    private val kodein by Kodein.lazy {
        extend((activity as RootActivity<*>).kodein)
        import(fragmentModule)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(androidx.fragment.app.DialogFragment.STYLE_NO_FRAME, R.style.AppTheme)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        dialog?.window?.attributes?.windowAnimations = R.style.FullScreenDialogAnimation
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(layoutResourceId, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        injector.inject(kodein)
        initializeUI()
        registerListeners()
        presenter.initialize()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.destroy()
    }

    abstract fun initializeUI()

    abstract fun registerListeners()

}
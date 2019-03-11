package com.multicinescc.app.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjected
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.lazy
import com.multicinescc.app.extension.hideMe
import com.multicinescc.app.extension.showMe
import com.multicinescc.app.extension.toast
import com.multicinescc.app.presenter.Presenter
import com.multicinescc.app.view.app.App

/**
 * RootActivity
 */
abstract class RootActivity<out V : Presenter.View> : AppCompatActivity(), KodeinInjected, Presenter.View {

    abstract val progress: View

    abstract val presenter: Presenter<V>

    abstract val layoutResourceId: Int

    override val injector = KodeinInjector()

    abstract val activityModule: Kodein.Module

    val kodein by Kodein.lazy {
        extend((application as App).kodein)
        import(activityModule)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResourceId)

        initializeDI()
        initializeUI()
        registerListeners()

        presenter.initialize()
    }

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }

    override fun onStop() {
        super.onStop()
        presenter.stop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    private fun initializeDI() {
        inject(kodein)
    }

    abstract fun initializeUI()

    abstract fun registerListeners()

    override fun showError(error: String) = toast(error)

    override fun showError(errorId: Int) = toast(errorId)

    override fun showMessage(message: String) = toast(message, Toast.LENGTH_SHORT)

    override fun showMessage(messageId: Int) = toast(messageId, Toast.LENGTH_SHORT)

    override fun showProgress() = progress.showMe()

    override fun hideProgress() = progress.hideMe()
}

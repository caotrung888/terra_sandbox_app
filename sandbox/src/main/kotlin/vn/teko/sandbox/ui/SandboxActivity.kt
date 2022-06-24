package vn.teko.sandbox.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import vn.teko.android.core.ui.base.BaseActivity
import vn.teko.apollo.ApolloTheme
import vn.teko.sandbox.BR
import vn.teko.sandbox.R
import vn.teko.sandbox.databinding.ActivityMainBinding
import javax.inject.Inject

class SandboxActivity : BaseActivity<ActivityMainBinding, SandboxViewModel>() {

    @Inject
    lateinit var apolloTheme: ApolloTheme

    private val sandboxViewModel: SandboxViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window?.statusBarColor = apolloTheme.getNeutralColor().whiteColor
            window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    override fun getBindingVariable() = BR.viewModel

    override fun getLayoutId() = R.layout.activity_main

    override fun initComponents() {}

    override fun getViewModel() = sandboxViewModel
}
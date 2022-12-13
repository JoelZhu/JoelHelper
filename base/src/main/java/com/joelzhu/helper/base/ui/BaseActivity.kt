package com.joelzhu.helper.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.joelzhu.helper.base.util.LogUtil
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * [Description here].
 *
 * @author zhuqian
 * @since 2022-11-29
 */
abstract class BaseActivity<DataBinding : ViewBinding?, VM : ViewModel?> : AppCompatActivity() {
    protected var binding: DataBinding? = null

    protected var viewModel: VM? = null

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val types = actualTypes
        if (types == null) {
            LogUtil.e(LogUtil.LogType.MAIN, "Get actual type failed, class: " + javaClass.simpleName)
            return
        }

        assignDataBinding(types[0] as Class<DataBinding>)
        assignViewModel(types[1] as Class<VM>)
        if (binding == null || viewModel == null) {
            return
        }

        setContentView(binding?.root)
        doOnCreate()
    }

    protected open fun doOnCreate() {}

    private val actualTypes: Array<Type>?
        private get() {
            val parameterizedType = javaClass.genericSuperclass as ParameterizedType
            return parameterizedType.actualTypeArguments
        }

    private fun assignDataBinding(bindingClass: Class<DataBinding>) {
        try {
            val method = bindingClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
            binding = method.invoke(null, layoutInflater) as DataBinding
        } catch (exception: NoSuchMethodException) {
            LogUtil.e(LogUtil.LogType.MAIN, "Invoke databinding class got exception: " + exception.message)
        } catch (exception: IllegalAccessException) {
            LogUtil.e(LogUtil.LogType.MAIN, "Invoke databinding class got exception: " + exception.message)
        } catch (exception: InvocationTargetException) {
            LogUtil.e(LogUtil.LogType.MAIN, "Invoke databinding class got exception: " + exception.message)
        }
    }

    private fun assignViewModel(viewModelClass: Class<VM>) {
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))[viewModelClass]
    }
}
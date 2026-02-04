package dev.simple.core.livedata

import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * detail: 一个用于封装可观测单一状态、值的 LiveData 类
 * @author Ttt
 * 泛化概念：可表示 status、data、source、page 等
 */
open class StateLiveData<T>(
    _value: T? = null
) {

    // 状态数据
    protected val _state = MutableLiveData<T>(_value)
    val state: LiveData<T> get() = _state

    /**
     * 获取状态数据
     * @return value
     */
    open fun stateValue(): T? {
        return _state.value
    }

    /**
     * 主线程直接设置值
     * @param value 待更新值
     * @param allowNull 是否允许设置为 null
     * @return `true` success, `false` fail
     */
    open fun setState(
        value: T?,
        allowNull: Boolean = false
    ): Boolean {
        if (shouldUpdateState(value)) {
            if (allowNull || value != null) {
                _state.value = value
                return true
            }
        }
        return false
    }

    /**
     * 子线程安全设置值 ( 自动切换到主线程 )
     * @param value 待更新值
     * @param allowNull 是否允许设置为 null
     * @return `true` success, `false` fail
     */
    open fun postState(
        value: T?,
        allowNull: Boolean = false
    ): Boolean {
        if (shouldUpdateState(value)) {
            if (allowNull || value != null) {
                _state.postValue(value)
                return true
            }
        }
        return false
    }

    /**
     * 智能线程判断 ( 自动选择 setValue、postValue )
     * @param value 待更新值
     * @param allowNull 是否允许设置为 null
     * @return `true` success, `false` fail
     */
    open fun smartUpdateState(
        value: T?,
        allowNull: Boolean = false
    ): Boolean {
        return if (isMainThread()) {
            setState(value, allowNull)
        } else {
            postState(value, allowNull)
        }
    }

    /**
     * 重置状态数据 ( 主线程直接设置 null )
     * @return `true` success, `false` fail
     */
    open fun resetState(): Boolean {
        return setState(null, true)
    }

    /**
     * 重置状态数据 ( 子线程安全设置 null )
     * @return `true` success, `false` fail
     */
    open fun postResetState(): Boolean {
        return postState(null, true)
    }

    /**
     * 重置状态数据 ( 智能线程判断设置 null )
     * @return `true` success, `false` fail
     */
    open fun smartResetState(): Boolean {
        return smartUpdateState(null, true)
    }

    /**
     * 判断是否需要更新值
     * @param value 待更新值
     * @return `true` yes, `false` no
     */
    open fun shouldUpdateState(value: T?): Boolean {
        return !isEqual(value, _state.value)
    }

    /**
     * 判断是否相同值
     * @param value 待判断值
     * @return `true` yes, `false` no
     */
    open fun isEqual(value: T?): Boolean {
        return isEqual(value, _state.value)
    }

    /**
     * 判断是否相同值
     * @param newValue 待更新值
     * @param currentValue 当前值
     * @return `true` yes, `false` no
     */
    open fun isEqual(
        newValue: T?,
        currentValue: T?
    ): Boolean {
        return when {
            newValue == currentValue -> true
            else -> {
                // 对于复杂对象，建议重写 equals 方法
                newValue == currentValue
            }
        }
    }

    /**
     * 当前线程是否主线程
     * @return `true` yes, `false` no
     */
    open fun isMainThread(): Boolean {
        return Looper.getMainLooper().thread === Thread.currentThread()
    }
}
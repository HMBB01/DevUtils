package dev.simple.core.livedata

/**
 * detail: 状态类型值
 * @author Ttt
 */
object StateInt {

    // 默认状态
    const val NORMAL = 1020301

    // 操作中
    const val ING = 1020302

    // 操作成功
    const val SUCCESS = 1020303

    // 操作失败
    const val FAIL = 1020304

    // 操作异常
    const val ERROR = 1020305

    // 开始操作
    const val START = 1020306

    // 重新开始操作
    const val RESTART = 1020307

    // 操作结束
    const val END = 1020308

    // 操作暂停
    const val PAUSE = 1020309

    // 操作恢复 ( 继续 )
    const val RESUME = 1020310

    // 操作停止
    const val STOP = 1020311

    // 操作取消
    const val CANCEL = 1020312

    // 创建
    const val CREATE = 1020313

    // 销毁
    const val DESTROY = 1020314

    // 回收
    const val RECYCLE = 1020315

    // 初始化
    const val INIT = 1020316

    // 已打开
    const val ENABLED = 1020317

    // 正在打开
    const val ENABLING = 1020318

    // 已关闭
    const val DISABLED = 1020319

    // 正在关闭
    const val DISABLING = 1020320

    // 连接成功
    const val CONNECTED = 1020321

    // 连接中
    const val CONNECTING = 1020322

    // 连接失败、断开
    const val DISCONNECTED = 1020323

    // 暂停、延迟
    const val SUSPENDED = 1020324

    // 未知
    const val UNKNOWN = 1020325

    // 新增
    const val INSERT = 1020326

    // 删除
    const val DELETE = 1020327

    // 更新
    const val UPDATE = 1020328

    // 查询
    const val SELECT = 1020329

    // 加密
    const val ENCRYPT = 1020330

    // 解密
    const val DECRYPT = 1020331

    // 重置
    const val RESET = 1020332

    // 关闭
    const val CLOSE = 1020333

    // 打开
    const val OPEN = 1020334

    // 退出
    const val EXIT = 1020335

    // 下一步
    const val NEXT = 1020336

    // 无任何
    const val NONE = 1020337

    // 结束
    const val FINISH = 1020338

    // 等待中
    const val WAITING = 1020339

    // 完成
    const val COMPLETE = 1020340
}

/**
 * detail: State Int LiveData
 * @author Ttt
 */
open class StateIntLiveData(
    _value: Int = StateInt.NORMAL
) : StateLiveData<Int>(_value) {

    /**
     * 是否 XXX 状态
     * @return `true` yes, `false` no
     */
    open fun isXXXState(state: Int): Boolean {
        return isEqual(state)
    }

    /**
     * 设置为 XXX 状态 ( 主线程 )
     * @return `true` success, `false` fail
     */
    open fun setXXX(state: Int): Boolean {
        return setState(state)
    }

    /**
     * 设置为 XXX 状态 ( 子线程 )
     * @return `true` success, `false` fail
     */
    open fun postXXX(state: Int): Boolean {
        return postState(state)
    }

    /**
     * 设置为 XXX 状态 ( 智能线程判断 )
     * @return `true` success, `false` fail
     */
    open fun smartUpdateXXX(state: Int): Boolean {
        return smartUpdateState(state)
    }

    // =

    // NORMAL
    open fun isNORMALState(): Boolean = isEqual(StateInt.NORMAL)
    open fun setNORMAL(): Boolean = setState(StateInt.NORMAL)
    open fun postNORMAL(): Boolean = postState(StateInt.NORMAL)
    open fun smartUpdateNORMAL(): Boolean = smartUpdateState(StateInt.NORMAL)

    // ING
    open fun isINGState(): Boolean = isEqual(StateInt.ING)
    open fun setING(): Boolean = setState(StateInt.ING)
    open fun postING(): Boolean = postState(StateInt.ING)
    open fun smartUpdateING(): Boolean = smartUpdateState(StateInt.ING)

    // SUCCESS
    open fun isSUCCESSState(): Boolean = isEqual(StateInt.SUCCESS)
    open fun setSUCCESS(): Boolean = setState(StateInt.SUCCESS)
    open fun postSUCCESS(): Boolean = postState(StateInt.SUCCESS)
    open fun smartUpdateSUCCESS(): Boolean = smartUpdateState(StateInt.SUCCESS)

    // FAIL
    open fun isFAILState(): Boolean = isEqual(StateInt.FAIL)
    open fun setFAIL(): Boolean = setState(StateInt.FAIL)
    open fun postFAIL(): Boolean = postState(StateInt.FAIL)
    open fun smartUpdateFAIL(): Boolean = smartUpdateState(StateInt.FAIL)

    // ERROR
    open fun isERRORState(): Boolean = isEqual(StateInt.ERROR)
    open fun setERROR(): Boolean = setState(StateInt.ERROR)
    open fun postERROR(): Boolean = postState(StateInt.ERROR)
    open fun smartUpdateERROR(): Boolean = smartUpdateState(StateInt.ERROR)

    // START
    open fun isSTARTState(): Boolean = isEqual(StateInt.START)
    open fun setSTART(): Boolean = setState(StateInt.START)
    open fun postSTART(): Boolean = postState(StateInt.START)
    open fun smartUpdateSTART(): Boolean = smartUpdateState(StateInt.START)

    // RESTART
    open fun isRESTARTState(): Boolean = isEqual(StateInt.RESTART)
    open fun setRESTART(): Boolean = setState(StateInt.RESTART)
    open fun postRESTART(): Boolean = postState(StateInt.RESTART)
    open fun smartUpdateRESTART(): Boolean = smartUpdateState(StateInt.RESTART)

    // END
    open fun isENDState(): Boolean = isEqual(StateInt.END)
    open fun setEND(): Boolean = setState(StateInt.END)
    open fun postEND(): Boolean = postState(StateInt.END)
    open fun smartUpdateEND(): Boolean = smartUpdateState(StateInt.END)

    // PAUSE
    open fun isPAUSEState(): Boolean = isEqual(StateInt.PAUSE)
    open fun setPAUSE(): Boolean = setState(StateInt.PAUSE)
    open fun postPAUSE(): Boolean = postState(StateInt.PAUSE)
    open fun smartUpdatePAUSE(): Boolean = smartUpdateState(StateInt.PAUSE)

    // RESUME
    open fun isRESUMEState(): Boolean = isEqual(StateInt.RESUME)
    open fun setRESUME(): Boolean = setState(StateInt.RESUME)
    open fun postRESUME(): Boolean = postState(StateInt.RESUME)
    open fun smartUpdateRESUME(): Boolean = smartUpdateState(StateInt.RESUME)

    // STOP
    open fun isSTOPState(): Boolean = isEqual(StateInt.STOP)
    open fun setSTOP(): Boolean = setState(StateInt.STOP)
    open fun postSTOP(): Boolean = postState(StateInt.STOP)
    open fun smartUpdateSTOP(): Boolean = smartUpdateState(StateInt.STOP)

    // CANCEL
    open fun isCANCELState(): Boolean = isEqual(StateInt.CANCEL)
    open fun setCANCEL(): Boolean = setState(StateInt.CANCEL)
    open fun postCANCEL(): Boolean = postState(StateInt.CANCEL)
    open fun smartUpdateCANCEL(): Boolean = smartUpdateState(StateInt.CANCEL)

    // CREATE
    open fun isCREATEState(): Boolean = isEqual(StateInt.CREATE)
    open fun setCREATE(): Boolean = setState(StateInt.CREATE)
    open fun postCREATE(): Boolean = postState(StateInt.CREATE)
    open fun smartUpdateCREATE(): Boolean = smartUpdateState(StateInt.CREATE)

    // DESTROY
    open fun isDESTROYState(): Boolean = isEqual(StateInt.DESTROY)
    open fun setDESTROY(): Boolean = setState(StateInt.DESTROY)
    open fun postDESTROY(): Boolean = postState(StateInt.DESTROY)
    open fun smartUpdateDESTROY(): Boolean = smartUpdateState(StateInt.DESTROY)

    // RECYCLE
    open fun isRECYCLEState(): Boolean = isEqual(StateInt.RECYCLE)
    open fun setRECYCLE(): Boolean = setState(StateInt.RECYCLE)
    open fun postRECYCLE(): Boolean = postState(StateInt.RECYCLE)
    open fun smartUpdateRECYCLE(): Boolean = smartUpdateState(StateInt.RECYCLE)

    // INIT
    open fun isINITState(): Boolean = isEqual(StateInt.INIT)
    open fun setINIT(): Boolean = setState(StateInt.INIT)
    open fun postINIT(): Boolean = postState(StateInt.INIT)
    open fun smartUpdateINIT(): Boolean = smartUpdateState(StateInt.INIT)

    // ENABLED
    open fun isENABLEDState(): Boolean = isEqual(StateInt.ENABLED)
    open fun setENABLED(): Boolean = setState(StateInt.ENABLED)
    open fun postENABLED(): Boolean = postState(StateInt.ENABLED)
    open fun smartUpdateENABLED(): Boolean = smartUpdateState(StateInt.ENABLED)

    // ENABLING
    open fun isENABLINGState(): Boolean = isEqual(StateInt.ENABLING)
    open fun setENABLING(): Boolean = setState(StateInt.ENABLING)
    open fun postENABLING(): Boolean = postState(StateInt.ENABLING)
    open fun smartUpdateENABLING(): Boolean = smartUpdateState(StateInt.ENABLING)

    // DISABLED
    open fun isDISABLEDState(): Boolean = isEqual(StateInt.DISABLED)
    open fun setDISABLED(): Boolean = setState(StateInt.DISABLED)
    open fun postDISABLED(): Boolean = postState(StateInt.DISABLED)
    open fun smartUpdateDISABLED(): Boolean = smartUpdateState(StateInt.DISABLED)

    // DISABLING
    open fun isDISABLINGState(): Boolean = isEqual(StateInt.DISABLING)
    open fun setDISABLING(): Boolean = setState(StateInt.DISABLING)
    open fun postDISABLING(): Boolean = postState(StateInt.DISABLING)
    open fun smartUpdateDISABLING(): Boolean = smartUpdateState(StateInt.DISABLING)

    // CONNECTED
    open fun isCONNECTEDState(): Boolean = isEqual(StateInt.CONNECTED)
    open fun setCONNECTED(): Boolean = setState(StateInt.CONNECTED)
    open fun postCONNECTED(): Boolean = postState(StateInt.CONNECTED)
    open fun smartUpdateCONNECTED(): Boolean = smartUpdateState(StateInt.CONNECTED)

    // CONNECTING
    open fun isCONNECTINGState(): Boolean = isEqual(StateInt.CONNECTING)
    open fun setCONNECTING(): Boolean = setState(StateInt.CONNECTING)
    open fun postCONNECTING(): Boolean = postState(StateInt.CONNECTING)
    open fun smartUpdateCONNECTING(): Boolean = smartUpdateState(StateInt.CONNECTING)

    // DISCONNECTED
    open fun isDISCONNECTEDState(): Boolean = isEqual(StateInt.DISCONNECTED)
    open fun setDISCONNECTED(): Boolean = setState(StateInt.DISCONNECTED)
    open fun postDISCONNECTED(): Boolean = postState(StateInt.DISCONNECTED)
    open fun smartUpdateDISCONNECTED(): Boolean = smartUpdateState(StateInt.DISCONNECTED)

    // SUSPENDED
    open fun isSUSPENDEDState(): Boolean = isEqual(StateInt.SUSPENDED)
    open fun setSUSPENDED(): Boolean = setState(StateInt.SUSPENDED)
    open fun postSUSPENDED(): Boolean = postState(StateInt.SUSPENDED)
    open fun smartUpdateSUSPENDED(): Boolean = smartUpdateState(StateInt.SUSPENDED)

    // UNKNOWN
    open fun isUNKNOWNState(): Boolean = isEqual(StateInt.UNKNOWN)
    open fun setUNKNOWN(): Boolean = setState(StateInt.UNKNOWN)
    open fun postUNKNOWN(): Boolean = postState(StateInt.UNKNOWN)
    open fun smartUpdateUNKNOWN(): Boolean = smartUpdateState(StateInt.UNKNOWN)

    // INSERT
    open fun isINSERTState(): Boolean = isEqual(StateInt.INSERT)
    open fun setINSERT(): Boolean = setState(StateInt.INSERT)
    open fun postINSERT(): Boolean = postState(StateInt.INSERT)
    open fun smartUpdateINSERT(): Boolean = smartUpdateState(StateInt.INSERT)

    // DELETE
    open fun isDELETEState(): Boolean = isEqual(StateInt.DELETE)
    open fun setDELETE(): Boolean = setState(StateInt.DELETE)
    open fun postDELETE(): Boolean = postState(StateInt.DELETE)
    open fun smartUpdateDELETE(): Boolean = smartUpdateState(StateInt.DELETE)

    // UPDATE
    open fun isUPDATEState(): Boolean = isEqual(StateInt.UPDATE)
    open fun setUPDATE(): Boolean = setState(StateInt.UPDATE)
    open fun postUPDATE(): Boolean = postState(StateInt.UPDATE)
    open fun smartUpdateUPDATE(): Boolean = smartUpdateState(StateInt.UPDATE)

    // SELECT
    open fun isSELECTState(): Boolean = isEqual(StateInt.SELECT)
    open fun setSELECT(): Boolean = setState(StateInt.SELECT)
    open fun postSELECT(): Boolean = postState(StateInt.SELECT)
    open fun smartUpdateSELECT(): Boolean = smartUpdateState(StateInt.SELECT)

    // ENCRYPT
    open fun isENCRYPTState(): Boolean = isEqual(StateInt.ENCRYPT)
    open fun setENCRYPT(): Boolean = setState(StateInt.ENCRYPT)
    open fun postENCRYPT(): Boolean = postState(StateInt.ENCRYPT)
    open fun smartUpdateENCRYPT(): Boolean = smartUpdateState(StateInt.ENCRYPT)

    // DECRYPT
    open fun isDECRYPTState(): Boolean = isEqual(StateInt.DECRYPT)
    open fun setDECRYPT(): Boolean = setState(StateInt.DECRYPT)
    open fun postDECRYPT(): Boolean = postState(StateInt.DECRYPT)
    open fun smartUpdateDECRYPT(): Boolean = smartUpdateState(StateInt.DECRYPT)

    // RESET
    open fun isRESETState(): Boolean = isEqual(StateInt.RESET)
    open fun setRESET(): Boolean = setState(StateInt.RESET)
    open fun postRESET(): Boolean = postState(StateInt.RESET)
    open fun smartUpdateRESET(): Boolean = smartUpdateState(StateInt.RESET)

    // CLOSE
    open fun isCLOSEState(): Boolean = isEqual(StateInt.CLOSE)
    open fun setCLOSE(): Boolean = setState(StateInt.CLOSE)
    open fun postCLOSE(): Boolean = postState(StateInt.CLOSE)
    open fun smartUpdateCLOSE(): Boolean = smartUpdateState(StateInt.CLOSE)

    // OPEN
    open fun isOPENState(): Boolean = isEqual(StateInt.OPEN)
    open fun setOPEN(): Boolean = setState(StateInt.OPEN)
    open fun postOPEN(): Boolean = postState(StateInt.OPEN)
    open fun smartUpdateOPEN(): Boolean = smartUpdateState(StateInt.OPEN)

    // EXIT
    open fun isEXITState(): Boolean = isEqual(StateInt.EXIT)
    open fun setEXIT(): Boolean = setState(StateInt.EXIT)
    open fun postEXIT(): Boolean = postState(StateInt.EXIT)
    open fun smartUpdateEXIT(): Boolean = smartUpdateState(StateInt.EXIT)

    // NEXT
    open fun isNEXTState(): Boolean = isEqual(StateInt.NEXT)
    open fun setNEXT(): Boolean = setState(StateInt.NEXT)
    open fun postNEXT(): Boolean = postState(StateInt.NEXT)
    open fun smartUpdateNEXT(): Boolean = smartUpdateState(StateInt.NEXT)

    // NONE
    open fun isNONEState(): Boolean = isEqual(StateInt.NONE)
    open fun setNONE(): Boolean = setState(StateInt.NONE)
    open fun postNONE(): Boolean = postState(StateInt.NONE)
    open fun smartUpdateNONE(): Boolean = smartUpdateState(StateInt.NONE)

    // FINISH
    open fun isFINISHState(): Boolean = isEqual(StateInt.FINISH)
    open fun setFINISH(): Boolean = setState(StateInt.FINISH)
    open fun postFINISH(): Boolean = postState(StateInt.FINISH)
    open fun smartUpdateFINISH(): Boolean = smartUpdateState(StateInt.FINISH)

    // WAITING
    open fun isWAITINGState(): Boolean = isEqual(StateInt.WAITING)
    open fun setWAITING(): Boolean = setState(StateInt.WAITING)
    open fun postWAITING(): Boolean = postState(StateInt.WAITING)
    open fun smartUpdateWAITING(): Boolean = smartUpdateState(StateInt.WAITING)

    // COMPLETE
    open fun isCOMPLETEState(): Boolean = isEqual(StateInt.COMPLETE)
    open fun setCOMPLETE(): Boolean = setState(StateInt.COMPLETE)
    open fun postCOMPLETE(): Boolean = postState(StateInt.COMPLETE)
    open fun smartUpdateCOMPLETE(): Boolean = smartUpdateState(StateInt.COMPLETE)
}
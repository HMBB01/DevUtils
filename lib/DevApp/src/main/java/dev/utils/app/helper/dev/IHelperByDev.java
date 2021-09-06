package dev.utils.app.helper.dev;

import dev.utils.app.HandlerUtils;
import dev.utils.app.helper.IHelper;

/**
 * detail: DevHelper 接口
 * @author Ttt
 */
public interface IHelperByDev<T>
        extends IHelper<T> {

    // ===========
    // = Handler =
    // ===========

    /**
     * 在主线程 Handler 中执行任务
     *
     * @param runnable 可执行的任务
     * @return Helper
     */
    T postRunnable(Runnable runnable);

    /**
     * 在主线程 Handler 中执行延迟任务
     *
     * @param runnable    可执行的任务
     * @param delayMillis 延迟时间
     * @return Helper
     */
    T postRunnable(
            Runnable runnable,
            long delayMillis
    );

    /**
     * 在主线程 Handler 中执行延迟任务
     *
     * @param runnable    可执行的任务
     * @param delayMillis 延迟时间
     * @param number      轮询次数
     * @param interval    轮询时间
     * @return Helper
     */
    T postRunnable(
            Runnable runnable,
            long delayMillis,
            int number,
            int interval
    );

    /**
     * 在主线程 Handler 中执行延迟任务
     *
     * @param runnable      可执行的任务
     * @param delayMillis   延迟时间
     * @param number        轮询次数
     * @param interval      轮询时间
     * @param onEndListener 结束通知
     * @return Helper
     */
    T postRunnable(
            Runnable runnable,
            long delayMillis,
            int number,
            int interval,
            HandlerUtils.OnEndListener onEndListener
    );

    /**
     * 在主线程 Handler 中清除任务
     *
     * @param runnable 需要清除的任务
     * @return Helper
     */
    T removeRunnable(Runnable runnable);
}
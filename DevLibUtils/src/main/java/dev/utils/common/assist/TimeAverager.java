package dev.utils.common.assist;

/**
 * detail: 时间均值计算器, 只能用于单线程计时。
 * @author Ttt
 */
public class TimeAverager {

    // 计时器
    private TimeCounter timeCounter = new TimeCounter();
    // 均值器
    private Averager averager = new Averager();

    /**
     * 开始计时
     * @return 返回开始时间(毫秒)
     */
    public long start() {
        return timeCounter.start();
    }

    /**
     * 结束计时
     * @return 返回结束时间(毫秒)
     */
    public long end() {
        long time = timeCounter.duration();
        averager.add(time);
        return time;
    }

    /**
     * 结束计时, 并重新启动新的计时
     * @return 返回距离上次计时的时间差(毫秒)
     */
    public long endAndRestart() {
        long time = timeCounter.durationRestart();
        averager.add(time);
        return time;
    }

    /**
     * 求全部计时均值
     * @return 返回全部计时时间之和均值
     */
    public Number average() {
        return averager.getAverage();
    }

    /**
     * 打印全部时间值
     * @return 返回计时信息
     */
    public String print() {
        return averager.print();
    }

    /**
     * 清除数据
     */
    public void clear() {
        averager.clear();
    }
}

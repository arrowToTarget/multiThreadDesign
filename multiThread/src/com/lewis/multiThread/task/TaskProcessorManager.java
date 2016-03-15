package com.lewis.multiThread.task;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhangminghua on 2016/3/14.
 * 异步执行管理器
 */
public class TaskProcessorManager {

    /**
     * 默认的业务执行域
     */
    private static String defaultBusinessDomain = TaskProcessorManager.class.getName();

    /**
     * 默认的执行器工厂
     */
    private static TaskProcessorFactory defaultTaskProcessorFactory = new TaskProcessorFactory();

    /**
     * 执行器的容器，根据业务域进行区分，每个业务域只有一个执行器
     */
    private static Map<String,TaskProcessor> taskProcessorContainer = new ConcurrentHashMap<String, TaskProcessor>();

    /**
     * 获取执行器，使用默认的执行器工厂
     * @param businessDomain 业务域
     * @return 执行器
     */
    public static TaskProcessor getTaskProcessor(String businessDomain){
        return getTaskProcessor(businessDomain,defaultTaskProcessorFactory);
    }

    /**
     * 获取默认的执行器
     * @return 执行器
     */
    public static TaskProcessor getTaskProcessor(){
        return getTaskProcessor(defaultBusinessDomain,defaultTaskProcessorFactory);
    }

    /**
     * 根据指定的业务域、执行器工厂获取执行器
     * @param businessDomain 业务域
     * @param factory 执行器工厂
     * @return 执行器
     */
    public static TaskProcessor getTaskProcessor(String businessDomain,TaskProcessorFactory factory){
        if (factory == null) {
            factory = defaultTaskProcessorFactory;
        }
        TaskProcessor taskProcessor = taskProcessorContainer.get(businessDomain);
        if (taskProcessor == null) {
            taskProcessor = factory.createTaskProcessor();
            taskProcessorContainer.put(businessDomain,taskProcessor);
        }
        return taskProcessor;
    }


}

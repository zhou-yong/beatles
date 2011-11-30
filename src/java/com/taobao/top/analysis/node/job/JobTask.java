/**
 * 
 */
package com.taobao.top.analysis.node.job;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import com.taobao.top.analysis.config.JobConfig;
import com.taobao.top.analysis.statistics.data.Rule;

/**
 * 
 * 任务的真实需要执行的实例，每个计算节点根据描述的输入获取数据，
 * 根据规则来分析数据，最后返回结果到输出
 * 
 * @author fangweng
 * @Email fangweng@taobao.com
 * 2011-11-24
 *
 */
public class JobTask implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4539861249196752195L;
	
	private String jobName;
	private String taskId;
	private Rule statisticsRule;
	private String input;
	private String output;
	private String splitRegex;
	private String inputEncoding;
	private String outputEncoding;
	private int taskRecycleTime;
	/**
	 * 任务执行状态
	 */
	private JobTaskStatus status;
	
	/**
	 * 任务创建时间
	 */
	private long creatTime;
	/**
	 * 任务开始时间
	 */
	private long startTime;
	/**
	 * 任务结束时间
	 */
	private long endTime;
	
	/**
	 * 该job回收计数
	 */
	private AtomicInteger recycleCounter;
	
	
	
	public JobTask(JobConfig jobConfig)
	{
		input = jobConfig.getInput();
		output = jobConfig.getOutput();
		splitRegex = jobConfig.getSplitRegex();
		inputEncoding = jobConfig.getInputEncoding();
		outputEncoding = jobConfig.getOutputEncoding();
		taskRecycleTime = jobConfig.getTaskRecycleTime();
		status = JobTaskStatus.UNDO;
		creatTime = System.currentTimeMillis();
		recycleCounter= new AtomicInteger(0);
	}
	
	public boolean equal(JobTask jobTask)
	{
		return jobName.equals(jobTask.jobName) && taskId.equals(jobTask.taskId);
	}
	
	public String getJobName() {
		return jobName;
	}


	public void setJobName(String jobName) {
		this.jobName = jobName;
	}



	public String getOutputEncoding() {
		return outputEncoding;
	}

	public void setOutputEncoding(String outputEncoding) {
		this.outputEncoding = outputEncoding;
	}

	
	public JobTaskStatus getStatus() {
		return status;
	}
	public void setStatus(JobTaskStatus status) {
		this.status = status;
	}
	public long getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(long creatTime) {
		this.creatTime = creatTime;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public AtomicInteger getRecycleCounter() {
		return recycleCounter;
	}
	public void setRecycleCounter(AtomicInteger recycleCounter) {
		this.recycleCounter = recycleCounter;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public Rule getStatisticsRule() {
		return statisticsRule;
	}
	public void setStatisticsRule(Rule statisticsRule) {
		this.statisticsRule = statisticsRule;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getSplitRegex() {
		return splitRegex;
	}
	public void setSplitRegex(String splitRegex) {
		this.splitRegex = splitRegex;
	}
	public String getInputEncoding() {
		return inputEncoding;
	}
	public void setInputEncoding(String inputEncoding) {
		this.inputEncoding = inputEncoding;
	}

	public int getTaskRecycleTime() {
		return taskRecycleTime;
	}

	public void setTaskRecycleTime(int taskRecycleTime) {
		this.taskRecycleTime = taskRecycleTime;
	}

}
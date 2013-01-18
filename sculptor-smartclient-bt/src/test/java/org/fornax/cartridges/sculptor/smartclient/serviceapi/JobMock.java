package org.fornax.cartridges.sculptor.smartclient.serviceapi;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class JobMock extends QuartzJobBean {
	private int timeout;
	private int count=0;

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getCount() {
		return count;
	}

	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		System.out.println("\n>>>> FIRED QUARTZ JOB (timeout:"+timeout+") <<<<<\n");
		count++;
	}
}
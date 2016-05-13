package com.tekexperts.pipeline.pipelineManagement.operation;

import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;

public class FalloutUnassignedOrders extends PipelineBase{

	public FalloutUnassignedOrders(WebDriver dr){
		driver = dr;
	}
}

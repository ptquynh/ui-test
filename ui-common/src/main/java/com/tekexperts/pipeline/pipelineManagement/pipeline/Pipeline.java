package com.tekexperts.pipeline.pipelineManagement.pipeline;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;

import static com.tekexperts.pipeline.common.TestLogger.info;

public class Pipeline extends PipelineBase{

	//Pipeline list
	public By ELEMENT_PIPELINE_LIST=By.xpath(".//*[@id='gvPipeline']");
	
	public Pipeline(WebDriver dr) {
		driver=dr;
	}

}

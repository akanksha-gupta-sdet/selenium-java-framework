package com.akanksha.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Framework", "Selenium TestNG");
            extent.setSystemInfo("Author", "Akanksha Gupta");
        }

        return extent;
    }
}
package com.w2a.listeners;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.Page;
import com.w2a.utilities.MonitoringMail;
import com.w2a.utilities.TestConfig;
import com.w2a.utilities.Utilities;
import org.testng.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static com.w2a.utilities.Utilities.isTestRunnable;

public class CustomListeners extends Page implements ITestListener, ISuiteListener {
    public String messageBody;
    @Override
    public void onTestStart(ITestResult iTestResult) {
        test = rep.startTest(iTestResult.getName().toUpperCase());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        test.log(LogStatus.PASS, iTestResult.getName().toUpperCase() + " PASS");
        rep.endTest(test);
        rep.flush();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.setProperty("org.uncommons.reportng.escape-output","false");
        try {
            Utilities.captureScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.log(LogStatus.FAIL, iTestResult.getName().toUpperCase() + " Failed with exception : " + iTestResult.getThrowable());
        test.log(LogStatus.INFO, test.addScreenCapture(Utilities.screenshotName));

        Reporter.log("Click to see screenshot");
        Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + ">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "><img src=" + Utilities.screenshotName + " height=200 width=200></img></a>");
        rep.endTest(test);
        rep.flush();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        test.log(LogStatus.SKIP, iTestResult.getName().toUpperCase() + " Skipped the test as the Run mode is NO");
        rep.endTest(test);
        rep.flush();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    @Override
    public void onStart(ISuite iSuite) {

    }

    @Override
    public void onFinish(ISuite iSuite) {

        MonitoringMail mail = new MonitoringMail();

        try {
            messageBody = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8089/job/LiveProject-PageObjectWithFactories/Extent_20Report/";
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
